import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Layout3 extends JPanel{
	private JTextField a1 , a2 ,a3 ,a4 ,b1 ,b2 ,b3,b4, c1,c2,c3,c4;
	private static final int SIZE = 5;
	private JButton calcBtn , resetBtn;
	
	public Layout3(){
		a1= new JTextField(SIZE);
		a2= new JTextField(SIZE);
		a3= new JTextField(SIZE);
		a4= new JTextField(SIZE);
		a4.setBackground(Color.gray);
		b1= new JTextField(SIZE);
		b2= new JTextField(SIZE);
		b3= new JTextField(SIZE);
		b4= new JTextField(SIZE);
		b4.setBackground(Color.gray);
		c1= new JTextField(SIZE);
		c2= new JTextField(SIZE);
		c3= new JTextField(SIZE);
		c4= new JTextField(SIZE);
		c4.setBackground(Color.gray);
		
		calcBtn = new JButton("Llogarit");
		resetBtn = new JButton("Fshij");
		
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		// ////////// First row ///////////////////////////////////

				gc.gridy = 0;

				gc.weightx = 1;
				gc.weighty = 0.1;

				gc.gridx = 0;
				gc.fill = GridBagConstraints.NONE;
				gc.anchor = GridBagConstraints.LINE_START;
				gc.insets = new Insets(0, 0, 0, 5);
				add(new JLabel("X1"), gc);
				
				gc.gridx = 1;
				gc.fill = GridBagConstraints.NONE;
				gc.anchor = GridBagConstraints.LINE_START;
				gc.insets = new Insets(0, 0, 0, 5);
				add(new JLabel("X2"), gc);
				
				gc.gridx = 2;
				gc.fill = GridBagConstraints.NONE;
				gc.anchor = GridBagConstraints.LINE_START;
				gc.insets = new Insets(0, 0, 0, 5);
				add(new JLabel("X3"), gc);
				
				gc.gridx = 3;
				gc.fill = GridBagConstraints.NONE;
				gc.anchor = GridBagConstraints.LINE_START;
				gc.insets = new Insets(0, 0, 0, 5);
				add(new JLabel("A"), gc);

				// //////////Second row ///////////////////////////////////

				gc.gridy++;

				gc.weightx = 1;
				gc.weighty = 0.1;

				gc.gridx = 0;
				gc.insets = new Insets(0, 0, 0, 0);
				gc.anchor = GridBagConstraints.LINE_START;
				add(a1, gc);
				
				gc.gridx = 1;
				gc.insets = new Insets(0, 0, 0, 0);
				gc.anchor = GridBagConstraints.LINE_START;
				add(a2, gc);
				
				gc.gridx = 2;
				gc.insets = new Insets(0, 0, 0, 0);
				gc.anchor = GridBagConstraints.LINE_START;
				add(a3, gc);
				
				gc.gridx = 3;
				gc.insets = new Insets(0, 0, 0, 0);
				gc.anchor = GridBagConstraints.LINE_START;
				add(a4, gc);

				// //////////Next row ///////////////////////////////////

				gc.gridy++;

				gc.weightx = 0;
				gc.weighty = 0.1;

				gc.gridx = 0;
				gc.insets = new Insets(0, 0, 0, 0);
				gc.anchor = GridBagConstraints.LINE_START;
				add(b1, gc);
				
				gc.gridx = 1;
				gc.insets = new Insets(0, 0, 0, 0);
				gc.anchor = GridBagConstraints.LINE_START;
				add(b2, gc);
				
				gc.gridx = 2;
				gc.insets = new Insets(0, 0, 0, 0);
				gc.anchor = GridBagConstraints.LINE_START;
				add(b3, gc);
				
				gc.gridx = 3;
				gc.insets = new Insets(0, 0, 0, 0);
				gc.anchor = GridBagConstraints.LINE_START;
				add(b4, gc);
				
				// //////////Next row ///////////////////////////////////

				gc.gridy++;

				gc.weightx = 0;
				gc.weighty = 0.1;

				gc.gridx = 0;
				gc.insets = new Insets(0, 0, 0, 0);
				gc.anchor = GridBagConstraints.LINE_START;
				add(c1, gc);
				
				gc.gridx = 1;
				gc.insets = new Insets(0, 0, 0, 0);
				gc.anchor = GridBagConstraints.LINE_START;
				add(c2, gc);
				
				gc.gridx = 2;
				gc.insets = new Insets(0, 0, 0, 0);
				gc.anchor = GridBagConstraints.LINE_START;
				add(c3, gc);
				
				gc.gridx = 3;
				gc.insets = new Insets(0, 0, 0, 0);
				gc.anchor = GridBagConstraints.LINE_START;
				add(c4, gc);
				
				// //////////Next row ///////////////////////////////////
				
				gc.gridy ++;
				gc.weightx = 0;
				gc.weighty = 5;
				
				gc.gridx = 2;
				gc.insets = new Insets(0, 0, 0, 0);
				gc.anchor = GridBagConstraints.FIRST_LINE_START;
				add(resetBtn, gc);
				
				gc.gridx = 3;
				gc.insets = new Insets(0, 0, 0, 0);
				gc.anchor = GridBagConstraints.FIRST_LINE_START;
				add(calcBtn, gc);
				
	}
}
