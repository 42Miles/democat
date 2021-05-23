package com.example.democat.Controllers;

import com.example.democat.Models.Hero;
import com.example.democat.Models.User;
import com.example.democat.Repositories.HeroRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
            //@RequestParam("username") String username,
            @RequestParam("heroClass") String heroClass,
            @RequestParam("heroName") String heroName,
            @RequestParam("level") String level,
            @RequestParam("weapon") String weapon,
            Model model)
            throws Exception {
        Hero hero = new Hero();
        System.out.println(hero);
        heroRepo.save(hero);
        model.addAttribute("hero", hero);
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
/*
    @RequestMapping("/search")
    public String search(@RequestParam("kryterium") String kryterium, Model model){
        model.addAttribute("hero", heroRepo.findAllByheroName(kryterium));
        return "yourHero";
    }
*/
    @RequestMapping("/update")
    public String update(
            //@RequestParam("id") Integer id,
            @RequestParam("heroClass") String heroClass,
            @RequestParam("heroName") String heroName,
            @RequestParam("level") String level,
            @RequestParam("weapon") String weapon,
            Model model)
            throws Exception {
        Hero hero = new Hero();
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
            //@RequestParam("id") Integer id,
            //@RequestParam("hero") String hero,
            //@RequestParam("username") String username)
            @RequestParam("heroClass") String heroClass,
            @RequestParam("heroName") String heroName,
            @RequestParam("level") String level,
            @RequestParam("weapon") String weapon)
            throws Exception
    {
        Hero hero = new Hero();
        heroRepo.save(hero);
        return "hero: "+hero+", hero=" + hero; }


}
