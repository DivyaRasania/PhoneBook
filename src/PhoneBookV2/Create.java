package PhoneBookV2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Create extends JFrame implements ActionListener {
    JLabel headingLabel, nameLabel, phoneNumberLabel, emailLabel, addressLabel;
    JTextField nameTextField, phoneNumberTextField, emailTextField, addressTextField;
    JButton addContactButton, backButton;
    JPanel headingPanel, mainPanel;
    Font font, font1;

    // TODO: Remove this psvm method
    public static void main(String[] args) {
        new Create().setVisible(true);
    }

    Create() {
        headingLabel = new JLabel("Add Contact");
        nameLabel = new JLabel("Name");
        phoneNumberLabel = new JLabel("Phone Number");
        emailLabel = new JLabel("Email");
        addressLabel = new JLabel("Address");
        nameTextField = new JTextField();
        phoneNumberTextField = new JTextField();
        emailTextField = new JTextField();
        addressTextField = new JTextField();
        addContactButton = new JButton("Add Contact");
        backButton = new JButton("Back");
        headingPanel = new JPanel();
        mainPanel = new JPanel();
        font = new Font("Calibri", Font.BOLD, 35);
        font1 = new Font("Calibri", Font.PLAIN, 20);
        ImageIcon tempImg = new ImageIcon(ClassLoader.getSystemResource("Resources/Images/user.png"));
        Image addUserIcon = tempImg.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - (getWidth() + 500)) / 2;
        int y = (screenSize.height - (getHeight() + 450)) / 2;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocation(x, y);
        setSize(400, 400);
        setIconImage(addUserIcon);
        setTitle("Create Contact");

        headingLabel.setFont(font);
        headingLabel.setHorizontalAlignment(JLabel.CENTER);

        nameLabel.setFont(font1);
        phoneNumberLabel.setFont(font1);
        emailLabel.setFont(font1);
        addressLabel.setFont(font1);

        nameTextField.setFont(font1);
        phoneNumberTextField.setFont(font1);
        emailTextField.setFont(font1);
        addressTextField.setFont(font1);

        addContactButton.setFont(font1.deriveFont(Font.BOLD));
        addContactButton.addActionListener(this);
        addContactButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        backButton.setFont(font1.deriveFont(Font.BOLD));
        backButton.addActionListener(this);
        backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        headingPanel.setLayout(new GridLayout(1, 1, 10, 10));
        headingPanel.add(headingLabel);

        mainPanel.setLayout(new GridLayout(5, 2, 10, 10));
        mainPanel.add(nameLabel);
        mainPanel.add(nameTextField);
        mainPanel.add(phoneNumberLabel);
        mainPanel.add(phoneNumberTextField);
        mainPanel.add(emailLabel);
        mainPanel.add(emailTextField);
        mainPanel.add(addressLabel);
        mainPanel.add(addressTextField);
        mainPanel.add(addContactButton);
        mainPanel.add(backButton);

        setLayout(new BorderLayout(10, 20));
        add(headingPanel, "North");
        add(mainPanel, "Center");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = nameTextField.getText(),
               email = emailTextField.getText(),
               address = addressTextField.getText(),
               phoneNumber = phoneNumberTextField.getText();
        boolean isFileSaved = false;

        if (e.getSource() == addContactButton) {
            try {
                if (name.equals("") || email.equals("") || address.equals("") || phoneNumber.equals("")) {
                    JOptionPane.showMessageDialog(this, "Please fill all the fields.");
                    return;
                }
            } catch (NullPointerException e1) {
                JOptionPane.showMessageDialog(this, "Please fill all the fields.");
                return;
            }

            try {
                FileWriter fileWriter = new FileWriter("out/contacts.txt", true);
                PrintWriter printWriter = new PrintWriter(fileWriter);

                printWriter.println(name + " -\n" +
                                    phoneNumber + " -\n" +
                                    email + " -\n" +
                                    address + " -\n---");

                isFileSaved = true;
                printWriter.close();
                fileWriter.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

            if (!isFileSaved) {
                JOptionPane.showMessageDialog(this, "There was an error saving the contact.");
            } else {
                JOptionPane.showMessageDialog(this, "Contact created successfully!");
            }
            this.dispose();
            new Create().setVisible(true);

        } else if (e.getSource() == backButton) {
            this.dispose();
            new Main().setVisible(true);
        }
    }
}