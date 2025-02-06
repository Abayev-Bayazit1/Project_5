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
        //валидция пароля
        if(user.getPassword().length() < 4 || user.getPassword().length() > 8) {
            System.out.println("Password should be between 4 and 8 characters");

            return false;
        }

        return userService.register(user);
    }

}
