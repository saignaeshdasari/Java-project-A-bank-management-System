import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class login extends JFrame implements ActionListener {

  JButton loginButton, clearButton, signup;
  JTextField cardTextField;
  JPasswordField pinTextField;

  login() {
    setLayout(null);
    setTitle("Automated Teller Machine");

    ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("logo.jpg"));
    Image i2 = il.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel back = new JLabel(i3);
    back.setBounds(70, 10, 100, 100);
    add(back);

    JLabel text = new JLabel("Welcome to the ATM");
    text.setFont(new Font("Oswald", Font.BOLD, 38));
    text.setBounds(200, 40, 400, 40);
    add(text);

    
    JLabel Cardno = new JLabel("Card number:");
    Cardno.setFont(new Font("Raleway", Font.BOLD, 28));
    Cardno.setBounds(120, 150, 200, 40);
    add(Cardno);

    cardTextField = new JTextField();
    cardTextField.setBounds(320, 160, 250, 30);
    cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
    add(cardTextField);

    
    JLabel pin = new JLabel("Enter the pin:");
    pin.setFont(new Font("Raleway", Font.BOLD, 28));
    pin.setBounds(120, 220, 400, 40);
    add(pin);

    pinTextField = new JPasswordField();
    pinTextField.setBounds(320, 230, 250, 30);
    pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
    add(pinTextField);

  
    loginButton = new JButton("Sign In");
    loginButton.setBounds(300, 300, 100, 30);
    loginButton.setBackground(Color.BLACK);
    loginButton.setForeground(Color.WHITE);
    loginButton.addActionListener(this);
    add(loginButton);

    clearButton = new JButton("Clear");
    clearButton.setBounds(420, 300, 100, 30);
    clearButton.setBackground(Color.BLACK);
    clearButton.setForeground(Color.WHITE);
    clearButton.addActionListener(this);
    add(clearButton);

    signup = new JButton("Sign Up");
  signup.setBounds(300, 350, 230, 30);
     signup.setBackground(Color.BLACK);
     signup.setForeground(Color.WHITE);
  signup.addActionListener(this);
    add(signup);

    getContentPane().setBackground(Color.WHITE);
  setSize(800, 480);
    setVisible(true);
     setLocation(350, 200);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == clearButton) {
      cardTextField.setText("");
      pinTextField.setText("");
    } else if (e.getSource() == loginButton) {
      Conn conn = new Conn();
      String cardnumber = cardTextField.getText();
      String pin = pinTextField.getText();
      String query = "select * from login where cardnumber='" + cardnumber + "' and pin='" + pin + "'";
      try {
        ResultSet rs = conn.s.executeQuery(query);
        if (rs.next()) {
          setVisible(false);
          new Transactions(pin).setVisible(true);
        } else {
          JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
        }
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    } else if (e.getSource() == signup) {
     setVisible(false);
     new Signup1().setVisible(true);
    }
  }

  public static void main(String[] args) {
    new login();
  }
}
