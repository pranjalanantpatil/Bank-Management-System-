package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;   // Date mention kiya because date class sql package me bhi hai to iss liye ki date jo hai util package se pick karo

public class FastCash extends JFrame implements ActionListener {
    JButton hundred, fivehundred, thousand, twothousand, fivethousand, tenthousand, back;
    String pinnumber;
    
    FastCash(String pinnumber) {   //Constructor
        this.pinnumber = pinnumber;    // Local variable ko store krr kahe ho global variable me
        
        setLayout(null);      //For icon can place where we placed if we not null then their default layout is centered
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);     // For Resize the image
        ImageIcon i3 = new ImageIcon(i2);    // Converting image into imageIcon
        JLabel image = new JLabel(i3);       // with the help of Jframe we can able to see image on our page or frame
        image.setBounds(0, 0, 900, 900);     //Place the image on frame(page)
        add(image);
        
        JLabel text = new JLabel("SELECT WITHDRAWAL AMOUNT");
        text.setBounds(220, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);   // add text on image
        
        hundred = new JButton("Rs 100");
        hundred.setBounds(170, 415, 150, 30);
        hundred.addActionListener(this);
        image.add(hundred);
        
        fivehundred = new JButton("Rs 500");
        fivehundred.setBounds(355, 415, 150, 30);
        fivehundred.addActionListener(this);
        image.add(fivehundred);
        
        thousand = new JButton("Rs 1000");
        thousand.setBounds(170, 450, 150, 30);
        thousand.addActionListener(this);
        image.add(thousand);
        
        twothousand = new JButton("Rs 2000");
        twothousand.setBounds(355, 450, 150, 30);
        twothousand.addActionListener(this);
        image.add(twothousand);
        
        fivethousand = new JButton("Rs 5000");
        fivethousand.setBounds(170, 485, 150, 30);
        fivethousand.addActionListener(this);
        image.add(fivethousand);
        
        tenthousand = new JButton("Rs 10000");
        tenthousand.setBounds(355, 485, 150, 30);
        tenthousand.addActionListener(this);
        image.add(tenthousand);
        
        back = new JButton("BACK");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);
       
        
        setSize(900, 900);   // For creating a frame
        setLocation(300, 0);   // Opening in middle
        setUndecorated(true);   // For invisible the white scale on the frame top 
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        } else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);  // Minus the first three character Rs 500
            Conn c = new Conn();
            try {
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"' ");  // ye pinnumber utha ke check karega
                int balance = 0;
                while(rs.next()) {   //rs.next helping the looping thye rowso of deposit and withdraw amount
                    if(rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));   // Amount ko integer me convert kiya because wo string tha
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));   // Amount ko integer me convert kiya because wo string tha                      
                    }
                }
                
                if (ae.getSource() != back && balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                
                Date date = new Date();
                String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs "+ amount + "Debited Successfully");
                
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
                
            }
        } 
        
    }
    
    public static void main(String args[]) {
        new FastCash("");
        
        
    }
    
}
