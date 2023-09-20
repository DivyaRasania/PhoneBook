package PhoneBookV2;

/*
 * Filename Main.java
 * Written by Divya Rasania
 * Written on 09/06/2023
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {
    JLabel welcomeLabel;
    JTextField searchBar;
    JButton searchButton, addButton, editButton, deleteButton, exportButton, importButton;
    JPanel searchPanel, contactsPanel, importExportPanel;
    Font font1, font2, font3;
    ImageIcon phoneBookIcon, searchIcon, addIcon, editIcon, deleteIcon, exportIcon, importIcon;

    // TODO: Remove this psvm method
    public static void main(String[] args) {
        new Main().setVisible(true);
    }

    Main() {
        ImageIcon tempImg1 = new ImageIcon(ClassLoader.getSystemResource("Resources/Images/phonebook.png"));
        Image tempImg2 = tempImg1.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        phoneBookIcon = new ImageIcon(tempImg2);
        ImageIcon tempImg3 = new ImageIcon(ClassLoader.getSystemResource("Resources/Images/add.png"));
        Image tempImg4 = tempImg3.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        addIcon = new ImageIcon(tempImg4);
        ImageIcon tempImg5 = new ImageIcon(ClassLoader.getSystemResource("Resources/Images/search.png"));
        Image tempImg6 = tempImg5.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        searchIcon = new ImageIcon(tempImg6);
        ImageIcon tempImg7 = new ImageIcon(ClassLoader.getSystemResource("Resources/Images/edit.png"));
        Image tempImg8 = tempImg7.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        editIcon = new ImageIcon(tempImg8);
        ImageIcon tempImg9 = new ImageIcon(ClassLoader.getSystemResource("Resources/Images/delete.png"));
        Image tempImg10 = tempImg9.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        deleteIcon = new ImageIcon(tempImg10);
        ImageIcon tempImg11 = new ImageIcon(ClassLoader.getSystemResource("Resources/Images/export.png"));
        Image tempImg12 = tempImg11.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        exportIcon = new ImageIcon(tempImg12);
        ImageIcon tempImg13 = new ImageIcon(ClassLoader.getSystemResource("Resources/Images/import.png"));
        Image tempImg14 = tempImg13.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        importIcon = new ImageIcon(tempImg14);
        searchBar = new JTextField();
        searchButton = new JButton(searchIcon);
        addButton = new JButton(addIcon);
        editButton = new JButton(editIcon);
        deleteButton = new JButton(deleteIcon);
        exportButton = new JButton(exportIcon);
        importButton = new JButton(importIcon);
        searchPanel = new JPanel();
        contactsPanel = new JPanel();
        importExportPanel = new JPanel();
        welcomeLabel = new JLabel("Contacts");
        font1 = new Font("Calibri", Font.BOLD, 35);
        font2 = new Font("Calibri", Font.BOLD, 30);
        font3 = new Font("Calibri", Font.BOLD, 25);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - (getWidth() + 700)) / 2;
        int y = (screenSize.height - (getHeight() + 450)) / 2;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Phone Book");
        setSize(750, 450);
        setLocation(x, y);
        setIconImage(phoneBookIcon.getImage());
        setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
