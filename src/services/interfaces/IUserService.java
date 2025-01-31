package services.interfaces;

import models.User;
import repository.interfaces.IUserRepository;

public interface IUserService {
     User login(String username, String password);
     boolean register(User user);

}
