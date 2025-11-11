import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.*;

public class Fastcash extends JFrame implements ActionListener {
    JButton deposit, withdrawal, fastcash, miniStatement, pinchange, Balance, exit;
    String pin;

    Fastcash(String pin) {
        this.pin = pin;
        setLayout(null);
        setTitle("Machine");
        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2 = il.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel back = new JLabel(i3);
        back.setBounds(0, 0, 900, 900);
        add(back);

        JLabel text = new JLabel("Select withdrawal Amount");
        text.setBounds(210, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        back.add(text);

        deposit = new JButton("100");
        deposit.setBounds(170, 415, 150, 30);
        deposit.addActionListener(this);
        back.add(deposit);

        withdrawal = new JButton("500");
        withdrawal.setBounds(355, 415, 150, 30);
        withdrawal.addActionListener(this);
        back.add(withdrawal);

        fastcash = new JButton("1000");
        fastcash.setBounds(170, 450, 150, 30);
        fastcash.addActionListener(this);
        back.add(fastcash);

        miniStatement = new JButton("2000");
        miniStatement.setBounds(355, 450, 150, 30);
        miniStatement.addActionListener(this);
        back.add(miniStatement);

        pinchange = new JButton("5000");
        pinchange.setBounds(170, 485, 150, 30);
        pinchange.addActionListener(this);
        back.add(pinchange);

        Balance = new JButton("10000");
        Balance.setBounds(355, 485, 150, 30);
        Balance.addActionListener(this);
        back.add(Balance);

        exit = new JButton("BACK");
        exit.setBounds(355, 520, 150, 30);
        exit.addActionListener(this);
        back.add(exit);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit) {
            setVisible(false);
            new Transactions(pin).setVisible(true);
        }else{
            String amount  = ((JButton)ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try{
               ResultSet rs = c.s.executeQuery("select * from bank where pin ='"+pin+"'");
               int balance =0;
               while(rs.next()){
                 if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                 }else{
                 balance -= Integer.parseInt(rs.getString("amount"));
                 }
               }
               if (ae.getSource() != exit && balance<Integer.parseInt(amount)){
                JOptionPane.showMessageDialog(null,"Insufficient Balance");
                return;
               }
               Date date = new Date();
               String query = "insert into bank values('"+pin+"','"+date+"','withdrawal','"+amount+"')";
               c.s.executeQuery(query);
               JOptionPane.showMessageDialog(null,"rs"+amount+"Debited Sucessfully");

               setVisible(false);
               new Transactions(pin).setVisible(true);
            }catch(Exception e){
             System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        new Fastcash("");
    }
}
