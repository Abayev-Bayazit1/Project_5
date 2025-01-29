package services;

import models.User;
import repository.interfaces.IUserRepository;
import services.interfaces.IUserService;

public class UserService implements IUserService {

    private final IUserRepository userRepository;


    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public boolean register(User user) {
        return userRepository.addUser(user);
    }
}
