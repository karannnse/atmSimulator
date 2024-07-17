package bankmangment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class conn {



 Connection c;
 Statement s;

   public conn()

    {
           try{
           Class.forName("com.mysql.cj.jdbc.Driver");
            c= DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagment", "root","7874836911");
            s=c.createStatement();
           System.out.println(c);
        } catch (Exception e) {
            System.out.println(e);
        }
    
     }
            
         }


