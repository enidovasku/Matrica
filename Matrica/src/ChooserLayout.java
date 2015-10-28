import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ChooserLayout extends JPanel implements ActionListener{
	
	ChooseListener chooseListener;
	JButton matrica2;
	JButton matrica3;
	
	public ChooserLayout(){
		setBorder(BorderFactory.createEtchedBorder());
		Dimension dim = getPreferredSize();
		dim.width = 300;
		setSize(dim);
		setLayout(new FlowLayout(FlowLayout.LEFT));
		setVisible(true);
		
		matrica2 = new JButton("Matrica 2x2");
		matrica3 = new JButton("Matrica 3x3");
		
		matrica2.addActionListener(this);
		matrica3.addActionListener(this);
		
		add(new JLabel("Zgjidh:"));
		add(matrica2 );
		add(matrica3 );

		
		
	}
	
	public void setChooseListener(ChooseListener chooseListener){
		this.chooseListener = chooseListener;
	}

	@Override
	public void actionPerformed(ActionEvent e){
		JButton klikuar = (JButton)e.getSource();
		
		if(klikuar == matrica2) {
			if(chooseListener != null) {
				chooseListener.chooseOption(0);
			}
		}
		if(klikuar == matrica3) {
			if(chooseListener != null) {
				chooseListener.chooseOption(1);
			}
		}
		
	}		
	}

