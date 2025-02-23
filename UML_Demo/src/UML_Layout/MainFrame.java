package UML_Layout;

import java.awt.BorderLayout;
import javax.swing.*;    
import java.awt.event.*;   

public class MainFrame extends JFrame{
	private int width = 1200;
	private int height = 800;
	private JSplitPane splitPane;
	private ButtonsPanel buttonsPanel;
	private DrawPanel drawPanel;
	private MenuBar menubar;
	
	public MainFrame() {
		// create and set up the window
		super();
		this.setSize(width, height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new BorderLayout());
		
		// set content panel
		buttonsPanel = new ButtonsPanel();
		drawPanel = new DrawPanel();
		menubar = new MenuBar(drawPanel);
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, buttonsPanel, drawPanel);
		splitPane.setResizeWeight(0.01f);
		
		this.setJMenuBar(menubar);
		this.getContentPane().add(splitPane);

		// set frame visible
		this.setVisible(true);
	}
	
	public ButtonsPanel getButtonsPanel() {
		return buttonsPanel;
	}
	
	public DrawPanel getDrawPanel() {
		return drawPanel;
	}
}
