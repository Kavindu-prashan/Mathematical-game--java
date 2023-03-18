package com.gameLevels;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import com.server.RmiInterface;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class StarterWindow {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StarterWindow window = new StarterWindow();
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
	public StarterWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(102, 102, 153));
		frame.setBounds(100, 100, 683, 503);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(197, 10, 297, 47);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblMAT = new JLabel("M A T H   B O X");
		lblMAT.setForeground(new Color(102, 102, 153));
		lblMAT.setBackground(Color.WHITE);
		panel.add(lblMAT);
		lblMAT.setFont(new Font("FreeMono", Font.BOLD, 20));
		lblMAT.setHorizontalAlignment(SwingConstants.CENTER);
		
		textField = new JTextField();
		textField.setForeground(Color.BLACK);
		textField.setFont(new Font("Tahoma", Font.BOLD, 10));
		textField.setToolTipText("Enter your name");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(239, 81, 211, 23);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JRadioButton rdbtnEasy = new JRadioButton("Easy");
		rdbtnEasy.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnEasy.setBackground(new Color(102, 102, 153));
		rdbtnEasy.setBounds(249, 124, 149, 23);
		frame.getContentPane().add(rdbtnEasy);
		
		JRadioButton rdbtnHard = new JRadioButton("Hard");
		rdbtnHard.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnHard.setBackground(new Color(102, 102, 153));
		rdbtnHard.setBounds(249, 149, 149, 23);
		frame.getContentPane().add(rdbtnHard);
		
		JButton btnNewButton = new JButton("S T A R T");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//opening relevant mode
				try {
					RmiInterface s =(RmiInterface) Naming.lookup("rmi://localhost:5096/MathBoxServices");
					if(s.IntUser().equals("null")) {
						s.AddNewPlayer(textField.getText());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				if(rdbtnEasy.isSelected()) {
					EasyMode e = new EasyMode();
					e.main(null);
					frame.dispose();
				}
				if(rdbtnHard.isSelected()) {
					MediumMode m = new MediumMode();
					m.main(null);
					frame.dispose();
				}
			}
		});
		btnNewButton.setBounds(197, 222, 297, 25);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Server Status :");
		lblNewLabel.setBounds(197, 276, 118, 15);
		frame.getContentPane().add(lblNewLabel);
		
		//check for previous player?
		try {
			RmiInterface s =(RmiInterface) Naming.lookup("rmi://localhost:5096/MathBoxServices");
			String name=s.IntUser();
			System.out.println("got name is : "+name);
			if(!name.equals("null")) {
				textField.setText(name);
				textField.setEnabled(false);
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
}
