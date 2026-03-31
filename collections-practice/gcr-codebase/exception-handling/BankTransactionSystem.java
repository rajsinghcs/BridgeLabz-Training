import java.util.*;
class InsufficientBalanceException extends Exception{
    public InsufficientBalanceException(String message){
        super(message);
    }
}

class BankAccount{
    private double balance;

    public BankAccount(double balance){
        this.balance = balance;
    }

    public void withdrawAmount(double amount) throws InsufficientBalanceException{

        if(amount < 0){
            throw new InsufficientBalanceException("Invalid Amount");
        }
        if(amount > balance){
            throw new InsufficientBalanceException("Insufficient balance!");
        }else{
            balance -= amount;
            System.out.println("Withdrawal successful, new balance- " + balance);
        }
    }
}
public class BankTransactionSystem {
    public static void main(String[] args){
        BankAccount ba = new BankAccount(20000);

        try{
            ba.withdrawAmount(200);
        }catch(InsufficientBalanceException e){
            System.out.println(e.getMessage());
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
