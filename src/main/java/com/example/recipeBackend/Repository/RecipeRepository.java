package com.example.recipeBackend.Repository;

import com.example.recipeBackend.Model.RecipeModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends MongoRepository<RecipeModel , ObjectId> {
    @Query("{'id': ?0}")
    RecipeModel GetRecipeById(Integer id);
}
