package br.edu.ifpb.pd.rmimessenger.server;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {
	private static String operadora = "VIVO";
		
	public static void main(String args[]) throws RemoteException{
	     LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
	     try {
	      	System.out.println("Server working...");
	        Naming.bind("VIVO", new Operadora());
	        System.out.println("Operadora "+operadora+" Aberta!!!");
	     } catch (AlreadyBoundException ex) {
	         Logger.getLogger(Operadora.class.getName()).log(Level.SEVERE, null, ex);
	     } catch (MalformedURLException ex) {
	         Logger.getLogger(Operadora.class.getName()).log(Level.SEVERE, null, ex);
	     }
	}
}
