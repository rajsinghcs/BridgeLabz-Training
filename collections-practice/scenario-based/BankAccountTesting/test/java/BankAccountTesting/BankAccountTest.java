import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    @Test
    public void Test_Deposit_ValidAmount() {
        BankAccount account = new BankAccount(100.0);
        account.deposit(50.0);
        assertEquals(150.0, account.getBalance(), "Balance should be updated correctly after deposit");
    }

    @Test
    public void Test_Deposit_NegativeAmount() {
        BankAccount account = new BankAccount(100.0);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-50.0);
        });
        assertEquals("Deposit amount cannot be negative", exception.getMessage());
    }

    @Test
    public void Test_Withdraw_ValidAmount() {
        BankAccount account = new BankAccount(100.0);
        account.withdraw(40.0);
        assertEquals(60.0, account.getBalance(), "Balance should be updated correctly after withdrawal");
    }

    @Test
    public void Test_Withdraw_InsufficientFunds() {
        BankAccount account = new BankAccount(100.0);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(200.0);
        });
        assertEquals("Insufficient funds", exception.getMessage());
    }
}