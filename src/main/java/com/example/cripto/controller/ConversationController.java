package com.example.cripto.controller;

import com.example.cripto.EjemploCriptoWebApplication;
import com.example.cripto.model.Chat;
import com.example.cripto.model.Message;
import com.example.cripto.model.PublicKey;
import com.example.cripto.model.User;
import com.example.cripto.service.MessageService;
import com.example.cripto.service.PublicKeyService;
import com.example.cripto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Array;
import java.util.ArrayList;

@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET})
@RequestMapping("api/v1/chats")
@RestController
public class ConversationController {

    @Autowired
    MessageService messageServiceImpl;

    @Autowired
    UserService userServiceImpl;

    @Autowired
    PublicKeyService pkSeviceImpl;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getChatsByUserSession(HttpServletRequest request){
        try {
            final String authorizationHeader = request.getHeader("Authorization");

            String email = null;
            String jwt = null;

            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                jwt = authorizationHeader.substring(7);
                email = EjemploCriptoWebApplication.jwtConfig.extractEmail(jwt);
                User u = userServiceImpl.findUserByEmail(email);
                if(u != null) {
                    ArrayList<Chat> res = messageServiceImpl.getChatsByUserId(u.getId());
                    if(!res.isEmpty()){
                        return ResponseEntity.ok(res);
                    }else{
                        return ResponseEntity.ok(new ArrayList<Chat>());
                    }

                }else{
                    return new ResponseEntity<String>("nah m8", HttpStatus.BAD_REQUEST);
                }


            } else {
                return new ResponseEntity<String>("nah m8", HttpStatus.BAD_REQUEST);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<String>("nah m8", HttpStatus.BAD_REQUEST);
        }
    }
}
