package tfw.Controller;

import tfw.Entity.User;
import tfw.Service.UserService;

public abstract class UserControllerAbstract {
    UserService service;

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


}
