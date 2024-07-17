package bankmangment;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JPasswordField;
import javax.swing.*;
    
    public  class login extends JFrame implements ActionListener {
        
        JButton login,signup,clear;
        JTextField pinTextField, cardTextField;
        JPasswordField pinTeextField;
        login()
        {
              setTitle("autometed teller machine");

              setLayout(null);

             
           ImageIcon I1 =new ImageIcon(ClassLoader.getSystemResource("images.png")) ;
           Image I2 = I1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
           ImageIcon I3 =new ImageIcon(I2);
           JLabel label = new JLabel(I3);
           label.setBounds(70, 10, 100, 100);
           add(label);

           JLabel text = new JLabel("Welcome to ATM");
           text.setFont(new Font("osward", Font.BOLD, 38));
           text.setBounds(200, 40, 400, 40);
           add(text);

           JLabel cardno = new JLabel("Card no:");
           cardno.setFont(new Font("railway", Font.BOLD, 28));
           cardno.setBounds(120, 150, 150, 30);
           add(cardno);

           cardTextField = new JTextField();
           cardTextField.setBounds(300,150,230,30);
           cardTextField.setFont(new Font("Arial", Font.BOLD,14));
           add(cardTextField);


           JLabel pinno = new JLabel("PIN:");
           pinno.setFont(new Font("railway", Font.BOLD, 28));
           pinno.setBounds(120, 220, 400, 40);
           add(pinno);
         
            pinTextField = new JPasswordField();
           pinTextField.setBounds(300,220,230,30);
           pinTextField.setFont(new Font("Arial", Font.BOLD,14));
           add(pinTextField);

           login =new JButton("SIGN IN");
           login.setBounds(300, 300, 100, 30);
           login.setBackground(Color.BLACK);
           login.setForeground(Color.WHITE);
           login.addActionListener(this);
           add(login);

           clear =new JButton("CLEAR");
           clear.setBounds(430, 300, 100, 30);
           clear.setBackground(Color.BLACK);
           clear.setForeground(Color.WHITE);
           clear.addActionListener(this);
           add(clear);

           signup =new JButton("SIGN UP");
           signup.setBounds(300, 350, 230, 30);
           signup.setBackground(Color.BLACK);
           signup.setForeground(Color.WHITE);
           signup.addActionListener(this);
           add(signup);

           getContentPane().setBackground(Color.GRAY);
            
            setSize(800,480);
            setVisible(true);
            setLocation(350,200);
        } 
        public  static void main(String args[])
        {
           
            new login();
           
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == clear)
            {   cardTextField.setText("");
                pinTextField.setText("");

            } else if(e.getSource() == login)
            {
                conn cc = new conn();
                String cardno = cardTextField.getText();
                String pinno = pinTextField.getText();
                String query ="select * from login where cardno = '"+cardno+"' and pin = '"+pinno+"'";
                try {
                  ResultSet rs =  cc.s.executeQuery(query);
                  if (rs.next()) {
                        setVisible(false);
                        new Transaction(pinno).setVisible(true);                   
                  }
                  else{
                    JOptionPane.showMessageDialog(null,"Incorrect cardNumber or pin");
                  }
                } catch (Exception ex) {
                    System.out.println(ex);
                }

            } else if(e.getSource() == signup){
                    setVisible(false);
                    new signupone().setVisible(true);
            } 
        }
}
