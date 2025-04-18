package self.jjjyjj.chapter3_aggregation;

import org.junit.jupiter.api.Test;
import self.jjjyjj.chapter1_what_is_an_object.User;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Test class for the Users class.
 * Contains tests for the functionality provided by the Users class.
 */
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

    /**
     * Tests that users are correctly sorted by age in ascending order.
     */
    @Test
    void getUsersSortedByAge_ShouldReturnUsersSortedByAge() {
        // Arrange
        Users users = new Users();

        User user1 = new User("Alice", 30, LocalDate.of(1993, 5, 15));
        User user2 = new User("Bob", 25, LocalDate.of(1998, 3, 10));
        User user3 = new User("Charlie", 35, LocalDate.of(1988, 7, 22));

        users.add(user1); // 30 years old
        users.add(user2); // 25 years old
        users.add(user3); // 35 years old

        // Act
        List<User> sortedUsers = users.getUsersSortedByAge();

        // Assert
        assertEquals(3, sortedUsers.size());
        assertEquals("Bob", sortedUsers.get(0).getName()); // Youngest (25)
        assertEquals("Alice", sortedUsers.get(1).getName()); // Middle (30)
        assertEquals("Charlie", sortedUsers.get(2).getName()); // Oldest (35)
    }
}
