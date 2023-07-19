package tfw.Controller;

import tfw.Entity.User;
import tfw.Service.UserService;

import java.util.ArrayList;

public abstract class UserControllerAbstract {
    protected UserService service;


    public UserControllerAbstract(UserService service) {
        this.service = service;
    }

    public abstract boolean create(User user);

    //    GETS DATA IN DATABASE
    public abstract User getUserById(User user);

    //    UPDATE DATA IN DATABASE
    public abstract boolean update(User user);

    //    DELETE DATA IN DATABASE
    public abstract boolean delete(User user);

    public abstract ArrayList<User> getAllUsers();

    public abstract ArrayList<User> getAllUsersByProjectId(int project_id);


}
