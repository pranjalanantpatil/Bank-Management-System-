package bank.management.system;

import java.sql.*;

public class Conn {   // Ya class cha object banun use kelay in that we cannot use main method 
    
    Connection c;   //Globally create kela Connection class cha object c 
    Statement s;
    public Conn() {
        try {
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "123456789");
            s = c.createStatement();  // With the help of statement we can execute a query
            
        } catch(Exception e){
            System.out.println(e);   //e print kela means jo error aala to print kela  
        }
    }
    
    
}
