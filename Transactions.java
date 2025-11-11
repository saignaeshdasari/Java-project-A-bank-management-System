import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener{
    JButton deposit , withdrawal,fastcash,miniStatement,pinchange,Balance,exit;
    String pin;
    Transactions(String pin){
      this.pin = pin;
        setLayout(null);
        setTitle("Machine");
        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2 = il.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel back = new JLabel(i3);
        back.setBounds(0,0,900,900);
        add(back);

        JLabel text = new JLabel("please select your Transation");
        text.setBounds(210,300 ,700 ,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        back.add(text);

        deposit = new JButton("deposit");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        back.add(deposit);

       withdrawal = new JButton("Cash Withdrawal");
        withdrawal.setBounds(355, 415, 150, 30);
        withdrawal.addActionListener(this);
        back.add(withdrawal);

         fastcash = new JButton("fast cash");
        fastcash.setBounds(170, 450, 150, 30);
        fastcash.addActionListener(this);
        back.add(fastcash);

        miniStatement = new JButton("Mini statement");
        miniStatement.setBounds(355,450,150,30);
        miniStatement.addActionListener(this);
        back.add(miniStatement);

     pinchange = new JButton("Change PIN");
        pinchange.setBounds(170, 485, 150, 30);
        pinchange.addActionListener(this);
        back.add(pinchange);

        Balance = new JButton("Balance enquiry");
        Balance.setBounds(355, 485, 150, 30);
        Balance.addActionListener(this);
        back.add(Balance);
        
         exit = new JButton("Exit");
        exit.setBounds(355, 520, 150, 30);
        exit.addActionListener(this);
        back.add(exit);

        setSize(900,900);
      setLocation(300,0);
      setUndecorated(true);
      setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
      if(ae.getSource()== exit){
          System.exit(0);
      }else if(ae.getSource() == deposit){
        setVisible(false);
        new Deposit(pin).setVisible(true);;
      }else if(ae.getSource() == withdrawal) {
        setVisible(false);
        new withdrawal(pin).setVisible(true);;
      }else if(ae.getSource() == fastcash){
        new Fastcash(pin).setVisible(true);
      }else if(ae.getSource() == pinchange){
        setVisible(false);
        new pinchange(pin).setVisible(true);
    }else if(ae.getSource() == Balance){
      setVisible(false);
      new BalanceEnqiury(pin).setVisible(true);
    }else{
      new MiniStatement(pin).setVisible(true);
    }
  }
    public static void main(String[] args) {
        new Transactions("");
    }
}
