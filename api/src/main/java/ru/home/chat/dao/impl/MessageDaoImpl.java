package ru.home.chat.dao.impl;

import org.springframework.stereotype.Repository;
import ru.home.chat.dao.MessageDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
@Repository
public class MessageDaoImpl implements MessageDao {

    @PersistenceContext
    private EntityManager em;

    //TODO
    @Override
    public void say(String name, String msg) {
    }
}
