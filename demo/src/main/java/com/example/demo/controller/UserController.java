package com.example.demo.controller;


import com.example.demo.entity.EntryV2;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("")
    public ResponseEntity<List<User>> getAllUser(){
            List<User> users=userService.getAll();
            if(!users.isEmpty()) {
                return new ResponseEntity<>(users, HttpStatus.OK);

            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("")
    public ResponseEntity<?> createUser(@RequestBody User newUser){
        try{
            userService.save(newUser);
            return new ResponseEntity<>(newUser,HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(false,HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{userName}")
    public ResponseEntity<?> updateUser(@RequestBody User update,@PathVariable String userName){
        User userInDb=userService.findByUserName(userName);
        if(userInDb!=null){
            userInDb.setUserName(update.getUserName());
            userInDb.setPassword(update.getPassword());
            userService.save(userInDb);
            return new ResponseEntity<>(userInDb,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

//    @DeleteMapping
}
