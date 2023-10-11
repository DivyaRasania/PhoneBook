package PhoneBookV2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {
    JLabel welcomeLabel, welcomeLabel2, usernameLabel, passwordLabel, iconLabel;
    JTextField usernameTextField;
    JPasswordField passwordTextField;
    JPanel loginPanel, headingPanel, iconPanel;
    JButton loginButton, cancelButton;
    Font font1, font2, font3;

    public static void main(String[] args) {
        new Login().setVisible(true);
    }

    Login() {
        welcomeLabel = new JLabel("Welcome to PhoneBook");
        welcomeLabel2 = new JLabel("Please login to proceed");
        usernameLabel = new JLabel("Username");
        passwordLabel = new JLabel("Password");
        ImageIcon tempImg1 = new ImageIcon(ClassLoader.getSystemResource("Resources/Images/user.png"));
        Image tempImg2 = tempImg1.getImage().getScaledInstance(128, 128, Image.SCALE_AREA_AVERAGING);
        ImageIcon userIcon = new ImageIcon(tempImg2);
        iconLabel = new JLabel(userIcon);
        usernameTextField = new JTextField();
        passwordTextField = new JPasswordField();
        loginPanel = new JPanel();
        headingPanel = new JPanel();
        iconPanel = new JPanel();
        loginButton = new JButton("Login");
        cancelButton = new JButton("Cancel & Exit");
        font1 = new Font("Calibri", Font.BOLD, 35);
        font2 = new Font("Calibri", Font.BOLD, 30);
        font3 = new Font("Calibri", Font.BOLD, 20);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - (getWidth() + 530)) / 2;
        int y = (screenSize.height - (getHeight() + 300)) / 2;
        ImageIcon tempImg3 = new ImageIcon(ClassLoader.getSystemResource("Resources/Images/login.png"));
        Image loginUserIcon = tempImg3.getImage().getScaledInstance(150, 150, Image.SCALE_AREA_AVERAGING);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocation(x, y);
        setSize(530, 300);
        setIconImage(loginUserIcon);
        setTitle("Login");

        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        welcomeLabel.setFont(font1);

        welcomeLabel2.setHorizontalAlignment(JLabel.CENTER);
        welcomeLabel2.setFont(font2);

        usernameLabel.setFont(font3);

        passwordLabel.setFont(font3);

        usernameTextField.setFont(font3);

        passwordTextField.setFont(font3);

        loginButton.addActionListener(this);
        loginButton.setFont(font3);
        loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        cancelButton.addActionListener(this);
        cancelButton.setFont(font3);
        cancelButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        loginPanel.setLayout(new GridLayout(3 ,2, 10, 10));
        loginPanel.add(usernameLabel);
        loginPanel.add(usernameTextField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordTextField);
        loginPanel.add(loginButton);
        loginPanel.add(cancelButton);

        headingPanel.setLayout(new GridLayout(2, 1, 10, 10));
        headingPanel.add(welcomeLabel);
        headingPanel.add(welcomeLabel2);

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

                // TODO: maybe change username and password before exporting
                if (username.equals("admin")) {
                    if (password.equals("admin")) {
                        this.setVisible(false);
                        new Main().setVisible(true);
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
