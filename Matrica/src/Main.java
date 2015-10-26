import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;


public class Main extends JFrame {
	
	LeftPanel leftPanel;
	Console console;
	Toolbar toolbar;
	
		
	public Main(){
		super("Matrica");
		
		leftPanel = new LeftPanel();
		console = new Console();
		toolbar = new Toolbar();
		
		setLayout(new BorderLayout());
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setMinimumSize(new Dimension(600,600));
		//setSize(600,600);
		
		add(toolbar, BorderLayout.NORTH);
		add(console, BorderLayout.SOUTH);
		add(leftPanel,BorderLayout.WEST);
	}
}
