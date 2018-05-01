package ru.home.chat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.home.chat.dao.MessageDao;
import ru.home.chat.dao.UserDao;


@Service
public class MessageService {

    @Autowired
    private UserService userService;

    @Autowired
    private MessageDao messageDao;

    @Autowired
    private UserDao userDao;

    //TODO
    public void say(String name, String msg) {
    }
}
