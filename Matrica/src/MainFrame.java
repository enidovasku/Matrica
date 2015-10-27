
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;


public class MainFrame extends JFrame {
	
	private ChooserLayout chooserLayout;
	private ConsoleLayout consoleLayout;
	private MatricaLayout matricaLayout;
	private JFileChooser fileChooser;
	
		
	public MainFrame(){
		super("Matrica");
		
		chooserLayout = new ChooserLayout();
		consoleLayout = new ConsoleLayout();
		matricaLayout = new MatricaLayout();
		
		fileChooser = new JFileChooser();
		
		fileChooser.addChoosableFileFilter(new Filefilter());
		
		setJMenuBar(createMenuBar());
		
		chooserLayout.setChooseListener(new ChooseListener(){
			@Override
			public void chooseOption(int choose){
				switch (choose)
				{
				case 0:
					consoleLayout.appendText("Matrica 2x2\n");
					break;
				case 1:
					consoleLayout.appendText("Matrica 3x3\n");
					break ;
				default:
					break;
				}
			}
		});
		
		setLayout(new BorderLayout());
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setMinimumSize(new Dimension(600,600));
		//setSize(600,600);
		
		add(consoleLayout, BorderLayout.CENTER);
		add(chooserLayout,BorderLayout.WEST);
	}


	private JMenuBar createMenuBar(){
		JMenuBar menuBar = new JMenuBar();

		JMenu fileMenu = new JMenu("File");
		JMenuItem exportDataItem = new JMenuItem("Export Data...");
		JMenuItem importDataItem = new JMenuItem("Import Data...");
		JMenuItem exitItem = new JMenuItem("Largohu");

		fileMenu.add(exportDataItem);
		fileMenu.add(importDataItem);
		fileMenu.addSeparator();
		fileMenu.add(exitItem);

		JMenu windowMenu = new JMenu("Dritare");
		JMenu showMenu = new JMenu("Shfaq");

		JCheckBoxMenuItem showFormItem = new JCheckBoxMenuItem("Paneli i Zgjedhjes");
		showFormItem.setSelected(true);

		showMenu.add(showFormItem);
		windowMenu.add(showMenu);

		menuBar.add(fileMenu);
		menuBar.add(windowMenu);

		showFormItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				JCheckBoxMenuItem menuItem = (JCheckBoxMenuItem) ev.getSource();

				chooserLayout.setVisible(menuItem.isSelected());
			}
		});

		fileMenu.setMnemonic(KeyEvent.VK_F);
		exitItem.setMnemonic(KeyEvent.VK_X);

		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
				ActionEvent.CTRL_MASK));
		
		importDataItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fileChooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
					System.out.println(fileChooser.getSelectedFile());
				}
			}
		});
		
		exportDataItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fileChooser.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
					System.out.println(fileChooser.getSelectedFile());
				}
			}
		});

		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int action = JOptionPane.showConfirmDialog(MainFrame.this,
						"Deshiron te largohesh nga aplikacioni ?",
						"Konfirmo Largimin", JOptionPane.OK_CANCEL_OPTION);

				if (action == JOptionPane.OK_OPTION) {
					System.exit(0);
				}
			}
		});

		return menuBar;
	}
}
