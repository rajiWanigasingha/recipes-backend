package com.example.recipeBackend.Model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "recipe")
public class RecipeModel {

    @Id
    private ObjectId objectId;

    private Integer id;

    private String title;

    private List<String> ingredients;

    private String instructions;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ObjectId getObjectId() {
        return objectId;
    }

    public void setObjectId(ObjectId objectId) {
        this.objectId = objectId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public RecipeModel(ObjectId objectId, Integer id, String title, List<String> ingredients, String instructions) {
        this.objectId = objectId;
        this.id = id;
        this.title = title;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }
}
