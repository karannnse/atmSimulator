package bankmangment;

import java.awt.Color;
import java.awt.Font;


import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class signuptwo extends JFrame implements ActionListener 
{

    
    JTextField  panTextFeild, aadharTextFeild;
    JButton next;
    JRadioButton Syes ,Sno,eyes ,eno;
    String formno;
    JComboBox religion,catagory,occupation,education,income;
   

    signuptwo(String formno)
    {
        this.formno=formno; 
        setLayout(null);



        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
          
          
            


                JLabel additionalDetail = new JLabel("page 2: Additional details" );
                additionalDetail.setFont(new Font("raleway", Font.BOLD, 22));
                additionalDetail.setBounds(290, 80, 400, 30);
                add(additionalDetail);

                JLabel name = new JLabel( "Religion:");
                name.setFont(new Font ("raleway ",Font.BOLD,20));
                name.setBounds(100,140,100,30);
                add(name);

                String valreligion[] = {"Hindu","muslin","sikh","Cristion","other"} ;
                religion = new JComboBox<>(valreligion);
                religion.setBounds(300, 140, 400, 30);
                add(religion);

            
               
                JLabel fname = new JLabel("Catagory:");
                fname.setFont(new Font("Raleway", Font.BOLD, 20));
                fname.setBounds(100,190,200,30);
                add(fname);

                String valcatagory[]= {"general","obc ","sc","st","other"};
                catagory = new JComboBox<>(valcatagory);
                catagory.setBounds(300, 190, 400, 30);
                add(catagory);

                JLabel Dob = new JLabel("Income:");
                Dob.setFont(new Font("Raleway", Font.BOLD, 20));
                Dob.setBounds(100,240,200,30);
                add(Dob);

                String incomecatagory[] = {"null","< 1,50,000","<2,50,000","<5,00,000","<10,00,000"} ;
                income = new JComboBox<>(incomecatagory);
                income.setBounds(300, 240, 400, 30);
                add(income);
                


                JLabel gender = new JLabel("Educational");
                gender.setFont(new Font("Raleway", Font.BOLD, 20));
                gender.setBounds(100,290,200,30);
                add(gender);

            
                JLabel email = new JLabel("Qualification:");
                email.setFont(new Font("Raleway", Font.BOLD, 20));
                email.setBounds(100,315,200,30);
                add(email);

                String educationvalue[] = {"non-graduate","Graduation","post-graguation",} ;
                education= new JComboBox<>(educationvalue);
                education.setBounds(300, 315, 400, 30);
                add(education);


            
                JLabel marital = new JLabel("Occupation:");
                marital.setFont(new Font("Raleway", Font.BOLD, 20));
                marital.setBounds(100,390,200,30);
                add(marital);

                String Occupationval[] = {"Salaride","self-employed","Bussiness","Studend", "retired"} ;
                occupation= new JComboBox<>(Occupationval);
                occupation.setBounds(300, 390, 400, 30);
                add(occupation);

            
                JLabel address = new JLabel("Pan no:");
                address.setFont(new Font("Raleway", Font.BOLD, 20));
                address.setBounds(100,440,200,30);
                add(address);

                panTextFeild = new JTextField();
                panTextFeild.setFont(new Font("raleway", Font.BOLD, 14));
                panTextFeild.setBounds(300, 440, 400, 30);
                add(panTextFeild);

                JLabel aadharno = new JLabel("aadhar no:");
                aadharno.setFont(new Font("Raleway", Font.BOLD, 20));
                aadharno.setBounds(100,490,200,30);
                add(aadharno);

                aadharTextFeild = new JTextField();
                aadharTextFeild.setFont(new Font("raleway", Font.BOLD, 14));
                aadharTextFeild.setBounds(300, 490, 400, 30);
                add( aadharTextFeild);

                JLabel state = new JLabel("Senior citizen:");
                state.setFont(new Font("Raleway", Font.BOLD, 20));
                state.setBounds(100,540,200,30);
                add(state);

                Syes =new JRadioButton("Yes");
                Syes.setBounds(300,540,100,30);
                Syes.setBackground(Color.WHITE);
                add(Syes);

                Sno =new JRadioButton("No");
                Sno.setBounds(450,540,100,30);
                Sno.setBackground(Color.WHITE);
                add(Sno);
                ButtonGroup SGroup=new ButtonGroup();
                SGroup.add(Syes);
                SGroup.add(Sno);
            

                JLabel pincode = new JLabel("Exisiting Account:");
                pincode.setFont(new Font("Raleway", Font.BOLD, 20));
                pincode.setBounds(100,590,200,30);
                add(pincode);

                eyes =new JRadioButton("Yes");
                eyes.setBounds(300,590,100,30);
                eyes.setBackground(Color.WHITE);
                add(eyes);

                eno =new JRadioButton("No");
                eno.setBounds(450,590,100,30);
                eno.setBackground(Color.WHITE);
                add(eno);
                ButtonGroup eGroup=new ButtonGroup();
                eGroup.add(eyes);
                eGroup.add(eno);
               
  
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
     
       String sreligion = (String) religion.getSelectedItem();
       String scatagory= (String) catagory.getSelectedItem();
       String sincome = (String) income.getSelectedItem();
       String seducation= (String) education.getSelectedItem();      
       String soccupation = (String) occupation.getSelectedItem();  
       String seniorcitizen =null;     
       if(Syes.isSelected())
       {
        seniorcitizen = "yes";
       }
       else if (Sno.isSelected())
       {
        seniorcitizen = "No";
       }
        
       String existingaccount = null;
       if (eyes.isSelected())
       {
          existingaccount = "yes";
       } else if (eno.isSelected())
       {
       existingaccount = "no";
       }

       String span = panTextFeild.getText();
       String saadhar = aadharTextFeild.getText();
      
       try{
                            conn c =new conn();
                             String query = "insert into signuptwo values('"+formno+"','"+sreligion+"','"+scatagory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"+existingaccount+"')";
                            c.s.executeUpdate(query);
                        setVisible(false);
                        new signupthree(formno).setVisible(true);
         }
       
      catch (Exception e) {
            System.out.println(e);
     }
    }

public static void main(String[] args) {
    
     new signuptwo("");
}
}  


            
    
       

    
    
    
