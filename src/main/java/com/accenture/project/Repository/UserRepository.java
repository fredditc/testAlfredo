/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.accenture.project.Repository;

import com.accenture.project.Entity.User;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author alfredotorres
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    
    public List<User> findByUsername(String username);
    
    public List<User> findByFullName(String name);
    
}
