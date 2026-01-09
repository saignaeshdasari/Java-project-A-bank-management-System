import javax.naming.spi.DirStateFactory.Result;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame {
  String pin;

  MiniStatement(String pin) {
    this.pin = pin;
    setLayout(null);

    JLabel text = new JLabel();
    add(text);

    JLabel bank = new JLabel("Canara Bank");
    bank.setBounds(150, 20, 150, 20);
    add(bank);

    JLabel card = new JLabel();
    card.setBounds(20, 80, 300, 20);
    add(card);

    JLabel mini = new JLabel("Mini Statement");
    mini.setBounds(150, 60, 100, 20);
    add(mini);

    try {
      Conn conn = new Conn();

      String query = "SELECT * FROM bank WHERE pin = ''" + pin + "''";
      PreparedStatement pst = conn.c.prepareStatement(query);
      ResultSet rs = pst.executeQuery();

      if (rs.next()) {
        String cn = rs.getString("cardnumber");
        card.setText("Card Number: " + cn.substring(0, 4) + "XXXXXXXX" + cn.substring(12));
      } else {
        card.setText("No card found for this PIN");
      }

    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }

    try{
      Conn conn = new Conn();
      int Bal =0;

      ResultSet rs = conn.s.executeQuery("SELECT * FROM bank WHERE pin = ''" + pin + "''");
      while(rs.next()){
        text.setText(text.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
        while(rs.next()){
                 if(rs.getString("type").equals("Deposit")){
                    Bal += Integer.parseInt(rs.getString("amount"));
                 }else{
                 Bal -= Integer.parseInt(rs.getString("amount"));
                 }
      }
    }
    text.setText("Your current account balance is Rs " + Bal);
    }catch(Exception e){
      e.printStackTrace();
    } 

    text.setBounds(20, 140, 400, 400);

    setSize(400, 600);
    setLocation(20, 20);
    getContentPane().setBackground(Color.WHITE);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  }

  public static void main(String[] args) {
    new MiniStatement("1234");
  }
}
