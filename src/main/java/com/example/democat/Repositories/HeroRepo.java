package com.example.democat.Repositories;
import com.example.democat.Models.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface HeroRepo extends JpaRepository<Hero, Integer> {

    List<Hero> findAllByheroName(String wyszukaj);
}
