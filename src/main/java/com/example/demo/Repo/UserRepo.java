package com.example.demo.Repo;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.User;
public interface UserRepo extends JpaRepository<User, Long> {
    List<User> findByNameContaining(String name);
    List<User> findByCompanyContaining(String company);
}
