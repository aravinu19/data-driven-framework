package guiUtils;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;


public class TestLogWindow extends JFrame{
	
	/**
	 * By Aravind RaJ
	 */
	private static final long serialVersionUID = 1L;
	public static JFrame mainFrame ;
	public static JLabel headerLabel;
	public static JLabel statusLabel;
	public static JPanel controlPanel;
	public static JTextArea logArea;
	public static JScrollPane scrollPane;
	public static JButton closeBTN;
	
	private static boolean is_initialized = false;
	
	
	public TestLogWindow() {
		//prepareGUI();
	}
	
	public static void prepareGUI() {
		
		if(is_initialized) return;
		
		is_initialized = true;
		
		mainFrame = new JFrame("Enquode Test Framework");
		mainFrame.setSize(600, 500);
		
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 20, 5);
		
		mainFrame.setLayout(layout);
		
		headerLabel = new JLabel("", JLabel.CENTER);
		statusLabel = new JLabel("", JLabel.CENTER);
		closeBTN = new JButton("CLOSE");
		closeBTN.setPreferredSize(new Dimension(100, 50));
		
		closeBTN.setActionCommand("CLOSE");
		closeBTN.addActionListener(new TestLogWindow().new ButtonListener());
		statusLabel.setSize(100, 100);
		
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
		
		controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout());
		controlPanel.setBorder(new TitledBorder(new EtchedBorder(), "EnQuode Test Log"));
		
		logArea = new JTextArea(20, 50);
		logArea.setEditable(false);
		logArea.setText("\tLogs Will Appear as soon as test is started !");
		scrollPane = new JScrollPane(logArea);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		controlPanel.add(scrollPane);
		
		mainFrame.add(headerLabel);
		mainFrame.add(statusLabel);
		mainFrame.add(controlPanel);
		mainFrame.add(closeBTN);
		mainFrame.setVisible(true);
		
	}
	
	public class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			
			TestLogWindow.closeWindow();
			
		}
		
	}
	
	public static void showCurretProgress(String testName, String testcase) {
		
		if(!is_initialized) prepareGUI();
		
		headerLabel.setText("Current Test Name : " + testName);
		statusLabel.setText("Test : " + testcase);
		mainFrame.setVisible(true);
		
	}
	
	public static void sendLog(String logMsg) {
		
		logArea.append("\n" + logMsg);
		
	}
	
	public static void closeWindow() {
		
		mainFrame.dispose();
		
	}
	
}
