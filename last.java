import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class last extends JFrame {
    private JTextArea textArea1;
    private JPanel main;
    private JButton generateButton;
    private JPanel buttonPanel;

    public last() {
        //If it runs, Don't touch huhu
        //!!SAMPLE!!
        this("?", "?", "?",
                "?", "?", "?",
                "?", "?", "?",
                "?", "?", "?",
                "Total Amount: ?");
    }

    public last(String name, String accNum, String paymentMethod,
                String service1, String hours1, String rate1,
                String service2, String hours2, String rate2,
                String service3, String hours3, String rate3,
                String total) {
        setTitle("Payment Receipt");
        setSize(500, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        main = new JPanel(new BorderLayout());
        textArea1 = new JTextArea();
        generateButton = new JButton("Print Receipt");
        buttonPanel = new JPanel();

        textArea1.setFont(new Font("Monospaced", Font.PLAIN, 14));
        textArea1.setEditable(false);

        String receiptContent = generateReceipt(name, accNum, paymentMethod,
                service1, hours1, rate1,
                service2, hours2, rate2,
                service3, hours3, rate3,
                total);
        textArea1.setText(receiptContent);

        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                   
                    boolean complete = textArea1.print();
                    if (complete) {
                        JOptionPane.showMessageDialog(last.this, "Receipt printed successfully!");
                    } else {
                        JOptionPane.showMessageDialog(last.this, "Printing was cancelled");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(last.this, "Error printing receipt: " + ex.getMessage(),
                            "Print Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(textArea1);
        buttonPanel.add(generateButton);

        main.add(scrollPane, BorderLayout.CENTER);
        main.add(buttonPanel, BorderLayout.SOUTH);

        setContentPane(main);
    }

    private String generateReceipt(String name, String accNum, String paymentMethod,
                                   String service1, String hours1, String rate1,
                                   String service2, String hours2, String rate2,
                                   String service3, String hours3, String rate3,
                                   String total) {
        StringBuilder receipt = new StringBuilder();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateTime = dateFormat.format(new Date());

        receipt.append(String.format("%40s\n\n", "OFFICIAL RECEIPT"));
        receipt.append(String.format("%-20s: %s\n", "Date", dateTime));
        receipt.append(String.format("%-20s: %s\n", "Customer Name", name));
        receipt.append(String.format("%-20s: %s\n", "Account Number", accNum));
        receipt.append(String.format("%-20s: %s\n", "Payment Method", paymentMethod));
        receipt.append("\n");
        receipt.append(String.format("%50s\n", "").replace(' ', '-'));
        receipt.append(String.format("%-25s %8s %10s %10s\n", "SERVICE", "HOURS", "RATE", "AMOUNT"));
        receipt.append(String.format("%50s\n", "").replace(' ', '-'));


        addServiceRow(receipt, service1, hours1, rate1);
        addServiceRow(receipt, service2, hours2, rate2);
        addServiceRow(receipt, service3, hours3, rate3);


        receipt.append(String.format("%50s\n", "").replace(' ', '-'));
        receipt.append(String.format("%45s\n", total));
        receipt.append(String.format("%50s\n", "").replace(' ', '='));
        receipt.append(String.format("%40s\n", "Thank you for your service!"));

        return receipt.toString();
    }

    private void addServiceRow(StringBuilder receipt, String service, String hours, String rate) {
        if (service != null && !service.isEmpty() &&
                hours != null && !hours.isEmpty() &&
                rate != null && !rate.isEmpty()) {
            try {
                int h = Integer.parseInt(hours);
                int r = Integer.parseInt(rate);
                int amount = h * r;
                receipt.append(String.format("%-25s %8s %10s %10s\n",
                        service, hours, "₱" + rate, "₱" + amount));
            } catch (NumberFormatException e) {
                receipt.append(String.format("%-25s %8s %10s %10s\n",
                        service, "INVALID", "INPUT", ""));
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new last().setVisible(true);
            }
        });
    }
}