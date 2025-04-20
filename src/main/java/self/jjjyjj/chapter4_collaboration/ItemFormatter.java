package self.jjjyjj.chapter4_collaboration;

/**
 * Class that formats an item for printing.
 */
public class ItemFormatter {
    private final String description;
    private final Money price;

    public ItemFormatter(String description, Money price) {
        this.description = description;
        this.price = price;
    }

    public void print(Printer p) {
        p.print(description);
        p.print(" ");
        price.print(p);

        p.newline();
    }
}
