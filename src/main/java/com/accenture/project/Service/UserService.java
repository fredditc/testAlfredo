/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.accenture.project.Service;

import com.accenture.project.Entity.User;
import com.accenture.project.Repository.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alfredotorres
 */
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepo;
    
    
    public Iterable getAllUsers(){
        return this.userRepo.findAll();
    }
    
    public void saveUser(User user){
        this.userRepo.save(user);
    }
    
    public boolean deleteUserById(Long id){
        try{
            Optional<User> user = this.userRepo.findById(id);
            if(user.isPresent()){
                this.userRepo.delete(user.get());
            }
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    public User findUserById(Long id){
        User user = null;
        try{
            Optional<User> userOptional = this.userRepo.findById(id);
            if(userOptional.isPresent()){
                return userOptional.get();
            }
        }catch(Exception e){
            
        }
        return user;
    }
}
