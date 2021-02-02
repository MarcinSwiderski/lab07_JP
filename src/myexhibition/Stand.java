package myexhibition;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import communication.ICenter;
import communication.IStand;
import support.Description;

public class Stand implements IStand{

	private int id;
	
	public static void main(String[] args) {
		try {
			Registry reg = LocateRegistry.getRegistry("localhost",3000);
			ICenter ic = (ICenter) reg.lookup("Center");
			Stand s = new Stand();
		    IStand is = (IStand) UnicastRemoteObject.exportObject(s,0); 
		    System.out.println("Stand is ready");
		    s.id = ic.connect(is);
		} catch (RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void setContent(Description d) throws RemoteException {
	}

	@Override
	public int getId() throws RemoteException {
		return id;
	}

}
