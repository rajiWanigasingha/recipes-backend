package com.example.recipeBackend.Service;

import com.example.recipeBackend.Model.FavoriteModel;
import com.example.recipeBackend.Model.RecipeModel;
import com.example.recipeBackend.Repository.FavoriteRepository;
import com.example.recipeBackend.Repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetMyRecipes {

    private final RecipeRepository recipeRepository;

    private final FavoriteRepository favoriteRepository;

    public GetMyRecipes(RecipeRepository recipeRepository, FavoriteRepository favoriteRepository) {
        this.recipeRepository = recipeRepository;
        this.favoriteRepository = favoriteRepository;
    }

    public List<RecipeModel> GetMyFavorite(String email){
        List<FavoriteModel> myFavorite =  favoriteRepository.getFavoriteByUser(email);

        System.out.println(email);

        List<RecipeModel> myFavoriteRecipes = new java.util.ArrayList<>(List.of());

        for (FavoriteModel element : myFavorite){

            if(element.getEmail().equals(email)) {
                Integer recipeId = element.getId();
                myFavoriteRecipes.add(recipeRepository.GetRecipeById(recipeId));
            }


        }

        return myFavoriteRecipes;
    }

}
