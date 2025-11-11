import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class Signup2 extends JFrame implements ActionListener {

    JTextField pTextField, ATextField, STextField;
    JRadioButton Yes, No;
    JComboBox<String> category, religion, income, edu, occ;
     String formno;
    Signup2(String formno) {
        setLayout(null);
        setTitle("New Account Application Form - Page 2");
        this.formno = formno;

        JLabel Additionaldetails = new JLabel("Page 2: Additional details");
        Additionaldetails.setFont(new Font("Raleway", Font.BOLD, 22));
        Additionaldetails.setBounds(290, 80, 400, 30);
        add(Additionaldetails);

        JLabel Category = new JLabel("Category");
        Category.setBounds(100, 160, 100, 30);
        Category.setFont(new Font("Raleway", Font.BOLD, 22));
        add(Category);

        String valCategory[] = { "Open", "OBC", "SC", "ST", "Other" };
        category = new JComboBox<>(valCategory);
        category.setBounds(300, 160, 400, 30);
        add(category);

        JLabel Religion = new JLabel("Religion:");
        Religion.setBounds(100, 210, 200, 30);
        Religion.setFont(new Font("Raleway", Font.BOLD, 22));
        add(Religion);

        String valReligion[] = { "Hindu", "Muslim", "Sikh", "Christian", "Other" };
        religion = new JComboBox<>(valReligion);
        religion.setBounds(300, 210, 400, 30);
        add(religion);

        JLabel Income = new JLabel("Income:");
        Income.setBounds(100, 250, 190, 30);
        Income.setFont(new Font("Raleway", Font.BOLD, 22));
        add(Income);

        String valIncome[] = { "Null", "< 1 Lakh", "1 - 5 Lakh", "5 - 10 Lakh", "> 10 Lakh" };
        income = new JComboBox<>(valIncome);
        income.setBounds(300, 260, 400, 30);
        add(income);

        JLabel Education = new JLabel("Qualification:");
        Education.setBounds(100, 300, 200, 30);
        Education.setFont(new Font("Raleway", Font.BOLD, 22));
        add(Education);

        String valEdu[] = { "Metric", "Non Graduate", "Graduate", "Post Graduate", "PhD", "Other" };
        edu = new JComboBox<>(valEdu);
        edu.setBounds(300, 310, 400, 30);
        add(edu);

        JLabel Occupation = new JLabel("Occupation:");
        Occupation.setBounds(100, 380, 200, 30);
        Occupation.setFont(new Font("Raleway", Font.BOLD, 22));
        add(Occupation);

        String valOcc[] = { "Salaried", "Self employed", "Business", "Student", "Others" };
        occ = new JComboBox<>(valOcc);
        occ.setBounds(300, 390, 400, 30);
        add(occ);

        JLabel pan = new JLabel("PAN no:");
        pan.setBounds(100, 440, 200, 30);
        pan.setFont(new Font("Raleway", Font.BOLD, 22));
        add(pan);

        pTextField = new JTextField();
        pTextField.setBounds(300, 440, 400, 30);
        add(pTextField);

        JLabel aadhar = new JLabel("Aadhar no:");
        aadhar.setBounds(100, 480, 200, 30);
        aadhar.setFont(new Font("Raleway", Font.BOLD, 22));
        add(aadhar);

        ATextField = new JTextField();
        ATextField.setBounds(300, 490, 400, 30);
        add(ATextField);

        JLabel senior = new JLabel("Senior citizen:");
        senior.setBounds(100, 520, 200, 30);
        senior.setFont(new Font("Raleway", Font.BOLD, 22));
        add(senior);

        Yes = new JRadioButton("Yes");
        Yes.setBounds(300, 520, 100, 30);
        No = new JRadioButton("No");
        No.setBounds(400, 520, 100, 30);

        ButtonGroup grp = new ButtonGroup();
        grp.add(Yes);
        grp.add(No);

        add(Yes);
        add(No);

        JLabel exist = new JLabel("Existing Account ? :");
        exist.setBounds(100, 560, 200, 30);
        exist.setFont(new Font("Raleway", Font.BOLD, 22));
        add(exist);

        STextField = new JTextField();
        STextField.setBounds(300, 560, 400, 30);
        add(STextField);

        JButton next = new JButton("Next");
        next.setBounds(620, 660, 80, 30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        setSize(850, 800);
        setLocation(350, 10);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String cat = (String) category.getSelectedItem();
        String rel = (String) religion.getSelectedItem();
        String inc = (String) income.getSelectedItem();
        String education = (String) edu.getSelectedItem();
        String occupation = (String) occ.getSelectedItem();
        String pan = pTextField.getText();
        String aadhar = ATextField.getText();
        String seniorCitizen = Yes.isSelected() ? "Yes" : "No";
        String existingAcc = STextField.getText();
        

        try {
            if (pan.isEmpty() || aadhar.isEmpty()) {
                JOptionPane.showMessageDialog(null, "PAN and Aadhar are required!");
            } else {
                Conn c = new Conn();
                String query = "INSERT INTO signup2 VALUES('" +formno+ "','" + cat + "','" + rel + "','" + inc + "','"
                        + education + "','" + occupation + "','" + pan + "','" + aadhar + "','"
                        + seniorCitizen + "','" + existingAcc + "')";

                c.s.executeUpdate(query);
                   
                    setVisible(false);
                    new Signup3(formno);
                    
                JOptionPane.showMessageDialog(null, "Details Saved Successfully ");
              
              
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void main(String[] args) {
        new Signup2("");
    }
}
