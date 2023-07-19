package tfw.Controller;

import tfw.Entity.User;
import tfw.Service.UserService;

import java.util.ArrayList;

public class UserController extends UserControllerAbstract {

    public UserController(UserService service) {
        super(service);
    }

    @Override
    public boolean create(User user) {
        return this.service.create(user);
    }

    //    GETS DATA IN DATABASE
    @Override
    public User getUserById(User user) {
        return this.service.getUserById(user);
    }

    public User getUserByName(User user) {
        return this.service.getUserByName(user);
    }

    public User getUserByEmail(User user) {
        return this.service.getUserByEmail(user);
    }

    public User login(User user) {
        return this.service.login(user);
    }

    //    UPDATE DATA IN DATABASE
    @Override
    public boolean update(User user) {
        return this.service.update(user);
    }

    //    DELETE DATA IN DATABASE
    @Override
    public boolean delete(User user) {
        return this.service.delete(user);
    }

    @Override
    public ArrayList<User> getAllUsers(){
        return service.getAllUsers();
    }

    @Override
    public ArrayList<User> getAllUsersByProjectId(int project_id){
        return service.getAllUsersByProjectId(project_id);
    }
}
