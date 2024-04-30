package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;       
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener {
    
    long random;  // Globally declared
    JTextField nameTextField, fnameTextField, dobTextField, emailTextField, addressTextField, cityTextField, stateTextField, pinTextField;
    JButton next;
    JRadioButton male, female, other, married, unmarried;
    JDateChooser dateChooser;

    SignupOne() {   //Constructor
        
        setLayout(null);
        
        Random ran = new Random();    //Object
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);   // For generating random no. of page
        
        JLabel  formno = new JLabel("APPLICATION FORM NO. " + random );
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(140, 20, 600, 40);
        add(formno);
        
        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personalDetails.setBounds(290, 80, 400, 30);
        add(personalDetails);
        
        JLabel name = new JLabel("Name: ");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);
        
        nameTextField = new JTextField();  // For Creating the box infront of the name label
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));  // Font for writing inside the box
        nameTextField.setBounds(300, 140, 400, 30);   // Set the box size where to starting, Top, Box Width, Box Height
        add(nameTextField);
        
        JLabel fname = new JLabel("Father's Name: ");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);
        
        fnameTextField = new JTextField();  // For Creating the box infront of the fname label
        fnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));  // Font for writing inside the box
        fnameTextField.setBounds(300, 190, 400, 30);   // Set the box size where to starting, Top, Box Width, Box Height
        add(fnameTextField);
        
        JLabel dob = new JLabel("Date Of Birth: ");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);
        
        dateChooser = new JDateChooser();   //JDateChooser ch Object
        dateChooser.setBounds(300, 240, 400, 30);
        dateChooser.setForeground(new Color(105, 105, 105));  //Create a new Color Object RGB
        add(dateChooser);
        
        
        JLabel gender = new JLabel("Gender: ");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);
        
        male = new JRadioButton("Male");  //JRadioButton for add radio buttons 
        male.setBounds(300, 290, 60, 30);
        male.setBackground(Color.WHITE);
        add(male);
        
        female = new JRadioButton("Female");  //JRadioButton for add radio buttons 
        female.setBounds(450, 290, 120, 30);
        female.setBackground(Color.WHITE);
        add(female);
        
        ButtonGroup gendergroup = new ButtonGroup();   // Male, Female hyan cha group kela for selecting only one option
        gendergroup.add(male);
        gendergroup.add(female);
        
        JLabel email = new JLabel("Email Address: ");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 340, 200, 30);
        add(email);
        
        emailTextField = new JTextField();  // For Creating the box infront of the email label
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));  // Font for writing inside the box
        emailTextField.setBounds(300, 340, 400, 30);   // Set the box size where to starting, Top, Box Width, Box Height
        add(emailTextField);
        
        JLabel marital = new JLabel("Marital Status: ");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100, 390, 200, 30);
        add(marital);
        
        married = new JRadioButton("Married");  //JRadioButton for add radio buttons 
        married.setBounds(300, 390, 100, 30);
        married.setBackground(Color.WHITE);
        add(married);
        
        unmarried = new JRadioButton("Unmarried");  //JRadioButton for add radio buttons 
        unmarried.setBounds(450, 390, 100, 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        
        other = new JRadioButton("Other");  //JRadioButton for add radio buttons 
        other.setBounds(630, 390, 100, 30);
        other.setBackground(Color.WHITE);
        add(other);
        
        ButtonGroup maritalgroup = new ButtonGroup();   // Married,Unmarried hyan cha group kela for selecting only one option
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(other);
        
        JLabel address = new JLabel("Address: ");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 440, 200, 30);
        add(address);
        
        addressTextField = new JTextField();  // For Creating the box infront of the address label
        addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));  // Font for writing inside the box
        addressTextField.setBounds(300, 440, 400, 30);   // Set the box size where to starting, Top, Box Width, Box Height
        add(addressTextField);
        
        JLabel city = new JLabel("City: ");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 490, 200, 30);
        add(city);
        
        cityTextField = new JTextField();  // For Creating the box infront of the city label
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));  // Font for writing inside the box
        cityTextField.setBounds(300, 490, 400, 30);   // Set the box size where to starting, Top, Box Width, Box Height
        add(cityTextField);
        
        JLabel state = new JLabel("State: ");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 540, 200, 30);
        add(state);
        
        stateTextField = new JTextField();  // For Creating the box infront of the state label
        stateTextField.setFont(new Font("Raleway", Font.BOLD, 14));  // Font for writing inside the box
        stateTextField.setBounds(300, 540, 400, 30);   // Set the box size where to starting, Top, Box Width, Box Height
        add(stateTextField);
        
        JLabel pincode = new JLabel("Pin Code: ");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100, 590, 200, 30);
        add(pincode);
        
        pinTextField = new JTextField();  // For Creating the box infront of the pin code label
        pinTextField.setFont(new Font("Raleway", Font.BOLD, 14));  // Font for writing inside the box
        pinTextField.setBounds(300, 590, 400, 30);   // Set the box size where to starting, Top, Box Width, Box Height
        add(pinTextField);
        
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);  // Add a Actionlistener to a next button
        add(next);
                    
        getContentPane().setBackground(Color.WHITE);   //Set Frame Background white
        
        
        setSize(850, 800);    //Set size of Frame
        setLocation(350, 10);   //For open a page in middle
        setVisible(true);  // default true
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        String formno = "" + random; // long
        String name = nameTextField.getText();   // Get the value from their own text Fields
        String fname = fnameTextField.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (male.isSelected()) {
            gender = "Male";
        } else if(female.isSelected()){
            gender = "Female";
        }
        
        String email = emailTextField.getText();
        String marital = null;
        if (married.isSelected()){
            marital = "Married";
        } else if(unmarried.isSelected()){
            marital = "Unmarried";
        } else if(other.isSelected()) {
            marital = "Other";
        }
        
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pinTextField.getText();
        
        try{
            if(name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name is Required");
            } else{
                Conn c = new Conn(); //Connection  ch Object
                String query = "insert into signup values('"+formno+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+marital+"', '"+address+"', '"+city+"', '"+pin+"', '"+state+"')";   // Mysql Query to insert the data in to databases
                c.s.executeUpdate(query);      // Execute a query with the help of Connection class and statement
                
                setVisible(false);  // for invisible (Closing) this page
                new SignupTwo(formno).setVisible(true);  //formno is primary key. with the help of this we can insert data to correct person 1 page to 2nd page
            }
        }catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
    public static void main(String[] args) {
        new SignupOne();  //Object of SIgnupOne
        
    }
    
}
