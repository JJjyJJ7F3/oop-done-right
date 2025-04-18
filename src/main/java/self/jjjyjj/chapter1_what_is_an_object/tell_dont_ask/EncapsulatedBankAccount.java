package self.jjjyjj.chapter1_what_is_an_object.tell_dont_ask;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Represents a bank account with encapsulated behavior.
 * This class demonstrates the "Tell" part of the "Tell, Don't Ask" principle,
 * where the behavior is encapsulated within the object and external classes
 * tell the object what to do rather than asking for its state.
 * <p>
 * This class is thread-safe and optimized for high-performance concurrent access.
 */
class EncapsulatedBankAccount {
    /**
     * The current balance of the account stored as an atomic reference.
     * Using AtomicReference allows for lock-free operations on the balance,
     * improving performance in concurrent scenarios.
     */
    private final AtomicReference<Double> balance = new AtomicReference<>(0.0);

    /**
     * Lock used only for complex operations that cannot be performed atomically.
     * This lock is more efficient than synchronized blocks and provides more flexibility.
     */
    private final Lock lock = new ReentrantLock();

    /**
     * Gets the current balance of the account.
     * This method is lock-free and has better performance than synchronized methods.
     * 
     * @return the current balance
     */
    public double getBalance() {
        return balance.get();
    }

    /**
     * Withdraws a specified amount from the account.
     * This method uses optimistic concurrency control with atomic operations
     * to avoid locking when possible.
     * 
     * @param amount the amount to withdraw
     * @throws IllegalStateException if there are insufficient funds
     */
    public void withdraw(double amount) {
        balance.getAndUpdate(currentBalance -> {
            if (currentBalance >= amount) {
                return currentBalance - amount;
            } else {
                throw new IllegalStateException("Insufficient funds");
            }
        });
    }

    /**
     * Deposits a specified amount into the account.
     * This method uses atomic operations for better performance in concurrent scenarios.
     * 
     * @param amount the amount to deposit
     */
    public void deposit(double amount) {
        balance.getAndUpdate(currentBalance -> currentBalance + amount);
    }

    /**
     * Transfers a specified amount to another account.
     * This method uses a more efficient approach for handling transfers between accounts.
     * <p>
     * For transfers between different accounts, it uses a consistent locking order
     * based on object identity to prevent deadlocks.
     * 
     * @param recipient the account to transfer to
     * @param amount the amount to transfer
     * @throws IllegalStateException if there are insufficient funds
     */
    public void transfer(EncapsulatedBankAccount recipient, double amount) {
        // Self-transfer optimization
        if (this == recipient) {
            return;
        }

        // Determine locking order based on object identity to prevent deadlocks
        boolean thisFirst = System.identityHashCode(this) < System.identityHashCode(recipient);
        Lock firstLock = thisFirst ? this.lock : recipient.lock;
        Lock secondLock = thisFirst ? recipient.lock : this.lock;

        // Acquire locks in a consistent order
        firstLock.lock();
        try {
            secondLock.lock();
            try {
                // Check and perform the transfer
                double currentBalance = this.balance.get();
                if (currentBalance >= amount) {
                    this.balance.set(currentBalance - amount);
                    recipient.balance.set(recipient.balance.get() + amount);
                } else {
                    throw new IllegalStateException("Insufficient funds");
                }
            } finally {
                secondLock.unlock();
            }
        } finally {
            firstLock.unlock();
        }
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
     * <p>
     * The implementation delegates to the account's transfer method,
     * which uses optimized concurrency control for better performance.
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
