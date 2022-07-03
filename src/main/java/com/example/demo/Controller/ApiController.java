package com.example.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.User;
import com.example.demo.Repo.UserRepo;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ApiController {
//    Get all users
    @Autowired
    UserRepo tutorialRepository;
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllTutorials(@RequestParam(required = false) String company) {
        try {
            List<User> tutorials = new ArrayList<User>();
            if (company == null)
                tutorialRepository.findAll().forEach(tutorials::add);
            else
                tutorialRepository.findByCompanyContaining(company).forEach(tutorials::add);
            if (tutorials.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(tutorials, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //    Create new user
    @PostMapping("/users")
    public ResponseEntity<User> createTutorial(@RequestBody User tutorial) {
        try {
            User _tutorial = tutorialRepository
                    .save(new User(tutorial.getName(), tutorial.getEmail(), tutorial.getCompany() ));
            return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateTutorial(@PathVariable("id") long id, @RequestBody User tutorial) {
        Optional<User> tutorialData = tutorialRepository.findById(id);
        if (tutorialData.isPresent()) {
            User _tutorial = tutorialData.get();
            _tutorial.setName(tutorial.getName());
            _tutorial.setEmail(tutorial.getEmail());
            _tutorial.setCompany(tutorial.getCompany());
            return new ResponseEntity<>(tutorialRepository.save(_tutorial), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
        try {
            tutorialRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
