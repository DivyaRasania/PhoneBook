package PhoneBookV2;

import javax.swing.*;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;

public class Main extends JFrame {

    // TODO: Remove this psvm method
    public static void main(String[] args) {
        new Main().setVisible(true);
    }

    Main() {
        Font font = new Font("Calibri", Font.PLAIN, 20);

        setTitle("Phone Book");
        setSize(750, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        ImageIcon tempImg1 = new ImageIcon(ClassLoader.getSystemResource("Resources/Images/phonebook.png"));
        Image tempImg2 = tempImg1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        ImageIcon phoneBookIcon = new ImageIcon(tempImg2);
        setIconImage(phoneBookIcon.getImage());
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
        JTable tableLayout = new JTable(23, 6);
        tableLayout.setFont(font.deriveFont(Font.BOLD, 25));
        tableLayout.setRowHeight(30);

        String[] columnNames = {"Name", "Phone Number", "Email", "Address", "Edit", "Delete"};

        // TODO: change last two column width
        TableColumnModel tableColumnModel = tableLayout.getColumnModel();
        TableColumn tableColumn = tableColumnModel.getColumn(4);
        tableColumn.setPreferredWidth(50);
        tableColumn = tableColumnModel.getColumn(5);
        tableColumn.setPreferredWidth(50);

        // TODO: read from file and populate table
        // Get the table column model
        TableColumnModel tableModel = tableLayout.getColumnModel();

        // Get the table column that you set the preferred width of
        TableColumn tableColumns = tableModel.getColumn(0);

        // Get the minimum width of the column
        int minWidth = tableColumns.getMinWidth();

        // Iterate over the cells in the column and get the width of each cell
        int maxWidth = 0;
        for (int row = 0; row < 20; row++) {
            Component component = tableLayout.prepareRenderer(tableLayout.getCellRenderer(row, 0), row, 0);
            maxWidth = Math.max(maxWidth, component.getPreferredSize().width);
        }

// Get the table column model's auto-resize mode
        int autoResizeMode = tableLayout.getAutoResizeMode();

// Print the minimum width, maximum width, and auto-resize mode
        System.out.println("Minimum width: " + minWidth);
        System.out.println("Maximum width: " + maxWidth);
        System.out.println("Auto-resize mode: " + autoResizeMode);

        for(int column = 0; column < tableLayout.getColumnCount(); column++) {
            tableLayout.setValueAt(columnNames[column], 0, column);
            /*
             * for(int row = 0; row < tableLayout.getRowCount(); row++) {
             *   contactsFile.setValueAt("", row, column);
             * }
             */
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
    }
}
