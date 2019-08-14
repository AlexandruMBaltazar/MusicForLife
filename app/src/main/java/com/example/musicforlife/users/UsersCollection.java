package com.example.musicforlife.users;

import java.util.HashMap;

public class UsersCollection {

    private static HashMap<String, User> users = new HashMap<>();
    private static User currentUser = new User();

    public static HashMap<String, User> getUsers() {
        return users;
    }

    public static void addUsers(String key, User user){
        users.put(key, user);
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User user) {
        currentUser = user;
    }
}
