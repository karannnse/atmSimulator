package bankmangment;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;


public class signupone extends JFrame implements ActionListener 
{

    long Random;
    JTextField  nameTextFeild,fnameTextFeild,emailTextFeild,addressTextFeild,cityTextFeild, stateTextFeild,pinTextFeild ;
    JButton next;
    JRadioButton male ,female,other ,married,unmarried;
    JDateChooser dateChooser ;
    

    /**
     * 
     */
    signupone()
    {

        setLayout(null);
            Random ran =new Random();
            Random = Math.abs((ran.nextLong() % 9000L ) + 1000L );
          
             JLabel formno = new JLabel("APPLICATION FORM NO." + Random);
                formno.setFont(new Font("raleway", Font.BOLD, 38));
                formno.setBounds(140, 20, 600, 40);
                add(formno);


                JLabel personDetail = new JLabel("page 1: person details" );
                personDetail.setFont(new Font("raleway", Font.BOLD, 22));
                personDetail.setBounds(290, 80, 400, 30);
                add(personDetail);

                JLabel name = new JLabel( "Name :");
                name.setFont(new Font ("raleway ",Font.BOLD,20));
                name.setBounds(100,140,100,30);
                add(name);


                nameTextFeild = new JTextField();
                nameTextFeild.setFont(new Font("raleway", Font.BOLD, 14));
                nameTextFeild.setBounds(300, 140, 400, 30);
                add(nameTextFeild);


                JLabel fname = new JLabel("Father's Name:");
                fname.setFont(new Font("Raleway", Font.BOLD, 20));
                fname.setBounds(100,190,200,30);
                add(fname);

                fnameTextFeild = new JTextField();
                fnameTextFeild.setFont(new Font("raleway", Font.BOLD, 14));
                fnameTextFeild.setBounds(300, 190, 400, 30);
                add(fnameTextFeild);

                JLabel Dob = new JLabel("Date Of Birth:");
                Dob.setFont(new Font("Raleway", Font.BOLD, 20));
                Dob.setBounds(100,240,200,30);
                add(Dob);


                dateChooser =  new JDateChooser();
                dateChooser.setBounds(300, 240, 400, 30);
                dateChooser.setForeground(new Color(105,105,105));
                add(dateChooser);

                JLabel gender = new JLabel("Gender:");
                gender.setFont(new Font("Raleway", Font.BOLD, 20));
                gender.setBounds(100,290,200,30);
                add(gender);

                male = new JRadioButton("Male");
                male.setBounds(300, 290, 60, 30);
                male.setBackground(Color.WHITE);
                add(male);


                 female =new JRadioButton("Female");
                female.setBounds(450,290,120,30);
                female.setBackground(Color.WHITE);
                add(female);

                ButtonGroup gendeGroup =new ButtonGroup();
                gendeGroup.add(male);
                gendeGroup.add(female);

                JLabel email = new JLabel("Email Address:");
                email.setFont(new Font("Raleway", Font.BOLD, 20));
                email.setBounds(100,340,200,30);
                add(email);

                  emailTextFeild = new JTextField();
                emailTextFeild.setFont(new Font("raleway", Font.BOLD, 14));
                emailTextFeild.setBounds(300, 340, 400, 30);
                add(emailTextFeild);

                JLabel marital = new JLabel("Marital Status:");
                marital.setFont(new Font("Raleway", Font.BOLD, 20));
                marital.setBounds(100,390,200,30);
                add(marital);

                 married = new JRadioButton("married");
                married.setBounds(300, 390, 100, 30);
                married.setBackground(Color.WHITE);
                add(married);

                 unmarried =new JRadioButton("unmarried");
                unmarried.setBounds(450,390,100,30);
                unmarried.setBackground(Color.WHITE);
                add(unmarried);

                 other =new JRadioButton("other");
                other.setBounds(630,390,100,30);
                other.setBackground(Color.WHITE);
                add(other);


                ButtonGroup maritalGroup=new ButtonGroup();
                maritalGroup.add(married);
                maritalGroup.add(unmarried);
                maritalGroup.add(other);
               

                JLabel address = new JLabel("Address:");
                address.setFont(new Font("Raleway", Font.BOLD, 20));
                address.setBounds(100,440,200,30);
                add(address);

                 addressTextFeild = new JTextField();
                addressTextFeild.setFont(new Font("raleway", Font.BOLD, 14));
                addressTextFeild.setBounds(300, 440, 400, 30);
                add(addressTextFeild);


                JLabel city = new JLabel("City:");
                city.setFont(new Font("Raleway", Font.BOLD, 20));
                city.setBounds(100,490,200,30);
                add(city);

                cityTextFeild = new JTextField();
                cityTextFeild.setFont(new Font("raleway", Font.BOLD, 14));
                cityTextFeild.setBounds(300, 490, 400, 30);
                add(cityTextFeild);

                JLabel state = new JLabel("State:");
                state.setFont(new Font("Raleway", Font.BOLD, 20));
                state.setBounds(100,540,200,30);
                add(state);

                stateTextFeild = new JTextField();
                stateTextFeild.setFont(new Font("raleway", Font.BOLD, 14));
                stateTextFeild.setBounds(300, 540, 400, 30);
                add(stateTextFeild);

                JLabel pincode = new JLabel("Pincode:");
                pincode.setFont(new Font("Raleway", Font.BOLD, 20));
                pincode.setBounds(100,590,200,30);
                add(pincode);

                pinTextFeild = new JTextField();
                pinTextFeild.setFont(new Font("raleway", Font.BOLD, 14));
                pinTextFeild.setBounds(300, 590, 400, 30);
                add(pinTextFeild);
  
            next = new JButton("Next");
            next.setBackground(Color.BLACK);
            next.setForeground(Color.WHITE);
            next.setFont(new Font("raleway", Font.BOLD, 14));
            next.setBounds(620, 660, 80, 30);
            next.addActionListener(this);
            add(next);

        getContentPane().setBackground(Color.LIGHT_GRAY);

        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
   
    public void actionPerformed(ActionEvent ae) {
       String formno = ""+Random;//long
       String name = nameTextFeild.getText();
       String fname = fnameTextFeild.getText();
       String Dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
       String gender = null;
       
       if(male.isSelected())
       {
        gender = "male";
       }
       else if (female.isSelected())
       {
        gender = "female";
       }
        
       String email = emailTextFeild.getText();

       String marital = null;
       if (married.isSelected())
       {
          marital = "married";
       } else if (unmarried.isSelected())
       {
        marital = "unmarried";
       } else if (other.isSelected())
       {
        marital = "other";
       }

       String address = addressTextFeild.getText();
       String city = cityTextFeild.getText();
       String state = stateTextFeild.getText();
       String pin = pinTextFeild.getText();

       try{
           
                 if(name.equals(""))
                     {
                              JOptionPane.showMessageDialog(null,"Name is reqired");
                      }  
       
                else 
                     {      conn c =new conn();
                             String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+Dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
                            c.s.execute(query);
                            System.out.println(query);
                           
                            setVisible(false);
                            new signuptwo(formno).setVisible(true);
                            
                     }
       }
      catch (Exception e) {
            System.out.println(e);
     }
    }

public static void main(String[] args) {
    
     new signupone();
}
}  


            
    
       

    
    
    
