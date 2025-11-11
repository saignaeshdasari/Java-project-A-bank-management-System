import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class pinchange extends JFrame implements ActionListener {

    JPasswordField newPin, rePin;
    JButton change, back;
    String pin;
    public pinchange(String pin) {
        this.pin = pin;
        setLayout(null);

        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2 = il.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel bg = new JLabel(i3);
        bg.setBounds(0, 0, 900, 900);
        add(bg);

        JLabel heading = new JLabel("CHANGE YOUR PIN");
        heading.setBounds(250, 300, 400, 20);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("System", Font.BOLD, 16));
        bg.add(heading);

        JLabel l1 = new JLabel("NEW PIN:");
        l1.setBounds(140, 350, 200, 20);
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        bg.add(l1);

        newPin = new JPasswordField();
        newPin.setBounds(250, 350, 250, 30);
        newPin.setFont(new Font("Raleway", Font.BOLD, 22));
        bg.add(newPin);

        JLabel l2 = new JLabel("RE-ENTER NEW PIN:");
        l2.setBounds(140, 450, 250, 20);
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("System", Font.BOLD, 16));
        bg.add(l2);

        rePin = new JPasswordField();
        rePin.setBounds(250, 475, 250, 30);
        rePin.setFont(new Font("Raleway", Font.BOLD, 22));
        bg.add(rePin);

        change = new JButton("CHANGE");
        change.setBounds(355, 550, 150, 30);
        change.addActionListener(this);
        bg.add(change);

        back = new JButton("BACK");
        back.setBounds(355, 585, 150, 30);
        back.addActionListener(this);
        bg.add(back);

        setTitle("PIN Change");
        setSize(900, 900);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == change) {
        try {
            String npin = newPin.getText();
            String rpin = rePin.getText();

            if (!npin.equals(rpin)) {
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }
            if(newPin.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter a new PIN");
                return;
            }
            Conn conn = new Conn();
            String query = "UPDATE bank SET pin = '" + rpin + "' WHERE pin = '" + pin + "'";
            String query1 = "UPDATE login SET pin = '" + rpin + "' WHERE pin = '" + pin + "'";
            String query2 = "UPDATE signupthree SET pin = '" + rpin + "' WHERE pin = '" + pin + "'";
            conn.s.executeUpdate(query);
            conn.s.executeUpdate(query1);
            conn.s.executeUpdate(query2);
            JOptionPane.showMessageDialog(null, "PIN changed successfully");
            setVisible(false);
            new Transactions(rpin).setVisible(true);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "An error occurred while processing your request.");
        }
    }else if(ae.getSource() == back) {
            setVisible(false);
            
            new Transactions(pin).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new pinchange("").setVisible(true);
    }
}
