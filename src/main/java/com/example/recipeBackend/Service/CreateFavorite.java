package com.example.recipeBackend.Service;

import com.example.recipeBackend.Model.FavoriteModel;
import com.example.recipeBackend.Repository.FavoriteRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateFavorite {

    private final FavoriteRepository favoriteRepository;


    public CreateFavorite(FavoriteRepository favoriteRepository) {
        this.favoriteRepository = favoriteRepository;
    }


    public FavoriteModel CreateNewFavorite(FavoriteModel favoriteModel){
        return favoriteRepository.save(favoriteModel);
    }
}
