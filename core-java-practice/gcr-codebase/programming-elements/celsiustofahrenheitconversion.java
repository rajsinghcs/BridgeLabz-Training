import java.util.*;
public class celsiustofahrenheitconversion {
    public static void main(String[] args) {    
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter temperature in Celsius: ");
        double celsius = scanner.nextDouble();
        
        //formula to convert Celsius to Fahrenheit
        double fahrenheit = (celsius * 9/5) + 32;
        System.out.println(celsius + " degree Celsius is equal to " + fahrenheit + " degree Fahrenheit.");
    }
}
