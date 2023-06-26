package tfw.Controller;

import tfw.Entity.User;
import tfw.Service.UserService;

public class UserController extends UserControllerAbstract{
    public UserController(User user, UserService service) {
        super(user, service);
    }
    @Override
    public boolean create(User user, String entityName){
        return service.create(user, entityName);
    }
    //    GETS DATA IN DATABASE
    @Override
    public User getUserById(User user, String entityName){
        return service.getUserById(user, entityName);
    }
    //    UPDATE DATA IN DATABASE
    @Override
    public boolean update(User user, String entityName){
        return service.update(user, entityName);
    }
    //    DELETE DATA IN DATABASE
    @Override
    public boolean delete(User user, String entityName){
        return service.delete(user, entityName);
    }
}
