class WalletTransfer implements TransferService {
    @Override
    public void transfer(Wallet from, Wallet to, double amount)
            throws InsufficientBalanceException {

        from.withdrawMoney(amount);
        to.addMoney(amount);

        from.recordTransaction(new Transaction("WALLET TRANSFER OUT", amount));
        to.recordTransaction(new Transaction("WALLET TRANSFER IN", amount));
    }
}
