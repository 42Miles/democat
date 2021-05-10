package com.example.democat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
class addControler {
    private DataRepo DataRepo;
    @Autowired
    public addControler(DataRepo dataRepo) {

        this.DataRepo = dataRepo;
    }

    @RequestMapping("/form")
    public String dodajemyDane(){ return "Formularz"; }


    @RequestMapping("/dodaj")
    public String dodajemyDane(
            @RequestParam("username") String username,
            @RequestParam("heroClass") String heroClass,
            @RequestParam("heroName") String heroName,
            @RequestParam("weapon") String weapon,
            Model model)
            throws Exception {

        Data data = new Data(username, heroClass, heroName, weapon, true);
        System.out.println(data);
        DataRepo.save(data);
        model.addAttribute("data", data);
        return "Widok";
    }

    @RequestMapping("/pokaz")
    public String pokaz( Model model) {
        int i = 0;
        for (Data users : DataRepo.findAll()) {
            System.out.println(users);
        }
        model.addAttribute("users", DataRepo.findAll());
        return "pokaz";
    }
    }