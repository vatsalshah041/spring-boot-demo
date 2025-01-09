package com.example.demo.controller;

import com.example.demo.entity.Entry;
import com.example.demo.entity.EntryV2;
import com.example.demo.service.EntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/journalv2")//adds mapping to the whole class
public class EntryControllerv2 {

    @Autowired
    private EntryService entryService;

    @GetMapping
    public List<EntryV2> getAll(){
        return entryService.getEntry();
    }

    @PostMapping
    public boolean createEntry(@RequestBody EntryV2 myEntry) {
        entryService.saveEntry(myEntry);
        return true;
    }
    @GetMapping("id/{myId}")
    public EntryV2 getById(@PathVariable ObjectId myId){
        return entryService.getEntryById(myId).orElse(null);
    }

    @DeleteMapping("id/{myId}")
    public boolean deletebyId(@PathVariable ObjectId myId){
         entryService.deleteById(myId);
         return true;
    }

    @PutMapping("id/{myid}")
    public EntryV2 updatebyId(@PathVariable ObjectId myid,@RequestBody EntryV2 newentry){
        EntryV2 old=entryService.getEntryById(myid).orElse(null);
        if(old!=null){
            old.setTitle(newentry.getTitle()!=null && !newentry.getTitle().equals("")?newentry.getTitle():old.getTitle());
            old.setContent(newentry.getContent()!=null && !newentry.getContent().equals("")? newentry.getContent() : old.getContent());
        }
        entryService.saveEntry(old);
        return newentry;
    }
}
