package PhoneBookV2;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    Main() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - (getWidth() + 700)) / 2;
        int y = (screenSize.height - (getHeight() + 450)) / 2;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Phone Book");
        setSize(750, 450);
        setLocation(x, y);
    }
}
