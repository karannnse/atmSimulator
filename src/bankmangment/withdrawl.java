package bankmangment;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class withdrawl extends JFrame implements ActionListener {
    JButton withdrawl,back;
    JTextField amount;
    String pinno;
    withdrawl(String pinno)
    {
    this.pinno=pinno;
    setLayout(null);

    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
    Image i2 =i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
    ImageIcon i3 =new ImageIcon(i2);
    JLabel Image = new JLabel(i3);
    Image.setBounds(0, 0, 900, 900);
    add(Image);

    JLabel text = new JLabel("Enter the amount you want to Withdraw");
    text.setFont(new Font("system", Font.BOLD, 16));
    text.setForeground(Color.WHITE);
    text.setBounds(170, 300, 400, 25);
    Image.add(text);
    
    amount = new JTextField();
    amount.setFont(new Font("releway", Font.BOLD, 25));
    amount.setBounds(170, 330, 320, 20);
    Image.add(amount);

    withdrawl = new JButton("withdrawl");
    withdrawl.setBounds(355,485,150,30);
    withdrawl.addActionListener(this);
    Image.add(withdrawl);

     back = new JButton("Back");
    back.setBounds(355,520,150,30);
    back.addActionListener(this);
    Image.add(back);


setSize(900,900) ;
setLocation(300,0 );
setVisible(true);

}



public static void main(String args[])
{
new withdrawl("");
}


@Override
public void actionPerformed(ActionEvent e) {
    
if (e.getSource() == withdrawl) {
    String number = amount.getText();
    Date date = new Date();
    if (number.equals("")) {
        JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdrwa");

    } else{

        try{
        
            conn cc=new conn();
            String query= ("insert into bank values('"+pinno+"', '"+date+"', 'withdrawl', '"+number+"')");
            cc.s.executeUpdate(query);
            
            //JOptionPane.showMessageDialog(null, "Rs. "+amount+" withdrawl Successfully");
            setVisible(false);
            new Transaction(pinno).setVisible(true);
        }   catch(Exception ex)
        {
            System.out.println(ex);
        }

       }      
}else if (e.getSource() == back){
    setVisible(false);
     new Transaction(pinno).setVisible(true);
}


}
    
}
