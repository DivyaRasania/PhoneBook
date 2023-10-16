package PhoneBookV2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A login screen for the PhoneBook application.
 *
 * @author Divya Rasania
 */
public class Login extends JFrame implements ActionListener {

    private static final String DEFAULT_USERNAME = "admin";
    private static final String DEFAULT_PASSWORD = "admin";

    private JLabel welcomeLabel, welcomeLabel2, usernameLabel, passwordLabel, iconLabel;
    private JTextField usernameTextField;
    private JPasswordField passwordTextField;
    private JPanel loginPanel, headingPanel, iconPanel;
    private JButton loginButton, cancelButton;
    private Font font1, font2, font;

    public Login() {
        initializeComponents();
        layoutComponents();
        addListeners();
    }

    private void initializeComponents() {
        welcomeLabel = new JLabel("Welcome to PhoneBook");
        welcomeLabel2 = new JLabel("Please login to proceed");
        usernameLabel = new JLabel("Username");
        passwordLabel = new JLabel("Password");
        iconLabel = new JLabel(new ImageIcon(ClassLoader.getSystemResource("Resources/Images/user.png")));
        usernameTextField = new JTextField();
        passwordTextField = new JPasswordField();
        loginPanel = new JPanel();
        headingPanel = new JPanel();
        iconPanel = new JPanel();
        loginButton = new JButton("Login");
        cancelButton = new JButton("Cancel & Exit");
        font = new Font("Calibri", Font.BOLD, 20);
    }

    private void layoutComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setIconImage(new ImageIcon(ClassLoader.getSystemResource("Resources/Images/login.png")).getImage());
        setTitle("Login");
        setLayout(new BorderLayout(10, 20));

        welcomeLabel.setFont(new Font("Calibri", Font.BOLD, 35));
        welcomeLabel2.setFont(new Font("Calibri", Font.BOLD, 30));
        usernameLabel.setFont(font);
        usernameTextField.setFont(font);
        passwordLabel.setFont(font);
        passwordTextField.setFont(font);
        loginButton.setFont(font);
        cancelButton.setFont(font);

        // Heading panel
        headingPanel.setLayout(new GridLayout(2, 1, 10, 10));
        headingPanel.add(welcomeLabel);
        headingPanel.add(welcomeLabel2);

        // Icon panel
        iconPanel.setLayout(new GridLayout(1, 1, 10, 10));
        iconPanel.add(iconLabel);

        // Login panel
        loginPanel.setLayout(new GridLayout(3, 2, 10, 10));
        loginPanel.add(usernameLabel);
        loginPanel.add(usernameTextField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordTextField);
        loginPanel.add(loginButton);
        loginPanel.add(cancelButton);

        // Add panels to the main frame
        add(headingPanel, BorderLayout.NORTH);
        add(iconPanel, BorderLayout.EAST);
        add(loginPanel, BorderLayout.CENTER);
        pack();
    }

    private void addListeners() {
        loginButton.addActionListener(this);
        cancelButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            // Get the username and password from the text fields
            String username = usernameTextField.getText();
            String password = passwordTextField.getText();

            // Validate the username and password
            if (username.equals(DEFAULT_USERNAME) && password.equals(DEFAULT_PASSWORD)) {
                // Login successful
                this.setVisible(false);
                new Contacts().setVisible(true);
            } else {
                // Login failed
                JOptionPane.showMessageDialog(null, "Invalid username or password.");
            }
        } else if (e.getSource() == cancelButton) {
            // Exit the application
            this.dispose();
        }
    }
}