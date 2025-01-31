package repository.interfaces;

import data.interfaces.IDB;
import models.User;
import repository.UserRepository;

public interface IUserRepository {
     User findByUsernameAndPassword(String username, String password);
     boolean addUser(User user);

}
