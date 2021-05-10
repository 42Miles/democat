package com.example.democat;
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
    private String weapon;
    @Transient
    boolean newuser;

    public Data(Integer id, String username, String heroClass, String heroName, String weapon, boolean newuser) {
        this.id = id;
        this.username = username;
        this.heroClass = heroClass;
        this.heroName = heroName;
        this.weapon = weapon;
        this.newuser = newuser;
    }

    public Data(String username, String heroClass, String heroName, String weapon, boolean newuser) {
        this.username = username;
        this.heroClass = heroClass;
        this.heroName = heroName;
        this.weapon = weapon;
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

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public boolean isNewuser() {
        return newuser;
    }

    public void setNewuser(boolean newuser) {
        this.newuser = newuser;
    }

    @Override
    public String toString() {
        return "DB{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", heroClass='" + heroClass + '\'' +
                ", heroName='" + heroName + '\'' +
                ", weapon='" + weapon + '\'' +
                ", newuser=" + newuser +
                '}';
    }
}