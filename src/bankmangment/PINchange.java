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
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;


public class PINchange extends JFrame implements ActionListener {  

    JPasswordField pin,repin;
    JButton change,back;
   
    
    String pinno;

    PINchange(String pinno){
        this.pinno = pinno;

        setLayout(null);
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2 =i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel Image = new JLabel(i3);
        Image.setBounds(0,0,900,900);
        add(Image);

       JLabel Text = new JLabel("CAHNGE YOUR PIN");
        Text.setForeground(Color.WHITE);
        Text.setFont(new Font("system", Font.BOLD, 16));
        Text.setBounds(250, 280, 500, 35);
        Image.add(Text);

        JLabel pintext= new JLabel("New PIN");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("system", Font.BOLD, 16));
        pintext.setBounds(165, 320, 180, 25);
        Image.add(pintext);

        JLabel repintext = new JLabel("Re-Enter new PIN ");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("system", Font.BOLD, 16));
        repintext.setBounds(165, 360, 180, 35);
        Image.add(repintext);

         pin = new JPasswordField();
        pin.setFont(new Font("releway", Font.BOLD, 25));
        pin.setBounds(330, 320, 180, 25);
        Image.add(pin);

         repin = new JPasswordField();
        repin.setFont(new Font("releway", Font.BOLD, 25));
        repin.setBounds(330, 360, 180, 25);
        Image.add(repin);

         change = new JButton("CHANGE");
        change.setBounds(355, 485, 150, 30);
        change.addActionListener(this);
         Image.add(change);

          back = new JButton("BACK");
         back.setBounds(355, 520, 150, 30);
         back.addActionListener(this);
          Image.add(back);
 
 
        setSize(900, 900);
        setLocation(300,0);
        setVisible(true);


           
    }

         public static void main(String args[]){
             new PINchange("").setVisible(true);

         }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == change) {
                
            
           try {
            String npin = pin.getText();
            String rpin = repin.getText();

            if (!npin.equals(rpin)) {
                JOptionPane.showMessageDialog(null, "ENTERED PIN DOES NOT MATCH");
                return;
            }
            if (npin.equals("")) { 
                JOptionPane.showMessageDialog(null, "Please  your PIN");
                return;
            }
            if (rpin.equals("")) {
                JOptionPane.showMessageDialog(null, "Please re-enter your PIN");
                return;
                
            }
            conn cc=new conn();
            String query1= "update bank set pin = '"+rpin+"' where pin='"+pinno+"'";
            String query2= "update login set pin = '"+rpin+"' where pin='"+pinno+"'";

            String query3= "update signupthree set pin = '"+rpin+"' where pin='"+pinno+"'";

            cc.s.executeUpdate(query1);
            cc.s.executeUpdate(query2);
            cc.s.executeUpdate(query3);
   
                JOptionPane.showMessageDialog(null, "PIN CHANGED SUCCESSFULLY");
                setVisible(false);
                new Transaction(rpin).setVisible(true);
         

           } catch (Exception ex) {
            System.out.println(ex);
           }
        } else {
            setVisible(false);
            new Transaction(pinno).setVisible(true);
        }
}
}
