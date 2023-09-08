/*
 * Filename Create.java
 * Written by Divya Rasania
 * Written on 9/7/2023
 */

package PhoneBook;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

public class Create extends JFrame implements ActionListener {
    JLabel headingLabel, idLabel, nameLabel, phoneNumberLabel, emailLabel, addressLabel;
    JTextField idTextField, nameTextField, phoneNumberTextField, emailTextField, addressTextField;
    JButton addContactButton, backButton;
    JPanel headingPanel, mainPanel;
    Font font, font1;
    int id;

    public static void main(String[] args) {
        // TODO: remove .setVisible(true);
        new Create().setVisible(true);
    }

    Create() {
        headingLabel = new JLabel("Add Contact");
        idLabel = new JLabel("ID");
        nameLabel = new JLabel("Name");
        phoneNumberLabel = new JLabel("Phone Number");
        emailLabel = new JLabel("Email");
        addressLabel = new JLabel("Address");
        idTextField = new JTextField();
        nameTextField = new JTextField();
        phoneNumberTextField = new JTextField();
        emailTextField = new JTextField();
        addressTextField = new JTextField();
        addContactButton = new JButton("Add Contact");
        backButton = new JButton("Back");
        headingPanel = new JPanel();
        mainPanel = new JPanel();
        font = new Font("Calibri", Font.BOLD, 35);
        font1 = new Font("Calibri", Font.BOLD, 20);
        ImageIcon tempImg = new ImageIcon(ClassLoader.getSystemResource("Resources/Images/add-user.png"));
        Image addUserIcon = tempImg.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocation(500, 200);
        setSize(400, 450);
        setIconImage(addUserIcon);
        setTitle("Create Contact");

        headingLabel.setFont(font);
        headingLabel.setHorizontalAlignment(JLabel.CENTER);

        idLabel.setFont(font1);
        nameLabel.setFont(font1);
        phoneNumberLabel.setFont(font1);
        emailLabel.setFont(font1);
        addressLabel.setFont(font1);

        id = UUID.randomUUID().hashCode();
        idTextField.setFont(font1);
        idTextField.setEditable(false);
        idTextField.setText(String.valueOf(id));
        nameTextField.setFont(font1);
        phoneNumberTextField.setFont(font1);
        emailTextField.setFont(font1);
        addressTextField.setFont(font1);

        addContactButton.setFont(font1);
        addContactButton.addActionListener(this);

        backButton.setFont(font1);
        backButton.addActionListener(this);

        headingPanel.setLayout(new GridLayout(1, 1, 10, 10));
        headingPanel.add(headingLabel);

        mainPanel.setLayout(new GridLayout(6, 2, 10, 10));
        mainPanel.add(idLabel);
        mainPanel.add(idTextField);
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
                FileWriter fileWriter = new FileWriter(System.getProperty("user.home") + "/Desktop/Contacts.txt", true);
                PrintWriter printWriter = new PrintWriter(fileWriter);

                printWriter.println("id: " + id + ",\n" +
                                    "name: " + name + ",\n" +
                                    "email: " + email + ",\n" +
                                    "address: " + address + ",\n" +
                                    "phoneNumber: " + phoneNumber + "\n");

                isFileSaved = true;
                printWriter.close();
                fileWriter.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

            if (isFileSaved) {
                JOptionPane.showMessageDialog(this, "Contact created successfully!");
                this.dispose();
                new Create().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "There was an error saving the contact.");
                this.dispose();
                new Create().setVisible(true);
            }

        } else if (e.getSource() == backButton) {
            this.dispose();
            new PhoneBook().setVisible(true);
        }
    }
}