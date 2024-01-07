package quiz;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Score extends JFrame implements ActionListener{
    String userName;
    int score;
    JButton replay;
    Score(String userName,int score)
    {
        this.userName=userName;
        this.score=score;
        getContentPane().setBackground(Color.white);
        setLayout(null);
        ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("image/score.png"));
        JLabel image=new JLabel(i);
        image.setBounds(0,50,1200,500);
        add(image);

        JLabel heading=new JLabel("Thank You "+userName+" for playing Brainy Quest");
        heading.setBounds(400,0,700,30);
        heading.setFont(new Font("Viner Hand ITC",Font.BOLD,20));
        heading.setForeground(new Color(247, 7, 115));
        add(heading);

        JLabel scoreLabel=new JLabel("Your Score is "+score);
        scoreLabel.setBounds(550,560,700,30);
        scoreLabel.setFont(new Font("Viner Hand ITC",Font.BOLD,20));
        scoreLabel.setForeground(new Color(247, 7, 115));
        add(scoreLabel);


        replay=new JButton("Play Again");
        replay.setBounds(550,600,130,40);
        replay.setFont(new Font("Tahoma",Font.BOLD,18));
        replay.setBackground(new Color(247,7,115));
        replay.setForeground(Color.WHITE);

        replay.addActionListener(this);
        add(replay);

        setSize(1200,700);
        setLocation(100,20);
        setVisible(true);



    }

    public  void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==replay)
        {
            setVisible(false);
            dispose();
            QuizPlay quizPlay = new QuizPlay(userName);
            quizPlay.resetGame();

        }
    }
    public static void main(String[] args) {
        new Score("User",0);
    }
}

