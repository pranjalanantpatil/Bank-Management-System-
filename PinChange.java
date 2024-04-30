package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener {   //Action perform when clicking the button and this present in the package of awt.event
    
    JPasswordField pin, repin;   //Globally Declared
    JButton change, back;
    String pinnumber;
    
    PinChange(String pinnumber) {   // Constructor
        this.pinnumber = pinnumber;    //Local se pin ko uthaya and global me dala
        setLayout(null);      //For icon can place where we placed if we not null then their default layout is centered
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);      // For Resize the image
        ImageIcon i3 = new ImageIcon(i2);    // Converting image into imageIcon
        JLabel image = new JLabel(i3);       // with the help of Jframe we can able to see image on our page or frame
        image.setBounds(0, 0, 900, 900);     //Place the image on frame(page)
        add(image);
        
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(250, 280, 500, 35);
        image.add(text);
        
        JLabel pintext = new JLabel("New PIN");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System", Font.BOLD, 16));
        pintext.setBounds(165, 320, 180, 25);
        image.add(pintext);
        
        pin = new JPasswordField();    // TextField used for create a box infront of card No.
        pin.setFont(new Font("Raleway", Font.BOLD, 25));
        pin.setBounds(330, 320, 180, 25);
        image.add(pin);     // Adding the pin textField on image
        
        JLabel repintext = new JLabel("Re-Enter New PIN");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System", Font.BOLD, 16));
        repintext.setBounds(165, 360, 180, 25);
        image.add(repintext);  
        
        repin = new JPasswordField();    // TextField used for create a box infront of card No.
        repin.setFont(new Font("Raleway", Font.BOLD, 25));
        repin.setBounds(330, 360, 180, 25);
        image.add(repin);
        
        change = new JButton("CHANGE");
        change.setBounds(355, 485, 150, 30);
        change.addActionListener(this);    //Catch the action when the user clicking the button
        image.add(change);   // Adding the change button on image
        
        back = new JButton("BACK");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);    //Catch the action when the user clicking the button
        image.add(back);   // Adding the change button on image
        
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == change) {

        try {        //Exception Handling
            String npin = pin.getText();    //Get the pin when user can enter 
            String rpin = repin.getText();
            
            if(!npin.equals(rpin)) {     //It checks the newpin is equals to repin or not if not then popup message can show
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }
            
            if (npin.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter new PIN");
                return;
            }
            
            if (rpin.equals("")) {
                JOptionPane.showMessageDialog(null, "Please re-enter new PIN");
                return;
            }
            
            Conn conn = new Conn();    //Opening the connection on database
            String query1 = "update bank set pin = '"+rpin+"' where pin= '"+pinnumber+"' ";    //Update the bank table first
            String query2 = "update login set pin = '"+rpin+"' where pin= '"+pinnumber+"' ";   //Update the Login table 
            String query3 = "update signupthree set pin = '"+rpin+"' where pin= '"+pinnumber+"' ";   //Update the Signupthree table
            
            conn.s.executeUpdate(query1);   // Execute querys
            conn.s.executeUpdate(query2);
            conn.s.executeUpdate(query3);
            
            JOptionPane.showMessageDialog(null, "PIN changed successfully");
            
            setVisible(false);
            new Transactions(rpin).setVisible(true);
                              
        } catch (Exception e) {
            System.out.println(e);            
        }
        } else {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
        
    }
        
    public static void main(String args[]) {
        new PinChange("").setVisible(true);
    }
    
}
