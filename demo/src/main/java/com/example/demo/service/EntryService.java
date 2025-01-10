package com.example.demo.service;

import com.example.demo.entity.EntryV2;
import com.example.demo.entity.User;
import com.example.demo.repository.EntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EntryService {

    @Autowired
    private EntryRepository entryRepository;
    @Autowired
    private UserService userService;
    public void saveEntry(EntryV2 entry, String userName){
        User user=userService.findByUserName(userName);
        EntryV2 saved = entryRepository.save(entry);
        user.getEntries().add(saved);
        userService.save(user);
    }

    public List<EntryV2> getEntry(){
        return entryRepository.findAll();
    }
    public Optional<EntryV2> getEntryById(ObjectId id){
        return entryRepository.findById(id);
    }
    public void deleteById(ObjectId id){
        entryRepository.deleteById(id);
    }
    public void updateById(EntryV2 entry){
        entryRepository.save(entry);
    }
}


//controller --> service --> repository
