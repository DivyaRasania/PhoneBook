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
        new PhoneBook().setVisible(true);
    }

    JLabel phonebookLabel, phonebookIconLabel;
    JButton entryButton, searchButton, editButton, deleteButton, backToLoginButton;
    JPanel buttonsPanel, headingPanel, iconPanel;
    Font font, font1;

    PhoneBook() {
        font = new Font("Calibri", Font.BOLD, 20);
        font1 = new Font("Calibri", Font.BOLD, 15);
        phonebookLabel = new JLabel("Phone Book");
        entryButton = new JButton("Entry");
        searchButton = new JButton("Search");
        editButton = new JButton("Edit");
        deleteButton = new JButton("Delete");
        backToLoginButton = new JButton("Back to Login");
        ImageIcon tempImg1 = new ImageIcon(ClassLoader.getSystemResource("Resources/Images/phonebook.png"));
        Image tempImg2 = tempImg1.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon phonebookIcon = new ImageIcon(tempImg2);
        buttonsPanel = new JPanel();
        headingPanel = new JPanel();
        iconPanel = new JPanel();
        phonebookIconLabel = new JLabel(phonebookIcon);

        setTitle("Phone Book");
        setLocation(450, 250);
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        phonebookLabel.setHorizontalAlignment(JLabel.CENTER);

        entryButton.addActionListener(this);
        searchButton.addActionListener(this);
        editButton.addActionListener(this);
        deleteButton.addActionListener(this);
        backToLoginButton.addActionListener(this);

        phonebookLabel.setFont(font);
        entryButton.setFont(font1);
        searchButton.setFont(font1);
        editButton.setFont(font1);
        deleteButton.setFont(font1);
        backToLoginButton.setFont(font1);

        buttonsPanel.setLayout(new GridLayout(5, 1, 10, 10));
        buttonsPanel.add(entryButton);
        buttonsPanel.add(searchButton);
        buttonsPanel.add(editButton);
        buttonsPanel.add(deleteButton);
        buttonsPanel.add(backToLoginButton);

        headingPanel.setLayout(new GridLayout(1, 1, 10, 10));
        headingPanel.add(phonebookLabel);

        iconPanel.setLayout(new GridLayout(1, 1, 10, 10));
        iconPanel.add(phonebookIconLabel);

        setLayout(new BorderLayout(10, 20));
        add(buttonsPanel, "Center");
        add(headingPanel, "North");
        add(iconPanel, "East");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == entryButton) {
            // this.setVisible(false);
            System.out.println("Pressed Entry");
            // new Entry().setVisible(true);
        } else if (e.getSource() == searchButton) {
            // this.setVisible(false);
            System.out.println("Pressed Search");
            // new Search().setVisible(true);
        } else if (e.getSource() == editButton) {
            // this.setVisible(false);
            System.out.println("Pressed Edit");
            // new Edit().setVisible(true);
        } else if (e.getSource() == deleteButton) {
            // this.setVisible(false);
            System.out.println("Pressed Delete");
            // new Delete().setVisible(true);
        } else {
            new Login().setVisible(true);
            this.dispose();
        }
    }
}
