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
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET})
@RequestMapping("api/v1/message")
@RestController
public class MessageController {

    @Autowired
    MessageService messageServiceImpl;

    @Autowired
    UserService userServiceImpl;

    @Autowired
    PublicKeyService pkServiceImpl;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = { "/{id}" })
    public ResponseEntity<?> getMessagesByConversationId(HttpServletRequest request, @PathVariable(value = "id") final int id){
        try {
            final String authorizationHeader = request.getHeader("Authorization");

            String email = null;
            String jwt = null;

            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                jwt = authorizationHeader.substring(7);
                email = EjemploCriptoWebApplication.jwtConfig.extractEmail(jwt);
                User u = userServiceImpl.findUserByEmail(email);
                if(u != null) {
                    List<Message> res = messageServiceImpl.getMessagesFromConversationId(id);
                    PublicKey pk = pkServiceImpl.getKeyByUserId(u.getId());
                    for (Message m : res) {
                        m.setContent(EjemploCriptoWebApplication.encryptionConfig.encrypt(m.getContent(), pk.getKey(), "1234567812345678"));
                    }
                    return ResponseEntity.ok(res);
                }else{
                    return ResponseEntity.ok(new ArrayList<Message>());
                }


            } else {
                return new ResponseEntity<String>("nah m8", HttpStatus.BAD_REQUEST);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<String>("nah m8", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(consumes = { "application/json" }, value = "/chat/{id}")
    public ResponseEntity<?> sendMessage(HttpServletRequest request, @PathVariable(value = "id") int chatId, @RequestBody Message m){
        try{
            final String authorizationHeader = request.getHeader("Authorization");

            String email = null;
            String jwt = null;

            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                jwt = authorizationHeader.substring(7);
                email = EjemploCriptoWebApplication.jwtConfig.extractEmail(jwt);
                User u = userServiceImpl.findUserByEmail(email);
                if(u != null) {
                    String temp = m.getContent();
                    temp = EjemploCriptoWebApplication.encryptionConfig.desEncrypt(m.getContent(), pkServiceImpl.getKeyByUserId(u.getId()).getKey(), "1234567812345678");
                    m.setContent(temp);
                    List<Message> res = messageServiceImpl.addMessage(chatId, m);
                    return ResponseEntity.ok(res);
                }
            } else {
                return new ResponseEntity<String>("nah m8", HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<String>("nah m8", HttpStatus.BAD_REQUEST);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<String>("nah m8", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping (path = "/newChat/{id}")
    public ResponseEntity<?> createConvo(HttpServletRequest request, @PathVariable(value = "id")int receiverId){
        try{
            final String authorizationHeader = request.getHeader("Authorization");

            String email = null;
            String jwt = null;

            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                jwt = authorizationHeader.substring(7);
                email = EjemploCriptoWebApplication.jwtConfig.extractEmail(jwt);
                User u = userServiceImpl.findUserByEmail(email);
                if(u != null) {
                    User receiver = userServiceImpl.findUserById(receiverId);
                    if(receiver != null){
                        int[] parties = new int[2];
                        parties[0] = u.getId();
                        parties[1] = receiver.getId();
                        messageServiceImpl.createConvo(parties);
                    }else{
                        return new ResponseEntity<String>("nah m8", HttpStatus.BAD_REQUEST);
                    }
                    ArrayList<Chat> res = messageServiceImpl.getChatsByUserId(u.getId());
                    if(!res.isEmpty()){
                        return ResponseEntity.ok(res);
                    }else{
                        return new ResponseEntity<String>("nah m8", HttpStatus.BAD_REQUEST);
                    }
                }else{
                    return new ResponseEntity<String>("nah m8", HttpStatus.BAD_REQUEST);
                }
            } else {
                return new ResponseEntity<String>("nah m8", HttpStatus.BAD_REQUEST); //ResponseEntity.ok(null);
            }
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<String>("nah m8", HttpStatus.BAD_REQUEST);
        }
    }
}
