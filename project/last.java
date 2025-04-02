import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class last extends JFrame{
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JTextField textField10;
    private JTextField textField11;
    private JTextField textField12;
    private JTextField textField13;
    private JTextField textField14;
    private JTextField textField15;
    private JButton homeButton;
    private JButton doneButton;
    private JButton printButton;
    private JPanel MainPanel;
    private JLabel name2;

    public last() {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(900,500);
        setContentPane(MainPanel);
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new pro().setVisible(true);
                
                dispose();
            }
            
        });
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
