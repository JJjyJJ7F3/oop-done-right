package self.jjjyjj.chapter3_aggregation;

import self.jjjyjj.chapter1_what_is_an_object.User;

import java.util.ArrayList;
import java.util.List;

public class Users {
    private final List<User> users = new ArrayList<>();

    public void add(User user) {
        users.add(user);
    }

    public void greetAll() {
        users.forEach(User::greet);
    }
}
