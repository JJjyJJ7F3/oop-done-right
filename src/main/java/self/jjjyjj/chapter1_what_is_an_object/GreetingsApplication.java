package self.jjjyjj.chapter1_what_is_an_object;

/**
 * A simple application that demonstrates the use of the User class.
 * This class serves as an entry point to show basic object instantiation and method invocation.
 */
public class GreetingsApplication {
    /**
     * The main method that creates a User object and calls its greet method.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        // Create a new User object with the name "John"
        User user = new User("John");

        // Call the greet method to display a greeting message
        user.greet();
    }
}
