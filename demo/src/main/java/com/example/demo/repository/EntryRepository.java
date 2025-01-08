package com.example.demo.repository;

import com.example.demo.entity.Entry;
import com.example.demo.entity.EntryV2;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EntryRepository extends MongoRepository<EntryV2,Long> {
}
