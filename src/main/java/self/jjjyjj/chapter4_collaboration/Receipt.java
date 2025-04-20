package self.jjjyjj.chapter4_collaboration;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that able to add some items and print them all.
 * The same printer is used to print out the entire receipt.
 *
 */
public class Receipt {
    private final Printer printer;
    private final List<Item> items = new ArrayList<>();
    private final TotalTracker totalTracker = new ReceiptTotal();

    public Receipt(Printer printer) {
        this.printer = printer;
    }

    /**
     * This method is an example of applying the "Call don't ask".
     */
    public void print() {
        items.forEach(item -> item.print(printer));
        totalTracker.printTotal(printer);
    }

    public void add(String description, Money price) {
        items.add(new Item(description, price));
        price.addToTracker(totalTracker);
    }


}
