package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame {
    
    MiniStatement(String pinnumber) {
        setTitle("Mini Statement");    // For Giving the title
        
        setLayout(null);    //For icon can place where we placed if we not null then their default layout is centered
        
        JLabel mini = new JLabel();
        add(mini);
        
        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150, 20, 100, 20);
        add(bank);
        
        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);
        
        JLabel balance = new JLabel();
        balance.setBounds(20, 400, 300, 20);
        add(balance);
        
        try {      //Query for login table 
            Conn conn = new Conn();   // Opening the Connection on database
            ResultSet rs = conn.s.executeQuery("select * from login where pin = '"+pinnumber+"' ");   //Resultset is in the sql package
            while(rs.next()) {
                card.setText("Card Number: " + rs.getString("cardnumber").substring(0, 4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12));   // For not to fully visible the card number 
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        try{    // Query for bank table
            Conn conn = new Conn();
            int bal = 0;
            ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            while(rs.next()) {
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");  // For spacing the in between date, type and amount
                 if(rs.getString("type").equals("Deposit")) {    
                        bal += Integer.parseInt(rs.getString("amount"));   // Amount ko integer me convert kiya because wo string tha
                    } else {
                        bal -= Integer.parseInt(rs.getString("amount"));   // Amount ko integer me convert kiya because wo string tha                      
                    }
            }
            balance.setText("Your Current Account balance is Rs " + bal);  // For Displaying the balance in account
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        mini.setBounds(20, 140, 400, 200);
        
        
        setSize(400, 600);    //Set the Size of frame
        setLocation(20, 20);  // For opening on left side 
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    
    public static void main(String args[]) {
        new MiniStatement("");
        
    }
    
}
