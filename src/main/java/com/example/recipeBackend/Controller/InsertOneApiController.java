package com.example.recipeBackend.Controller;

import com.example.recipeBackend.Model.RecipeModel;
import com.example.recipeBackend.Service.InsertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InsertOneApiController {

    @Autowired
    private final InsertService insertService;

    public InsertOneApiController(InsertService insertService) {
        this.insertService = insertService;
    }


    @PostMapping("/api/createNewRecord")
    public RecipeModel createOneRecipe(@RequestBody RecipeModel recipeModel){
        return insertService.CreateNewRecipes(recipeModel);
    }

}
