package snippet;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JProgressBar;
import javax.swing.JPanel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import org.omg.CORBA.PUBLIC_MEMBER;

import net.TcpThread;

import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.Socket;
import javax.swing.BoxLayout;
import javax.swing.JSeparator;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;

public class DuolaScan {

	public static JTextArea textArea_open = new JTextArea();
	public static JTextArea textArea_close = new JTextArea();
	private JFrame frame;
	private JTextField target;
	private JTextField from;
	private JTextField to;
	private JTextField Threadnum;
	static MyBucket bucket = new MyBucket(0, 0);
	public static JTextField textField;
	public static JButton btnNewButton = new JButton("\u626B\u63CF");
	public static JButton button = new JButton("\u9ED8\u8BA4\u7AEF\u53E3\u626B\u63CF");
	public static JButton button_2 = new JButton("\u505C\u6B62");
	public static JProgressBar progressBar = new JProgressBar();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DuolaScan window = new DuolaScan();
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
	public DuolaScan() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u5C0F\u602A\u7AEF\u53E3\u626B\u63CF\u5668");
		frame.setBounds(100, 100, 700, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		frame.getContentPane().add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4);
		
		JLabel lblNewLabel_1 = new JLabel("\u8FD0\u884C\u72B6\u6001\uFF1A");
		panel_4.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setText("\u505C\u6B62");
		textField.setEditable(false);
		panel_4.add(textField);
		textField.setColumns(10);
		
		   progressBar.setOrientation(JProgressBar.HORIZONTAL);
	       progressBar.setMinimum(0);
	       progressBar.setMaximum(60);
	       progressBar.setValue(0);
	       progressBar.setStringPainted(true);
	       progressBar.setPreferredSize(new Dimension(300, 20));
	       progressBar.setBorderPainted(true);
	       progressBar.setBackground(Color.pink);
		panel_3.add(progressBar);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBounds(10, 10, 664, 164);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ip\u5730\u5740\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel.setBounds(24, 25, 96, 45);
		panel_2.add(lblNewLabel);
		
		JLabel label = new JLabel("\u7AEF\u53E3\u53F7\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 20));
		label.setBounds(24, 90, 83, 34);
		panel_2.add(label);
		
		target = new JTextField();
		target.setText("www.baidu.com");
		target.setBounds(117, 29, 226, 45);
		panel_2.add(target);
		target.setColumns(10);
		
		from = new JTextField();
		from.setText("20");
		from.setColumns(10);
		from.setBounds(117, 93, 45, 34);
		panel_2.add(from);
		
		to = new JTextField();
		to.setText("80");
		to.setColumns(10);
		to.setBounds(199, 93, 45, 34);
		panel_2.add(to);
		
		JLabel label_1 = new JLabel("=>");
		label_1.setFont(new Font("宋体", Font.PLAIN, 24));
		label_1.setBounds(172, 93, 32, 34);
		panel_2.add(label_1);
		
		
		
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 22));
		btnNewButton.setBounds(458, 27, 83, 42);
		panel_2.add(btnNewButton);
		
		button.setFont(new Font("宋体", Font.PLAIN, 22));
		button.setBounds(458, 91, 178, 42);
		panel_2.add(button);
		
		
		button_2.setFont(new Font("宋体", Font.PLAIN, 22));
		button_2.setBounds(553, 27, 83, 42);
		panel_2.add(button_2);
		
		JLabel label_2 = new JLabel("\u7EBF\u7A0B\u6570\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 20));
		label_2.setBounds(268, 93, 83, 34);
		panel_2.add(label_2);
		
		Threadnum = new JTextField();
		Threadnum.setText("30");
		Threadnum.setColumns(10);
		Threadnum.setBounds(339, 93, 45, 34);
		panel_2.add(Threadnum);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u626B\u63CF\u7ED3\u679C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 184, 664, 212);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 22, 306, 185);
		panel_1.add(scrollPane);
		
		scrollPane.setViewportView(textArea_open);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(348, 22, 306, 185);
		panel_1.add(scrollPane_1);
		
		
		scrollPane_1.setViewportView(textArea_close);
		
		/*
		 * 监听
		 */
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("clicked stop");
				bucket.stop();
				btnNewButton.setEnabled(true);
				button.setEnabled(true);
				button_2.setEnabled(false);
			}				
			});
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				System.out.println("clicked moren");
				btnNewButton.setEnabled(false);
				button.setEnabled(false);
				button_2.setEnabled(true);
				textField.setText("正在扫描···");
				textArea_close.setText("");
				textArea_open.setText("");
				String host = target.getText();
				int threadnum = 10;
				try {
					threadnum = Integer.parseInt(DuolaScan.this.Threadnum.getText());
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null,"对不起，线程数错误！","提示",JOptionPane. INFORMATION_MESSAGE);
					System.out.println(e2);
				}
				
				if(host.length() < 3){
					JOptionPane.showMessageDialog(null,"对不起，参数错误！","提示",JOptionPane. INFORMATION_MESSAGE);
					return;
				}
				if(threadnum < 1 || threadnum > 100){
					JOptionPane.showMessageDialog(null,"对不起，确定线程数1~100！","提示",JOptionPane. INFORMATION_MESSAGE);
					return;
				}
				progressBar.setMinimum(0);
			    progressBar.setMaximum(12);
				bucket.update(0, 0);
				for( int i = 0; i < threadnum; i++ ){
					new MyScan2(host, bucket).start();
	            }
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("clicked start");
				btnNewButton.setEnabled(false);
				button.setEnabled(false);
				button_2.setEnabled(true);
				textField.setText("正在扫描···");
				textArea_close.setText("");
				textArea_open.setText("");
				String host = target.getText();
				int begin=80;
				int over=80;
				int threadnum = 10;
				try {
					begin = Integer.parseInt(from.getText());
					over = Integer.parseInt(to.getText());
					threadnum = Integer.parseInt(DuolaScan.this.Threadnum.getText());
				} catch (Exception e2) {
					// TODO: handle exception
					System.out.println(e2);
				}
				
				if(host.length() < 3 || begin > over){
					JOptionPane.showMessageDialog(null,"对不起，参数错误！","提示",JOptionPane. INFORMATION_MESSAGE);
					return;
				}
				if(threadnum < 1 || threadnum > 100){
					JOptionPane.showMessageDialog(null,"对不起，确定线程数1~100！","提示",JOptionPane. INFORMATION_MESSAGE);
					return;
				}
				System.out.println(host + "from" + begin + "to" + over);
				progressBar.setMinimum(begin);
			    progressBar.setMaximum(over);
				bucket.update(begin, over);
				//MyScan s1 = new MyScan(host, bucket);
				//MyScan s2 = new MyScan(host, bucket);
				//s1.start();
				//s2.start();
				for( int i = 0; i < threadnum; i++ ){
					new MyScan(host, bucket).start();
	            }
			}
		});
	}
}
