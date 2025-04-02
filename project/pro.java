import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pro extends JFrame {
    private JTextField nam1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
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
                new mid().setVisible(true);
               
                dispose();
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
