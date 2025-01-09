package com.example.demo.repository;

import com.example.demo.entity.Entry;
import com.example.demo.entity.EntryV2;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

//this just extends to mongo repo and takes the entity and id type
public interface EntryRepository extends MongoRepository<EntryV2, ObjectId> {
}
