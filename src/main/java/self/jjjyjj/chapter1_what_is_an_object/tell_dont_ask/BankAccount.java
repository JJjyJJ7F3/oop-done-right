package self.jjjyjj.chapter1_what_is_an_object.tell_dont_ask;

class BankAccount {
    private double balance;
    
    public double getBalance() {
        return balance;
    }
    
    public void setBalance(double balance) {
        this.balance = balance;
    }
}

class TransferService {
    public void transfer(BankAccount from, BankAccount to, double amount) {
        // Asking for state and making decisions outside
        if (from.getBalance() >= amount) {
            from.setBalance(from.getBalance() - amount);
            to.setBalance(to.getBalance() + amount);
        } else {
            throw new IllegalStateException("Insufficient funds");
        }
    }
}