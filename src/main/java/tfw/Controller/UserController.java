package tfw.Controller;

import service.AlunoService;
import tfw.Entity.User;
import tfw.Service.UserService;

public class UserController extends UserControllerAbstract{

    public UserController(UserService service) {
        super(service);
    }

    @Override
    public boolean create(User user){
        return this.service.create(user);
    }
    //    GETS DATA IN DATABASE
    @Override
    public User getUserById(User user){
        return this.service.getUserById(user);
    }
    //    UPDATE DATA IN DATABASE
    @Override
    public boolean update(User user){
        return this.service.update(user);
    }
    //    DELETE DATA IN DATABASE
    @Override
    public boolean delete(User user){
        return this.service.delete(user);
    }
}
