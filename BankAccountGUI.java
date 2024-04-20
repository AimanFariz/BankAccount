import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BankAccountGUI extends JFrame implements ActionListener {
    private BankAccount janeAcct;
    private BankAccount momAcct;
    private BankAccount savingsAcct;

    private JTextField depositField;
    private JTextField withdrawField;
    private JTextArea displayArea;

    public BankAccountGUI() {
        super("Bank Account Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        janeAcct = new BankAccount(10010_100001L, "Jane Smith Jr.", "123 Main St.", 555_13_9876, 500.00);
        momAcct = new BankAccount(10010_100002L, "Jane Smith Sr.", "123 Main St.", 555_79_1234, 10_000.00);
        savingsAcct = new BankAccount(momAcct);
        savingsAcct.setAccount_no(10010_100003L);
        savingsAcct.setBalance(1000.00);

        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.add(new JLabel("Deposit:"));
        depositField = new JTextField(10);
        inputPanel.add(depositField);
        inputPanel.add(new JLabel("Withdraw:"));
        withdrawField = new JTextField(10);
        inputPanel.add(withdrawField);
        JButton depositButton = new JButton("Deposit");
        depositButton.addActionListener(this);
        inputPanel.add(depositButton);
        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.addActionListener(this);
        inputPanel.add(withdrawButton);

        displayArea = new JTextArea(10, 30);
        displayArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(displayArea);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(inputPanel, BorderLayout.NORTH);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        displayAccountsInfo();

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Deposit")) {
            double depositAmount = Double.parseDouble(depositField.getText());
            savingsAcct.deposit(depositAmount);
            displayAccountsInfo();
        } else if (e.getActionCommand().equals("Withdraw")) {
            double withdrawAmount = Double.parseDouble(withdrawField.getText());
            if (!janeAcct.withdraw(withdrawAmount)) {
                JOptionPane.showMessageDialog(this, "Withdrawal rejected!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                displayAccountsInfo();
            }
        }
    }

    private void displayAccountsInfo() {
        displayArea.setText("");
        displayArea.append("Jane's Account:\n" + janeAcct.toString() + "\n");
        displayArea.append("Mom's Account:\n" + momAcct.toString() + "\n");
        displayArea.append("Savings Account:\n" + savingsAcct.toString() + "\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BankAccountGUI());
    }
}
