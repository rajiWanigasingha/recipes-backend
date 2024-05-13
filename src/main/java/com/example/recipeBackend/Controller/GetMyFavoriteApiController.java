package com.example.recipeBackend.Controller;

import com.example.recipeBackend.Model.RecipeModel;
import com.example.recipeBackend.Service.GetMyRecipes;
import com.example.recipeBackend.Service.GetRecipesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetMyFavoriteApiController {


    private final GetMyRecipes getMyRecipes;

    public GetMyFavoriteApiController(GetMyRecipes getMyRecipes) {
        this.getMyRecipes = getMyRecipes;
    }

    @GetMapping("/api/getMyFavorite/{email}")
    public List<RecipeModel> GetMyFavorite(@PathVariable String email){
        return getMyRecipes.GetMyFavorite(email);
    }
}
