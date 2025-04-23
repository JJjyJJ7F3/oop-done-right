package self.jjjyjj.chapter8_tdd_and_test_doubles;

public class TextConversion {
    private final Input input;
    private final Output output;

    public TextConversion(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public void showInputInUpperCase() {
        output.display(input.fetch().toUpperCase());
    }
}
