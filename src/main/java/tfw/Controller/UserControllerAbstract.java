package tfw.Controller;

import tfw.Entity.User;
import tfw.Service.UserService;

public abstract class UserControllerAbstract {
    User user;
    UserService service;
    public UserControllerAbstract(User user, UserService service){
        this.user = user;
        this.service = service;
    }
    public abstract boolean create(User user, String entityName);
    //    GETS DATA IN DATABASE
    public abstract User getUserById(User user, String entityName);
    //    UPDATE DATA IN DATABASE
    public abstract boolean update(User user, String entityName);
    //    DELETE DATA IN DATABASE
    public abstract boolean delete(User user, String entityName);


}
