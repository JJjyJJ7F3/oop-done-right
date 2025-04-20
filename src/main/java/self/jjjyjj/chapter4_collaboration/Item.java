package self.jjjyjj.chapter4_collaboration;

/**
 * A simple item class that can be printed.
 */
public class Item {
    private final String description;
    private final Money price;

    public Item(String description, Money price) {
        this.description = description;
        this.price = price;
    }

    public void print(Printer p) {
        // TODO
    }
}
