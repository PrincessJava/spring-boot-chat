package ru.home.chat.model;

import javax.persistence.*;

@Entity
@Table(name = "user", schema = "chat")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "login", unique = true, nullable = false, length = 20)
//    @NotBlank(message = "Name can not be empty")
//    @Pattern(regexp = "^[\\p{Alnum}]{1,32}$", message = "The name must contain only letters of the Russian or English alphabet")
    private String login;


    public Integer getId() {
        return id;
    }

    public User setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public User setLogin(String login) {
        this.login = login;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                '}';
    }
}
