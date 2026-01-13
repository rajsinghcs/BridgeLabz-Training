public class DigitalWalletSystem {
    public static void main(String[] args) {

        User u1 = new User(1, "Raj");
        User u2 = new User(2, "Aman");

        Wallet w1 = new Wallet(u1);
        Wallet w2 = new Wallet(u2);

        w1.addMoney(5000);

        WalletService service =
                new WalletService(new WalletTransfer());

        try {
            service.transferMoney(w1, w2, 2000);
            service.transferMoney(w1, w2, 4000); 
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Balance: Rs- " + w1.getBalance());
        w1.showTransactions();
    }
}
