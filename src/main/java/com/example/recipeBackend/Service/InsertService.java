package com.example.recipeBackend.Service;

import com.example.recipeBackend.Model.RecipeModel;
import com.example.recipeBackend.Repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Random;

@Service
public class InsertService {

    @Autowired
    private final RecipeRepository recipeRepository;

    public InsertService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public RecipeModel CreateNewRecipes(RecipeModel recipeModel){
        Random id = new Random();
        recipeModel.setId(id.nextInt(1000));
        return recipeRepository.save(recipeModel);
    }


}
