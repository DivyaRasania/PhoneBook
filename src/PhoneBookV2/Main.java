package PhoneBookV2;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main extends JFrame {

    // TODO: Remove this psvm method
    public static void main(String[] args) {
        new Main().setVisible(true);
    }

    Main() {
        Font font = new Font("Calibri", Font.PLAIN, 20);

        setTitle("Phone Book");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon tempImg1 = new ImageIcon(ClassLoader.getSystemResource("Resources/Images/phonebook.png"));
        Image tempImg2 = tempImg1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        ImageIcon phoneBookIcon = new ImageIcon(tempImg2);
        setIconImage(phoneBookIcon.getImage());
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - (getWidth() + 975)) / 2;
        int y = (screenSize.height - (getHeight() + 825)) / 2;
        setLocation(x, y);
        setResizable(false);

        // HEADER
        JLabel headerLabel = new JLabel("Contacts");
        headerLabel.setFont(new Font("Calibri", Font.BOLD, 30));
        headerLabel.setHorizontalAlignment(JLabel.CENTER);

        JTextField searchTextField = new JTextField();
        searchTextField.setFont(font);

        ImageIcon tempImg3 = new ImageIcon(ClassLoader.getSystemResource("Resources/Images/search.png"));
        Image tempImg4 = tempImg3.getImage().getScaledInstance(32, 32, Image.SCALE_AREA_AVERAGING);
        ImageIcon searchIcon = new ImageIcon(tempImg4);
        JButton searchButton = new JButton(searchIcon);
        searchButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        ImageIcon tempImg5 = new ImageIcon(ClassLoader.getSystemResource("Resources/Images/add.png"));
        Image tempImg6 = tempImg5.getImage().getScaledInstance(32, 32, Image.SCALE_AREA_AVERAGING);
        ImageIcon addIcon = new ImageIcon(tempImg6);
        JButton createButton = new JButton(addIcon);
        createButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        createButton.addActionListener(e -> {
            this.dispose();
            new Create().setVisible(true);
        });

        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new GridLayout(1, 3, 10, 10));
        searchPanel.add(searchTextField);
        searchPanel.add(searchButton);
        searchPanel.add(createButton);

        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new GridLayout(2, 1, 10, 10));
        headerPanel.add(headerLabel);
        headerPanel.add(searchPanel);

        // CONTACTS
        JTable tableLayout = new JTable(20, 6);
        tableLayout.setFont(font.deriveFont(Font.BOLD, 25));
        tableLayout.setRowHeight(30);

        tableLayout.getColumnModel().getColumn(0).setPreferredWidth(150);
        tableLayout.getColumnModel().getColumn(1).setPreferredWidth(200);
        tableLayout.getColumnModel().getColumn(2).setPreferredWidth(200);
        tableLayout.getColumnModel().getColumn(3).setPreferredWidth(300);
        tableLayout.getColumnModel().getColumn(4).setPreferredWidth(75);
        tableLayout.getColumnModel().getColumn(5).setPreferredWidth(75);

        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);
        renderer.setVerticalAlignment(JLabel.CENTER);

        for (int i = 0; i < 6; i++) {
            tableLayout.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader("out/contacts.txt"));
            String line;
            int row = 0;
            int column = 0;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split("-");
                String[] newContact = line.split("---");

                if (tokens.length == 1 && tokens[0].equals("---")) {
                    row++;
                    column = 0;
                }

                if (tokens.length > 0) {
                    for (int i = 0; i < tokens.length && column < tableLayout.getColumnCount(); i++) {
                        tableLayout.setValueAt(tokens[i], 0, column);
                    }
                    column++;
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("contacts.txt not found");
        }

        JPanel contactsPanel = new JPanel();
        contactsPanel.setLayout(new BorderLayout(10, 10));
        contactsPanel.add(tableLayout);

        // IMPORT/EXPORT
        ImageIcon tempImg7 = new ImageIcon(ClassLoader.getSystemResource("Resources/Images/import.png"));
        Image tempImg8 = tempImg7.getImage().getScaledInstance(32, 32, Image.SCALE_AREA_AVERAGING);
        ImageIcon importIcon = new ImageIcon(tempImg8);
        JButton importButton = new JButton(" Import Contacts", importIcon);
        importButton.setFont(font);
        importButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        ImageIcon tempImg9 = new ImageIcon(ClassLoader.getSystemResource("Resources/Images/export.png"));
        Image tempImg10 = tempImg9.getImage().getScaledInstance(32, 32, Image.SCALE_AREA_AVERAGING);
        ImageIcon exportIcon = new ImageIcon(tempImg10);
        JButton exportButton = new JButton(" Export Contacts", exportIcon);
        exportButton.setFont(font);
        exportButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        JPanel importExportPanel = new JPanel();
        importExportPanel.setLayout(new GridLayout(1, 2, 10, 10));
        importExportPanel.add(importButton);
        importExportPanel.add(exportButton);

        setLayout(new BorderLayout(10, 10));
        add(headerPanel, BorderLayout.NORTH);
        add(contactsPanel, BorderLayout.CENTER);
        add(importExportPanel, BorderLayout.SOUTH);
        pack();
    }
}
