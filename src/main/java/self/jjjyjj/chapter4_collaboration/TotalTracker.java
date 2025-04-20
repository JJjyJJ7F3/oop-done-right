package self.jjjyjj.chapter4_collaboration;

/**
 * Interface that tracks the total amount of money spent.
 */
public interface TotalTracker {
    void addAmount(Money money);

    void printTotal(Printer printer);
}
