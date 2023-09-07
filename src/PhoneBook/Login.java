/*
 * Filename Login.java
 * Written by Divya Rasania
 * Written on 9/6/2023
 */

package PhoneBook;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {
    public static void main(String[] args) {
        new Login().setVisible(true);
    }

    JLabel welcomeLabel, usernameLabel, passwordLabel, iconLabel;
    JTextField usernameTextField;
    JPasswordField passwordTextField;
    JPanel loginPanel, headingPanel, iconPanel;
    JButton loginButton, cancelButton;
    Font font1, font2;

    Login() {
        font1 = new Font("Calibri", Font.BOLD, 25);
        font2 = new Font("Calibri", Font.BOLD, 18);
        welcomeLabel = new JLabel("Welcome to PhoneBook");
        usernameLabel = new JLabel("Username");
        passwordLabel = new JLabel("Password");
        usernameTextField = new JTextField();
        passwordTextField = new JPasswordField();
        loginButton = new JButton("Login");
        cancelButton = new JButton("Cancel");
        ImageIcon tempImg1 = new ImageIcon(ClassLoader.getSystemResource("Resources/Images/user.png"));
        Image tempImg2 = tempImg1.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon userIcon = new ImageIcon(tempImg2);
        ImageIcon tempImg3 = new ImageIcon(ClassLoader.getSystemResource("Resources/Images/login.png"));
        Image loginIcon = tempImg3.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        iconLabel = new JLabel(userIcon);
        loginPanel = new JPanel();
        headingPanel = new JPanel();
        iconPanel = new JPanel();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Login PhoneBook");
        setLocation(400, 300);
        setSize(530, 250);
        setIconImage(loginIcon);
        setResizable(false);

        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        welcomeLabel.setFont(font1);

        usernameLabel.setFont(font2);

        passwordLabel.setFont(font2);

        usernameTextField.setFont(font2);

        passwordTextField.setFont(font2);

        loginButton.addActionListener(this);
        loginButton.setFont(font2);

        cancelButton.addActionListener(this);
        cancelButton.setFont(font2);

        loginPanel.setLayout(new GridLayout(3 ,2, 10, 10));
        loginPanel.add(usernameLabel);
        loginPanel.add(usernameTextField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordTextField);
        loginPanel.add(loginButton);
        loginPanel.add(cancelButton);

        headingPanel.setLayout(new GridLayout(1, 1, 10, 10));
        headingPanel.add(welcomeLabel);

        iconPanel.setLayout(new GridLayout(1, 1, 10, 10));
        iconPanel.add(iconLabel);

        setLayout(new BorderLayout(10, 20));
        add(headingPanel, "North");
        add(iconPanel, "East");
        add(loginPanel, "Center");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();

        if(e.getSource() == loginButton) {
            try {
                if (username.equals("Admin")) {
                    if (password.equals("Password")) {
                        this.setVisible(false);
                        new PhoneBook().setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Password is not correct.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Username is not correct.");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        if (e.getSource() == cancelButton) {
            this.dispose();
        }
    }
}
