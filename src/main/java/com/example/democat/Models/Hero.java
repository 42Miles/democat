package com.example.democat.Models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table
public class Hero {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String level;
    private String weapon;
    private String health;
    private String heroName;
    private String heroClass;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "user")
    private User user;

    public Hero(String level, String weapon, String health, String heroName, String heroClass, User user) {
        this.level = level;
        this.weapon = weapon;
        this.health = health;
        this.heroName = heroName;
        this.heroClass = heroClass;
        this.user = user;
    }

    public Hero(String heroName) {
        this.heroName = heroName;
    }

    public Hero(String heroName, String heroClass, String health, String level, String weapon) {
        this.level = level;
        this.weapon = weapon;
        this.health = health;
        this.heroName = heroName;
        this.heroClass = heroClass;
        this.user = user;
    }

    public Hero() {

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getHeroClass() {
        return heroClass;
    }

    public void setHeroClass(String heroClass) {
        this.heroClass = heroClass;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hero hero = (Hero) o;
        return Objects.equals(id, hero.id) && Objects.equals(level, hero.level) && Objects.equals(weapon, hero.weapon) && Objects.equals(health, hero.health) && Objects.equals(heroName, hero.heroName) && Objects.equals(heroClass, hero.heroClass) && Objects.equals(user, hero.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, level, weapon, health, heroName, heroClass, user);
    }

    @Override
    public String toString() {
        return "Hero{" +
                "id=" + id +
                ", level=" + level +
                ", weapon='" + weapon + '\'' +
                ", health=" + health +
                ", heroName='" + heroName + '\'' +
                ", heroClass='" + heroClass + '\'' +
                ", user=" + user +
                '}';
    }
}
