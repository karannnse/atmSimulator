package bankmangment;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class BalanceEnquiry extends JFrame implements ActionListener{

    JButton back;
    String pinno;

    BalanceEnquiry(String pinno){

        this.pinno= pinno;


        setLayout(null);
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2 =i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel Image = new JLabel(i3);
        Image.setBounds(0,0,900,900);
        add(Image);

       back = new JButton("Back");
       back.setBounds(355, 520, 150, 30);
       back.addActionListener(this);
       Image.add(back);
       
      // conn c =new conn();
        int balance = 0;
                try {
                    conn c =new conn();
                   // int balance = 0;
                    ResultSet rs = c.s.executeQuery("Select * from bank where pin = '"+pinno+"'");
                  
                    while (rs.next()) {
                        if (rs.getString("type").equals("deposit")) {
                            balance +=Integer.parseInt(rs.getString("amount"));
                        }else {
                            balance -= Integer.parseInt(rs.getString("amount"));
                        }
                    }
                }

                    catch (Exception e)
                    {
                        System.out.println(e);
                    }

            JLabel text = new JLabel("Your Currunt Account Balance is Rs "  + balance);
            text.setForeground(Color.WHITE);
            text.setBounds(170,300 ,400 ,30 );
            Image.add(text);  

            setSize(900, 900);
            setLocation(300,0 );
            setVisible(true);


    }

    public static void main(String[] args) {
        new BalanceEnquiry("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      setVisible(false);
      new Transaction(pinno).setVisible(true);
    }
}
