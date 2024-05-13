package com.example.recipeBackend.Controller;

import com.example.recipeBackend.Model.RecipeModel;
import com.example.recipeBackend.Service.InsertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class InsertApiController {

    @Autowired
    private final InsertService insertService;

    public InsertApiController(InsertService insertService) {
        this.insertService = insertService;
    }

    @PostMapping("/api/createNewRecipes")
    public String CreateNewRecipes(@RequestBody Map<String ,RecipeModel> stringRecipeModelMap){

        for (RecipeModel values : stringRecipeModelMap.values()){
            insertService.CreateNewRecipes(values);
        }

        return "Success";
    }

}
