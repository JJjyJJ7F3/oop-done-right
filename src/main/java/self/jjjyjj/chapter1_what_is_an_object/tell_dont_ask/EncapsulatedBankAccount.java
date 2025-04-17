package self.jjjyjj.chapter1_what_is_an_object.tell_dont_ask;

class EncapsulatedBankAccount {
    private double balance;

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            throw new IllegalStateException("Insufficient funds");
        }
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void transfer(EncapsulatedBankAccount recipient, double amount) {
        withdraw(amount);
        recipient.deposit(amount);
    }
}

class BankTransferService {
    public void transfer(EncapsulatedBankAccount from, EncapsulatedBankAccount to, double amount) {
        // Telling the object what to do
        from.transfer(to, amount);
    }
}