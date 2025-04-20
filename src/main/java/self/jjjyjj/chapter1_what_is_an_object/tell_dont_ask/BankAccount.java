package self.jjjyjj.chapter1_what_is_an_object.tell_dont_ask;

import lombok.Data;

/**
 * Represents a bank account with a balance.
 * This class demonstrates the "Ask" part of the "Tell, Don't Ask" principle,
 * where external classes ask for the state and make decisions based on it.
 */
@Data
class BankAccount {
    /**
     * The current balance of the account
     */
    private double balance;
}

/**
 * Service class that handles transfers between bank accounts.
 * This class demonstrates a violation of the "Tell, Don't Ask" principle
 * by asking for the state of the BankAccount objects and making decisions
 * based on that state.
 */
class TransferService {
    /**
     * Transfers a specified amount from one account to another.
     * This method asks for the state of the 'from' account to check if there are enough funds,
     * which violates the "Tell, Don't Ask" principle.
     * 
     * @param from the account to transfer money from
     * @param to the account to transfer money to
     * @param amount the amount to transfer
     * @throws IllegalStateException if the 'from' account has insufficient funds
     */
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
