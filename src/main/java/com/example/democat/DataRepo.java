package com.example.democat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface DataRepo extends JpaRepository <Data, String> {
    @Transactional
    void deleteById(Integer id);
    List<Data> findAllByusername(String wyszukaj);
}
