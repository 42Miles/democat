package com.example.democat.Repositories;
import com.example.democat.Models.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeroRepo extends JpaRepository<Hero, Integer> {
    List<Hero> findAllByheroName(String wyszukaj);
}
