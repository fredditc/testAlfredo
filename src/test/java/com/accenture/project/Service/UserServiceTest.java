/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.accenture.project.Service;

import com.accenture.project.Controller.UserController;
import com.accenture.project.Entity.User;
import com.accenture.project.Repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.h2.command.dml.MergeUsing;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnit44Runner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
/**
 *
 * @author alfredotorres
 */
@RunWith(MockitoJUnit44Runner.class)
@SpringBootTest
public class UserServiceTest {
    
    @Mock
    UserService userService;
    
    @Mock
    UserRepository userRepository;
    
    @InjectMocks
    UserController userController;
    
    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);;
    }
    
    @Test
    void findUserById(){
       User userMock = new User();
       userMock.setId(1L);
       userMock.setFullName("Alfredo Torres");
       userMock.setUsername("Freddy");
       userMock.setPassword("123");
       Mockito.when(userController.findUserbyId(1L)).thenReturn(userMock);
      
       Assertions.assertEquals(1L, userMock.getId());
       Assertions.assertEquals("Alfredo Torres", userMock.getFullName());
       Assertions.assertEquals("Freddy", userMock.getUsername());
       Assertions.assertEquals("123", userMock.getPassword());
       
    }
    
    @Test
    void allUser(){
       List<User> mockList = new ArrayList<User>();
       User userMock = new User();
       userMock.setId(1L);
       userMock.setFullName("Benjamin");
       userMock.setUsername("Torres");
       userMock.setPassword("test");
       mockList.add(userMock);
       
       Mockito.when(userController.getAllUsers()).thenReturn(mockList);
    }
    
    @Test
    void addNewUser(){
       User userMock = new User();
       userMock.setId(1L);
       userMock.setFullName("Benjamin");
       userMock.setUsername("Torres");
       userMock.setPassword("test");
       Mockito.when(userService.deleteUserById(1L)).thenReturn(true);
    }
}
 