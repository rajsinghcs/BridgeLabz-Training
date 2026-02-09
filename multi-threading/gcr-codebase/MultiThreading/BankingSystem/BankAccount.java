import java.time.LocalDateTime;

public class BankAccount {
    private int balance = 10000;
    public int getBalance(){
        return balance;
    }

    public boolean withdraw(String customer, int amount){
        if(balance >= amount){
            try{
                Thread.sleep(300);
            }catch(InterruptedException e){
                e.printStackTrace();
            }

            balance -= amount;
            System.out.println("Transaction successful: " + customer + ", Amount: " + amount + ", Balance: " + balance + ", Time: " + LocalDateTime.now());
            return true;
        }
        else{
            System.out.println("Transaction failed: " + customer +
                    ", Amount: " + amount +
                    ", Balance: " + balance +
                    ", Time: " + LocalDateTime.now());
                    return false;
        }
    }
}
