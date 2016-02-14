package br.edu.ifpb.pd.rmimessenger.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Map;

import br.edu.ifpb.pd.rmimessenger.interfaces.ClientIF;
import br.edu.ifpb.pd.rmimessenger.interfaces.MessengerIF;

public class Messenger extends UnicastRemoteObject implements MessengerIF{
	private static final long serialVersionUID = 1L;
	
	private Map<String, ClientIF> clients;
	
		public Messenger() throws RemoteException{
			
		}

	@Override
	public void joinMessenger(ClientIF client) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendPublicMessage(String msg) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendPrivateMessage(String user, String msg)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	
}
