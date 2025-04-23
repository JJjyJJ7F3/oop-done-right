package self.jjjyjj.chapter8_tdd_and_test_doubles;

import lombok.Getter;

public class MockOutput implements Output {
    @Getter
    private String actual;

    @Override
    public void display(String toDisplay) {
        this.actual = toDisplay;
    }
}
