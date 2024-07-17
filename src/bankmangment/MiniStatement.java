package bankmangment;

import java.awt.Color;
import java.sql.ResultSet;


import javax.swing.JFrame;
import javax.swing.JLabel;

public class MiniStatement extends  JFrame{

    MiniStatement(String pinno)
    {
            setTitle("Mini Statement");
            setLayout(null);

            JLabel mini = new JLabel();
            add(mini);

            JLabel bank = new JLabel("BANK OF INDIA");
           bank.setBounds(150, 20, 100, 20);
           add(bank);

           JLabel card = new JLabel();
           card.setBounds(20,80,300,20);
           add(card);

           JLabel balance = new JLabel();
           balance.setBounds(20,400,300,20);
           add(balance);


           try {
            conn cc =new conn();
           ResultSet rs = cc.s.executeQuery("select * from bank where pinno = '"+pinno+"'");
            while (rs.next()) {
                card.setText("Card number :" + rs.getString("cardno").substring(0, 4)  + "xxxxxxxx"  + rs.getString("cardno").substring(12));
            }
           } catch (Exception e) {
            System.out.println(e);
           }

           try {
            conn cc = new conn();
            int bal=0;
            ResultSet rs =cc.s.executeQuery("select * from bank where pin =  '"+pinno+"' "); 
            while (rs.next()) {
                mini.setText(mini.getText() + "<html>"  + rs.getString("date")  + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +rs.getString("amount") + "<br><br><html>" );
                if (rs.getString("type").equals("deposit")) {
                    bal +=Integer.parseInt(rs.getString("amount"));
                }else {
                    bal -= Integer.parseInt(rs.getString("amount"));
                } 
            }
             balance.setText("your current account balance Rs is" + bal);
           } catch (Exception e) {
            System.out.println(e);
           }
             mini.setBounds(20, 140, 400,40 );
          
            setSize(400, 600);
            setLocation(20, 20);
            getContentPane().setBackground(Color.WHITE);
            setVisible(true);
    }
    public static void main(String[] args) {
        new MiniStatement("");
    }   
 }
