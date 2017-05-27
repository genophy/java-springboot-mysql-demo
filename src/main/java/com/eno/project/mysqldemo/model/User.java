package com.eno.project.mysqldemo.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by eno on 2017/05/27.
 */
@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "gender")
    private Integer gender;

    @Column(name = "nick")
    private String nick;

    public User() {
    }

    public User(String name, Integer gender, String nick) {
        this.name = name;
        this.gender = gender;
        this.nick = nick;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }
}
