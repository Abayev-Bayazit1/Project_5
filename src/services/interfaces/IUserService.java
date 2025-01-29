package services.interfaces;

import models.User;
import repository.interfaces.IUserRepository;

public interface IUserService {
    public User login(String username, String password);
    public boolean register(User user);

}
