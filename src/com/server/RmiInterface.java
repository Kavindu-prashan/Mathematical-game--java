package com.server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.ResultSet;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public interface RmiInterface extends Remote{
	String IntUser() throws RemoteException;
	void SendScore(String mode, int score) throws RemoteException;
	JTable FetchScoreBoard(String mode) throws RemoteException;
	void AddNewPlayer(String name) throws RemoteException;
	void AddToData(int score) throws RemoteException;
	String GenarateJSON() throws RemoteException;
}
