package PhoneBookV2;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TableMouseListener extends MouseAdapter {

    @Override
    public void mouseClicked(MouseEvent e) {
        JTable table = (JTable) e.getSource();
        int columnIndex = table.getColumnModel().getColumnIndexAtX(e.getX());

        if (columnIndex == 4) {
            System.out.println("Contact Edited.");
        }

        if (columnIndex == 5) {
            System.out.println("Contact Deleted.");
        }
    }
}
