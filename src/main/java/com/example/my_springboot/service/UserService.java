package com.example.my_springboot.service;

import com.example.my_springboot.model.User;
import com.example.my_springboot.reposirory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
@Service
public class UserService {
    private UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository= userRepository;
    }

    public User getUserById(Long id) {
       return userRepository.getOne(id);
    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public User saveUser(User user) {
     return userRepository.save(user);
    }
    public void removeUser(Long id) {
        userRepository.deleteById(id);
    }

 }



