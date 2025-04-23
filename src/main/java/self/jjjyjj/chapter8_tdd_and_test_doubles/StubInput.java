package self.jjjyjj.chapter8_tdd_and_test_doubles;

public class StubInput implements Input {
    private final String stubInput;

    public StubInput(String stubInput) {
        this.stubInput = stubInput;
    }

    @Override
    public String fetch() {
        return stubInput;
    }
}
