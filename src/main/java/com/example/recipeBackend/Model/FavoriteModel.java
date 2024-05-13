package com.example.recipeBackend.Model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "favorite")
public class FavoriteModel {

    @Id
    private ObjectId objectId;

    private Integer id;

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ObjectId getObjectId() {
        return objectId;
    }

    public void setObjectId(ObjectId objectId) {
        this.objectId = objectId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public FavoriteModel(ObjectId objectId, Integer id, String email) {
        this.objectId = objectId;
        this.id = id;
        this.email = email;
    }
}
