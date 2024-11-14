package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Bankmandao {
	
	private String jdbcURL="jdbc:mysql://localhost:30006/BankMan";
	private String jdbcid="root";
	private String jdbcname="root";
	
	
	private static final String INSERT_USER_SQL="INSERT INTO Bank"+" (id, name, dob, balance) VALUES "+"(?,?,?,?);";
	private static final String SELECT_USER_BY_ID="SELECT * FROM Bank WHERE id=?;";
	private static final String SELECT_ALL_USERS="SELECT FROM Bank;";
	private static final String DELETE_USERS_SQL="DELETE FROM Bank WHERE id=?;";
	private static final String UPDATE_USERS_SQL="UPDATE Bank SET id=?, name=?, dob=?, balance=? where id=?;";
	
	public Bankmandao() {
		super();
	// TODO Auto-generated constructor stub
	}
	
	public Connection getConnection()
	{
		Connection connection=null;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection= DriverManager.getConnection (jdbcURL, jdbcid, jdbcname);
		} 
		
		catch (SQLException | ClassNotFoundException e)
		{
			e.printStackkTrace();
		}
		
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return connection;
	}
	
	
	public void insertUser (BankMan user)
	{
		Bankmandao dao new Bankmandao();
		
		try(Connection connection=dao.getConnection()) 
		{
			PreparedStatement preparedStatement= connection.prepareStatement(INSERT_USER_SQL);
			preparedStatement.setString(1, user.getID());
			preparedStatement.setString(2,user.getName());
			preparedStatement.setString(3,user.getDob());
			preparedStatement.setString(4,user.getBalance());
			
			preparedStatement.executeUpdate();
		}
		catch (Exception e) { 
			e.printStackTrace();
		}
	}	

	public User selectUser(int id)
	{
		BankMan user=new User();
		Bankmandao dao = new Bankmandao();
		
		try(Connection connection = dao.getConnection())
		{
			PreparedStatement preparedStatement = connection.prepareStatement (SELECT_USER_BY_ID); 
			preparedStatement.setInt(1, id);
			
			ResultSet resultSet= preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				user.setId(id);
				user.setId(resultSet.getString("id"));
				user.setName(resultSet.getString("name"));
				user.setDob(resultSet.getString("dob")); 
				user.setBalance(resultSet.getString("balance"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return user;
		}
	
	public List<BankMan> selectAllBankMan()
	{
		List<BankMan> users =new ArrayList<BankMan>();
		Bankmandao dao= new Bankmandao();
		try(Connection connection=dao.getConnection())
		{
			PreparedStatement preparedStatement= connection.prepareStatement(SELECT_ALL_USERS);
			ResultSet resultSet= preparedStatement.executeQuery();
			
			
			while(resultSet.next())
			{
				int id= resultSet.getInt("id");
				String name = resultSet.getString("name");
				String dob = resultSet.getString("dob");
				String balance = resultSet.getString("balance");
				
				users.add(new BankMan(id,name,dob,balance));
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return users;
		
		}
	
	public boolean deleteUser(int id) 
	{
		boolean status=false;
		Bankmandao dao=new Bankmandao();
		
		try(Connection connection=dao.getConnection())
		{
			PreparedStatement preparedStatement= connection.prepareStatement(DELETE_USERS_SQL);
			preparedStatement.setInt(1,id);
			
			status=preparedStatement.execute();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
		
}

