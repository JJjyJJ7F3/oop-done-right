package self.jjjyjj.chapter3_aggregation;

import lombok.NoArgsConstructor;
import self.jjjyjj.chapter1_what_is_an_object.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A collection class that manages a group of User objects.
 * This class demonstrates the concept of aggregation in object-oriented programming,
 * where a class contains a collection of other objects.
 */
@NoArgsConstructor
public class Users {
    /**
     * The internal list that stores User objects
     */
    private final List<User> users = new ArrayList<>();

    /**
     * Adds a single user to the collection
     * 
     * @param user the User object to add
     */
    public void add(User user) {
        users.add(user);
    }

    /**
     * Calls the greet method on all users in the collection
     */
    public void greetAll() {
        users.forEach(User::greet);
    }

    /**
     * Returns a defensive copy of the users list
     * 
     * @return a new ArrayList containing all users
     */
    public List<User> getUsers() {
        return new ArrayList<>(users);
    }

    /**
     * Returns a new list of users sorted by age in ascending order
     * 
     * @return a sorted list of users by age
     */
    public List<User> getUsersSortedByAge() {
        return users.stream()
                .sorted(Comparator.comparingInt(User::getAge))
                .collect(Collectors.toList());
    }
}
