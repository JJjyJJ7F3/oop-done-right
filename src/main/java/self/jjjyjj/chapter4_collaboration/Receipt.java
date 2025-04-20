package self.jjjyjj.chapter4_collaboration;

/**
 * Class that able to add some items and print them all.
 * The same printer is used to print out the entire receipt.
 *
 */
public class Receipt {
    private final Printer printer;

    public Receipt(Printer printer) {
        this.printer = printer;
    }

    public void print() {
        // TODO - using field printer to print out the receipt
    }

    public void add(String description, Money price) {
        // TODO
    }


}
