package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@Document
public class EntryV2 {
    @Id
    private ObjectId id;

    private String content;

    private String title;





}
