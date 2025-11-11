import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;


public class BalanceEnqiury extends JFrame implements ActionListener {
    JButton back;
    String pin;
    BalanceEnqiury(String pin){
        this.pin=pin;
        setLayout(null);

        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2 = il.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel bg = new JLabel(i3);
        bg.setBounds(0, 0, 900, 900);
        add(bg);

        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        bg.add(back);


        setTitle("");
        setSize(900, 900);
        setUndecorated(true);
        setVisible(true);

          Conn c = new Conn();
          int balance = 0;
            try{
               ResultSet rs = c.s.executeQuery("select * from bank where pin ='"+pin+"'");
               
               while(rs.next()){
                 if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                 }else{
                 balance -= Integer.parseInt(rs.getString("amount"));
                 }
                } 
               }catch(Exception e){
                 System.out.println(e);
               }

               JLabel text = new JLabel("Your current Account balance is Rs "+balance);
               text.setForeground(Color.WHITE);
               text.setBounds(170,300,400,30);
               bg.add(text);

    }

    public void actionPerformed(ActionEvent e){
      setVisible(false);
      new Transactions(pin).setVisible(true);
    }
    public static void main(String[] args) {
        new BalanceEnqiury("");

    }
}
