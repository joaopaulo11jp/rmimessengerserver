package br.edu.ifpb.pd.rmimessenger.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Iterator;
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
	public boolean joinMessenger(ClientIF client) throws RemoteException {
		if(this.clients.get(client.getName()) == null){
			this.clients.put(client.getName(), client);
			System.out.println(client.getName()+" entrou no chat!");
			return true;
		}else{
			return false;
		}
	}

	@Override
	public void sendPublicMessage(String fromUser,String msg) throws RemoteException {
		Iterator it = this.clients.values().iterator();
		ClientIF client = null;
		
		while(it.hasNext()){
			client = (ClientIF) it.next();
			client.message(fromUser+" : "+msg);
		}
	}

	@Override
	public boolean sendPrivateMessage(String fromUser,String user, String msg)
			throws RemoteException {
		if(this.clients.get(user) != null) this.clients.get(user).message(msg);
		else return false;
		
		return true;
	}
	
}
