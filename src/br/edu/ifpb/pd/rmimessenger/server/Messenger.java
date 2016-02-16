package br.edu.ifpb.pd.rmimessenger.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
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
			Iterator<ClientIF> it;
			Collection<String> list = new ArrayList<String>();
			
			this.clients.put(client.getName(), client);
			System.out.println(client.getName()+" entrou no chat!");
			
			it = this.clients.values().iterator();
			list.addAll(this.clients.keySet());
			while(it.hasNext()){
				it.next().setUserList(list);
			}
			
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
			client.message(fromUser+" : "+msg+" "+new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date())+"\n");
		}
	}

	@Override
	public boolean sendPrivateMessage(String fromUser,String user, String msg)
			throws RemoteException {
		if(this.clients.get(user) != null){ 
			this.clients.get(fromUser).message(fromUser+" (PVT recebido): "+msg+" "+new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date())+"\n");
			this.clients.get(user).message(fromUser+" (PVT enviado para"+user+"): "+msg+" "+new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date())+"\n");
		}else return false;
		
		return true;
	}

	@Override
	public void exitMessenger(ClientIF client) throws RemoteException {
		System.out.println(client.getName()+" saiu do chat!");
		this.clients.remove(client.getName());
	}
	
}
