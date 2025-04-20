package self.jjjyjj.chapter4_collaboration;

import lombok.Getter;

import java.math.BigDecimal;

/**
 * Class that represents a monetary amount.
 */
public class Money {
    @Getter
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

}
