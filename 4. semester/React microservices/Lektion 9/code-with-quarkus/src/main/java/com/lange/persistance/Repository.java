package com.lange.persistance;

import com.lange.domain.*;

import javax.enterprise.context.Dependent;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Dependent
public class Repository {
    private final Map<ID, User> userMap;

    public Repository() {
        this.userMap = new HashMap<>();
    }

public boolean UserExsit(Username username, Email email) {
        return userMap.values().stream().anyMatch(u -> u.getUserName().equals(username) || u.getEmail().equals(email));
}

    public User createUser(Username username, Email email, Password password) {
        User u = new User(password, username, email, new ID(UUID.randomUUID()));
        userMap.put(u.getUserID(), u);
        return  u;

    }

    public User findUser(Email email, Username username, Password password) {
        User user = null;
        try {
        for (User u : userMap.values()) {
            if (u.getUserName().equals(username) || u.getEmail().equals(email)) {
                user = u;
                break;
            }
        }
        if (user.getPassword().equals(password)) {
            return user;
        }
            return null;
        }
        catch (Exception e) {
            return null;
        }

    }
/*
    private boolean verifyPass() {

    }*/
}
