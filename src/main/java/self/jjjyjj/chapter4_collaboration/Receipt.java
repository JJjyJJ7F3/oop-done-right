package self.jjjyjj.chapter4_collaboration;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that able to add some items and print them all.
 * The same printer is used to print out the entire receipt.
 *
 */
public class Receipt {
    private final Printer printer;
    private BigDecimal total = BigDecimal.ZERO;
    private final List<Item> items = new ArrayList<>();

    public Receipt(Printer printer) {
        this.printer = printer;
    }

    /**
     * This method is an example of applying the "Call don't ask".
     */
    public void print() {
        items.forEach(item -> item.print(printer));
        printer.print("------------Total: ");
        printer.print(total.toPlainString());
    }

    public void add(String description, Money price) {
        items.add(new Item(description, price));

        total = total.add(price.getAmount());
    }


}
