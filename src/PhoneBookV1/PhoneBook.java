/*
 * Filename PhoneBook.java
 * Written by Divya Rasania
 * Written on 09/07/2023
 */

package PhoneBookV1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PhoneBook extends JFrame implements ActionListener {
    JLabel phonebookLabel, phonebookIconLabel;
    JButton createButton, viewOrSearchButton, editButton, deleteButton, backToLoginButton;
    JPanel headingPanel, buttonsPanel, iconPanel;
    Font font, font1;

    public static void main(String[] args) {
        new PhoneBook().setVisible(true);
    }

    PhoneBook() {
        phonebookLabel = new JLabel("Phone Book");
        ImageIcon tempImg1 = new ImageIcon(ClassLoader.getSystemResource("Resources/Images/phonebook.png"));
        Image tempImg2 = tempImg1.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon phonebookIcon = new ImageIcon(tempImg2);
        phonebookIconLabel = new JLabel(phonebookIcon);
        createButton = new JButton("Create");
        viewOrSearchButton = new JButton("View/Search");
        editButton = new JButton("Edit");
        deleteButton = new JButton("Delete");
        backToLoginButton = new JButton("Back to PhoneBookV2.Login");
        headingPanel = new JPanel();
        buttonsPanel = new JPanel();
        iconPanel = new JPanel();
        font = new Font("Calibri", Font.BOLD, 35);
        font1 = new Font("Calibri", Font.BOLD, 20);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - (getWidth() + 500)) / 2;
        int y = (screenSize.height - (getHeight() + 450)) / 2;

        setTitle("Phone Book");
        setLocation(x, y);
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(phonebookIcon.getImage());

        phonebookLabel.setFont(font);
        phonebookLabel.setHorizontalAlignment(JLabel.CENTER);

        createButton.setFont(font1);
        createButton.addActionListener(this);

        viewOrSearchButton.setFont(font1);
        viewOrSearchButton.addActionListener(this);

        editButton.setFont(font1);
        editButton.addActionListener(this);

        deleteButton.setFont(font1);
        deleteButton.addActionListener(this);

        backToLoginButton.setFont(font1);
        backToLoginButton.addActionListener(this);

        headingPanel.setLayout(new GridLayout(1, 1, 10, 10));
        headingPanel.add(phonebookLabel);

        buttonsPanel.setLayout(new GridLayout(5, 1, 10, 10));
        buttonsPanel.add(createButton);
        buttonsPanel.add(viewOrSearchButton);
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
        if (e.getSource() == createButton) {
            this.setVisible(false);
            new Create().setVisible(true);
        }

        if (e.getSource() == viewOrSearchButton) {
//            this.setVisible(false);
//            new ViewOrSearch().setVisible(true);
        }

        if (e.getSource() == editButton) {
//            this.setVisible(false);
//            new Edit().setVisible(true);
        }

        if (e.getSource() == deleteButton) {
//            this.setVisible(false);
//            new Delete().setVisible(true);
        }

        if (e.getSource() == backToLoginButton){
            new Login().setVisible(true);
            this.dispose();
        }
    }
}
