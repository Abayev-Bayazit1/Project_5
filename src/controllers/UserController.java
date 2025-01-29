package controllers;

import controllers.interfaces.IUserController;
import models.User;
import services.interfaces.IUserService;

public class UserController  {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    public User login(String username, String password) {
        return userService.login(username, password);
    }

    public boolean register(User user) {
        return userService.register(user);
    }

}
