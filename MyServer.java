import java.rmi.*;
import java.rmi.registry.*;

public class MyServer {
	public static void main(String[] args){
		if (args.length != 2) {
			System.out.println("You have to enter RMI object address in the form: //host_address/service_name //host_address/service_name");
			return;
		}
		if (System.getSecurityManager() == null)
			System.setSecurityManager(new SecurityManager());
		try {
			try {
				Registry reg = LocateRegistry.createRegistry(1099);
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
			CalcObjImpl mySrvObj = new CalcObjImpl();
			CalcObjImpl2 mySrvObj2 = new CalcObjImpl2();
			java.rmi.Naming.rebind(args[0], mySrvObj);
			java.rmi.Naming.rebind(args[1], mySrvObj2);
			System.out.println("Server is registered now :-)");
			System.out.println("Press Crl+C to stop...");
		} catch (Exception e) {
			System.out.println("SERVER CAN'T BE REGISTERED!");
			e.printStackTrace();
			return;
		}
	}
}
