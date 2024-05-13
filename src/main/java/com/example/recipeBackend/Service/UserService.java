package com.example.recipeBackend.Service;

import com.example.recipeBackend.Model.UserModel;
import com.example.recipeBackend.Repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserModel CreateUserService(UserModel userModel){
        UserModel EmailExist = userRepository.FindEmailIFItExist(userModel.getEmail());
        ObjectId objectId = new ObjectId();

        if(EmailExist == null){
            userModel.setId(objectId.toString());
           return userRepository.save(userModel);
        }

        return null;
    }
}
