package self.jjjyjj.chapter5_test_driven_development;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BillCalculatorTest {
    @Test
    public void totalStartsAtZero() {
        // Arrange
        BillCalculator calculator = new BillCalculator();

        // Act
        float total = calculator.getTotal();

        // Assert
        assertThat(total).isZero();
    }
}
