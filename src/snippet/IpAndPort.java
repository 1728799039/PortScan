package snippet;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JProgressBar;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JScrollPane;

public class IpAndPort {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IpAndPort window = new IpAndPort();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public IpAndPort() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel_Port = new JPanel();
		tabbedPane.addTab("\u7AEF\u53E3\u626B\u63CF", null, panel_Port, null);
		panel_Port.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_Port.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_4.setBounds(10, 10, 664, 164);
		panel_3.add(panel_4);
		
		JLabel label_1 = new JLabel("ip\u5730\u5740\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 24));
		label_1.setBounds(24, 25, 96, 45);
		panel_4.add(label_1);
		
		JLabel label_2 = new JLabel("\u7AEF\u53E3\u53F7\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 20));
		label_2.setBounds(24, 90, 83, 34);
		panel_4.add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setText("www.baidu.com");
		textField_1.setColumns(10);
		textField_1.setBounds(117, 29, 226, 45);
		panel_4.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setText("20");
		textField_2.setColumns(10);
		textField_2.setBounds(117, 93, 45, 34);
		panel_4.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setText("80");
		textField_3.setColumns(10);
		textField_3.setBounds(199, 93, 45, 34);
		panel_4.add(textField_3);
		
		JLabel label_3 = new JLabel("=>");
		label_3.setFont(new Font("宋体", Font.PLAIN, 24));
		label_3.setBounds(172, 93, 32, 34);
		panel_4.add(label_3);
		
		JButton button = new JButton("\u626B\u63CF");
		button.setFont(new Font("宋体", Font.PLAIN, 22));
		button.setBounds(458, 27, 83, 42);
		panel_4.add(button);
		
		JButton button_1 = new JButton("\u9ED8\u8BA4\u7AEF\u53E3\u626B\u63CF");
		button_1.setFont(new Font("宋体", Font.PLAIN, 22));
		button_1.setBounds(458, 91, 178, 42);
		panel_4.add(button_1);
		
		JButton button_2 = new JButton("\u505C\u6B62");
		button_2.setFont(new Font("宋体", Font.PLAIN, 22));
		button_2.setBounds(553, 27, 83, 42);
		panel_4.add(button_2);
		
		JLabel label_4 = new JLabel("\u7EBF\u7A0B\u6570\uFF1A");
		label_4.setFont(new Font("宋体", Font.PLAIN, 20));
		label_4.setBounds(268, 93, 83, 34);
		panel_4.add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setText("30");
		textField_4.setColumns(10);
		textField_4.setBounds(339, 93, 45, 34);
		panel_4.add(textField_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u626B\u63CF\u7ED3\u679C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBounds(10, 184, 664, 212);
		panel_3.add(panel_5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 22, 306, 185);
		panel_5.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(348, 22, 306, 185);
		panel_5.add(scrollPane_1);
		
		JPanel panel_1 = new JPanel();
		panel_Port.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		
		JLabel label = new JLabel("\u8FD0\u884C\u72B6\u6001\uFF1A");
		panel_2.add(label);
		
		textField = new JTextField();
		textField.setText("\u505C\u6B62");
		textField.setEditable(false);
		textField.setColumns(10);
		panel_2.add(textField);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setValue(0);
		progressBar.setStringPainted(true);
		progressBar.setPreferredSize(new Dimension(300, 20));
		progressBar.setOrientation(SwingConstants.HORIZONTAL);
		progressBar.setMinimum(0);
		progressBar.setMaximum(60);
		progressBar.setBorderPainted(true);
		progressBar.setBackground(Color.PINK);
		panel_1.add(progressBar);
		
		JPanel panel_Ip = new JPanel();
		tabbedPane.addTab("\u7F51\u6BB5\u626B\u63CF", null, panel_Ip, null);
		panel_Ip.setLayout(new BorderLayout(0, 0));
	}

}
