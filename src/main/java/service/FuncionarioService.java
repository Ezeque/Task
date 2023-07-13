package service;

import DAO.FuncionarioDAO;
import entity.Funcionario;
import tfw.Database.DatabaseConfiguration;
import tfw.Entity.User;
import tfw.Service.UserService;

import java.sql.SQLException;

public class FuncionarioService extends UserService {
    FuncionarioDAO dao;

    public FuncionarioService(DatabaseConfiguration dbconfig) {
        super(dbconfig);
        this.dao = new FuncionarioDAO(dbconfig);
    }

    @Override
    public boolean validateCreation(User user) {
        return true;
    }

    @Override
    public boolean validateSearch(User user) {
        return true;
    }

    @Override
    public boolean validateSearchByName(User user) {
        return true;
    }

    @Override
    public boolean validateSearchByEmail(User user) {
        return true;
    }

    @Override
    public boolean validateLogin(User user) {
        Funcionario userCopy = new Funcionario();
        userCopy.setPassword(user.getPassword());
        userCopy.setName(user.getName());

        return validateName(user) && validatePassword(userCopy);
    }

    public boolean validateName(User user){
        Funcionario funcionario = new Funcionario();


        try{
            funcionario = (Funcionario) dao.getUserByName(user);
        }catch(SQLException e){
            System.out.println(e);
        }


        if(funcionario == null){
            System.out.println("Login não cadastrado!");
            return false;
        }

        return true;
    }

    public boolean validatePassword(User user){
        Funcionario funcionario = new Funcionario();

        Funcionario userCopy = new Funcionario();
        userCopy.setPassword(user.getPassword());
        userCopy.setName(user.getName());

        try{
            funcionario = (Funcionario) dao.getUserByName(user);
        }catch(SQLException e){
            System.out.println(e);
        }

        if(funcionario == null){
            return false;
        }

        if(funcionario.getPassword().equals(userCopy.getPassword())){
            return true;
        }
        else{
            System.out.println("Senha incorreta!");
            return false;
        }

    }

    @Override
    public boolean validateUpdate(User user) {
        return true;
    }

    @Override
    public boolean validateDeletion(User user) {
        return true;
    }
}
