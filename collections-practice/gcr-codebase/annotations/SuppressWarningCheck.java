import java.util.*;
public class SuppressWarningCheck {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
	
		ArrayList list = new ArrayList();
		list.add(10);
		list.add("10");
		
		for (Object obj : list) {
            System.out.println(obj);
        }
	}
}
