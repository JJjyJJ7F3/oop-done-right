package self.jjjyjj.chapter4_collaboration;

public class ReceiptDemo {
    public static void main(String[] args) {
        Receipt receipt = new Receipt(new Printer());
        receipt.add("Pencil", new Money("1.99", "USD"));
        receipt.add("Pen", new Money("2.99", "USD"));
        receipt.add("Pencil", new Money("1.99", "USD"));

        receipt.print();
        // Output:
        // Pencil 1.99 USD
        // Pen 2.99 USD
        // Pencil 1.99 USD

    }
}
