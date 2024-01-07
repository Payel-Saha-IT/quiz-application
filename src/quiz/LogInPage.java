package quiz;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LogInPage extends JFrame implements ActionListener{
    JButton rules,back;
    JTextField tf;
    LogInPage()
    {

        getContentPane().setBackground(Color.white);

        setLayout(null);
        ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("image/LogIn.jpg"));
        JLabel image=new JLabel(i);
        image.setBounds(0,0,600,500);
        add(image);

        JLabel heading=new JLabel("Brainy Quest");
        heading.setBounds(750,60,300,45);
        heading.setFont(new Font("Viner Hand ITC",Font.BOLD,40));
        heading.setForeground(new Color(247, 7, 115));
        add(heading);

        JLabel name=new JLabel("Enter Your Name");
        name.setBounds(810,150,300,20);
        name.setFont(new Font("Mongolian Baiti",Font.BOLD,18));
        name.setForeground(new Color(247, 7, 115));
        add(name);

        tf=new JTextField();
        tf.setBounds(735,200,300,25);
        tf.setFont(new Font("Times New Roman",Font.BOLD,20));
        add(tf);

        rules=new JButton("Rules");
        rules.setBounds(735,270,120,25);
        rules.setBackground(new Color(247,7,115));
        rules.setForeground(Color.white);
        rules.addActionListener(this);
        add(rules);

        back=new JButton("Back");
        back.setBounds(915,270,120,25);
        back.setBackground(new Color(247,7,115));
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        setSize(1200,500);
        setLocation(120,120);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==rules)
        {

            String userName=tf.getText();
            setVisible(false);
            new Rules(userName);
        }

        else if(e.getSource()==back)
        {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new LogInPage();
    }
}
