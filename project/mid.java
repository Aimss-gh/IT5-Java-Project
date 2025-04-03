import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mid extends JFrame{
    private JTextField stf1;
    private JTextField hrstf1;
    private JTextField Rphtf1;
    private JTextField stf2;
    private JTextField hrstf2;
    private JTextField Rphtf2;
    private JTextField stf3;
    private JTextField hrstf3;
    private JTextField Rphtf3;
    private JButton proceedButton;
    private JPanel MainPanel;
    private JComboBox comboBox1;
    private JTextField accname;
    private JTextField accnum;
    private JLabel total;

    public mid() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(850,400);
        setLocationRelativeTo(null);
        setContentPane(MainPanel);
        proceedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lane();
                String name = accname.getText();
                String num = accnum.getText();
                String s1 = stf1.getText();
                String hh = hrstf1.getText();
                String rr = Rphtf1.getText();
                String box = (String) comboBox1.getSelectedItem();
                if (s1.isEmpty() || hh.isEmpty() || rr.isEmpty()){
                    JOptionPane.showMessageDialog(null, "This field is required.");
                }else{
                    JOptionPane.showMessageDialog(mid.this, "Account Name: " + name + "\n" + "Account Number: " + num + "\n" +
                          "Payment Method: " + box + "\n" + total.getText());
                }
            }
        });
    }
    public void lane(){
        try{
            int h1 = Integer.parseInt(hrstf1.getText());
            int r1 = Integer.parseInt(Rphtf1.getText());
            int h2 = Integer.parseInt(hrstf2.getText());
            int r2 = Integer.parseInt(Rphtf2.getText());
            int h3 = Integer.parseInt(hrstf3.getText());
            int r3 = Integer.parseInt(Rphtf3.getText());

            int t1 = h1 * r1;
            int t2 = h2 * r2;
            int t3 = h3 * r3;
            int subtotal = t1 + t2 + t3;

            total.setText(String.valueOf("Total Amount: " + subtotal));
        }catch (NumberFormatException e){
            total.setText("Valid Amount");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {new mid().setVisible(true);
            }
        });
    }
}
