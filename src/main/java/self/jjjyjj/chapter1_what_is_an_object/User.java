package self.jjjyjj.chapter1_what_is_an_object;

public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public void greet() {
        System.out.println("Hello, " + name);
    }
}
