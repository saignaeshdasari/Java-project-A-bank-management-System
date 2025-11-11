import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class Signup1 extends JFrame implements ActionListener {
  long random;
  JTextField nTextField, FTextField, MTextField, dTextField, ETextField, ATextField, PTextField, CTextField,
      STextField;
  JRadioButton male, Female, married, unmaried;

  Signup1(){ {
        setLayout(null);
        Random r = new Random();
        long random = Math.abs((r.nextLong()%9000L) + 1000L);
         JLabel formno = new JLabel("Application Form No. " + random);
         formno.setFont(new Font("Raleway", Font.BOLD, 38));
         formno.setBounds(160, 20, 600, 40);
         add(formno);
         
            JLabel personaldetails = new JLabel("Page 1: Personal details");
            personaldetails.setFont(new Font("Raleway", Font.BOLD, 22));
            personaldetails.setBounds(290, 80, 400, 30);
            add(personaldetails);

            JLabel name = new JLabel("Name:");
            name.setBounds(100,160,100,30);
            name.setFont(new Font("Raleway", Font.BOLD,22));
            add(name);

            nTextField = new JTextField();
            nTextField.setFont(new Font("Raleway", Font.BOLD, 15));
            nTextField.setBounds(300,160,400,30);
            add(nTextField);

            JLabel Fathername = new JLabel("Father's Name:");
            Fathername.setBounds(100, 210, 200, 30);
            Fathername.setFont(new Font("Raleway", Font.BOLD, 22));
            add(Fathername);

             FTextField = new JTextField();
            FTextField.setFont(new Font("Raleway", Font.BOLD, 15));
            FTextField.setBounds(300, 210, 400, 30);
            add(FTextField);

            JLabel Mothername = new JLabel("Mother's name:");
            Mothername.setBounds(100, 250, 190, 30);
            Mothername.setFont(new Font("Raleway", Font.BOLD, 22));
            add(Mothername);

            MTextField = new JTextField();
            MTextField.setFont(new Font("Raleway", Font.BOLD, 15));
            MTextField.setBounds(300, 260, 400, 30);
            add(MTextField);

            JLabel DOB = new JLabel("Date of Birth:");
            DOB.setBounds(100, 300, 200, 30);
            DOB.setFont(new Font("Raleway", Font.BOLD, 22));
            add(DOB);

           dTextField = new JTextField();
            dTextField.setFont(new Font("Raleway", Font.BOLD, 15));
            dTextField.setBounds(300, 310, 400, 30);
            add(dTextField);
            
           
            JLabel gender = new JLabel("Gender:");
            gender.setBounds(100, 340, 200, 30);
            gender.setFont(new Font("Raleway", Font.BOLD, 22));
            add(gender);

            male =  new JRadioButton("Male");
            male.setBounds(300,340,60,40);
            male.setBackground(Color.WHITE);
            add(male);

            Female = new JRadioButton("Female");
            Female.setBounds(450,340,80,40);
            Female.setBackground(Color.WHITE);
            add(Female);

            ButtonGroup gendergrp = new ButtonGroup();
            gendergrp.add(male);
            gendergrp.add(Female);
            
            JLabel email = new JLabel("Email ID:");
            email.setBounds(100, 380, 200, 30);
            email.setFont(new Font("Raleway", Font.BOLD, 22));
            add(email);

             ETextField = new JTextField();
            ETextField.setFont(new Font("Raleway", Font.BOLD, 15));
            ETextField.setBounds(300, 390, 400, 30);
            add(ETextField);
            
            JLabel ms = new JLabel("Marital status:");
            ms.setBounds(100, 420, 200, 30);
            ms.setFont(new Font("Raleway", Font.BOLD, 22));
            add(ms);

            married = new JRadioButton("Married");
            married.setBounds(300, 420, 100, 40);
            married.setBackground(Color.WHITE);
            add(married);

            unmaried = new JRadioButton("Unmarried");
            unmaried.setBounds(450, 420, 120, 40);
            unmaried.setBackground(Color.WHITE);
            add(unmaried);

            ButtonGroup margrp = new ButtonGroup();
            margrp.add(married);
            margrp.add(unmaried);

            JLabel address = new JLabel("Address:");
            address.setBounds(100, 460, 200, 30);
            address.setFont(new Font("Raleway", Font.BOLD, 22));
            add(address);

            ATextField = new JTextField();
            ATextField.setFont(new Font("Raleway", Font.BOLD, 15));
            ATextField.setBounds(300, 470, 400, 30);
            add(ATextField);

            JLabel city = new JLabel("City:");
            city.setBounds(100, 500, 200, 30);
            city.setFont(new Font("Raleway", Font.BOLD, 22));
            add(city);

            CTextField = new JTextField();
            CTextField.setFont(new Font("Raleway", Font.BOLD, 15));
            CTextField.setBounds(300, 510, 400, 30);
            add(CTextField);

            JLabel state = new JLabel("State:");
            state.setBounds(100, 540, 200, 30);
            state.setFont(new Font("Raleway", Font.BOLD, 22));
            add(state);

            STextField = new JTextField();
            STextField.setFont(new Font("Raleway", Font.BOLD, 15));
            STextField.setBounds(300, 550, 400, 30);
            add(STextField);
               
            JLabel pincode = new JLabel("Pincode:");
            pincode.setBounds(100, 580, 200, 30);
            pincode.setFont(new Font("Raleway", Font.BOLD, 22));
            add(pincode);
            
            
            PTextField = new JTextField();
            PTextField.setFont(new Font("Raleway", Font.BOLD, 15));
            PTextField.setBounds(300, 590, 400, 30);
            add(PTextField);

            JButton next = new JButton("Next");
            next.setBackground(Color.BLACK);
            next.setForeground(Color.WHITE);
            next.setBounds(620,660,80,30);
            next.setFont(new Font("Raleway",Font.BOLD,14));
            next.addActionListener(this);
            add(next);

       setSize(850, 800);
       setVisible(true);
       setLocation(350, 10);
       getContentPane().setBackground(Color.WHITE);
      
    }
  }
  public void actionPerformed(ActionEvent e) {
    String formno = "" + random;
    String name = nTextField.getText();
    String fname = FTextField.getText();
    String mname = MTextField.getText();
    String dob = dTextField.getText();
    String gender = null;
    if (male.isSelected()) {
      gender = "Male";
    } else if (Female.isSelected()) {
      gender = "Female";
    }
    String email = ETextField.getText();
    String marital = null;
    if (married.isSelected()) {
      marital = "married";
    } else {
      marital = "unmaried";
    }
    String address = ATextField.getText();
    String city = CTextField.getText();
    String state = STextField.getText();
    String pin = PTextField.getText();

    try {
      if (name.equals("")) {
        JOptionPane.showMessageDialog(this, "Name is required!");
      } else {
        Conn c = new Conn();
        String query = "insert into signup values{'" + formno + "','" + name + "','" + fname + "'+'" + mname + "','"
            + dob + "','" + gender + "','" + email + "','" + marital + "','" + address + "','" + city + "','" + state
            + "','" + pin + "'}";
        c.s.executeUpdate(query);
        
        setVisible(false);
        new Signup2(formno).setVisible(true);
       
      }
    } catch (Exception a) {
      System.out.println(a);
    }
  }
  
  public static void main(String[] args) {
    new Signup1();
  }
}
