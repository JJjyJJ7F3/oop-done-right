package self.jjjyjj.chapter5_test_driven_development;

import lombok.Getter;

/**
 * Class that calculates restaurant bills.
 */
@Getter
public class Bill {
    private float total;

    public void add(float amount) {
        total = amount;
    }
}
