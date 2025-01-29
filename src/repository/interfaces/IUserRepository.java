package repository.interfaces;

import data.interfaces.IDB;
import models.User;
import repository.UserRepository;

public interface IUserRepository {
    public User findByUsernameAndPassword(String username, String password);
    public boolean addUser(User user);

}
