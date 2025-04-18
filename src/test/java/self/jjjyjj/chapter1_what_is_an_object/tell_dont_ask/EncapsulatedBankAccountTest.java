package self.jjjyjj.chapter1_what_is_an_object.tell_dont_ask;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Test class for the EncapsulatedBankAccount class.
 * Contains tests to verify thread safety and proper handling of concurrent operations.
 */
class EncapsulatedBankAccountTest {

    /**
     * Tests that concurrent deposits to the same account are handled correctly.
     * Multiple threads deposit the same amount, and the final balance should be
     * the sum of all deposits.
     */
    @Test
    void concurrentDeposits_ShouldResultInCorrectBalance() throws InterruptedException {
        // Arrange
        final int threadCount = 10;
        final double depositAmount = 100.0;
        final double expectedFinalBalance = threadCount * depositAmount;
        
        EncapsulatedBankAccount account = new EncapsulatedBankAccount();
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        CountDownLatch latch = new CountDownLatch(threadCount);
        
        // Act
        for (int i = 0; i < threadCount; i++) {
            executor.submit(() -> {
                try {
                    account.deposit(depositAmount);
                } finally {
                    latch.countDown();
                }
            });
        }
        
        // Wait for all threads to complete
        latch.await(5, TimeUnit.SECONDS);
        executor.shutdown();
        
        // Assert
        assertEquals(expectedFinalBalance, account.getBalance(), 
                "Final balance should be equal to the sum of all deposits");
    }
    
    /**
     * Tests that concurrent transfers between accounts are handled correctly.
     * Multiple threads transfer money between the same two accounts in both directions,
     * and the final total balance should remain the same.
     */
    @Test
    void concurrentTransfers_ShouldMaintainTotalBalance() throws InterruptedException {
        // Arrange
        final int threadCount = 5;
        final double initialBalance = 1000.0;
        final double transferAmount = 50.0;
        
        EncapsulatedBankAccount account1 = new EncapsulatedBankAccount();
        EncapsulatedBankAccount account2 = new EncapsulatedBankAccount();
        
        account1.deposit(initialBalance);
        account2.deposit(initialBalance);
        
        double initialTotalBalance = account1.getBalance() + account2.getBalance();
        
        ExecutorService executor = Executors.newFixedThreadPool(threadCount * 2);
        CountDownLatch latch = new CountDownLatch(threadCount * 2);
        
        // Act
        // Half of the threads transfer from account1 to account2
        for (int i = 0; i < threadCount; i++) {
            executor.submit(() -> {
                try {
                    account1.transfer(account2, transferAmount);
                } catch (IllegalStateException e) {
                    // Ignore insufficient funds exceptions
                } finally {
                    latch.countDown();
                }
            });
        }
        
        // The other half transfer from account2 to account1
        for (int i = 0; i < threadCount; i++) {
            executor.submit(() -> {
                try {
                    account2.transfer(account1, transferAmount);
                } catch (IllegalStateException e) {
                    // Ignore insufficient funds exceptions
                } finally {
                    latch.countDown();
                }
            });
        }
        
        // Wait for all threads to complete
        latch.await(5, TimeUnit.SECONDS);
        executor.shutdown();
        
        // Assert
        double finalTotalBalance = account1.getBalance() + account2.getBalance();
        assertEquals(initialTotalBalance, finalTotalBalance, 
                "Total balance of both accounts should remain the same after transfers");
    }
    
    /**
     * Tests that concurrent withdrawals from the same account are handled correctly.
     * Multiple threads attempt to withdraw from an account with limited funds,
     * and the final balance should never go below zero.
     */
    @Test
    void concurrentWithdrawals_ShouldNotResultInNegativeBalance() throws InterruptedException {
        // Arrange
        final int threadCount = 20;
        final double initialBalance = 1000.0;
        final double withdrawalAmount = 100.0;
        
        EncapsulatedBankAccount account = new EncapsulatedBankAccount();
        account.deposit(initialBalance);
        
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        CountDownLatch latch = new CountDownLatch(threadCount);
        
        // Act
        for (int i = 0; i < threadCount; i++) {
            executor.submit(() -> {
                try {
                    account.withdraw(withdrawalAmount);
                } catch (IllegalStateException e) {
                    // Ignore insufficient funds exceptions
                } finally {
                    latch.countDown();
                }
            });
        }
        
        // Wait for all threads to complete
        latch.await(5, TimeUnit.SECONDS);
        executor.shutdown();
        
        // Assert
        assertTrue(account.getBalance() >= 0, 
                "Final balance should not be negative");
        
        // The final balance should be either 0 or a multiple of the withdrawal amount
        double expectedRemainder = initialBalance % withdrawalAmount;
        // If the initial balance is divisible by the withdrawal amount,
        // the final balance should be 0 or a multiple of the withdrawal amount
        assertEquals(0, account.getBalance() % withdrawalAmount, 0.001,
                "Final balance should be a multiple of the withdrawal amount");
    }
}