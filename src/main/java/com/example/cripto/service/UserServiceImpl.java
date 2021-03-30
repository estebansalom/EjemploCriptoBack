package com.example.cripto.service;

import com.example.cripto.EjemploCriptoWebApplication;
import com.example.cripto.dto.UserDto;
import com.example.cripto.model.User;
import com.example.cripto.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public int addUser(User u){
        userRepository.save(new UserDto(u));
        return 1;
    }

    public String login(String email, String password) {
        User loggedUser = new User(userRepository.findOneByEmail(email));
        return EjemploCriptoWebApplication.jwtConfig.generateToken(loggedUser);
    }

    @Override
    public User findUserByEmail(String email) {
        return new User(userRepository.findOneByEmail(email));
    }

    public ArrayList<User> getUsers(){
        List<UserDto> users = userRepository.findAll();
        ArrayList<User> res = new ArrayList<User>();
        if(users != null){
            for(UserDto u : users){
                User newUsr = new User(u);
                res.add(newUsr);
            }
        }

        return res;
    }

    public User findUserById(int id){
        return new User(userRepository.getOne(id));
    }
}
