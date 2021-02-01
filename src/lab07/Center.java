package lab07;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;


import communication.ICenter;
import communication.IDesigner;
import communication.IMonitor;
import communication.IStand;
import support.Answer;
import support.CustomException;
import support.Question;

public class Center implements ICenter {
   
	private static IDesigner id = null;
	private static IStand is = null;
	private static int identifier = 0;
	private static ArrayList<IStand> xd = new ArrayList<>();
	
	public static void main(String[] args) {
		try {
			Registry reg = LocateRegistry.createRegistry(3000);
			reg.rebind("Center", UnicastRemoteObject.exportObject(new Center(), 0));
			System.out.println("Center is ready");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int signIn(String visitorName) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void signOut(int visitorId) throws RemoteException, CustomException {
		// TODO Auto-generated method
		System.out.println("XD");
		
	}

	@Override
	public Question[] getQuestions() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean[] checkAnswers(int userId, Answer[] a) throws RemoteException, CustomException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addQA(Question[] q, Answer[] a) throws RemoteException, CustomException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IStand[] getStands() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int connect(IDesigner id) throws RemoteException {
		Center.id = id;
		return identifier++;
	}

	@Override
	public int connect(IStand is) throws RemoteException {
		Center.is = is;
		identifier++;
		id.notify(identifier, true);
		return identifier;
	}

	@Override
	public int connect(IMonitor im) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void disconnect(int identifier) throws RemoteException, CustomException {
		// TODO Auto-generated method stub
		
	}

	





}
