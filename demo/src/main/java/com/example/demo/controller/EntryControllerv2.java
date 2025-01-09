package com.example.demo.controller;

import com.example.demo.entity.EntryV2;
import com.example.demo.service.EntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/journalv2")//adds mapping to the whole class
public class EntryControllerv2 {

    @Autowired
    private EntryService entryService;

    @GetMapping
    public ResponseEntity<List<EntryV2>> getAll(){

        List<EntryV2> entries= entryService.getEntry();
        if(!entries.isEmpty()){
            return new ResponseEntity<>(entries, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> createEntry(@RequestBody EntryV2 myEntry) {
        try {
            entryService.saveEntry(myEntry);
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(false,HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("id/{myId}")
    public ResponseEntity<EntryV2> getById(@PathVariable ObjectId myId){
        Optional<EntryV2> findEntry= entryService.getEntryById(myId);
        if(findEntry.isPresent()){
            return new ResponseEntity<>(findEntry.get(),HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("id/{myId}")
    public ResponseEntity<?> deletebyId(@PathVariable ObjectId myId){
//            if(entryService.deleteById(myId)) {
//                return new ResponseEntity<>(true, HttpStatus.OK);
//            }
//            else{
//                return new ResponseEntity<>(false,HttpStatus.NOT_FOUND)
//            }
                return new ResponseEntity<>(true, HttpStatus.OK);


    }

    @PutMapping("id/{myid}")
    public ResponseEntity<EntryV2> updatebyId(@PathVariable ObjectId myid,@RequestBody EntryV2 newentry){
        Optional<EntryV2> old=entryService.getEntryById(myid);
        if(old.isPresent()){
            old.get().setTitle(newentry.getTitle()!=null && !newentry.getTitle().equals("")?newentry.getTitle(): old.get().getTitle());
            old.get().setContent(newentry.getContent()!=null && !newentry.getContent().equals("")? newentry.getContent() : old.get().getContent());
            entryService.saveEntry(old.orElse(null));
            return new ResponseEntity<>(old.get(),HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
