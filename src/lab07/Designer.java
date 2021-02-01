package lab07;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import communication.ICenter;
import communication.IDesigner;


public class Designer implements IDesigner {
	
	public static void main(String[] args) {
		try {
			Registry reg = LocateRegistry.getRegistry("localhost",3000);
			ICenter ic = (ICenter) reg.lookup("Center");
			Designer d = new Designer();
		    IDesigner id = (IDesigner) UnicastRemoteObject.exportObject(d,0); 
		    System.out.println("Designer is ready");
		    ic.connect(id);
		} catch (RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void notify(int standId, boolean isConnected) throws RemoteException {
		System.out.println("standId="+standId+" isConnected="+isConnected);		
	}
}
