package com.example.democat.Repositories;
import com.example.democat.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserRepo extends JpaRepository<User, Integer> {
    List<User> findAllByusername(String wyszukaj);

}
