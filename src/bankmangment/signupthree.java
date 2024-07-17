package bankmangment;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;



public class signupthree  extends JFrame implements ActionListener {
    
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit ,cancel;
    String formno;
    signupthree(String formno)
{
    this.formno = formno;
            setLayout(null);

        JLabel l1 = new JLabel("page 3: Account Details");
        l1.setFont(new Font("releway" ,Font.BOLD,22));
        l1.setBounds(280, 40, 400, 40);
        add(l1);

        JLabel type = new JLabel("Account type");
        type.setFont(new Font("releway",Font.BOLD,22));
        type.setBounds(100, 140, 200, 30);
        add(type);

        r2 = new JRadioButton("Fixed deposit Account");
        r2.setFont(new Font("releway", Font.BOLD, 16));
        r2.setBounds(350,180,230,20);
        r2.setBackground(Color.WHITE);
        add(r2);

        r3 = new JRadioButton("Cuurent account ");
        r3.setFont(new Font("releway", Font.BOLD, 16));
        r3.setBounds(100, 220, 150, 20);
        r3.setBackground(Color.WHITE);
        add(r3);

        r4 = new JRadioButton(" Reccuring Deposite Account");
        r4.setFont(new Font("releway", Font.BOLD, 16));
        r4.setBounds(350, 220, 250, 20);
        r4.setBackground(Color.WHITE);
        add(r4);

        r1 = new JRadioButton("Saving Account ");
        r1.setFont(new Font("releway", Font.BOLD, 16));
        r1.setBounds(100, 180, 150, 20);
        r1.setBackground(Color.WHITE);
        add(r1);

    ButtonGroup groupaccount = new ButtonGroup();
    groupaccount.add(r1);
    groupaccount.add(r2);
    groupaccount.add(r3);
    groupaccount.add(r4);

    JLabel card = new JLabel("card number");
    card.setFont(new Font("releway" ,Font.BOLD,22));
    card.setBounds(100, 300, 200, 30);
    add(card);

    JLabel number= new JLabel("XXXX-XXXX-XXXX-3112");
    number.setFont(new Font("releway" ,Font.BOLD,22));
    number.setBounds(330, 300, 300, 30);
    add(number);

    JLabel carddetail= new JLabel("Your sixteen digits card number");
    carddetail.setFont(new Font("releway" ,Font.BOLD,12));
    carddetail.setBounds(100, 330, 300, 20);
    add(carddetail);


    JLabel pin = new JLabel("pin:");
    pin.setFont(new Font("releway" ,Font.BOLD,22));
    pin.setBounds(100, 370, 200, 30);
    add(pin);

    JLabel Pnumber= new JLabel("XXXX");
    Pnumber.setFont(new Font("releway" ,Font.BOLD,22));
    Pnumber.setBounds(330, 370, 300, 30);
    add(Pnumber);

    JLabel pindetails= new JLabel("Your Four digits Password");
    pindetails.setFont(new Font("releway" ,Font.BOLD,12));
    pindetails.setBounds(100, 400, 300, 20);
    add(pindetails);

    JLabel services= new JLabel("Services required:");
    services.setFont(new Font("releway" ,Font.BOLD,22));
    services.setBounds(100, 450, 200, 30);
    add(services);

    c1 = new JCheckBox("ATM CARD");
    c1.setBackground(Color.WHITE);
    c1.setFont(new Font("releway", Font.BOLD, 16));
    c1.setBounds(100, 500, 200, 30);
    add(c1);

    c2 = new JCheckBox("Internet banking");
    c2.setBackground(Color.WHITE);
    c2.setFont(new Font("releway", Font.BOLD, 16));
    c2.setBounds(350, 500, 200, 30);
    add(c2);

    c3 = new JCheckBox("Mobile benking");
    c3.setBackground(Color.WHITE);
    c3.setFont(new Font("releway", Font.BOLD, 16));
    c3.setBounds(100, 550, 200, 30);
    add(c3);

    c4 = new JCheckBox("EMAIL & SMS Alerts");
    c4.setBackground(Color.WHITE);
    c4.setFont(new Font("releway", Font.BOLD, 16));
    c4.setBounds(350, 550, 200, 30);
    add(c4);

    c5 = new JCheckBox("Check Book");
    c5.setBackground(Color.WHITE);
    c5.setFont(new Font("releway", Font.BOLD, 16));
    c5.setBounds(100, 600, 200, 30);
    add(c5);

    c6 = new JCheckBox("E-statment");
    c6.setBackground(Color.WHITE);
    c6.setFont(new Font("releway", Font.BOLD, 16));
    c6.setBounds(350, 600, 200, 30);
     add(c6);

    c7 = new JCheckBox("I hereby decleres theat the above entered details are correct to the best of my knowledge");
    c7.setBackground(Color.WHITE);
    c7.setFont(new Font("releway", Font.BOLD, 12));
    c7.setBounds(100, 680, 550, 30);
    add(c7);

   
    submit= new JButton("Submit");
    submit.setBackground(Color.BLACK);
    submit.setForeground(Color.WHITE);
    submit.setFont(new Font("releway", Font.BOLD, 14));
    submit.setBounds(250, 720,100, 30);
    submit.addActionListener(this);
    add(submit);

    cancel= new JButton("Cancel");
    cancel.setBackground(Color.BLACK);
    cancel.setForeground(Color.WHITE);
    cancel.setFont(new Font("releway", Font.BOLD, 14));
    cancel.setBounds(420, 720,100, 30);
    cancel.addActionListener(this);
    add(cancel);
    getContentPane().setBackground(Color.WHITE);

        setSize(850, 820);
        setLocation(350, 0);
        setVisible(true);

    }
    

  

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submit)
        {
            String accountType = null;
            if (r1.isSelected()) {
                accountType = "Saving Account";

            } else if(r2.isSelected())
            {
                accountType = "Fixed deposit";
            }else if (r3.isSelected())
            {
                accountType = "Currunt Account";
            } else if (r4.isSelected())
            {
                accountType = "Reccuring Deposite account";
            }           


                Random random = new Random();
                String cardnumber ="" + Math.abs( (random.nextLong() % 90000000L) +  5040936000000000L); 

                String pinnumber = "" + Math.abs((random.nextLong() % 9000L)  + 1000L);

                String facility = "";
                if(c1.isSelected())
                {
                    facility =facility + " ATM card";
                } else if (c2.isSelected())
                {
                    facility = facility + "Internet banking";
                }else if ( c3.isSelected())
                {
                    facility = facility + "Mobile banking";
                }else if(c4.isSelected())
                {
                    facility = facility + "Email & SMS alerts";
                }else if(c5.isSelected())
                {
                    facility = facility + "Cheque Book";

                }else if(c6.isSelected())
                {
                    facility = facility + "E-Statement";
                }

                try {
                    if(accountType.equals(""))
                    {
                        JOptionPane.showMessageDialog(null ,"Account type is required");
                    }else{
                        conn cc=new conn();
                        String query1 = "insert into signupthree values('"+formno+"' , '"+accountType+"' , '"+cardnumber+"' , '"+pinnumber+"' , '"+facility+"')";
                        String query2 = "insert into login values('"+formno+"' , '"+cardnumber+"' , '"+pinnumber+"')";
                        
                        cc.s.executeUpdate(query1);
                        cc.s.executeUpdate(query2);

                        JOptionPane.showMessageDialog(null,  "Card nnumber:" + cardnumber + "\n pinnumber: " + pinnumber)  ;
                    }

                    setVisible(false);
                    new Deposit(pinnumber).setVisible(false);
                 }
                 
                    catch(Exception ex)
                {
                    System.out.println(ex);
                }

        }else if(e.getSource() == cancel){
             setVisible(false);
             new login().setVisible(true); 
        } 
}
public static void main(String[] args) {

    new signupthree("");
    
}
}