package com.example.recipeBackend.Service;

import com.example.recipeBackend.Model.RecipeModel;
import com.example.recipeBackend.Repository.RecipeRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GetRecipesService {

    @Autowired
    private final RecipeRepository recipeRepository;


    public GetRecipesService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<RecipeModel> getAllRecipes(){
        return recipeRepository.findAll();
    }

    public Optional<RecipeModel> getById(String id){
        return recipeRepository.findById(new ObjectId(id));
    }
}
