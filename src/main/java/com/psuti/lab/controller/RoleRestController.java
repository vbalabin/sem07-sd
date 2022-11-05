package com.psuti.lab.controller;
import com.psuti.lab.dao.RoleRepository;
import com.psuti.lab.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.Locale;

@RequestMapping("/roles")
@RestController
public class RoleRestController {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleRestController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @GetMapping
    public List<Role> getAll(){
        return roleRepository.findAll();
    }

    @GetMapping("/{name}")
    public Role getById(@PathVariable("name")String name){
        return roleRepository.findById(name).get();
    }

    @DeleteMapping("/{name}")
    public void remove(@PathVariable("name")String name){
        roleRepository.deleteById(name);
    }

    @PutMapping("/{name}")
    public Role update(@PathVariable("name")String name, @RequestBody Role role){
        roleRepository.deleteById(name);
        return roleRepository.save(role);
    }

    @PostMapping
    public Role create(@RequestBody Role role){
        String name = role.getName();
        if(name != null){
            if(roleRepository.existsById(role.getName())){
                throw new EntityExistsException(
                        String.format(Locale.getDefault(),
                                "Role with name: %s already exists",
                                role.getName()));
            }
        }
        return roleRepository.save(role);
    }
}
