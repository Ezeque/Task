package tfw.Controller;

import tfw.Entity.User;
import tfw.Service.TaskService;
import tfw.Service.UserService;

public abstract class UserControllerAbstract {
    public abstract boolean create(User user, UserService service);
    //    GETS DATA IN DATABASE
    public abstract User getUserById(User user, UserService service);
    //    UPDATE DATA IN DATABASE
    public abstract boolean update(User user, UserService service);
    //    DELETE DATA IN DATABASE
    public abstract boolean delete(User user, UserService service);


}
