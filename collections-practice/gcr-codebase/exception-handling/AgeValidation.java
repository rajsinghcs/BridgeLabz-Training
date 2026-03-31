import java.util.*;
import java.io.*;
class InvalidAgeException extends Exception{
    InvalidAgeException(String message){
        super(message);
    }
}
public class AgeValidation {
    public static void validAge(int age) throws InvalidAgeException{
        if(age < 18){
            throw new InvalidAgeException("Age must be 18 or above");
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        try{
            int age = sc.nextInt();
            validAge(age);
            System.out.println("Access granted!");  
        }catch(InvalidAgeException e){
            System.out.println(e.getMessage());
        }

    }
}
