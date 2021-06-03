package com.example.democat.Controllers;

import com.example.democat.Models.Hero;
import com.example.democat.Models.User;
import com.example.democat.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
class MainController {
    private UserRepo userRepo;
    @Autowired
    public MainController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @RequestMapping("/form")
    public String dodajemyDane(){ return "Formularz"; }

    @RequestMapping("/dodaj")
    public String dodajemyDane(
            @RequestParam("username") String username,
            @RequestParam("hero1") String hero1,
            Model model)
            throws Exception {

        List<Hero> heroes2 = new ArrayList<>();
        heroes2.add(new Hero (hero1));
        User user = new User(username, heroes2);
        System.out.println(user);
        userRepo.save(user);
        model.addAttribute("user", user);
        return "Widok";
    }

    @RequestMapping("/pokaz")
    public String pokaz( Model model){
        for (User user : userRepo.findAll()) {
            System.out.println(user);
        }
        model.addAttribute("user", userRepo.findAll());
        return "pokaz";
    }


    @RequestMapping("/kasuj")
    public String kasuj(@RequestParam("id") Integer id, Model model){
        userRepo.deleteById(id);

        model.addAttribute("user", userRepo.findAll());
        return "pokaz";
    }

    @RequestMapping("/wyszukaj")
    public String wyszukaj(@RequestParam("kryterium") String kryterium, Model model){
        model.addAttribute("user", userRepo.findAllByusername(kryterium));
        return "pokaz";
    }


    @RequestMapping("/aktualizuj")
    public String update(
            @RequestParam("username") String username,
            @RequestParam("hero") String hero1,
            Model model)
            throws Exception {
        List<Hero> heroes2 = new ArrayList<>();

        heroes2.add(new Hero (hero1));

        User user = new User(username, heroes2);
        System.out.println(user);
        userRepo.save(user);
        model.addAttribute("user", user);
        return "Widok";
    }

    @RequestMapping("/przekieruj")
    public String przekieruj(
            @RequestParam("id") Integer id, Model model
    )
            throws Exception {
        System.out.println(userRepo.findById(id));
        model.addAttribute("user", userRepo.findById(id));
        return "aktualizuj";
    }


}
