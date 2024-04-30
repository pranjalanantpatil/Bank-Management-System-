package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
 
public class Login extends JFrame implements ActionListener{      // Using Inheritance concept 
    
    JButton login, signup, clear;  // JButton defined Globally for accessing the buttons outside the constructor also
    JTextField cardTextField;  // Globally declared for accessing the action performer 
    JPasswordField pinTextField; 
    
    Login() {      // Constructor
        
        setTitle("AUTOMATED TELLER MACHINE");
        
        setLayout(null);   //For icon can place where we placed if we not null then their default layout is centered
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);      // For Resize the image
        ImageIcon i3 = new ImageIcon(i2);    // Converting image into imageIcon
        JLabel label = new JLabel(i3);       // with the help of Jframe we can able to see image on our page or frame
        label.setBounds(70, 10, 100, 100);   //For Spacing in between icon and page or frame
        add(label);
        
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200, 40, 400, 40);  // (left to right, top, width, height)
        add(text);
        
         JLabel cardno = new JLabel("Card No.");
        cardno.setFont(new Font("Raleway", Font.BOLD, 28));
        cardno.setBounds(120, 150, 150, 30);  // (left to right, top, width, height)
        add(cardno);
        
        cardTextField = new JTextField(); // TextField used for create a box infront of card No.
        cardTextField.setBounds(300, 150, 230, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));   //Font size for inside the card no.box
        add(cardTextField);
        
         JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(120, 220, 250, 30);  // (left to right, top, width, height)
        add(pin);
        
        pinTextField = new JPasswordField(); // TextField used for create a box infront of card No.
        pinTextField.setBounds(300, 220, 230, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));   //Font size for inside the pin no.box
        add(pinTextField);
        
        login = new JButton("SIGN IN");   //Button Locally defined hai
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);    // It is a Function it applay on our button perform a action
        add(login);
        
        clear = new JButton("CLEAR");   // Buttonnlocally defined hai
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);    // It is a Function it applay on our button perform a action
        add(clear);
        
        signup = new JButton("SIGN UP");   // Button locally defined hai
        signup.setBounds(300, 350, 230, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);    // It is a Function it applay on our button perform a action
        add(signup);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(800, 480); //set size of frame
        setVisible(true);
        setLocation(350, 200); //For open a page in middle 
    
    }
    
    public void actionPerformed(ActionEvent ae) {    // Override a Method 
        if (ae.getSource() == clear) {
            cardTextField.setText("");
            pinTextField.setText("");
        } else if (ae.getSource() == login) {
            Conn conn = new Conn();  // For establish a connection with database
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();  //erase mark indicate password is not text field
            String query = "Select* from login where cardnumber = '"+cardnumber+"' and  pin = '"+pinnumber+"' ";  // data ko match kr rahe hai user ne jo data fil kiya wo correct hai ya nahi direct mysql ke query ke through
            try{
                ResultSet rs = conn.s.executeQuery(query);  //If data is matched and those personal data can catch the resultset fuction
                if(rs.next()) {
                    setVisible(false);  //Closing the login page 
                    new Transactions(pinnumber).setVisible(true);   //Opening the transition page means we had successfully login,pinumber ko forward kiya transaction me 
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
                }
                
            } catch(Exception e){
                System.out.println(e);
            }
            
        } else if (ae.getSource() == signup) {  // If click in the signup page 
            setVisible(false);  // Closing current(login) page
            new SignupOne().setVisible(true);   // For Visible and opening the Signup form
            
            
        }
    
    }
    
    public static void main(String[] args) {
        new Login();   //Class ka Object
    }
}
