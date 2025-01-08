package com.example.demo;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Myclass {

    //whenever we want to use another class over here
    //it is dependency injection
    //myclass is depended on dog as it uses dog over here
    //more precisely it is called field injection
    @Autowired
    private Dog dog;

    @GetMapping("/fun")
    public String havingFun()
    {
        return dog.fun();
    }
    @GetMapping("")
    public String sayHello()
    {
        return "Hello";
    }

}
