import javax.swing.JPanel;
import javax.swing.JTextArea;


public class Console extends JPanel{
	
	private JTextArea textArea; 
	
	public Console (){
		
	}
	
	public void appendText(String text){
		textArea.append(text);
	}
}
