package PhoneBookV2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * A class to create a new contact in the phone book.
 */
public class Create extends JFrame implements ActionListener {

    // Component declarations
    private JLabel headingLabel, nameLabel, phoneNumberLabel, emailLabel, addressLabel;
    private JTextField nameTextField, phoneNumberTextField, emailTextField, addressTextField;
    private JButton addContactButton, backButton;
    private JPanel headingPanel, mainPanel;

    // Font declarations
    private Font font, font1;

    // Constructor
    public Create() {
        // Initialize component values
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

        // Load the user icon
        ImageIcon tempImg = new ImageIcon(ClassLoader.getSystemResource("Resources/Images/user.png"));
        Image addUserIcon = tempImg.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);

        // Set frame properties
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setSize(400, 400);
        setIconImage(addUserIcon);
        setTitle("Create Contact");

        // Set component fonts
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

        // Set panel layouts
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

        // Set frame layout
        setLayout(new BorderLayout(10, 20));
        add(headingPanel, "North");
        add(mainPanel, "Center");

        // Pack the frame
        pack();

        // Set the frame to visible
        setVisible(true);
    }

    /**
     * Handles button
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Get the contact details from the text fields
        String name = nameTextField.getText();
        String email = emailTextField.getText();
        String address = addressTextField.getText();
        String phoneNumber = phoneNumberTextField.getText();

        if (e.getSource() == backButton) {
           this.dispose();
           new Contacts().setVisible(true);
        }

        // Check if all the fields are filled
        if (name.isEmpty() || email.isEmpty() || address.isEmpty() || phoneNumber.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all the fields.");
            return;
        }

        // Write the contact details to the file
        boolean isFileSaved = false;
        try {
            FileWriter fileWriter = new FileWriter("src/contacts.txt", true);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.println(name + "\t\n" +
                    phoneNumber + "\t\n" +
                    email + "\t\n" +
                    address + "\t\n---");

            isFileSaved = true;
            printWriter.close();
            fileWriter.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        // Show a message to the user
        if (!isFileSaved) {
            JOptionPane.showMessageDialog(this, "There was an error saving the contact.");
        } else {
            JOptionPane.showMessageDialog(this, "Contact created successfully!");
        }

        // Close the frame
        this.dispose();

        // Open the main frame
        new Contacts().setVisible(true);
    }
}
