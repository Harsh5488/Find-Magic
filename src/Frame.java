import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame implements ActionListener {
//    ImageIcon gift = new ImageIcon("Gift.png");
//    ImageIcon magic = new ImageIcon("Magic.png");
//    ImageIcon party = new ImageIcon("Party.png");
//    ImageIcon lose = new ImageIcon("Lose.png");

    ImageIcon gift = new ImageIcon(getClass().getClassLoader().getResource("Gift.png"));
    ImageIcon magic = new ImageIcon(getClass().getClassLoader().getResource("Magic.png"));
    ImageIcon party = new ImageIcon(getClass().getClassLoader().getResource("Party.png"));
    ImageIcon lose = new ImageIcon(getClass().getClassLoader().getResource("Lose.png"));

    JFrame f =new JFrame();

    JButton b1 = new JButton(gift);
    JButton b2 = new JButton(gift);
    JButton b3 = new JButton(gift);
    JButton b4 = new JButton(gift);
    JButton b5 = new JButton(gift);

    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JPanel p3 = new JPanel();
    JPanel p4 = new JPanel();

    JLabel l1 = new JLabel();
    JLabel l2 = new JLabel();
    JLabel l3 = new JLabel();
    JLabel l4 = new JLabel();
    JLabel l5 = new JLabel();

    int points = 100, x, count=0;

    GetRand r = new GetRand();

    Frame(){
        x = r.getX();

        //      Frame Settings
        f.setTitle("Find Magic Game");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(800,600);
        f.setLayout(new BorderLayout());
        f.setIconImage(magic.getImage());
        f.setLocationRelativeTo(null);
//        f.setIconImage(Toolkit.getDefaultToolkit().getImage("Magic.png"));
        //--------------------------------

        //      Label settings
        l1.setText("Find Magic");
        l1.setFont(new Font("Gabriola",Font.BOLD,80));
        l1.setHorizontalAlignment(JLabel.CENTER);

        l2.setText("Choose any of the below boxes");
        l2.setFont(new Font(null,Font.PLAIN,20));
        l2.setHorizontalAlignment(JLabel.CENTER);

        l3.setText("Message in the box");
        l3.setFont(new Font(null,Font.PLAIN,20));
        l3.setHorizontalAlignment(JLabel.CENTER);
        l3.setVerticalAlignment(JLabel.TOP);

        l4.setText("Choose Any Box");
        l4.setFont(new Font(null,Font.PLAIN,20));
        l4.setVerticalAlignment(JLabel.CENTER);
        l4.setHorizontalAlignment(JLabel.CENTER);
        l4.setOpaque(true);
        l4.setBorder(BorderFactory.createLineBorder(Color.GRAY,10));
        l4.setBackground(Color.white);

        l5.setText("Points = "+ points);
        l5.setFont(new Font(null,Font.PLAIN,20));
        l5.setHorizontalAlignment(JLabel.CENTER);
        l5.setVerticalAlignment(JLabel.TOP);
        //----------------------------------------------------------

        //      Buttons Settings
        b1.setText("Box 1");
        b1.setPreferredSize(new Dimension(130,50));
        b1.addActionListener(this);

        b2.setText("Box 2");
        b2.setPreferredSize(new Dimension(130,50));
        b2.addActionListener(this);

        b3.setText("Box 3");
        b3.setPreferredSize(new Dimension(130,50));
        b3.addActionListener(this);

        b4.setText("Box 4");
        b4.setPreferredSize(new Dimension(130,50));
        b4.addActionListener(this);

        b5.setText("Box 5");
        b5.setPreferredSize(new Dimension(130,50));
        b5.addActionListener(this);
        //----------------------------------------------------------

        //      Panel Settings
        p1.setLayout(new BorderLayout());
        p1.add(l1, BorderLayout.NORTH);
        p1.add(l2, BorderLayout.SOUTH);

        p2.setLayout(new FlowLayout(FlowLayout.CENTER,10,50));
        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        p2.add(b4);
        p2.add(b5);

        p3.setLayout(new BorderLayout());
        p3.add(l3, BorderLayout.WEST);
        p3.add(l5, BorderLayout.EAST);


        p4.setLayout(new BorderLayout(100,50));
        p4.setPreferredSize(new Dimension(100,200));
        p4.add(p3, BorderLayout.NORTH);
        p4.add(l4, BorderLayout.CENTER);
        //----------------------------------------------------------

        //      Adding to frame
        f.add(p1,BorderLayout.NORTH);
        f.add(p2,BorderLayout.CENTER);
        f.add(p4,BorderLayout.SOUTH);
        //----------------------------------------------------------
        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(
                ((e.getSource()==b1) && (x==1)) ||
                ((e.getSource()==b2) && (x==2)) ||
                ((e.getSource()==b3) && (x==3)) ||
                ((e.getSource()==b4) && (x==4)) ||
                ((e.getSource()==b5) && (x==5))
        ){
            Disable(e);
            l4.setText("Expecto Patronum \n\nYou got the Magic");
            String[] opt = {"Exit","Restart"};
            int x = JOptionPane.showOptionDialog(null,"You Win "+points+" Points","Winner Winner Chicken Dinner",JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE,party,opt,opt[0]);
            if(x==0){
                f.dispose();
            }
            else{
                Restart();
            }
        }
        else{
            Disable(e);
            count++;
            points -= 25;
            l5.setText("Points = "+ points);
            l4.setText("Better Luck!! Next Time");
            if(count==4){
                String[] opt = {"Quit","Restart"};
                int x = JOptionPane.showOptionDialog(null,"You Lose "+points+" Points","OOPs...",JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE,lose,opt,opt[0]);
                if(x==0){
                    f.dispose();
                }
                else{
                    Restart();
                }
                //JOptionPane.showMessageDialog(null,"You Lose "+points+" Points","OOPs...",JOptionPane.PLAIN_MESSAGE,lose);
            }
        }
    }
    public void Restart(){
        x = r.resetX();
        points = 100;
        count=0;
        l5.setText("Points = "+ points);
        l4.setText("Choose Any Box");
        b1.setEnabled(true);
        b2.setEnabled(true);
        b3.setEnabled(true);
        b4.setEnabled(true);
        b5.setEnabled(true);
    }
    public void Disable(ActionEvent e){
        if(e.getSource()==b1){
            b1.setEnabled(false);
        }
        else if(e.getSource()==b2){
            b2.setEnabled(false);
        }
        else if(e.getSource()==b3){
            b3.setEnabled(false);
        }
        else if(e.getSource()==b4){
            b4.setEnabled(false);
        }
        else{
            b5.setEnabled(false);
        }
    }
}
