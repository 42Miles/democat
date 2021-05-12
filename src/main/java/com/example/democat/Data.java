package com.example.democat;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

@Entity
@Table(name="HeroList")
public class Data {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String heroClass;
    @Column(length = 2048)
    private String heroName;
    private String level;
    @Transient
    boolean newuser;

    public Data(Integer id, String username, String heroClass, String heroName, String level, boolean newuser) {
        this.id = id;
        this.username = username;
        this.heroClass = heroClass;
        this.heroName = heroName;
        this.level = level;
        this.newuser = newuser;
    }

    public Data(String username, String heroClass, String heroName, String level, boolean newuser) {
        this.username = username;
        this.heroClass = heroClass;
        this.heroName = heroName;
        this.level = level;
        this.newuser = newuser;
    }

    public Data() {

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

    public boolean isNewuser() {
        return newuser;
    }

    public void setNewuser(boolean newuser) {
        this.newuser = newuser;
    }
    //@Scope(proxyMode = ScopedProxyMode.INTERFACES)
    @Override
    public String toString() {
        return "DB{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", heroClass='" + heroClass + '\'' +
                ", heroName='" + heroName + '\'' +
                ", level='" + level + '\'' +
                ", newuser=" + newuser +
                '}';
    }
}
