package com.company;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        User user = new User("hello", "world", "hello.worldovich@mail.ru", "NEW", LocalDate.of(2020, 9, 29), 40);
        User anotherUser = new User("another", "user", "another.user@mail.ru", "OLD",  LocalDate.of(2020, 8, 9), 32);

        // won't be change status, because now it is 1 october
        User anotherOtherUser = new User("another", "other", "anotherOther.user@mail.ru", "NEW",  LocalDate.of(2020, 10, 1), 42);

        // will be changed, registered more than a month ago
        User inactiveUser = new User("inactive", "user", "inactive.user@mail.ru", "INACTIVE",  LocalDate.of(2020, 8, 1), 38);

        // won't be changed
        User activeLastMonth = new User("active", "user", "active.user@mail.ru", "INACTIVE",  LocalDate.of(2020, 9, 1), 26);

        // fill array list of users
        ArrayList<User> users = new ArrayList<>();
        users.add(user);
        users.add(anotherUser);
        users.add(anotherOtherUser);
        users.add(inactiveUser);
        users.add(activeLastMonth);

        Application app = new Application(users);

        app.printUsers();
    }
}
