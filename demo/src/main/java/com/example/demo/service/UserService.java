package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;
     public void save(User user){
        userRepository.save(user);
     }
     public List<User> getAll(){
         return userRepository.findAll();
     }
     public Optional<User> findById(ObjectId id){
         return userRepository.findById(id);
     }
     public void deleteById(ObjectId id){
         userRepository.deleteById(id);
     }
     public User findByUserName(String userName){
         return userRepository.findByUserName(userName);
     }

}
