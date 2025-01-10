package com.example.demo.controller;

import com.example.demo.entity.EntryV2;
import com.example.demo.entity.User;
import com.example.demo.service.EntryService;
import com.example.demo.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/userEntry")//adds mapping to the whole class
public class UserEntryController {

    @Autowired
    private EntryService entryService;
    @Autowired
    private UserService userService;

    @GetMapping("/{userName}")
    public ResponseEntity<List<EntryV2>> getAll(@PathVariable String userName){
        User user=userService.findByUserName(userName);
        List<EntryV2> userEntries=user.getEntries();
        if(userEntries.isEmpty() || userEntries==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(userEntries,HttpStatus.OK);
        }
    }

    @PostMapping("/{userName}")
    public ResponseEntity<?> createEntry(@RequestBody EntryV2 userEntry,@PathVariable String userName) {
        try {
//            User user=userService.findByUserName(userName);
            entryService.saveEntry(userEntry,userName);

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
    //this wil delte from EntryV2 collections but the reference in the Users is not delted as cascade delete is not done in monogdb

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

//    @PutMapping("id/{myid}")
//    public ResponseEntity<EntryV2> updatebyId(@PathVariable ObjectId myid,@RequestBody EntryV2 newentry){
//        Optional<EntryV2> old=entryService.getEntryById(myid);
//        if(old.isPresent()){
//            old.get().setTitle(newentry.getTitle()!=null && !newentry.getTitle().equals("")?newentry.getTitle(): old.get().getTitle());
//            old.get().setContent(newentry.getContent()!=null && !newentry.getContent().equals("")? newentry.getContent() : old.get().getContent());
//            entryService.saveEntry(old.orElse(null), userName);
//            return new ResponseEntity<>(old.get(),HttpStatus.OK);
//        }
//        else{
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
}
