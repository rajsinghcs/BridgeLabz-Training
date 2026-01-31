import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BankAccountTest {

    @Test
    void testDeposit() {
        BankAccount account = new BankAccount(100);

        account.deposit(50);

        assertEquals(150, account.getBalance());
    }

    @Test
    void testWithdraw() {
        BankAccount account = new BankAccount(200);

        account.withdraw(80);

        assertEquals(120, account.getBalance());
    }

    @Test
    void testWithdrawInsufficientFunds() {
        BankAccount account = new BankAccount(100);

        assertThrows(IllegalStateException.class, () -> {
            account.withdraw(150);
        });
    }
}
