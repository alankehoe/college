package ie.computing.dcu.kehoea8.question3;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: alan
 * Date: 20/11/2013
 * Time: 14:03
 */

public class Main extends JFrame {

    private Main() {
        initUI();
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Main ex = new Main();
                ex.setVisible(true);
            }
        });
    }

    private void initUI() {

        JPanel panel = new JPanel();
        getContentPane().add(panel);

        panel.setLayout(null);

        JButton button = new JButton("Should i do it");
        button.setBounds(50, 60, 80, 30);
        button.addActionListener(new AngelListener());
        button.addActionListener(new DevilListener());

        panel.add(button);

        setTitle("Worksheet A");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
