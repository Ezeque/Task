package controller;

import tfw.Controller.UserController;
import tfw.Entity.User;
import tfw.Service.UserService;

public class AlunoController extends UserController {
    public AlunoController(User user, UserService service) {
        super(user, service);
    }
}
