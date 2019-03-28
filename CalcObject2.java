import java.rmi.*;

public interface CalcObject2 extends Remote {
	public ResultType calculate(InputType inputParam) throws RemoteException;
}