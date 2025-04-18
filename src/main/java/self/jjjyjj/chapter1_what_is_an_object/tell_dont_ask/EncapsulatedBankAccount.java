package self.jjjyjj.chapter1_what_is_an_object.tell_dont_ask;

import lombok.Getter;

/**
 * Represents a bank account with encapsulated behavior.
 * This class demonstrates the "Tell" part of the "Tell, Don't Ask" principle,
 * where the behavior is encapsulated within the object and external classes
 * tell the object what to do rather than asking for its state.
 */
class EncapsulatedBankAccount {
    /**
     * The current balance of the account.
     * This field is private and only accessible through the class's methods,
     * enforcing encapsulation.
     */
    @Getter
    private double balance;

    /**
     * Withdraws a specified amount from the account.
     * This method encapsulates the logic for checking if there are sufficient funds.
     * 
     * @param amount the amount to withdraw
     * @throws IllegalStateException if there are insufficient funds
     */
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            throw new IllegalStateException("Insufficient funds");
        }
    }

    /**
     * Deposits a specified amount into the account.
     * 
     * @param amount the amount to deposit
     */
    public void deposit(double amount) {
        balance += amount;
    }

    /**
     * Transfers a specified amount to another account.
     * This method encapsulates the transfer logic within the object.
     * 
     * @param recipient the account to transfer to
     * @param amount the amount to transfer
     * @throws IllegalStateException if there are insufficient funds
     */
    public void transfer(EncapsulatedBankAccount recipient, double amount) {
        withdraw(amount);
        recipient.deposit(amount);
    }
}

/**
 * Service class that handles transfers between encapsulated bank accounts.
 * This class demonstrates the proper use of the "Tell, Don't Ask" principle
 * by telling the account what to do rather than asking for its state.
 */
class BankTransferService {
    /**
     * Transfers a specified amount from one account to another.
     * This method tells the 'from' account to perform the transfer,
     * adhering to the "Tell, Don't Ask" principle.
     * 
     * @param from the account to transfer money from
     * @param to the account to transfer money to
     * @param amount the amount to transfer
     */
    public void transfer(EncapsulatedBankAccount from, EncapsulatedBankAccount to, double amount) {
        // Telling the object what to do
        from.transfer(to, amount);
    }
}
