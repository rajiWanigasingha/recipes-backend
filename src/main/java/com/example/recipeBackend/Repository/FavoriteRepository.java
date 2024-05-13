package com.example.recipeBackend.Repository;

import com.example.recipeBackend.Model.FavoriteModel;
import com.example.recipeBackend.Model.RecipeModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteRepository extends MongoRepository<FavoriteModel, ObjectId> {

    @Query("'email':?0")
    List<FavoriteModel> getFavoriteByUser(String email);

}
