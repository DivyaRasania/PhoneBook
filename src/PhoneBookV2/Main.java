package PhoneBookV2;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

public class Main extends JFrame {

    // TODO: Remove this psvm method
    public static void main(String[] args) {
        new Main().setVisible(true);
    }

    Main() {
        Font font = new Font("Calibri", Font.PLAIN, 20);
        JTable tableLayout = new JTable(20, 6);

        setTitle("Phone Book");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon tempImgIco1 = new ImageIcon(ClassLoader.getSystemResource("Resources/Images/phonebook.png"));
        Image tempImg1 = tempImgIco1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        ImageIcon phoneBookIcon = new ImageIcon(tempImg1);
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

        ImageIcon tempImgIco2 = new ImageIcon(ClassLoader.getSystemResource("Resources/Images/search.png"));
        Image tempImg2 = tempImgIco2.getImage().getScaledInstance(32, 32, Image.SCALE_AREA_AVERAGING);
        ImageIcon searchIcon = new ImageIcon(tempImg2);
        JButton searchButton = new JButton(searchIcon);
        searchButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        searchButton.addActionListener(e -> {
            String searchTerm = searchTextField.getText();
            TableRowSorter tableRowSorter = new TableRowSorter(tableLayout.getModel());
            tableLayout.setRowSorter(tableRowSorter);

            tableRowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchTerm));
        });

        ImageIcon tempImgIco3 = new ImageIcon(ClassLoader.getSystemResource("Resources/Images/add.png"));
        Image tempImg3 = tempImgIco3.getImage().getScaledInstance(32, 32, Image.SCALE_AREA_AVERAGING);
        ImageIcon addIcon = new ImageIcon(tempImg3);
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
        tableLayout.setEnabled(false);
        tableLayout.setFont(font.deriveFont(Font.BOLD, 25));
        tableLayout.setRowHeight(30);

        String[] columnNames = {"Name", "Phone Number", "Email", "Address", "Edit", "Delete"};
        for(int column = 0; column < tableLayout.getColumnCount(); column++) {
            tableLayout.setValueAt(columnNames[column], 0, column);
        }

        tableLayout.getColumnModel().getColumn(0).setPreferredWidth(150);
        tableLayout.getColumnModel().getColumn(1).setPreferredWidth(200);
        tableLayout.getColumnModel().getColumn(2).setPreferredWidth(200);
        tableLayout.getColumnModel().getColumn(3).setPreferredWidth(400);
        tableLayout.getColumnModel().getColumn(4).setPreferredWidth(50);
        tableLayout.getColumnModel().getColumn(5).setPreferredWidth(75);

        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);
        renderer.setVerticalAlignment(JLabel.CENTER);

        //TODO: Add edit and delete buttons

        try {
            BufferedReader reader = new BufferedReader(new FileReader("out/contacts.txt"));
            String line;
            int row = 2;
            int column = 0;
            boolean newContact = false;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(" -");

                if (tokens.length == 1 && tokens[0].equals("---")) {
                    newContact = true;
                    row++;
                    column = 0;
                }

                if (tokens.length > 0) {
                    for (int i = 0; i < tokens.length && column < tableLayout.getColumnCount(); i++) {
                        tableLayout.setValueAt(tokens[i], row, column);
                    }

                    if (newContact) {
                        row++;
                        newContact = false;
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
        ImageIcon tempImgIco5 = new ImageIcon(ClassLoader.getSystemResource("Resources/Images/import.png"));
        Image tempImg5 = tempImgIco5.getImage().getScaledInstance(32, 32, Image.SCALE_AREA_AVERAGING);
        ImageIcon importIcon = new ImageIcon(tempImg5);
        JButton importButton = new JButton(" Import Contacts", importIcon);
        importButton.setFont(font);
        importButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        importButton.addActionListener(e -> {
            int result = JOptionPane.showConfirmDialog(null, "Do you want to import the file?", "Import File",
                    JOptionPane.YES_NO_OPTION);

            Path projectFolderPath = Paths.get("out");
            Path desktopPath = Paths.get(System.getProperty("user.home"), "Desktop");
            Path projectFilePath = projectFolderPath.resolve("contacts.txt");

            if (result == JOptionPane.YES_OPTION) {
                int ready = JOptionPane.showConfirmDialog(null,
                        "Please rename your file to contacts.txt and put it on desktop. \nThen click on Yes to continue and No to cancel",
                        "Rename your file", JOptionPane.YES_NO_OPTION);

                try {
                    Files.copy(desktopPath.resolve("contacts.txt"), projectFilePath);
                } catch (NoSuchFileException e2) {
                    JOptionPane.showConfirmDialog(null,
                            "There was an problem importing the file. \nPlease try to rename the file to contacts.txt and put it on desktop.",
                            "Rename your file", JOptionPane.YES_NO_OPTION);
                    ready = 0;
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                if (ready == 0) {
                    try {
                        Files.delete(Path.of("out/contacts.txt"));
                        Files.copy(desktopPath.resolve("contacts.txt"), projectFilePath);
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            }

            new Main().setVisible(true);
            this.dispose();
        });

        ImageIcon tempImgIco6 = new ImageIcon(ClassLoader.getSystemResource("Resources/Images/export.png"));
        Image tempImg6 = tempImgIco6.getImage().getScaledInstance(32, 32, Image.SCALE_AREA_AVERAGING);
        ImageIcon exportIcon = new ImageIcon(tempImg6);
        JButton exportButton = new JButton(" Export Contacts", exportIcon);
        exportButton.setFont(font);
        exportButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        exportButton.addActionListener(e -> {
            int result = JOptionPane.showConfirmDialog(null, "Do you want to export the file?", "Export File",
                    JOptionPane.YES_NO_OPTION);

            Path projectFolderPath = Paths.get("out");
            Path desktopPath = Paths.get(System.getProperty("user.home"), "Desktop");
            Path projectFilePath = projectFolderPath.resolve("contacts.txt");
            LocalDate currentDate = LocalDate.now();

            if (result == JOptionPane.YES_OPTION) {
                try {
                    Files.copy(projectFilePath, desktopPath.resolve("Contacts Export " + currentDate + ".txt"));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

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
