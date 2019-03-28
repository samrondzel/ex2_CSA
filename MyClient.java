
public class MyClient {
	public static void main(String[] args) {
		double result;
		CalcObject rObject;
		CalcObject2 rObject2;
		InputType inObj = new InputType();
		inObj.operation = "add";
		inObj.x1 = 100;
		inObj.x2 = 200;
		ResultType result2;
		if (args.length != 2) {
			System.out.println("You have to enter RMI object address in"
					+ "in the form: "
					+ "//host_address/service_name //host_address/service_name ");
			return;
		}
		String addr = args[0];
		String addr2 = args[1];
		// use this only if needed:
		// if (System.getSecurityManager() == null)
		//
		System.setSecurityManager(new SecurityManager());
		try {
			rObject = (CalcObject) java.rmi.Naming.lookup(addr);
			try {
				rObject2 = (CalcObject2) java.rmi.Naming.lookup(addr2);
				} catch (Exception e) {
				System.out.println("Reference to "+addr2+" can not be retrieved!");
				e.printStackTrace();
				return;
			}
			} catch (Exception e) {
			System.out.println("Reference to "+addr+" can not be retrieved!");
			e.printStackTrace();
			return;
		}
		System.out.println("Reference to "+addr+" is retrieved.");
		System.out.println("Reference to "+addr2+" is retrieved.");
		try {
			result = rObject.calculate(1.1, 2.2);
			try {
				result2 = rObject2.calculate(inObj);
			} catch (Exception e) {
				System.out.println("Remote call error!");
				e.printStackTrace();
				return;
			}
		} catch (Exception e) {
			System.out.println("Remote call error!");
			e.printStackTrace();
			return;
		}
		System.out.println("Result = "+result);
		System.out.println("Result2 = "+result2.result + "\nDescription: " + result2.result_description);
		return;
		}
}
