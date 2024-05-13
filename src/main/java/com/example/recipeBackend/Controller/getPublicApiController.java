package com.example.recipeBackend.Controller;

import com.example.recipeBackend.Model.RecipeModel;
import com.example.recipeBackend.Service.GetRecipesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api")
@RestController
public class getPublicApiController {

    @Autowired
    private final GetRecipesService getRecipesService;

    public getPublicApiController(GetRecipesService getRecipesService) {
        this.getRecipesService = getRecipesService;
    }

    @GetMapping("/getAll")
    public List<RecipeModel> getAllRecipes(){
        return getRecipesService.getAllRecipes();
    }

    @GetMapping("/getById/{id}")
    public Optional<RecipeModel> getById(@PathVariable String id){
        return getRecipesService.getById(id);
    }

}
