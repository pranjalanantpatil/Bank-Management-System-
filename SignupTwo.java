package bank.management.system;

import javax.swing.*;
import java.awt.*;      
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{
    
    JTextField pan, aadhar;    // Globally declared
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    JComboBox religion, category, occupation, education, income;
    String formno;

    SignupTwo(String formno) {   //Constructor
        this.formno = formno;
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);
        
        JLabel lreligion = new JLabel("Religion: ");
        lreligion.setFont(new Font("Raleway", Font.BOLD, 20));
        lreligion.setBounds(100, 140, 100, 30);
        add(lreligion);
        
        String valReligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"}; 
        religion = new JComboBox(valReligion);    //When we have a DropDown then we use ComboBox  
        religion.setBounds(300, 140, 400, 30);   // Set the box size where to starting, Top, Box Width, Box Height
        religion.setBackground(Color.WHITE);
        add(religion);
        
        
        JLabel Category = new JLabel("Category: ");
        Category.setFont(new Font("Raleway", Font.BOLD, 20));
        Category.setBounds(100, 190, 200, 30);
        add(Category);
        
        String valcategory[] = {"General", "OBC", "SC", "ST", "Other"};
        category = new JComboBox(valcategory);   //When we have a DropDown then we use ComboBox 
        category.setBounds(300, 190, 400, 30);   // Set the box size where to starting, Top, Box Width, Box Height
        category.setBackground(Color.WHITE);
        add(category);
        
        JLabel Income = new JLabel("Income: ");
        Income.setFont(new Font("Raleway", Font.BOLD, 20));
        Income.setBounds(100, 240, 200, 30);
        add(Income);
        
        String incomecategory[] = {"Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "Upto 10,00,000"};
        income = new JComboBox(incomecategory);   //When we have a DropDown then we use ComboBox 
        income.setBounds(300, 240, 400, 30);   // Set the box size where to starting, Top, Box Width, Box Height
        income.setBackground(Color.WHITE);
        add(income);
         
        JLabel Educational = new JLabel("Educational ");
        Educational.setFont(new Font("Raleway", Font.BOLD, 20));
        Educational.setBounds(100, 290, 200, 30);
        add(Educational);
        
        JLabel Qualification = new JLabel("Qualification: ");
        Qualification.setFont(new Font("Raleway", Font.BOLD, 20));
        Qualification.setBounds(100, 315, 200, 30);
        add(Qualification);
        
        String educationValues[] = {"Non-Graduation", "Graduation", "Post-Graduation", "Doctarate", "Others"};
        education = new JComboBox(educationValues);   //When we have a DropDown then we use ComboBox 
        education.setBounds(300, 315, 400, 30);   // Set the box size where to starting, Top, Box Width, Box Height
        education.setBackground(Color.WHITE);
        add(education);
        
        JLabel Occupation = new JLabel("Occupation: ");
        Occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        Occupation.setBounds(100, 390, 200, 30);
        add(Occupation);
        
        String occupationValues[] = {"Salaried", "Self-Employed", "Bussiness", "Student", "Retired", "Others"};
        occupation = new JComboBox(occupationValues);   //When we have a DropDown then we use ComboBox 
        occupation.setBounds(300, 390, 400, 30);   // Set the box size where to starting, Top, Box Width, Box Height
        occupation.setBackground(Color.WHITE);
        add(occupation);
      
        JLabel panno = new JLabel("PAN Number: ");
        panno.setFont(new Font("Raleway", Font.BOLD, 20));
        panno.setBounds(100, 440, 200, 30);
        add(panno);
        
        pan = new JTextField();  // For Creating the box infront of the address label
        pan.setFont(new Font("Raleway", Font.BOLD, 14));  // Font for writing inside the box
        pan.setBounds(300, 440, 400, 30);   // Set the box size where to starting, Top, Box Width, Box Height
        add(pan);
        
        JLabel aadharno = new JLabel("Aadhar Number: ");
        aadharno.setFont(new Font("Raleway", Font.BOLD, 20));
        aadharno.setBounds(100, 490, 200, 30);
        add(aadharno);
        
        aadhar = new JTextField();  // For Creating the box infront of the city label
        aadhar.setFont(new Font("Raleway", Font.BOLD, 14));  // Font for writing inside the box
        aadhar.setBounds(300, 490, 400, 30);   // Set the box size where to starting, Top, Box Width, Box Height
        add(aadhar);
        
        JLabel seniorc = new JLabel("Senior Citizen: ");
        seniorc.setFont(new Font("Raleway", Font.BOLD, 20));
        seniorc.setBounds(100, 540, 200, 30);
        add(seniorc);
        
        syes = new JRadioButton("Yes");  //JRadioButton for add radio buttons 
        syes.setBounds(300, 540, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno = new JRadioButton("No");  //JRadioButton for add radio buttons 
        sno.setBounds(450, 540, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        ButtonGroup seniorcgroup = new ButtonGroup();   // Yes or no1 hyan cha group kela for selecting only one option
        seniorcgroup.add(syes);
        seniorcgroup.add(sno);
     
        JLabel pincode = new JLabel("Existing Account: ");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100, 590, 200, 30);
        add(pincode);
        
        eyes = new JRadioButton("Yes");  //JRadioButton for add radio buttons 
        eyes.setBounds(300, 590, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno = new JRadioButton("No");  //JRadioButton for add radio buttons 
        eno.setBounds(450, 590, 100, 30);
        eno.setBackground(Color.WHITE);
        add(eno);
        
        ButtonGroup eaccountgroup = new ButtonGroup();   // Married,Unmarried hyan cha group kela for selecting only one option
        eaccountgroup.add(eyes);
        eaccountgroup.add(eno);
        
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
        String sreligion =(String) religion.getSelectedItem();   //get the values of religion dropdown
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        String seniorcitizen = null;
        if (syes.isSelected()) {
            seniorcitizen = "Yes";
        } else if(sno.isSelected()){
            seniorcitizen = "No";
        }
        
        String existingaccount = null;
        if (eyes.isSelected()){
            existingaccount = "Yes";
        } else if(eno.isSelected()){
            existingaccount = "No";
        } 
        
        String span = pan.getText();
        String saadhar = aadhar.getText();
      
        try{
                Conn c = new Conn(); //Connection  ch Object
                String query = "insert into signuptwo values('"+formno+"', '"+sreligion+"', '"+scategory+"', '"+sincome+"', '"+seducation+"', '"+soccupation+"', '"+span+"', '"+saadhar+"', '"+seniorcitizen+"', '"+existingaccount+"')";   // Mysql Query to insert the data in to databases
                c.s.executeUpdate(query);      // Execute a query with the help of Connection class and statement
                
                //Signup3 Object
                setVisible(false);   //Closing the SignupTwo form
                new SignupThree(formno).setVisible(true);   // Opening the SignupThree form, primary key is formno
        }catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
    public static void main(String[] args) {
        new SignupTwo("");  //Object of SignupTwo
        
    }
    
}
