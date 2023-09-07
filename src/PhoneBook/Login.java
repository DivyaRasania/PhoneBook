package PhoneBook;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {
    public static void main(String[] args) {
        new Login().setVisible(true);
    }

    JLabel l1, l2, l3, l4;
    JTextField tf;
    JPasswordField pf;
    JPanel p1, p2, p3;
    JButton b1, b2;
    Font f1, f2;

    Login() {
        f1 = new Font("Arial", Font.BOLD, 25);
        f2 = new Font("Arial", Font.BOLD, 18);
        l1 = new JLabel("Welcome to PhoneBook");
        l2 = new JLabel("Username");
        l3 = new JLabel("Password");
        tf = new JTextField();
        pf = new JPasswordField();
        b1 = new JButton("Login");
        b2 = new JButton("Cancel");
        ImageIcon tempImg1 = new ImageIcon(ClassLoader.getSystemResource("phonebookImg.png"));
        Image tempImg2 = tempImg1.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon img = new ImageIcon(tempImg2);
        l4 = new JLabel(img);
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Login PhoneBook");
        setLocation(400, 300);
        setSize(550, 250);
        setIconImage(tempImg2);
        setResizable(false);

        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setFont(f1);

        l2.setFont(f2);

        l3.setFont(f2);

        tf.setFont(f2);

        pf.setFont(f2);

        b1.addActionListener(this);
        b1.setFont(f2);

        b2.addActionListener(this);
        b2.setFont(f2);

        p1.setLayout(new GridLayout(3 ,2, 10, 10));
        p1.add(l2);
        p1.add(tf);
        p1.add(l3);
        p1.add(pf);
        p1.add(b1);
        p1.add(b2);

        p2.setLayout(new GridLayout(1, 1, 10, 10));
        p2.add(l1);

        p3.setLayout(new GridLayout(1, 1, 10, 10));
        p3.add(l4);

        setLayout(new BorderLayout(10, 20));
        add(p2, "North");
        add(p3, "East");
        add(p1, "Center");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = tf.getText();
        String password = pf.getText();

        if(e.getSource() == b1) {
            try {
                if (username.equals("Admin")) {
                    if (password.equals("Password")) JOptionPane.showMessageDialog(null, "You are in.");//new Home().setVisible(true);
                    else JOptionPane.showMessageDialog(null, "Password is not correct.");
                } else JOptionPane.showMessageDialog(null, "Username is not correct.");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        if (e.getSource() == b2) {
            this.dispose();
        }
    }
}
