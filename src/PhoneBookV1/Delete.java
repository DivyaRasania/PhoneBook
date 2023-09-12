/*
 * Filename Delete.java
 * Written by Divya Rasania
 * Written on 09/09/2023
 */

package PhoneBookV1;

import javax.swing.*;
import java.awt.*;

public class Delete extends JFrame {
    public static void main(String[] args) {
        new Delete().setVisible(true);
    }

    Delete() {
        ImageIcon tempImg = new ImageIcon(ClassLoader.getSystemResource("Resources/Images/delete.png"));
        Image deleteIcon = tempImg.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - (getWidth() + 500)) / 2;
        int y = (screenSize.height - (getHeight() + 300)) / 2;

        setTitle("Delete Contacts");
        setSize(500, 500);
        setLocation(x, y);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setIconImage(deleteIcon);
        setResizable(false);
    }
}
