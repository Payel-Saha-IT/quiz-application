package quiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener{

    String userName;
    JButton start,back;
    Rules(String userName)
    {
        this.userName=userName;
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel heading=new JLabel("Welcome "+userName+" to Brainy Quest");
        heading.setBounds(50,20,700,30);
        heading.setFont(new Font("Viner Hand ITC",Font.BOLD,28));
        heading.setForeground(new Color(247, 7, 115));
        add(heading);

        JLabel ruleList=new JLabel();
        ruleList.setBounds(20,90,700,400);
        ruleList.setFont(new Font("Times New Roman",Font.PLAIN,16));
        ruleList.setText(
                "<html>"+
                        "1. Avoid cheating or using unauthorized aids." + "<br><br>" +
                        "2. Play honestly and ethically, avoiding unfair advantages" + "<br><br>" +
                        "3. Accept outcomes gracefully without disruptive behavior" + "<br><br>" +
                        "4. Maintain a supportive and uplifting atmosphere." + "<br><br>" +
                        "5. Minimize disruptions during the activity." + "<br><br>" +
                        "6. Congratulate and celebrate others' achievements sincerely." + "<br><br>" +
                        "7. Prioritize adherence to safety guidelines and precautions." + "<br><br>" +
                        "8. Offer feedback in a constructive and respectful manner." + "<br><br>" +
                        "9. May your answers be as bright as your smile, and may luck stick to you like gum on a shoe during the quiz!" + "<br><br>" +
                        "10. Best of luck on the quiz! You've got this!" + "<br><br>" +
                        "<html>"
        );
        add(ruleList);

        start=new JButton("Start");
        start.setBounds(250,500,100,30);
        start.setBackground(new Color(247,7,115));
        start.setForeground(Color.white);
        start.addActionListener(this);
        add(start);

        back=new JButton("Back");
        back.setBounds(400,500,100,30);
        back.setBackground(new Color(247,7,115));
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);


        setSize(800,650);
        setLocation(350,80);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==start)
        {
            setVisible(false);
            new QuizPlay(userName);

        }
        else if (e.getSource()==back) {
            setVisible(false);
            new LogInPage();
        }
    }
    public static void main(String[] args) {
        new Rules("User");
    }
}
