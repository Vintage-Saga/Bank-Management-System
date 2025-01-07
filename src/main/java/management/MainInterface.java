package management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainInterface extends JFrame {

    public MainInterface() {
        // Set the title of the window
        setTitle("Bank Management System");

        // Set the size of the window
        setSize(600, 400);

        // Set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel to hold components
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));

        // Create buttons for different functionalities
        JButton viewCustomerButton = new JButton("View Customer");
        JButton depositMoneyButton = new JButton("Deposit Money");
        JButton withdrawMoneyButton = new JButton("Withdraw Money");
        JButton logoutButton = new JButton("Logout");
        JButton updatePasswordButton = new JButton("Update Password");

        // Add action listeners to buttons
        viewCustomerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code to view customer details
                JOptionPane.showMessageDialog(null, "View Customer functionality not implemented yet.");
            }
        });

        depositMoneyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code to deposit money
                JOptionPane.showMessageDialog(null, "Deposit Money functionality not implemented yet.");
            }
        });

        withdrawMoneyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code to withdraw money
                JOptionPane.showMessageDialog(null, "Withdraw Money functionality not implemented yet.");
            }
        });

        updatePasswordButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code to update password
                JOptionPane.showMessageDialog(null, "Update Password functionality not implemented yet.");
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code to logout
                JOptionPane.showMessageDialog(null, "Logging out...");
                dispose(); // Close the main interface
            }
        });

        // Add buttons to the panel
        panel.add(viewCustomerButton);
        panel.add(depositMoneyButton);
        panel.add(withdrawMoneyButton);
        panel.add(updatePasswordButton);
        panel.add(logoutButton);

        // Add the panel to the frame
        add(panel);

        // Set the frame to be visible
        setVisible(true);
    }

    public static void main(String[] args) {
        // Create the main interface after login
        new MainInterface();
    }
}