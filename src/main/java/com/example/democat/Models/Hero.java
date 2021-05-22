package com.example.democat.Models;

import javax.persistence.*;

@Entity
@Table
public class Hero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer level;
    private String weapon;
    private Integer health;
    private String heroName;
    private String heroClass;

    @ManyToOne (cascade = CascadeType.ALL)
    private User user;

    public Hero(Integer level, String weapon, Integer health, String heroName, String heroClass, User user) {
        this.level = level;
        this.weapon = weapon;
        this.health = health;
        this.heroName = heroName;
        this.heroClass = heroClass;
        this.user = user;
    }

    public Hero() {
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
