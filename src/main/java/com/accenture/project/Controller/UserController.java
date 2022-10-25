/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.accenture.project.Controller;

import com.accenture.project.Entity.User;
import com.accenture.project.Repository.UserRepository;
import com.accenture.project.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alfredotorres
 */
@RestController
@RequestMapping("api/users")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody User user){
        this.userService.saveUser(user);
    } 
    
    @GetMapping
    public Iterable getAllUsers(){
        return this.userService.getAllUsers();
    }
    
    @GetMapping("/search/{id}")
    public User findUserbyId(@PathVariable("id") Long id){
        return this.userService.findUserById(id);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public void updateUser(@RequestBody User user){
        this.userService.saveUser(user);
    }
    
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUserById(@PathVariable("id") Long id){
        this.userService.deleteUserById(id);
    }
}
