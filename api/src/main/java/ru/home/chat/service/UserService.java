package ru.home.chat.service;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import ru.home.chat.dao.UserDao;
import ru.home.chat.model.User;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserDao userDao;

    @Nullable
    @Transactional
    public User getLoggedIn(@NotNull String name) {
        return userDao.getByLogin(name);
    }

    @Transactional
    public void login(@NotNull String login) {
        User user = new User();
        userDao.save(user.setLogin(login));
    }

    @NotNull
    @Transactional
    public List<User> getOnlineUsers() {
        return new ArrayList<>(userDao.findAll());
    }

}
