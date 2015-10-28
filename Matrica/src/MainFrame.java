
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

import math.Matrice;
import math.Solver;


public class MainFrame extends JFrame {
	
	private ChooserLayout chooserLayout;
	private ConsoleLayout consoleLayout;
	private MatricaLayout matricaLayout;
	private JFileChooser fileChooser;
	private Layout2 layout2;
	private Layout3 layout3;
	
		
	public MainFrame(){
		super("Matrica");
		
		chooserLayout = new ChooserLayout();
		consoleLayout = new ConsoleLayout();
		matricaLayout = new MatricaLayout();
		layout2 = new Layout2();
		layout3 = new Layout3();
		
		layout2.setLayoutListener(new LayoutListener() {
			@Override
			public void layoutEventOccurred(LayoutEvent e) {
				int a1 = e.getA1();
				int a2 = e.getA2();
				int a3 = e.getA3();
				int b1 = e.getB1();
				int b2 = e.getB2();
				int b3 = e.getB3();
				
				Matrice matrice = new Matrice(a1, a2, a3, b1, b2, b3);
				Solver solver = new Solver();
				solver.generateNextMatrice(matrice, 1);
				consoleLayout.appendText(solver.getSolution());				
			}
		});
		
		layout3.setLayoutListener(new LayoutListener() {
			@Override
			public void layoutEventOccurred(LayoutEvent e) {
				int a1 = e.getA1();
				int a2 = e.getA2();
				int a3 = e.getA3();
				int a4 = e.getA4();
				int b1 = e.getB1();
				int b2 = e.getB2();
				int b3 = e.getB3();
				int b4 = e.getB4();
				int c1 = e.getC1();
				int c2 = e.getC2();
				int c3 = e.getC3();
				int c4 = e.getC4();
				
				Matrice matrice = new Matrice(a1, a2, a3,a4, b1, b2, b3,b4,c1,c2,c3,c4);
				Solver solver = new Solver();
				solver.generateNextMatrice(matrice, 1);
				consoleLayout.appendText(solver.getSolution());
			}
		});
		
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
					layout2.setVisible(true);
					layout3.setVisible(false);
					break;
				case 1:
					consoleLayout.appendText("Matrica 3x3\n");
					add(layout3,BorderLayout.CENTER);
					layout2.setVisible(false);
					layout3.setVisible(true);
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
		
		
		add(layout2,BorderLayout.WEST);
		
		//add(matricaLayout, BorderLayout.CENTER);
		add(consoleLayout, BorderLayout.CENTER);
		//add(chooserLayout,BorderLayout.WEST);
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
		
		JMenu help = new JMenu("Help");
		JMenuItem about = new JMenuItem("About");
		JMenuItem updateSoft = new JMenuItem("Update");
		help.add(updateSoft);
		help.addSeparator();
		help.add(about);

		JCheckBoxMenuItem showFormItem = new JCheckBoxMenuItem("Paneli i Zgjedhjes");
		showFormItem.setSelected(true);

		showMenu.add(showFormItem);
		windowMenu.add(showMenu);

		menuBar.add(fileMenu);
		menuBar.add(windowMenu);
		menuBar.add(help);
		
		updateSoft.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				consoleLayout.appendText("Update\n");
			}
		});
		
		about.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				consoleLayout.appendText("About\n");
			}
		});

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
