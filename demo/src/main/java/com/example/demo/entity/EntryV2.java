package com.example.demo.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class EntryV2 {
    @Id
    private ObjectId id;

    public ObjectId getId() {
        return id;
    }

    private String content;

    private String title;


    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
