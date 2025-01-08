package com.example.demo.controller;

import com.example.demo.entity.Entry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/journal")//adds mapping to the whole class
public class EntryController {

    private Map<Long,Entry> entries=new HashMap();
    //path over here would be journal/trial since i used request mapping
    @GetMapping
    public List<Entry> getAll(){
        return new ArrayList<>(entries.values());
    }

    @PostMapping
    public String createEntry(@RequestBody Entry myEntry)
    {
        entries.put(myEntry.getId(),myEntry);
        return "true";
    }
    @GetMapping("id/{myId}")
    public Entry getById(@PathVariable  Long myId){
        return entries.get(myId);
    }

    @DeleteMapping("id/{myId}")
    public boolean deletebyId(@PathVariable Long myId){
        entries.remove(myId);
        return true;
    }

    @PutMapping("id/{myid}")
    public Entry updatebyId(@PathVariable Long myid,@RequestBody Entry myentry){
        entries.put(myid,myentry);
        return entries.get(myid);
    }
}
