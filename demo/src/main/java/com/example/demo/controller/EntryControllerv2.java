package com.example.demo.controller;

import com.example.demo.entity.Entry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/journal")//adds mapping to the whole class
public class EntryControllerv2 {

    @GetMapping
    public List<Entry> getAll(){
        return null;
    }

    @PostMapping
    public boolean createEntry(@RequestBody Entry myEntry) {
        return true;
    }
    @GetMapping("id/{myId}")
    public Entry getById(@PathVariable  Long myId){
        return null;
    }

    @DeleteMapping("id/{myId}")
    public boolean deletebyId(@PathVariable Long myId){
        return true;
    }

    @PutMapping("id/{myid}")
    public Entry updatebyId(@PathVariable Long myid,@RequestBody Entry myentry){
        return null;
    }
}
