package com.gameLevels;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.CardLayout;
import javax.swing.JTextField;

import static java.util.concurrent.TimeUnit.SECONDS;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.classes.Meadium;
import com.server.RmiInterface;

import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.rmi.Naming;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.awt.event.ActionEvent;

public class MediumMode {

	private JFrame frame;
	private JTable table;
	private JTextField R1C1_Value;
	private JTextField R1C3_Value;
	private JTextField textField_6;
	private JTextField textField_8;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	int countdownStarter = 30;
	final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
	private JButton btnRET;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MediumMode window = new MediumMode();
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
	public MediumMode() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(102, 102, 153));
		frame.getContentPane().setFont(new Font("Dialog", Font.PLAIN, 25));
		frame.setBounds(100, 100, 702, 506);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel MatrixPanel = new JPanel();
		MatrixPanel.setBackground(Color.DARK_GRAY);
		MatrixPanel.setBounds(12, 44, 341, 270);
		frame.getContentPane().add(MatrixPanel);
		MatrixPanel.setLayout(new GridLayout(5, 5, 3, 3));
		
		JPanel R1C1 = new JPanel();
		MatrixPanel.add(R1C1);
		R1C1.setLayout(new GridLayout(1, 0, 0, 0));
		
		R1C1_Value = new JTextField();
		R1C1_Value.setFont(new Font("Dialog", Font.PLAIN, 20));
		R1C1_Value.setHorizontalAlignment(SwingConstants.CENTER);
		R1C1.add(R1C1_Value);
		R1C1_Value.setColumns(10);
		
		JPanel R1C2 = new JPanel();
		MatrixPanel.add(R1C2);
		R1C2.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel R1C2_Sign = new JLabel("−");
		R1C2_Sign.setFont(new Font("Dialog", Font.BOLD, 25));
		R1C2_Sign.setHorizontalAlignment(SwingConstants.CENTER);
		R1C2.add(R1C2_Sign);
		
		JPanel R1C3 = new JPanel();
		MatrixPanel.add(R1C3);
		R1C3.setLayout(new GridLayout(1, 0, 0, 0));
		
		R1C3_Value = new JTextField();
		R1C3_Value.setFont(new Font("Dialog", Font.PLAIN, 20));
		R1C3_Value.setHorizontalAlignment(SwingConstants.CENTER);
		R1C3.add(R1C3_Value);
		R1C3_Value.setColumns(10);
		
		JPanel R1C4 = new JPanel();
		MatrixPanel.add(R1C4);
		R1C4.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel R1C4_Sign = new JLabel("×");
		R1C4_Sign.setFont(new Font("Dialog", Font.BOLD, 20));
		R1C4_Sign.setHorizontalAlignment(SwingConstants.CENTER);
		R1C4.add(R1C4_Sign);
		
		JPanel R1C5 = new JPanel();
		MatrixPanel.add(R1C5);
		R1C5.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel R1C5_Value = new JLabel("2");
		R1C5_Value.setFont(new Font("Dialog", Font.BOLD, 20));
		R1C5_Value.setHorizontalAlignment(SwingConstants.CENTER);
		R1C5.add(R1C5_Value);
		
		JPanel R2C1 = new JPanel();
		MatrixPanel.add(R2C1);
		R2C1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel R2C1_Sign = new JLabel("+");
		R2C1_Sign.setFont(new Font("Dialog", Font.BOLD, 25));
		R2C1_Sign.setHorizontalAlignment(SwingConstants.CENTER);
		R2C1.add(R2C1_Sign);
		
		JPanel R2C2 = new JPanel();
		R2C2.setBackground(Color.LIGHT_GRAY);
		MatrixPanel.add(R2C2);
		
		JPanel R2C3 = new JPanel();
		MatrixPanel.add(R2C3);
		R2C3.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel R2C3_Sign = new JLabel("−");
		R2C3_Sign.setFont(new Font("Dialog", Font.BOLD, 25));
		R2C3_Sign.setHorizontalAlignment(SwingConstants.CENTER);
		R2C3.add(R2C3_Sign);
		
		JPanel R2C4 = new JPanel();
		R2C4.setBackground(Color.LIGHT_GRAY);
		MatrixPanel.add(R2C4);
		
		JPanel R2C5 = new JPanel();
		MatrixPanel.add(R2C5);
		R2C5.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel R2C5_Sign = new JLabel("+");
		R2C5_Sign.setFont(new Font("Dialog", Font.BOLD, 25));
		R2C5_Sign.setHorizontalAlignment(SwingConstants.CENTER);
		R2C5.add(R2C5_Sign);
		
		JPanel R3C1 = new JPanel();
		MatrixPanel.add(R3C1);
		R3C1.setLayout(new GridLayout(1, 0, 0, 0));
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Dialog", Font.PLAIN, 20));
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		R3C1.add(textField_6);
		textField_6.setColumns(10);
		
		JPanel R3C2 = new JPanel();
		MatrixPanel.add(R3C2);
		R3C2.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel R3C2_Sign = new JLabel("+");
		R3C2_Sign.setFont(new Font("Dialog", Font.BOLD, 25));
		R3C2_Sign.setHorizontalAlignment(SwingConstants.CENTER);
		R3C2.add(R3C2_Sign);
		
		JPanel R3C3 = new JPanel();
		MatrixPanel.add(R3C3);
		R3C3.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel R3C3_Value = new JLabel("2");
		R3C3_Value.setFont(new Font("Dialog", Font.BOLD, 20));
		R3C3_Value.setHorizontalAlignment(SwingConstants.CENTER);
		R3C3.add(R3C3_Value);
		
		JPanel R3C4 = new JPanel();
		MatrixPanel.add(R3C4);
		R3C4.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel R3C3_Sign_1 = new JLabel("+");
		R3C3_Sign_1.setFont(new Font("Dialog", Font.BOLD, 25));
		R3C3_Sign_1.setHorizontalAlignment(SwingConstants.CENTER);
		R3C4.add(R3C3_Sign_1);
		
		JPanel R3C5 = new JPanel();
		MatrixPanel.add(R3C5);
		R3C5.setLayout(new GridLayout(1, 0, 0, 0));
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Dialog", Font.PLAIN, 20));
		R3C5.add(textField);
		textField.setColumns(10);
		
		JPanel R4C1 = new JPanel();
		MatrixPanel.add(R4C1);
		R4C1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel R4C1_Sign = new JLabel("×");
		R4C1_Sign.setFont(new Font("Dialog", Font.BOLD, 25));
		R4C1_Sign.setHorizontalAlignment(SwingConstants.CENTER);
		R4C1.add(R4C1_Sign);
		
		JPanel R4C2 = new JPanel();
		R4C2.setBackground(Color.LIGHT_GRAY);
		MatrixPanel.add(R4C2);
		
		JPanel R4C3 = new JPanel();
		MatrixPanel.add(R4C3);
		R4C3.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel R3C3_Sign = new JLabel("+");
		R3C3_Sign.setHorizontalAlignment(SwingConstants.CENTER);
		R3C3_Sign.setFont(new Font("Dialog", Font.BOLD, 25));
		R4C3.add(R3C3_Sign);
		
		JPanel R4C4 = new JPanel();
		R4C4.setBackground(Color.LIGHT_GRAY);
		MatrixPanel.add(R4C4);
		
		JPanel R4C5 = new JPanel();
		MatrixPanel.add(R4C5);
		R4C5.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel R4C5_Sign = new JLabel("+");
		R4C5_Sign.setFont(new Font("Dialog", Font.BOLD, 25));
		R4C5_Sign.setHorizontalAlignment(SwingConstants.CENTER);
		R4C5.add(R4C5_Sign);
		
		JPanel R5C1 = new JPanel();
		MatrixPanel.add(R5C1);
		R5C1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel R5C1_Value = new JLabel("6");
		R5C1_Value.setFont(new Font("Dialog", Font.BOLD, 20));
		R5C1_Value.setHorizontalAlignment(SwingConstants.CENTER);
		R5C1.add(R5C1_Value);
		
		JPanel R5C2 = new JPanel();
		MatrixPanel.add(R5C2);
		R5C2.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel R5C2_Sign = new JLabel("+");
		R5C2_Sign.setHorizontalAlignment(SwingConstants.CENTER);
		R5C2_Sign.setFont(new Font("Dialog", Font.BOLD, 25));
		R5C2.add(R5C2_Sign);
		
		JPanel R5C3 = new JPanel();
		MatrixPanel.add(R5C3);
		R5C3.setLayout(new GridLayout(1, 0, 0, 0));
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Dialog", Font.PLAIN, 20));
		textField_8.setHorizontalAlignment(SwingConstants.CENTER);
		R5C3.add(textField_8);
		textField_8.setColumns(10);
		
		JPanel R5C4 = new JPanel();
		MatrixPanel.add(R5C4);
		R5C4.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel R5C4_Sign = new JLabel("+");
		R5C4_Sign.setHorizontalAlignment(SwingConstants.CENTER);
		R5C4_Sign.setFont(new Font("Dialog", Font.BOLD, 25));
		R5C4.add(R5C4_Sign);
		
		JPanel R5C5 = new JPanel();
		MatrixPanel.add(R5C5);
		R5C5.setLayout(new GridLayout(1, 0, 0, 0));
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Dialog", Font.PLAIN, 20));
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		R5C5.add(textField_2);
		textField_2.setColumns(10);
		
		JPanel HorizontalEqualPanel = new JPanel();
		HorizontalEqualPanel.setBounds(365, 44, 31, 270);
		frame.getContentPane().add(HorizontalEqualPanel);
		HorizontalEqualPanel.setLayout(new GridLayout(5, 0, 3, 3));
		
		JPanel panel_2 = new JPanel();
		HorizontalEqualPanel.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel label = new JLabel("=");
		label.setFont(new Font("Dialog", Font.BOLD, 25));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(label);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(102, 102, 153));
		HorizontalEqualPanel.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		HorizontalEqualPanel.add(panel_4);
		panel_4.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNewLabel = new JLabel("=");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 25));
		panel_4.add(lblNewLabel);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(102, 102, 153));
		HorizontalEqualPanel.add(panel_5);
		
		JPanel panel_1 = new JPanel();
		HorizontalEqualPanel.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel label_2 = new JLabel("=");
		label_2.setFont(new Font("Dialog", Font.BOLD, 25));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(label_2);
		
		JPanel HorizontalAnswerPanel = new JPanel();
		HorizontalAnswerPanel.setBounds(408, 44, 49, 270);
		frame.getContentPane().add(HorizontalAnswerPanel);
		HorizontalAnswerPanel.setLayout(new GridLayout(5, 0, 3, 3));
		
		JPanel panel_7 = new JPanel();
		HorizontalAnswerPanel.add(panel_7);
		panel_7.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNewLabel_7 = new JLabel("57");
		lblNewLabel_7.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		panel_7.add(lblNewLabel_7);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(102, 102, 153));
		HorizontalAnswerPanel.add(panel_8);
		
		JPanel panel_9 = new JPanel();
		HorizontalAnswerPanel.add(panel_9);
		panel_9.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNewLabel_6 = new JLabel("5");
		lblNewLabel_6.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel_9.add(lblNewLabel_6);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(102, 102, 153));
		HorizontalAnswerPanel.add(panel_10);
		
		JPanel panel_6 = new JPanel();
		HorizontalAnswerPanel.add(panel_6);
		panel_6.setLayout(new GridLayout(1, 0, 0, 0));
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Dialog", Font.BOLD, 20));
		panel_6.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel VerticalEqualPanel = new JPanel();
		VerticalEqualPanel.setBounds(12, 326, 341, 31);
		frame.getContentPane().add(VerticalEqualPanel);
		VerticalEqualPanel.setLayout(new GridLayout(0, 5, 3, 3));
		
		JPanel panel_11 = new JPanel();
		VerticalEqualPanel.add(panel_11);
		panel_11.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel label_3 = new JLabel("=");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Dialog", Font.BOLD, 25));
		panel_11.add(label_3);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBackground(new Color(102, 102, 153));
		VerticalEqualPanel.add(panel_12);
		panel_12.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_13 = new JPanel();
		VerticalEqualPanel.add(panel_13);
		panel_13.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("=");
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 25));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_13.add(lblNewLabel_3);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBackground(new Color(102, 102, 153));
		VerticalEqualPanel.add(panel_14);
		panel_14.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_15 = new JPanel();
		VerticalEqualPanel.add(panel_15);
		panel_15.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNewLabel_5 = new JLabel("=");
		lblNewLabel_5.setFont(new Font("Dialog", Font.BOLD, 25));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_15.add(lblNewLabel_5);
		
		JPanel VerticalAnswerPanel = new JPanel();
		VerticalAnswerPanel.setBounds(12, 369, 341, 49);
		frame.getContentPane().add(VerticalAnswerPanel);
		VerticalAnswerPanel.setLayout(new GridLayout(0, 5, 3, 3));
		
		JPanel panel_16 = new JPanel();
		VerticalAnswerPanel.add(panel_16);
		panel_16.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel label_1 = new JLabel("44");
		label_1.setFont(new Font("Dialog", Font.BOLD, 20));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_16.add(label_1);
		
		JPanel panel_17 = new JPanel();
		panel_17.setBackground(new Color(102, 102, 153));
		VerticalAnswerPanel.add(panel_17);
		
		JPanel panel_18 = new JPanel();
		VerticalAnswerPanel.add(panel_18);
		panel_18.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNewLabel_9 = new JLabel("0");
		lblNewLabel_9.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		panel_18.add(lblNewLabel_9);
		
		JPanel panel_19 = new JPanel();
		panel_19.setBackground(new Color(102, 102, 153));
		VerticalAnswerPanel.add(panel_19);
		
		JPanel panel_20 = new JPanel();
		VerticalAnswerPanel.add(panel_20);
		panel_20.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNewLabel_10 = new JLabel("3");
		lblNewLabel_10.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		panel_20.add(lblNewLabel_10);
		
		JPanel TimerPanel = new JPanel();
		TimerPanel.setBackground(new Color(153, 153, 204));
		TimerPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(102, 153, 204), new Color(0, 153, 153)));
		TimerPanel.setBounds(358, 326, 99, 98);
		frame.getContentPane().add(TimerPanel);
		TimerPanel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("TIME LEFT :");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(12, 0, 87, 27);
		TimerPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("90");
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 30));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 30, 87, 58);
		TimerPanel.add(lblNewLabel_2);
		
		JPanel LeaderbordPanel = new JPanel();
		LeaderbordPanel.setBackground(new Color(153, 153, 204));
		LeaderbordPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		LeaderbordPanel.setBounds(501, 44, 174, 380);
		frame.getContentPane().add(LeaderbordPanel);
		LeaderbordPanel.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("LEADERBOARD");
		lblNewLabel_4.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(12, 12, 150, 15);
		LeaderbordPanel.add(lblNewLabel_4);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Score"
			}
		));
		table.setBounds(22, 39, 140, 271);
		LeaderbordPanel.add(table);
		
		JLabel lblNewLabel_6_1 = new JLabel("My Score : ");
		lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_6_1.setBounds(12, 333, 150, 15);
		LeaderbordPanel.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_7_1 = new JLabel("Time Taken :");
		lblNewLabel_7_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_7_1.setBounds(12, 353, 150, 15);
		LeaderbordPanel.add(lblNewLabel_7_1);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(469, 43, 2, 425);
		frame.getContentPane().add(separator);
		
		JLabel lblMathBox = new JLabel("M A T H   B O X");
		lblMathBox.setHorizontalAlignment(SwingConstants.CENTER);
		lblMathBox.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 30));
		lblMathBox.setBounds(158, 5, 328, 30);
		frame.getContentPane().add(lblMathBox);
		
		JButton btnSUB = new JButton("S U B M I T");
		btnSUB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int score=0;
				try {
					Meadium m = new Meadium();
					boolean ans1 = m.correctAnswer(Integer.parseInt(R1C1_Value.getText()), R1C2_Sign.getText(), Integer.parseInt(R1C3_Value.getText()),R1C4_Sign.getText(), Integer.parseInt(R1C5_Value.getText()), Integer.parseInt(lblNewLabel_7.getText())); //R1
					boolean ans2 = m.correctAnswer(Integer.parseInt(textField_6.getText()), R3C2_Sign.getText(), Integer.parseInt(R3C3_Value.getText()),R3C3_Sign_1.getText(), Integer.parseInt(textField.getText()), Integer.parseInt(lblNewLabel_6.getText())); //R2
					boolean ans3 = m.correctAnswer(Integer.parseInt(R5C1_Value.getText()), R5C2_Sign.getText(), Integer.parseInt(textField_8.getText()),R5C4_Sign.getText(), Integer.parseInt(textField_2.getText()), Integer.parseInt(textField_1.getText())); //R3
					boolean ans4 = m.correctAnswer(Integer.parseInt(R1C1_Value.getText()), R2C1_Sign.getText(), Integer.parseInt(textField_6.getText()),R4C1_Sign.getText(), Integer.parseInt(R5C1_Value.getText()), Integer.parseInt(label_1.getText())); //C1
					boolean ans5 = m.correctAnswer(Integer.parseInt(R1C3_Value.getText()), R2C3_Sign.getText(), Integer.parseInt(R3C3_Value.getText()),R3C3_Sign.getText(), Integer.parseInt(textField_8.getText()), Integer.parseInt(lblNewLabel_9.getText())); //C2 
					boolean ans6 = m.correctAnswer(Integer.parseInt(R1C3_Value.getText()), R2C3_Sign.getText(), Integer.parseInt(R3C3_Value.getText()),R3C3_Sign.getText(), Integer.parseInt(textField_8.getText()), Integer.parseInt(lblNewLabel_9.getText())); //C2 

					if(ans1) {
						score+=10;
						R1C1_Value.setForeground(Color.GREEN); R1C3_Value.setForeground(Color.GREEN); 
					}else {
						R1C1_Value.setForeground(Color.RED); R1C3_Value.setForeground(Color.RED);
					}
					if(ans2) {
						score+=10;
						textField_6.setForeground(Color.GREEN); textField.setForeground(Color.GREEN); 
					}else {
						textField_6.setForeground(Color.RED); textField.setForeground(Color.RED); 
					}
					if(ans3) {
						score+=30;
						textField_8.setForeground(Color.GREEN); textField_2.setForeground(Color.GREEN); textField_1.setForeground(Color.GREEN);
					}else {
						textField_8.setForeground(Color.RED); textField_2.setForeground(Color.RED); textField_1.setForeground(Color.RED);
					}
					if(ans4) {
						score+=10;
						R1C1_Value.setForeground(Color.GREEN); textField_6.setForeground(Color.GREEN); 
					}else {
						R1C1_Value.setForeground(Color.RED); textField_6.setForeground(Color.RED); 
					}
					if(ans5) {
						score+=10;
						R1C3_Value.setForeground(Color.GREEN); textField_8.setForeground(Color.GREEN); 
					}else {
						R1C3_Value.setForeground(Color.RED); textField_8.setForeground(Color.RED); 

					}
					if(ans6) {
						score+=10;
						textField.setForeground(Color.GREEN); textField_2.setForeground(Color.GREEN); 
					}else {
						textField.setForeground(Color.RED); textField_2.setForeground(Color.RED); 
					}
					//Printing final score to the jframe
					int takentime =countdownStarter;
					scheduler.shutdown();
					lblNewLabel_6_1.setText("My Score : "+score);
					lblNewLabel_7_1.setText("Time Taken : "+String.valueOf(90-takentime-1));
					//sending score to db
					try {
						RmiInterface s =(RmiInterface) Naming.lookup("rmi://localhost:5096/MathBoxServices");
						s.SendScore("h", score); //Sending score to DB
						JTable res=s.FetchScoreBoard("h"); //get ScoreBoard values
						DefaultTableModel model = (DefaultTableModel) res.getModel();
						table.setModel(model);
						s.AddToData(score);
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, "Fill all the values");
				}
				btnRET.setEnabled(true);
			}
		});
		btnSUB.setBounds(40, 437, 198, 25);
		frame.getContentPane().add(btnSUB);
		
		//Generate values for fields
		Meadium m = new Meadium();
		R1C5_Value.setText(String.valueOf(m.genarateInt(0, 100)));
		lblNewLabel_7.setText(String.valueOf(m.genarateInt(0, 10)*Integer.parseInt(R1C5_Value.getText()))); //R1
		R3C3_Value.setText(String.valueOf(m.genarateInt(0, 10)));
		lblNewLabel_6.setText(String.valueOf(Integer.parseInt(R3C3_Value.getText())*m.genarateInt(0, 10))); //R2
		//R5C5_Value.setText(String.valueOf(m.genarateInt(0, 50)));
		//lblNewLabel_8.setText(String.valueOf(m.genarateInt(0, 10)*Integer.parseInt(R5C5_Value.getText()))); //R3
		R5C1_Value.setText(String.valueOf(m.genarateInt(0, 10)));
		label_1.setText(String.valueOf(Integer.parseInt(R5C1_Value.getText())*m.genarateInt(0, 10))); //C1
		R3C3_Value.setText(String.valueOf(m.genarateInt(0, 10)));
		lblNewLabel_9.setText(String.valueOf(m.genarateInt(0, 15))); //C2
		lblNewLabel_10.setText(String.valueOf(m.genarateInt(0, 100))); //c#
		
		btnRET = new JButton("R E T R Y");
		btnRET.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scheduler.shutdown();
				MediumMode m = new MediumMode();
				m.main(null);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnRET.setEnabled(false);
		btnRET.setBounds(274, 437, 90, 25);
		frame.getContentPane().add(btnRET);
		
		JButton btnANA = new JButton("A N A L Y Z E");
		btnANA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					RmiInterface s =(RmiInterface) Naming.lookup("rmi://localhost:5096/MathBoxServices");
					System.out.println(s.GenarateJSON());
					String url = s.GenarateJSON();
					String url1 = url;
					url1 = url1.replaceAll(" ", "%20");
					
					Image image = null;

					try {
						URL imgurl = new URL(url1);
						URLConnection conn = imgurl.openConnection();
						conn.setRequestProperty("User-Agent", "Mozilla/5.0");

						conn.connect();
						InputStream urlStream = conn.getInputStream();
						image = ImageIO.read(urlStream);

						JFrame frame = new JFrame();
						JLabel lblimage = new JLabel(new ImageIcon(image));
						frame.getContentPane().add(lblimage, BorderLayout.CENTER);
						frame.setSize(image.getWidth(null) + 25, image.getHeight(null) + 25);
						frame.setVisible(true);

					} catch (IOException ee) {
						JOptionPane.showMessageDialog(null, "Can't connect to the internet."+"\n"+ "Check your internet connection.", "ALERT",
								JOptionPane.WARNING_MESSAGE);
						System.out.println(ee.toString());
	
						
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnANA.setBounds(501, 436, 174, 27);
		frame.getContentPane().add(btnANA);
		
		//Timer
        final Runnable runnable = new Runnable() {
            

            public void run() {

                lblNewLabel_2.setText(String.valueOf(countdownStarter));
                countdownStarter--;

                if (countdownStarter < 0) {
                	JOptionPane.showMessageDialog(null,"Times is UP!","Times UP!",JOptionPane.WARNING_MESSAGE);
                	btnRET.setEnabled(true);
                    scheduler.shutdown();
                }
            }
        };
        scheduler.scheduleAtFixedRate(runnable, 0, 1, SECONDS);
		
	}
}
