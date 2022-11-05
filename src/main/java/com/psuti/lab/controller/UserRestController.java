package com.psuti.lab.controller;
import com.psuti.lab.dao.UserRepository;
import com.psuti.lab.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

@RequestMapping("/users")
@RestController
public class UserRestController {
    private final UserRepository userRepository;

    @Autowired
    public UserRestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> getAll(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable("id")UUID id){
        return userRepository.findById(id).get();
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable("id")UUID id){
        userRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable("id")UUID id, @RequestBody User user){
        userRepository.deleteById(id);
        return userRepository.save(user);
    }

    @PostMapping
    public User create(@RequestBody User user){
        UUID id = user.getId();
        if(id != null){
            if(userRepository.existsById(user.getId())){
                throw new EntityExistsException(
                        String.format(Locale.getDefault(),
                                "User with id: %s already exists",
                                user.getId()));
            }
        }
        return userRepository.save(user);
    }
}
