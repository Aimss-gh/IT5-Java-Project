import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pro extends JFrame {
    private JTextField nam1;
    private JTextField mail1;
    private JTextField num1;
    private JTextField loc1;
    private JButton proceedButton;
    private JPanel MainPanel;

    public pro() {
        setSize(400, 300);
        setLocationRelativeTo(null);
        setContentPane(MainPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        proceedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ntf = nam1.getText();
                String mtf = mail1.getText();
                String numtf = num1.getText();
                String ltf = loc1.getText();
                if(ntf.isEmpty() || mtf.isEmpty() || numtf.isEmpty() || ltf.isEmpty()){
                    JOptionPane.showMessageDialog(null, "This field is required.");
                }else{
                    JOptionPane.showMessageDialog(pro.this, "Login successful!");

                    new mid().setVisible(true);
                    dispose();
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new pro().setVisible(true);
            }
        });
    }
}
