package controllers;

import java.sql.Connection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.BankDAOImpl;
import models.AccountLink;
import models.Message;
import models.User;
import util.ConnectionFactory;

public class AccountLinks {
    public static void addAccountLink(HttpServletRequest req, HttpServletResponse res) {
        try (Connection conn = ConnectionFactory.getConnection()) {
            BankDAOImpl bDao = new BankDAOImpl(conn);
            ObjectMapper om = new ObjectMapper();
            JsonNode jsonNode = om.readTree(req.getReader());
            int userId = jsonNode.get("userId").asInt();
            int accountId = jsonNode.get("accountId").asInt();
            HttpSession session = req.getSession(false);
            User currentUser  = null;

            if (session == null) {
                res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                res.getWriter().write(om.writeValueAsString(new Message("The requested action is not permitted")));
                return;
            }

            currentUser  = (User ) session.getAttribute("user");
            int linkId = bDao.getLinkByUserAndAcct(userId, accountId);
            if (linkId != 0) {
                res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                res.getWriter().write(om.writeValueAsString(new Message("User  already associated with account")));
                return;
            }

            List<User> users = bDao.getUsersByAccount(accountId);
            if (users.size() > 0) {
                if (currentUser .getRole().getRoleId() == 1 || currentUser .getRole().getRoleId() == 4) {
                    User user = bDao.getUserById(userId);
                    if (user.getRole().getRoleId() == 3 || user.getRole().getRoleId() == 4) {
                        int insertId = bDao.insertAccountLink(new AccountLink(0, userId, accountId));
                        res.setStatus(HttpServletResponse.SC_CREATED);
                        res.getWriter().write(om.writeValueAsString(bDao.getLinkById(insertId)));
                    } else {
                        res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                        res.getWriter().write(om.writeValueAsString(new Message("Only standard and premium users may have accounts")));
                    }
                } else {
                    res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    res.getWriter().write(om.writeValueAsString(new Message("The requested action is not permitted")));
                }
            } else {
                int insertId = bDao.insertAccountLink(new AccountLink(0, userId, accountId));
                res.setStatus(HttpServletResponse.SC_CREATED);
                res.getWriter().write(om.writeValueAsString(bDao.getLinkById(insertId)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}