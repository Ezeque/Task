package Controller;

import Entity.User;
import Service.UserService;

import java.sql.SQLException;

public abstract class UserControllerAbstract {
    User user;
    UserService service;

    public abstract boolean create(User user, String entityName);
    //    GETS DATA IN DATABASE
    public abstract User getUserById(User user, String entityName);
    //    UPDATE DATA IN DATABASE
    public abstract boolean update(User user, String entityName);
    //    DELETE DATA IN DATABASE
    public abstract boolean delete(User user, String entityName);


}
