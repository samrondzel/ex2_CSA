import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalcObjImpl2 extends UnicastRemoteObject implements CalcObject2 {
	public CalcObjImpl2() throws RemoteException {
		super();
	}
	
	public ResultType calculate(InputType inParam) throws RemoteException {
		
		double zm1, zm2;
		
		ResultType res = new ResultType();
		
		zm1 = inParam.getx1();
		zm2 = inParam.getx2();
		
		res.result_description = "Operation "+inParam.operation;
		switch (inParam.operation) {
			case "add" :
				res.result = zm1 + zm2;
				break;
			case "sub" :
				res.result = zm1 - zm2;
				break;
			default :
				res.result = 0;
				res.result_description = "Bad operation is specified!";
				return res;
		}
		return res;
	}
}