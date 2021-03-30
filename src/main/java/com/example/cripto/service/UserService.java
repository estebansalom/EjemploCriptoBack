package com.example.cripto.service;

import com.example.cripto.model.User;

import java.util.ArrayList;
import java.util.List;

public interface UserService {
    int addUser(User u);
    ArrayList<User> getUsers();
    String login(String email, String password);
    User findUserByEmail(String email);
    User findUserById(int id);
}
