import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
 
/**
 * A very simple java swing application. 
 * Contains button and checkbox. Responds
 * to manipulations with these controls by
 * changing text in the main text area.
 * 
 * @author audriusa
 */
public class WikiHow extends JFrame implements ActionListener
{
  /**
   * The button.
   */ 
  JButton myButton = new JButton("Button");
 
  /**
   * The the checkbox.
   */
  JCheckBox myCheckBox = new JCheckBox("Check");
 
  /**
   * The text area.
   */
  JTextArea myText = new JTextArea("My text");
 
  /**
   * The bottom panel which holds button.
   */ 
  JPanel bottomPanel = new JPanel();
 
  /**
   * The top level panel which holds all.
   */
  JPanel holdAll = new JPanel();
 
  /**
   * The constructor.
   */
  public WikiHow()
  {
    bottomPanel.setLayout(new FlowLayout());
    bottomPanel.add(myCheckBox);
    bottomPanel.add(myButton);
 
    holdAll.setLayout(new BorderLayout());
    holdAll.add(bottomPanel, BorderLayout.SOUTH);
    holdAll.add(myText, BorderLayout.CENTER);
 
    getContentPane().add(holdAll, BorderLayout.CENTER);
 
    myButton.addActionListener(this);
    myCheckBox.addActionListener(this);
 
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
  }
 
  /**
   * The program    * @param args the program start up parameters, not used.
   */
  public static void main(String[] args)
  {
    WikiHow myApplication = new WikiHow();
 
    // Specify where will it appear on the screen:
    myApplication.setLocation(10, 10);
    myApplication.setSize(300, 300);
 
    // Show it!
    myApplication.setVisible(true);
  }
 
  /**
   * Each non abstract class that implements the ActionListener
   * must have this method.
   * 
   * @param e the action event.
   */
  public void actionPerformed(ActionEvent e)
  {
    if (e.getSource() == myButton)
      myText.setText("A button click");
    else if (e.getSource() == myCheckBox)
      myText.setText("The checkbox state changed to " + 
                     myCheckBox.isSelected());
    else
      myText.setText("E ...?");
  }
}
