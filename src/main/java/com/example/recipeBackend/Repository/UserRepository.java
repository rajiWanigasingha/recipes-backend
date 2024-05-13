package com.example.recipeBackend.Repository;

import com.example.recipeBackend.Model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserModel ,String> {

    @Query("{'email' : ?0}")
    UserModel FindEmailIFItExist(String email);

}
