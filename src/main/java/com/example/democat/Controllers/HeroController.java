package com.example.democat.Controllers;

import com.example.democat.Models.Hero;
import com.example.democat.Repositories.HeroRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
class HeroController {
    private HeroRepo heroRepo;
    @Autowired
    public HeroController(HeroRepo heroRepo) {
        this.heroRepo = heroRepo;
    }

    @RequestMapping("/addHero")
    public String dodajemyDane(){ return "heroAdd"; }

    @RequestMapping("/add")
    public String dodajemyDane(
            @RequestParam("heroName") String heroName,
            @RequestParam("heroClass") String heroClass,
            @RequestParam("health") String health,
            @RequestParam("level") String level,
            @RequestParam("weapon") String weapon,
            Model model)
            throws Exception {
        List<Hero> heroes3 = new ArrayList<>();
        heroes3.add(new Hero (heroName));
        heroes3.add(new Hero (heroClass));
        heroes3.add(new Hero (health));
        heroes3.add(new Hero (level));
        heroes3.add(new Hero (weapon));

        Hero hero = new Hero(heroName, heroClass, health, level, weapon);
        System.out.println(heroes3);
        //heroRepo.save(heroes3);
        model.addAttribute("hero", heroes3);
        return "Widok2";
    }

    @RequestMapping("/show")
    public String pokaz( Model model){
        for (Hero hero : heroRepo.findAll()) {
            System.out.println(hero);
        }
        model.addAttribute("user", heroRepo.findAll());
        return "yourHero";
    }
    @RequestMapping("/yourHero")
    public String yourHero( Model model){
        model.addAttribute("hero", heroRepo.findAll());
        return "yourHero";
    }

    @RequestMapping("/delete")
    public String kasuj(@RequestParam("id") Integer id, Model model){
        heroRepo.deleteById(id);

        model.addAttribute("hero", heroRepo.findAll());
        return "yourHero";
    }

    @RequestMapping("/find")
    public String wyszukaj(@RequestParam("kryterium") String kryterium, Model model){
        model.addAttribute("user", heroRepo.findAllByheroName(kryterium));
        return "yourHero";
    }

    @RequestMapping("/search")
    public String search(@RequestParam("kryterium") String kryterium, Model model){
        model.addAttribute("hero", heroRepo.findAllByheroName(kryterium));
        return "yourHero";
    }



    @RequestMapping("/update")
    public String update(
            @RequestParam("heroName") String heroName,
            @RequestParam("heroClass") String heroClass,
            @RequestParam("health") String health,
            @RequestParam("level") String level,
            @RequestParam("weapon") String weapon,
            Model model)
            throws Exception {
        Hero hero = new Hero(heroName, heroClass, health, level, weapon);
        System.out.println(hero);
        heroRepo.save(hero);
        model.addAttribute("hero", hero);
        return "Widok2";
    }

    @RequestMapping("/redirect")
    public String przekieruj(
            @RequestParam("id") Integer id, Model model
    )
            throws Exception {
        System.out.println(heroRepo.findById(id));
        model.addAttribute("hero", heroRepo.findById(id));
        return "update";
    }

    @RequestMapping("/saveHero")
    public String dodajemyDane(
            @RequestParam("heroName") String heroName,
            @RequestParam("heroClass") String heroClass,
            @RequestParam("health") String health,
            @RequestParam("level") String level,
            @RequestParam("weapon") String weapon)
            throws Exception
    {
        Hero hero = new Hero(heroName, heroClass, health, level, weapon);
        heroRepo.save(hero);
        return "hero: "+hero+", hero=" + hero; }


}
