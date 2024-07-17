package bankmangment;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Transaction extends JFrame  implements ActionListener {


    JButton deposite,withdrawl,miniStatement,pinchange,fastcash,balanceenquiery,exit;
    String pinno;

    

    Transaction(String pinno){

        this.pinno=pinno;
        setLayout(null);
         
ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
ImageIcon i3= new ImageIcon(i2);
JLabel image =  new JLabel(i3);
image.setBounds(0, 0, 900, 900);
add(image);


JLabel text = new JLabel("Please select your Transaction");
text.setBounds(210,300,700,35);
text.setFont(new Font("system", Font.BOLD, 16));
text.setForeground(Color.WHITE);
image.add( text );

        deposite = new JButton("Deposit");
        deposite.setBounds(170, 415, 150, 30);
        deposite.addActionListener(this);
        image.add(deposite);

        withdrawl = new JButton("Cash Withdrawl");
        withdrawl.setBounds(355, 415, 150, 30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(170, 450, 150, 30);
        fastcash.addActionListener(this);
        image.add(fastcash);

        miniStatement = new JButton("Mini Statement");
        miniStatement.setBounds(355, 450, 150, 30);
        miniStatement.addActionListener(this);
        image.add(miniStatement);

        pinchange = new JButton("Pin Change");
        pinchange.setBounds(170, 485, 150, 30);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balanceenquiery= new JButton("Balance Enquiry");
        balanceenquiery.setBounds(355, 485, 150, 30);
        balanceenquiery.addActionListener(this);
        image.add(balanceenquiery);

        exit = new JButton("Exit");
        exit.setBounds(355, 520, 150, 30);
        exit.addActionListener(this);
        image.add(exit);




        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }
        public static void main(String[] args) {
            new Transaction("");
            
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == exit)
            {
                System.exit(0);
            }else if (e.getSource() == deposite) {
                setVisible(false);
                new Deposit(pinno).setVisible(true);
            } else if (e.getSource() == withdrawl) {
                setVisible(false);
                new withdrawl(pinno).setVisible(true);
            }else if (e.getSource()  == fastcash )
            {
                setVisible(false);
                new fastcash(pinno).setVisible(true);
            }  else if (e.getSource() == pinchange) {
                setVisible(false);
                new PINchange(pinno).setVisible(true);
                
            }  else if (e.getSource() == balanceenquiery) {
                setVisible(false);
                new BalanceEnquiry(pinno).setVisible(true);
            } else if (e.getSource() == miniStatement){

                new MiniStatement(pinno).setVisible(true);
            }    
        } 
}
