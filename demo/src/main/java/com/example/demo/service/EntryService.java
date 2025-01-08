package com.example.demo.service;

import com.example.demo.entity.EntryV2;
import com.example.demo.repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class EntryService {

    @Autowired
    private EntryRepository entryRepository;

    public void saveEntry(EntryV2 entryV2){
        entryRepository.save(entryV2);
    }
}


//controller --> service --> repository
