package br.edu.ifpb.pd.rmimessenger.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

import br.edu.ifpb.pd.rmimessenger.interfaces.ClientIF;
import br.edu.ifpb.pd.rmimessenger.interfaces.MessengerIF;

public class Messenger extends UnicastRemoteObject implements MessengerIF{
	private static final long serialVersionUID = 1L;
	
	private Map<String, ClientIF> clients;
	
		public Messenger() throws RemoteException{
			this.clients = new HashMap<String,ClientIF>();
		}

	@Override
	public void joinMessenger(ClientIF client) throws RemoteException {
		if(this.clients.get(client.getName()) == null)
			this.clients.put(client.getName(), client);
		else{
			// Erro de usuário já existente
		}
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
