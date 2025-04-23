package self.jjjyjj.chapter8_tdd_and_test_doubles;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextConversionTest {
    @Test
    public void displayUpperCasedInput() {
        // Arrange
        var input = new StubInput("Hello World!");
        var output = new MockOutput();
        var textConversion = new TextConversion(input, output);

        // Act
        textConversion.showInputInUpperCase();

        // Assert
        assertEquals("HELLO WORLD!", output.getActual());
    }
}