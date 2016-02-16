package br.edu.ifpb.pd.rmimessenger.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Collection;

public interface MessengerIF extends Remote{
	public boolean joinMessenger(ClientIF client) throws RemoteException;
	public void sendPublicMessage(String fromUser,String msg) throws RemoteException;
	public Integer sendPrivateMessage(String fromUser,String user,String msg) throws RemoteException;
	public void exitMessenger(ClientIF client) throws RemoteException;
}
