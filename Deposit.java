import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener {
    JTextField amount;
    JButton deposit,b;
    String pin;
    Deposit(String pin){
        this.pin =pin;
        setLayout(null);
        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2 = il.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel back = new JLabel(i3);
        back.setBounds(0, 0, 900, 900);
        add(back);
        JLabel text = new JLabel("Enter the amount you want to deposit:");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(170,300,400,20);
        back.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(170,350,320,25);
        back.add(amount);

         deposit = new JButton("Deposit");
        deposit.setBounds(355,485,150,30);
        deposit.addActionListener(this);
        back.add(deposit);
        
         b= new JButton("Exit");
        b.setBounds(355, 520, 150, 30);
        b.addActionListener(this);
        back.add(b);

     setSize(900,900);
     setLocation(300, 0);
     setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == deposit){
         String number = amount.getText();
         Date date = new Date();
         if(number.equals("")){
            JOptionPane.showMessageDialog(null,"Please enter the amount you want to deposit ");
         }else{
            try{
            Conn conn = new Conn();
            String query  = "insert into bank values('"+pin+"','"+date+"','Deposit','"+number+"')";
            conn.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"rs"+number+" Deposit sucessfully");
            setVisible(false);
            new Transactions(pin).setVisible(true);
         }catch(Exception e){
            System.out.println();
         }
        }
        }else if(ae.getSource() == b){
         setVisible(false);
         new Transactions(pin).setVisible(true); 
        }
    }
    public static void main(String[] args) {
        new Deposit("");
    }
}


