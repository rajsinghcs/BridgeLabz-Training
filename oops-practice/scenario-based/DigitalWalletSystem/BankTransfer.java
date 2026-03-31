class BankTransfer implements TransferService {
    @Override
    public void transfer(Wallet from, Wallet to, double amount)
            throws InsufficientBalanceException {

        from.withdrawMoney(amount);
        System.out.println("Transferred Rs- " + amount + " to bank account");
    }
}
