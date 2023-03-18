package com.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class MathBoxServices extends UnicastRemoteObject implements RmiInterface {

	private static final long serialVersionUID = 4748101764377103417L;
	ArrayList<Integer> Data = new ArrayList<Integer>();
	
	protected MathBoxServices() throws RemoteException {
		super();
		Data = new ArrayList<Integer>();
	}

	@Override
	public String IntUser() throws RemoteException {
		String out="null";
		
		try {
			System.out.println("Client IP :"+getClientHost());
			PreparedStatement pst = null;
			ResultSet rs = null;
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MathBox","root", ""); // Open connection to database.
			pst = (PreparedStatement) con.prepareStatement("SELECT * FROM `Users` WHERE IP=?");
			pst.setString(1, getClientHost().toString());
			rs = pst.executeQuery();
			while(rs.next()) {
				out= rs.getString("Name");
			}
		}catch(Exception e) {
			
		}
		return out;
	}

	@Override
	public void SendScore(String mode, int score) throws RemoteException {
		try {
			PreparedStatement pst = null;
			ResultSet rs = null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MathBox","root", ""); // Open connection to database.
			pst = (PreparedStatement) con.prepareStatement("SELECT * FROM `Users` WHERE IP=?");
			pst.setString(1, getClientHost().toString());
			rs = pst.executeQuery();
			int ID=-1;
			while(rs.next()) {
				 ID= rs.getInt("UID");
			}
			if(mode.equals("e")) {
				pst = (PreparedStatement) con.prepareStatement("INSERT INTO `MScoreBoard` (`SID`, `UID`, `Score`,`Mode`) VALUES (NULL,?, ?, ?)");
				pst.setInt(1, ID);
				pst.setInt(2, score);
				pst.setString(3, "e");
				pst.executeUpdate();
			}else {
				pst = (PreparedStatement) con.prepareStatement("INSERT INTO `MScoreBoard` (`SID`, `UID`, `Score`,`Mode`) VALUES (NULL,?, ?, ?)");
				pst.setInt(1, ID);
				pst.setInt(2, score);
				pst.setString(3, "h");
				pst.executeUpdate();
			}
			
		}catch(Exception e) {
			
		}
		
		
	}

	@Override
	public JTable FetchScoreBoard(String mode) throws RemoteException {
		ResultSet rs = null;
		JTable table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Score"
			}
		));
		try {
			if(mode.equals("e")) {
				PreparedStatement pst = null;
				int ID=-1;
				Class.forName("com.mysql.cj.jdbc.Driver");
				java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MathBox","root", ""); // Open connection to database.
				pst = (PreparedStatement) con.prepareStatement("SELECT Name, MAX(Score) AS Score FROM MScoreBoard s,Users u WHERE s.UID=u.UID GROUP BY Name");
				rs = pst.executeQuery();
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				while(rs.next()) {
					model.addRow(new String [] {rs.getString("Name"),rs.getString("Score")});
				}
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return table;
	}

	@Override
	public void AddNewPlayer(String name) throws RemoteException {
		try {
			PreparedStatement pst = null;
			ResultSet rs = null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MathBox","root", ""); // Open connection to database.
			pst = (PreparedStatement) con.prepareStatement("INSERT INTO `Users`(`UID`, `Name`, `IP`) VALUES (NULL,?,?)");
			pst.setString(1, name);
			pst.setString(2, getClientHost().toString());
			pst.executeUpdate();
			
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		
	}

	@Override
	public void AddToData(int score) throws RemoteException {
		Data.add(score);
	} 

	@Override
	public String GenarateJSON() throws RemoteException {
		String json = null;
		
		String p1 = "https://quickchart.io/chart?devicePixelRatio=1.0&c={type: 'line',data: {labels: [";
		for(int i=0 ; i<Data.size() ; i++) {
			p1=p1 + "'Atmpt " + (i+1) + "',";
		}
		String p2=p1+"],datasets: [{label: 'Score Analyze',backgroundColor: 'rgb(255, 99, 132)',borderColor: 'rgb(255, 99, 132)',data: [";
		for(int i=0 ; i<Data.size() ; i++) {
			p2=p2 + Data.get(i) +",";
		}
		json=p2 + "],fill: false,}],},options: {title: {display: true,text: 'Chart.js Line Chart',},},}";
		return json;
	}

}
