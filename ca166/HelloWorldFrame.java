import javax.swing.JFrame;
import javax.swing.JLabel;

//import statements
//Check if window closes automatically. Otherwise add suitable code
public class HelloWorldFrame extends JFrame {

	public static void main(String args[]) {
		new HelloWorldFrame();
	}
	HelloWorldFrame() {
		JLabel jlbHelloWorld = new JLabel("Hello World");
		add(jlbHelloWorld);
		this.setSize(1000, 100);
		// pack();
		setVisible(true);
	}
}
