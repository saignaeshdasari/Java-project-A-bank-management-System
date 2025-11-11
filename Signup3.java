import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Signup3 extends JFrame implements ActionListener {
    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel;
    String formno;

    Signup3(String formno) {
        this.formno = formno;
        setLayout(null);
        setTitle("New Account Application Form - Page 3");

        JLabel il = new JLabel("Page 3: Account Details");
        il.setFont(new Font("Raleway", Font.BOLD, 22));
        il.setBounds(290, 80, 400, 30);
        add(il);

        JLabel accType = new JLabel("Account Type:");
        accType.setBounds(100, 160, 200, 30);
        accType.setFont(new Font("Raleway", Font.BOLD, 22));
        add(accType);

        r1 = new JRadioButton("Saving Account");
        r2 = new JRadioButton("Fixed Deposit Account");
        r3 = new JRadioButton("Current Account");
        r4 = new JRadioButton("Recurring Deposit Account");

        JRadioButton[] radios = { r1, r2, r3, r4 };
        int y = 160;
        for (JRadioButton r : radios) {
            r.setFont(new Font("Raleway", Font.BOLD, 16));
            r.setBackground(Color.WHITE);
            r.setBounds(300, y, 240, 20);
            add(r);
            y += 30;
        }

        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        bg.add(r3);
        bg.add(r4);

        JLabel card = new JLabel("Card Number:");
        card.setBounds(100, 300, 200, 30);
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        add(card);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-1234");
        number.setFont(new Font("Raleway", Font.BOLD, 22));
        number.setBounds(300, 300, 400, 30);
        add(number);

        JLabel pin = new JLabel("PIN:");
        pin.setBounds(100, 350, 200, 30);
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        add(pin);

        JLabel pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway", Font.BOLD, 22));
        pnumber.setBounds(300, 350, 400, 30);
        add(pnumber);

        JLabel services = new JLabel("Services Required:");
        services.setBounds(50, 400, 250, 30);
        services.setFont(new Font("Raleway", Font.BOLD, 22));
        add(services);

        c1 = new JCheckBox("ATM Card");
        c2 = new JCheckBox("Internet Banking");
        c3 = new JCheckBox("Mobile Banking");
        c4 = new JCheckBox("Email & SMS Alerts");
        c5 = new JCheckBox("Cheque Book");
        c6 = new JCheckBox("E-Statement");
        c7 = new JCheckBox("I hereby declare that the above details are correct.");

        JCheckBox[] checks = { c1, c2, c3, c4, c5, c6 };
        int cy = 400;
        for (int i = 0; i < checks.length; i++) {
            checks[i].setBackground(Color.WHITE);
            checks[i].setFont(new Font("Raleway", Font.BOLD, 16));
            checks[i].setBounds(i < 4 ? 300 : 550, cy, 200, 30);
            add(checks[i]);
            if (i == 3)
                cy = 400;
            else
                cy += 50;
        }

        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        c7.setBounds(100, 550, 600, 30);
        add(c7);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(200, 650, 100, 30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(550, 650, 100, 30);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String atype = null;
            if (r1.isSelected())
                atype = "Saving Account";
            else if (r2.isSelected())
                atype = "Fixed Deposit Account";
            else if (r3.isSelected())
                atype = "Current Account";
            else if (r4.isSelected())
                atype = "Recurring Deposit Account";

            if (atype == null) {
                JOptionPane.showMessageDialog(null, "Account Type is Required");
                return;
            }

            Random random = new Random();
            String cardnumber = "" + Math.abs(random.nextLong() % 90000000L + 5040936000000000L);
            String pinnumber = "" + Math.abs(random.nextLong() % 9000L + 1000L);

            String facilities = "";
            if (c1.isSelected())
                facilities += "ATM Card ";
            if (c2.isSelected())
                facilities += "Internet Banking ";
            if (c3.isSelected())
                facilities += "Mobile Banking ";
            if (c4.isSelected())
                facilities += "Email & SMS Alerts ";
            if (c5.isSelected())
                facilities += "Cheque Book ";
            if (c6.isSelected())
                facilities += "E-Statement ";

            try {
                Conn c = new Conn();
                String query1 = "insert into signup3 values('" + formno + "','" + atype + "','" + cardnumber + "','"
                        + pinnumber + "','" + facilities + "')";
                String query2 = "insert into login values('" + formno + "','" + cardnumber + "','" + pinnumber + "')";

                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "Card Number: " + cardnumber + "\nPIN: " + pinnumber);

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Database Error!");
            }
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);

        } else if (ae.getSource() == cancel) {
            setVisible(false);
            new login().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Signup3("12345");
    }
}
