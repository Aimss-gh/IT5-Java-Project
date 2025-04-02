import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mid extends JFrame{
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField9;
    private JTextField textField10;
    private JTextField textField11;
    private JButton proceedButton;
    private JPanel MainPanel;
    private JComboBox comboBox1;
    private JTextField textField4;
    private JTextField textField8;

    public mid() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(850,400);
        setLocationRelativeTo(null);
        setContentPane(MainPanel);
        proceedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new last().setVisible(true);
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new mid().setVisible(true);
            }
        });
    }
}
