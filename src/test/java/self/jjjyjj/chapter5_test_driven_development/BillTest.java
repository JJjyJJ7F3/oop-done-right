package self.jjjyjj.chapter5_test_driven_development;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BillTest {
    @Test
    public void totalStartsAtZero() {
        // Arrange
        var bill = new Bill();

        // Act
        float total = bill.getTotal();

        // Assert
        assertThat(total).isZero();
    }

    @Test
    public void correctTotalForOneItem() {
        // Arrange
        var calculator = new Bill();

        // Act
        calculator.add(12.4F);
        float total = calculator.getTotal();

        // Assert
        assertThat(total).isEqualTo(12.4F);
    }
}
