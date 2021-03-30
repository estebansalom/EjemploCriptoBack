package com.example.cripto.controller;

import com.example.cripto.model.AuthResponse;
import com.example.cripto.model.Credentials;
import com.example.cripto.model.User;
import com.example.cripto.service.PublicKeyService;
import com.example.cripto.service.UserService;
import com.example.cripto.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;


@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET})
@RequestMapping("api/v1/user")
@RestController
public class UserController {

    @Autowired
    private UserService userServiceImpl;

    @Autowired
    private PublicKeyService pkServiceImpl;

    @PostMapping( consumes={"application/json"})
    public int addUser(@RequestBody User u) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        userServiceImpl.addUser(u);
        pkServiceImpl.generateKey(u.getEmail() + u.getIdentificacion());
        return 1;
    }

    @PostMapping(path ="/login", consumes={"application/json"})
    public ResponseEntity<?> login(@RequestBody Credentials c){
        if(!c.getEmail().isEmpty() && !c.getEmail().isBlank() && !c.getPassword().isEmpty() && !c.getPassword().isBlank()){
            User search = userServiceImpl.findUserByEmail(c.getEmail());
            if(search.getPassword().equals(c.getPassword()) && search.getEmail().equals(c.getEmail())){
                return ResponseEntity.ok(new AuthResponse(userServiceImpl.login(c.getEmail(), c.getPassword()), pkServiceImpl.getKeyByUserId(userServiceImpl.findUserByEmail(c.getEmail()).getId()).getKey()));
            }else{
                return new ResponseEntity<String>("nah m8", HttpStatus.BAD_REQUEST);
            }
            }else{
            return new ResponseEntity<String>("nah m8", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ArrayList<User> getUsers(){
        return userServiceImpl.getUsers();
    }

}
