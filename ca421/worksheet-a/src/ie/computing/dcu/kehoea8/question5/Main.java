package ie.computing.dcu.kehoea8.question5;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: alan
 * Date: 20/11/2013
 * Time: 14:03
 */

public class Main extends JFrame {
    JButton button;
    int counter = 0;

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

        button = new JButton("Click Me");
        button.setBounds(50, 60, 80, 30);
        button.addActionListener(new CountingListener());
        button.addActionListener(new DefeatistListener());

        panel.add(button);

        setTitle("Worksheet A");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    class DefeatistListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            if(counter == 3) {
                button.removeActionListener(this);
            } else {
                System.out.println("I don't know!");
            }
        }
    }

    class CountingListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            counter++;
        }
    }
}


