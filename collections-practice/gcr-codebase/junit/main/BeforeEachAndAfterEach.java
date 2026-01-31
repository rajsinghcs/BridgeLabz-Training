public class BeforeEachAndAfterEach {
	
	private static boolean status = false;
	public void connect() {
		status = true;
		System.out.println("Connect Successfully");
	}
	
	public void disconnect() {
		status = false;
		System.out.println("Disconnect Successfully");
	}
	
	public boolean isConnected() {
		return status;
	}
}
