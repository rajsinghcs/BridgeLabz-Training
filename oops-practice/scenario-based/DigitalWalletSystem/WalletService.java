class WalletService {
    private TransferService transferService;

    public WalletService(TransferService transferService) {
        this.transferService = transferService;
    }

    public void transferMoney(
            Wallet from,
            Wallet to,
            double amount
    ) throws InsufficientBalanceException {

        transferService.transfer(from, to, amount);
    }
}
