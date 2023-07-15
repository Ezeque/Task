package Controller;

import database.DBConfigFuncionario;
import entity.Funcionario;
import service.FuncionarioService;
import tfw.Controller.UserController;
import tfw.Database.DatabaseConfiguration;
import tfw.Entity.User;
import tfw.Service.UserService;

import java.util.ArrayList;

public class FuncionarioController extends UserController {
    DatabaseConfiguration config = new DBConfigFuncionario();
    FuncionarioService funcService = new FuncionarioService(config);
    public FuncionarioController(UserService service){
        super(service);
    }

    public Funcionario UserToFuncionario(User user){
        Funcionario funcionario = new Funcionario();

        funcionario.setEmail(user.getEmail());
        funcionario.setName(user.getName());
        funcionario.setPassword(user.getPassword());
        funcionario.setId(user.getId());

        return funcionario;
    }

    public boolean setStatus(User user, int status){
        Funcionario funcionario = UserToFuncionario(user);
        funcionario.setStatus(status);
        return this.funcService.setStatus(funcionario);
    }

    public int getStatus(User user){
        Funcionario funcionario = UserToFuncionario(user);
        return this.funcService.getStatus(funcionario);
    }

    public Funcionario userToFuncionario(User user){
        Funcionario funcionario = new Funcionario();

        funcionario.setName(user.getName());
        funcionario.setPassword(user.getPassword());
        funcionario.setId(user.getId());
        funcionario.setPassword(user.getPassword());
        funcionario.setEmail(user.getEmail());

        return funcionario;
    }

    public ArrayList<Funcionario> usersToFuncionarios(ArrayList<User> users){
        ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();

        for(User user : users){
            Funcionario funcionario = userToFuncionario(user);
            funcionarios.add(funcionario);
        }

        return funcionarios;
    }


}
