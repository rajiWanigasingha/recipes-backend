package com.example.recipeBackend.Controller;

import com.example.recipeBackend.Model.UserModel;
import com.example.recipeBackend.Service.UserService;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class CreateNewUserApiController {

    private final UserService userService;

    public CreateNewUserApiController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/createUser")
    public UserModel createUser(@RequestBody UserModel userModel){
        UserModel newUser = userService.CreateUserService(userModel);

        if(newUser == null){
            throw new ResponseStatusException(HttpStatusCode.valueOf(400),"User already exist");
        }

        return userService.CreateUserService(userModel);
    }

}
