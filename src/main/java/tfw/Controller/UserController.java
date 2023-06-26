package tfw.Controller;

import tfw.Entity.User;
import tfw.Service.UserService;

public class UserController extends UserControllerAbstract{
    @Override
    public boolean create(User user, UserService service){
        return service.create(user);
    }
    //    GETS DATA IN DATABASE
    @Override
    public User getUserById(User user, UserService service){
        return service.getUserById(user);
    }
    //    UPDATE DATA IN DATABASE
    @Override
    public boolean update(User user, UserService service){
        return service.update(user);
    }
    //    DELETE DATA IN DATABASE
    @Override
    public boolean delete(User user, UserService service){
        return service.delete(user);
    }
}
