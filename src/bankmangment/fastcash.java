package bankmangment;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class fastcash extends JFrame  implements ActionListener {

    JButton deposite,withdrawl,miniStatement,pinchange,fastcash,balanceenquiery,exit;
    String pinno;

    fastcash(String pinno)
    {
        this.pinno=pinno;
        setLayout(null);
         
ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
ImageIcon i3= new ImageIcon(i2);
JLabel image =  new JLabel(i3);
image.setBounds(0, 0, 900, 900);
add(image);

JLabel text = new JLabel("Select withdrawal Amount");
text.setBounds(210,300,700,35);
text.setFont(new Font("system", Font.BOLD, 16));
text.setForeground(Color.WHITE);
image.add( text );

        deposite = new JButton("Rs 100");
        deposite.setBounds(170, 415, 150, 30);
        deposite.addActionListener(this);
        image.add(deposite);

        withdrawl = new JButton("Rs 500");
        withdrawl.setBounds(355, 415, 150, 30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        fastcash = new JButton("Rs 1000");
        fastcash.setBounds(170, 450, 150, 30);
        fastcash.addActionListener(this);
        image.add(fastcash);

        miniStatement = new JButton("Rs 2000");
        miniStatement.setBounds(355, 450, 150, 30);
        miniStatement.addActionListener(this);
        image.add(miniStatement);

        pinchange = new JButton("Rs 5000");
        pinchange.setBounds(170, 485, 150, 30);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balanceenquiery= new JButton("Rs 10000");
        balanceenquiery.setBounds(355, 485, 150, 30);
        balanceenquiery.addActionListener(this);
        image.add(balanceenquiery);

        exit = new JButton("BACK");
        exit.setBounds(355, 520, 150, 30);
        exit.addActionListener(this);
        image.add(exit);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }
        public static void main(String[] args) {
            new fastcash("");  
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == exit)
            {
                setVisible(false);
                new Transaction(pinno).setVisible(true);
            }else
             {
                String amount =((JButton)e.getSource()).getText().substring(3);
                conn c =new conn();
                try {
                    ResultSet rs = c.s.executeQuery("Select * from bank where pin= '"+pinno+"'");
                    int balance = 0;
                    while (rs.next()) {
                        if (rs.getString("type").equals("deposit")) {
                            balance +=Integer.parseInt(rs.getString("amount"));
                        }else {
                            balance -= Integer.parseInt(rs.getString("amount"));
                        }
                    }

                    if (e.getSource() != exit && balance < Integer.parseInt(amount))
                     {
                        JOptionPane.showMessageDialog(null, "insufficient balance");
                        return ;
                    } 
                    Date date = new Date();
                    String query = "insert into bank values('"+pinno+"' , '"+date+"' , 'withdrawl' , '"+amount+"')";
                    c.s.executeQuery(query);
                    JOptionPane.showMessageDialog(null, "Rs " + amount + "Debited successfully " );

                        setVisible(false);
                        new Transaction(pinno).setVisible(true);
                    
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }   
        } 
}