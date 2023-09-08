/*
 * Filename PhoneBook.java
 * Written by Divya Rasania
 * Written on 9/7/2023
 */

package PhoneBook;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PhoneBook extends JFrame implements ActionListener {
    public static void main(String[] args) {
        new PhoneBook();
    }

    JLabel phonebookLabel, phonebookIconLabel;
    JButton viewContactsButton, createButton, searchButton, editButton, deleteButton, backToLoginButton;
    JPanel headingPanel, buttonsPanel, iconPanel;
    Font font, font1;

    PhoneBook() {
        phonebookLabel = new JLabel("Phone Book");
        ImageIcon tempImg1 = new ImageIcon(ClassLoader.getSystemResource("Resources/Images/phonebook.png"));
        Image tempImg2 = tempImg1.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon phonebookIcon = new ImageIcon(tempImg2);
        phonebookIconLabel = new JLabel(phonebookIcon);
        viewContactsButton = new JButton("View Contacts");
        createButton = new JButton("Create");
        searchButton = new JButton("Search");
        editButton = new JButton("Edit");
        deleteButton = new JButton("Delete");
        backToLoginButton = new JButton("Back to Login");
        headingPanel = new JPanel();
        buttonsPanel = new JPanel();
        iconPanel = new JPanel();
        font = new Font("Calibri", Font.BOLD, 35);
        font1 = new Font("Calibri", Font.BOLD, 20);

        setTitle("Phone Book");
        setLocation(450, 250);
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(phonebookIcon.getImage());

        phonebookLabel.setFont(font);
        phonebookLabel.setHorizontalAlignment(JLabel.CENTER);

        viewContactsButton.setFont(font1);
        viewContactsButton.addActionListener(this);

        createButton.setFont(font1);
        createButton.addActionListener(this);

        searchButton.setFont(font1);
        searchButton.addActionListener(this);

        editButton.setFont(font1);
        editButton.addActionListener(this);

        deleteButton.setFont(font1);
        deleteButton.addActionListener(this);

        backToLoginButton.setFont(font1);
        backToLoginButton.addActionListener(this);

        headingPanel.setLayout(new GridLayout(1, 1, 10, 10));
        headingPanel.add(phonebookLabel);

        buttonsPanel.setLayout(new GridLayout(6, 1, 10, 10));
        buttonsPanel.add(viewContactsButton);
        buttonsPanel.add(createButton);
        buttonsPanel.add(searchButton);
        buttonsPanel.add(editButton);
        buttonsPanel.add(deleteButton);
        buttonsPanel.add(backToLoginButton);

        iconPanel.setLayout(new GridLayout(1, 1, 10, 10));
        iconPanel.add(phonebookIconLabel);

        setLayout(new BorderLayout(10, 20));
        add(headingPanel, "North");
        add(buttonsPanel, "Center");
        add(iconPanel, "East");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewContactsButton) {
            // this.setVisible(false);
            // new ViewContacts().setVisible(true);
            System.out.println("Pressed View Contacts");
        }

        if (e.getSource() == createButton) {
            this.setVisible(false);
            new Create().setVisible(true);
        }

        if (e.getSource() == searchButton) {
            // this.setVisible(false);
            // new Search().setVisible(true);
            System.out.println("Pressed Search");
        }

        if (e.getSource() == editButton) {
            // this.setVisible(false);
            // new Edit().setVisible(true);
            System.out.println("Pressed Edit");
        }

        if (e.getSource() == deleteButton) {
            // this.setVisible(false);
            // new Delete().setVisible(true);
            System.out.println("Pressed Delete");
        }

        if (e.getSource() == backToLoginButton){
            new Login().setVisible(true);
            this.dispose();
        }
    }
}
