package self.jjjyjj.chapter3_aggregation;

import org.junit.jupiter.api.Test;
import self.jjjyjj.chapter1_what_is_an_object.User;

import static org.mockito.Mockito.*;

class UsersTest {

    /**
     * Class Description:
     * The Users class manages a list of User objects and provides the ability to trigger greetings from all users via the `greetAll` method.
     * <p>
     * Method Under Test:
     * `greetAll()` - Iterates over the list of users and calls the `greet` method on each User object in the list.
     */

    @Test
    void greetAll_ShouldCallGreetOnSingleUser() {
        // Arrange
        User mockUser = mock(User.class);
        Users users = new Users();
        users.add(mockUser);

        // Act
        users.greetAll();

        // Assert
        verify(mockUser, times(1)).greet();
    }

    @Test
    void greetAll_ShouldCallGreetOnMultipleUsers() {
        // Arrange
        User mockUser1 = mock(User.class);
        User mockUser2 = mock(User.class);
        Users users = new Users();
        users.add(mockUser1);
        users.add(mockUser2);

        // Act
        users.greetAll();

        // Assert
        verify(mockUser1, times(1)).greet();
        verify(mockUser2, times(1)).greet();
    }

    @Test
    void greetAll_ShouldNotFailWithNoUsers() {
        // Arrange
        Users users = new Users();

        // Act & Assert (No exception should be thrown)
        users.greetAll();
    }
}