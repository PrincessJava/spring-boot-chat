package ru.home.chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.home.chat.model.User;
import ru.home.chat.service.MessageService;
import ru.home.chat.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("chat")
public class ChatController {

    private UserService userService;

    private MessageService messageService;

    @Autowired
    public ChatController(UserService userService, MessageService messageService) {
        this.userService = userService;
        this.messageService = messageService;
    }

    @PostMapping(path = "login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> login(@RequestParam("name") String name) {
        if (name.length() < 1 || name.length() > 20) {
            return ResponseEntity.badRequest()
                    .body("Invalid name length");
        }

        User alreadyLoggedIn = userService.getLoggedIn(name);
        if (alreadyLoggedIn != null) {
            return ResponseEntity.badRequest()
                    .body("Already logged in");
        }
        userService.login(name);

        return ResponseEntity.ok().build();
    }

    @PostMapping(path = "logout", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity logout(@RequestParam("name") String name) {
        return ResponseEntity.badRequest().build();
    }

    @GetMapping(path = "online", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity online() {
        List<User> online = userService.getOnlineUsers();
        String responseBody = online.stream()
                .map(User::getLogin)
                .collect(Collectors.joining("\n"));

        return ResponseEntity.ok().body(responseBody);
    }

    @PostMapping(path = "say", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity say(@RequestParam("name") String name, @RequestParam("msg") String msg) {
        messageService.say(name, msg);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "chat", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> chat() {

        return ResponseEntity.badRequest().build();
    }

}
