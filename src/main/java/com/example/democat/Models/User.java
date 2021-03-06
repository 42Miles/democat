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
    @OneToMany( cascade = CascadeType.ALL, mappedBy="user",
            fetch = FetchType.EAGER
    )
    private List<Hero> heroes;

    public User(Integer id, String username, List<Hero> heroes) {
        this.id = id;
        this.username = username;
        this.heroes = heroes;
    }

    public User(Integer id, String username) {
        this.id = id;
        this.username = username;
    }

    public User() {
    }

    public User(String username, List<Hero> heroes) {
        this.username = username;
        this.heroes = heroes;
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
                '}';
    }
}