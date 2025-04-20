package self.jjjyjj.chapter4_collaboration;

import java.math.BigDecimal;

/**
 * Class that represents a monetary amount.
 */
public class Money {
    private final BigDecimal amount;
    private final String currency;

    public Money(BigDecimal amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public void print(Printer p) {
        p.print(amount.toPlainString());
        p.print(" ");
        p.print(currency);
    }

    public void addToTracker(TotalTracker tracker) {
        tracker.addAmount(this);
    }

    public Money add(Money other) {
        if (currency.equals(other.currency)) {
            return new Money(amount.add(other.amount), currency);
        } else {
            throw new IllegalArgumentException("Cannot add money of different currencies");
        }
    }
}
