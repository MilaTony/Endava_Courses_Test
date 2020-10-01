package com.company;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Application {

    ArrayList<User> users;

    public Application(ArrayList<User> users) {
        for (User user : users) {
            if (user.getStatus().equals("NEW") && isRegisteredMoreThanDay(user)) {
                user.setStatus("ACTIVE");
            } else if (user.getStatus().equals("INACTIVE") && isRegisteredMoreThanMonth(user)) {
                user.setStatus("BLOCKED");
            }
        }

        this.users = users;
    }

    public void printUsers() {
        for (User user : users) {
            System.out.println(user.toString());
        }
    }

    private boolean isRegisteredMoreThanDay(User user) {
        return ChronoUnit.DAYS.between(user.getTimestamp(), LocalDate.now()) > 1;
    }

    private boolean isRegisteredMoreThanMonth(User user) {
        return ChronoUnit.MONTHS.between(user.getTimestamp(), LocalDate.now()) > 1;
    }

}
