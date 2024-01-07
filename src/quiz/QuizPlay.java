package quiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class QuizPlay extends JFrame implements ActionListener {
    String questions[][]=new String[10][5];
    String answers[][]=new String[10][2];
    String userAnswers[][]=new String[10][1];
    JLabel questionNum,question;
    JRadioButton opt1,opt2,opt3,opt4;
    JButton next,lifeline,submit;
    public static int timer=40;
    public static int ans_given=0;
    public static int count=0;
    public static int score=0;
    ButtonGroup groupOption;
    String userName;
    QuizPlay(String userName)
    {
        this.userName=userName;
        getContentPane().setBackground(Color.white);

        setLayout(null);

        ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("image/welcome.jpg"));
        JLabel image=new JLabel(i);
        image.setBounds(0,0,1200,360);
        add(image);

        questionNum=new JLabel();
        questionNum.setBounds(100,400,50,30);
        questionNum.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(questionNum);

        question=new JLabel();
        question.setBounds(150,400,1000,30);
        question.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(question);


        questions[0][0] = "Which film was selected as the ‘best film-drama’"+'\n'+"in the Global Globes Award 2023?";
        questions[0][1] = "Avatar: The Way of Water";
        questions[0][2] = " Elvis";
        questions[0][3] = "The Fabelmans";
        questions[0][4] = "Top Gun: Maverick";

        questions[1][0] = "In the FIH Hockey Men’s World Cup 2023, which country defeated India in the crossover match?";
        questions[1][1] = "England";
        questions[1][2] = "New Zealand";
        questions[1][3] = "Morocco";
        questions[1][4] = "South Africa";

        questions[2][0] = "‘Lecanemab’, which was granted approval by the US FDA, is used to treat which disease?";
        questions[2][1] = "COVID-19";
        questions[2][2] = "Alzheimer";
        questions[2][3] = "Cancer";
        questions[2][4] = "Diabetes";

        questions[3][0] = "Hornbill Festival is celebrated in which state of India?";
        questions[3][1] = "Manipur";
        questions[3][2] = "Nagaland";
        questions[3][3] = "Meghalaya";
        questions[3][4] = "Mizoram";

        questions[4][0] = "As per Indian Mythology, Dhumravarna is an incarnation or avatara of _______?";
        questions[4][1] = "Vishnu";
        questions[4][2] = "Shiva";
        questions[4][3] = "Ganesha";
        questions[4][4] = "Hanuman";

        questions[5][0] = "Which was the first Indian movie nominated for Oscar?";
        questions[5][1] = "Salaam Bombay";
        questions[5][2] = "Lagaan";
        questions[5][3] = "Mother India";
        questions[5][4] = "None of these";

        questions[6][0] = "Kangla Palace is a historical and archaeological site of which state?";
        questions[6][1] = "Assam";
        questions[6][2] = "Odisha";
        questions[6][3] = "Manipur";
        questions[6][4] = "Meghalaya";

        questions[7][0] = "With which among the following sports, Ian Thorpe is related to?";
        questions[7][1] = "Athletics";
        questions[7][2] = "Boxing";
        questions[7][3] = "Swimming";
        questions[7][4] = "Racing";

        questions[8][0] = "What is the alien race Loki sends to invade Earth in The Avengers?";
        questions[8][1] = "The Chitauri";
        questions[8][2] = "The Skrulls";
        questions[8][3] = "The Kree";
        questions[8][4] = "The Flerkens";

        questions[9][0] = "What fake name does Natasha use when she first meets Tony?";
        questions[9][1] = "Natalie Rushman";
        questions[9][2] = "Natalia Romanoff";
        questions[9][3] = "Nicole Rohan";
        questions[9][4] = "Naya Rabe";



        answers[0][1] = "The Fabelmans";
        answers[1][1] = "New Zealand";
        answers[2][1] = "Alzheimer";
        answers[3][1] = "Nagaland";
        answers[4][1] = "Ganesha";
        answers[5][1] = "Mother India";
        answers[6][1] = "Manipur";
        answers[7][1] = "Swimming";
        answers[8][1] = "The Chitauri";
        answers[9][1] = "Natalie Rushman";

        opt1=new JRadioButton();
        opt1.setBounds(170,440,700,30);
        opt1.setBackground(Color.white);
        opt1.setFont(new Font("Dialog",Font.PLAIN,20));
        add(opt1);

        opt2=new JRadioButton();
        opt2.setBounds(170,480,700,30);
        opt2.setBackground(Color.white);
        opt2.setFont(new Font("Dialog",Font.PLAIN,20));
        add(opt2);

        opt3=new JRadioButton();
        opt3.setBounds(170,520,700,30);
        opt3.setBackground(Color.white);
        opt3.setFont(new Font("Dialog",Font.PLAIN,20));
        add(opt3);

        opt4=new JRadioButton();
        opt4.setBounds(170,560,700,30);
        opt4.setBackground(Color.white);
        opt4.setFont(new Font("Dialog",Font.PLAIN,20));
        add(opt4);

        groupOption=new ButtonGroup();
        groupOption.add(opt1);
        groupOption.add(opt2);
        groupOption.add(opt3);
        groupOption.add(opt4);


        next=new JButton("Next");
        next.setBounds(100,620,200,40);
        next.setFont(new Font("Tahoma",Font.PLAIN,22));
        next.setBackground(new Color(247,7,115));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);



        submit=new JButton("Submit");
        submit.setBounds(750,620,200,40);
        submit.setFont(new Font("Tahoma",Font.PLAIN,22));
        submit.setBackground(new Color(247,7,115));
        submit.setForeground(Color.WHITE);

        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);



        start(count);

        setSize(1200,720);
        setLocation(100,0);
        setVisible(true);


    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==next)
        {
            repaint();
            ans_given=1;

            if(groupOption.getSelection()==null)
            {
                userAnswers[count][0]="";
            }
            else
            {
                userAnswers[count][0]=groupOption.getSelection().getActionCommand();
            }


            if(count==8)
            {
                next.setEnabled(false);
                submit.setEnabled(true);
            }

            count++;
            start(count);
        }

        else if (e.getSource()==submit)
        {
            ans_given=1;
            if(groupOption.getSelection()==null)
            {
                userAnswers[count][0]="";
            }
            else
            {
                userAnswers[count][0]=groupOption.getSelection().getActionCommand();
            }

            for(int i=0;i<userAnswers.length;i++)
            {
                if(userAnswers[i][0].equals(answers[i][1]))
                {
                    score=score+10;
                }

            }

            setVisible(false);
            new Score(userName,score);
        }
    }

    public void paint(Graphics g)
    {
        super.paint(g);
        String time="Time Left:\n "+timer+" seconds";
        g.setColor(new Color(247,7,115));
        g.setFont(new Font("Tahoma",Font.BOLD,25));

        if(timer>0)
        {
            g.drawString(time,900,500);
        }

        else {
            g.drawString("Times Up!!",900,500);
        }
        timer--;
        try {
            Thread.sleep(1000);
            repaint();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        if (ans_given==1)
        {
            ans_given=0;
            timer=40;
        }
        else if (timer<0) {
            timer=40;

            if(count==8)
            {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if(count==9)
            {
                if(groupOption.getSelection()==null)
                {
                    userAnswers[count][0]="";
                }
                else
                {
                    userAnswers[count][0]=groupOption.getSelection().getActionCommand();
                }

                for(int i=0;i<userAnswers.length;i++)
                {
                    if(userAnswers[i][0].equals(answers[i][1]))
                    {
                        score=score+10;
                    }

                }

                setVisible(false);
                new Score(userName,score);
            }

            else {
                if(groupOption.getSelection()==null)
                {
                    userAnswers[count][0]="";
                }
                else
                {
                    userAnswers[count][0]=groupOption.getSelection().getActionCommand();
                }

                count++;
                start(count);
            }

        }
    }


    public void start(int count)
    {
        questionNum.setText(""+ (count+1) +".");
        question.setText(questions[count][0]);

        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);

        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);

        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);

        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);

        groupOption.clearSelection();
    }


    public void resetGame() {

        count = 0;
        score = 0;


        start(count);
    }

    public static void main(String[] args) {

        new QuizPlay("User");
    }
}
