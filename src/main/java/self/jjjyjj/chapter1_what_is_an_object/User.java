package self.jjjyjj.chapter1_what_is_an_object;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Represents a user in the system.
 * This class demonstrates basic object-oriented principles and is used
 * throughout the application to show various OOP concepts.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    /**
     * The name of the user
     */
    private String name;

    /**
     * The age of the user in years
     */
    private int age;

    /**
     * The birthday of the user
     */
    private LocalDate birthday;

    /**
     * Constructor that only initializes the name
     * @param name the name of the user
     */
    public User(String name) {
        this.name = name;
    }

    /**
     * Prints a greeting message to the console
     */
    public void greet() {
        System.out.println("Hello, " + name);
    }
}
