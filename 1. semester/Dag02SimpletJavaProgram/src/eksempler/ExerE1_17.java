package eksempler;
import javax.swing.JOptionPane;

public class ExerE1_17 {
	
	public static void main(String[] args) {
		String name = JOptionPane.showInputDialog("What is your name?");
		JOptionPane.showInputDialog("My name is Hal, What would you like me to do?");
		JOptionPane.showMessageDialog(null, "I'm sorry, " + name + " I'm afriad can't do that!");
		

	}

}
