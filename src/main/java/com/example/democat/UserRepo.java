package com.example.democat;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface UserRepo extends JpaRepository<User, Integer> {

    List<User> findAllByusername(String wyszukaj);
}
