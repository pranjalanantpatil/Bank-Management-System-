package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class BalanceEnquiry extends JFrame implements ActionListener {
    
    JButton back;
    String pinnumber;
    
    BalanceEnquiry(String pinnumber) {
        this.pinnumber = pinnumber;   //Local se pin ko uthaya and global me dala
        setLayout(null);            //For icon can place where we placed if we not null then their default layout is centered
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);       // For Resize the image
        ImageIcon i3 = new ImageIcon(i2);      // Converting image into imageIcon
        JLabel image = new JLabel(i3);         // with the help of Jframe we can able to see image on our page or frame
        image.setBounds(0, 0, 900, 900);       //Place the image on frame(page)
        add(image);
        
        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);     //Catch the action when the user clicking the button
        image.add(back);                  // Adding the change button on image
        
         Conn c = new Conn();
          int balance = 0;
         try {
             ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"' ");  // ye pinnumber utha ke check karega
             while(rs.next()) {   //rs.next helping the looping thye rowso of deposit and withdraw amount
                 if(rs.getString("type").equals("Deposit")) {
                     balance += Integer.parseInt(rs.getString("amount"));   // Amount ko integer me convert kiya because wo string tha
                 } else {
                     balance -= Integer.parseInt(rs.getString("amount"));   // Amount ko integer me convert kiya because wo string tha                      
                 }
               }
             } catch (Exception e) {
                  System.out.println(e);
           }
         
         JLabel text = new JLabel("Your Current Account Balance is Rs " + balance);
         text.setForeground(Color.WHITE);
         text.setBounds(170, 300, 400, 30);
         image.add(text);
        
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }
    public static void main(String args[]) {
        new BalanceEnquiry("");    //Class ka Object
    }
}
