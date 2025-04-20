package self.jjjyjj.chapter4_collaboration;

public class ReceiptTotal implements TotalTracker {
    private Money total = null;

    @Override
    public void addAmount(Money money) {
        if (total == null) {
            total = money;
        } else {
            total = total.add(money);
        }
    }

    @Override
    public void printTotal(Printer printer) {
        printer.print("--------------------");
        printer.newline();
        printer.print("Total: ");
        if (total != null) {
            total.print(printer);
        } else {
            printer.print("0.00");
        }
        printer.newline();
    }
}
