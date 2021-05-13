package com.example.democat;

import javax.persistence.*;

@Entity
@Table(name="HeroList")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String heroClass;
    @Column(length = 2048)
    private String heroName;
    private String level;
    @Transient
    boolean nowy;

    public User(Integer id, String username, String heroClass, String heroName, String level, boolean nowy) {
        this.id = id;
        this.username = username;
        this.heroClass = heroClass;
        this.heroName = heroName;
        this.level = level;
        this.nowy = nowy;
    }

    public User(String username, String heroClass, String heroName, String level, boolean nowy) {
        this.username = username;
        this.heroClass = heroClass;
        this.heroName = heroName;
        this.level = level;
        this.nowy = nowy;
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

    public String getHeroClass() {
        return heroClass;
    }

    public void setHeroClass(String heroClass) {
        this.heroClass = heroClass;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public boolean isNowy() {
        return nowy;
    }

    public void setNowy(boolean nowy) {
        this.nowy = nowy;
    }
    //@Scope(proxyMode = ScopedProxyMode.INTERFACES)
    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", heroClass='" + heroClass + '\'' +
                ", heroName='" + heroName + '\'' +
                ", level='" + level + '\'' +
                ", newuser=" + nowy +
                '}';
    }
}