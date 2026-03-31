class LegacyAPI{
	
	@Deprecated
	void oldFeature() {
		System.out.println("Old method");
	}
	
	void newFeature() {
		System.out.println("New method");
	}
	
}

public class DeprecatedAnnotate {
	public static void main(String[] args) {
		LegacyAPI legacyAPI = new LegacyAPI();
		legacyAPI.oldFeature();
		legacyAPI.newFeature();
	}
}
