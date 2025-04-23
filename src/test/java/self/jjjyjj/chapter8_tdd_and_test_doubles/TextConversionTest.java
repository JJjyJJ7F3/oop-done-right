package self.jjjyjj.chapter8_tdd_and_test_doubles;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class TextConversionTest {
    @Mock
    private Input input;

    @Mock
    private Output output;

    @BeforeEach
    public void beforeEachTest() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void displayUpperCasedInput() {
        // Arrange
        Mockito.when(input.fetch()).thenReturn("hello world");
        var tc = new TextConversion(input, output);

        // Act
        tc.showInputInUpperCase();

        // Assert
        Mockito.verify(output, Mockito.times(1)).display("HELLO WORLD");
    }
}