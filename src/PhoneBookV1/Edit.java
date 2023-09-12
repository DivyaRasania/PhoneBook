/*
 * Filename Edit.java
 * Written by Divya Rasania
 * Written on 09/08/2023
 */

package PhoneBookV1;

import javax.swing.*;
import java.awt.*;

public class Edit extends JFrame {
    public static void main(String[] args) {
        new Edit().setVisible(true);
    }

    Edit() {
        ImageIcon tempImg = new ImageIcon(ClassLoader.getSystemResource("Resources/Images/edit.png"));
        Image editIcon = tempImg.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - (getWidth() + 500)) / 2;
        int y = (screenSize.height - (getHeight() + 300)) / 2;

        setTitle("Edit Contacts");
        setSize(700, 400);
        setLocation(x, y);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setIconImage(editIcon);
        setResizable(false);
    }
}
