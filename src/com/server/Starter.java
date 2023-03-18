package com.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Starter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Registry reg;
		try {
			MathBoxServices ser = new MathBoxServices();
			reg = LocateRegistry.createRegistry(5096);
			reg.rebind("MathBoxServices", ser);
			System.out.println("Server is Running....");
		} catch (RemoteException e1) {

			//JOptionPane.showMessageDialog(null, "Server is Already Running...", "ALERT",JOptionPane.WARNING_MESSAGE);
			System.out.println(e1.toString());
		}
	}

}
