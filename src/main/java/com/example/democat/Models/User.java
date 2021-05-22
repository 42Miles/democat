package com.example.democat.Models;

import com.example.democat.Models.Hero;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="HeroList")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String username;
    @OneToMany
    private List<Hero> heroes;
    @Transient
    boolean nowy;

    public User(String username) {
        this.username = username;
        this.heroes = new ArrayList<>();
    }

    public User(String username, String hero) {
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Hero> getHeroes() {
        return heroes;
    }

    public void setHeroes(List<Hero> heroes) {
        this.heroes = heroes;
    }

    public void fillCollectionsWithHeroes(Hero hero) {
        heroes.add(hero);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", heroes=" + heroes +
                ", nowy=" + nowy +
                '}';
    }
}