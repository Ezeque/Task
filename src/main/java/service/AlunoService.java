package service;

import dao.AlunoDAO;
import dao.PlanoDAO;
import database.DBConfigAluno;
import entity.Aluno;
import entity.Plano;
import tfw.Database.DatabaseConfiguration;
import tfw.Entity.User;
import tfw.Service.UserService;

import java.sql.SQLException;

public class AlunoService extends UserService {

    public AlunoService(DBConfigAluno dbConfig) {
        super(dbConfig);
    }


    @Override
    public boolean validateCreation(User user) {
        if (user.getName().length() > 1 && user.getPassword().length() > 1 &&
                user.getEmail().contains("@")) {
            return true;
        }
        return false;
    }

    @Override
    public boolean validateSearch(User user) {
        return true;
    }

    @Override
    public boolean validateSearchByName(User user) {
        if (user.getName().length() > 1) {
            return true;
        }
        return false;
    }

    public boolean validateLogin(User user) {
        if (user.getName().length() > 1 && user.getPassword().length() > 1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean validateUpdate(User user) {
        return false;
    }

    @Override
    public boolean validateDeletion(User user) {
        return false;
    }

    public boolean validateSetPlano(Plano plano) {
        if (plano.getId() > 0) {
            return true;
        }
        return false;
    }

    public Plano searchPlanoAluno(Plano plano, Aluno aluno) throws SQLException {
        DatabaseConfiguration config = new DBConfigAluno();
        if (validateSearch(aluno)) {
            PlanoDAO dao = new PlanoDAO(config);
            return dao.getProjectByAluno(plano, aluno);
        }
        return null;
    }

    @Override
    public User login(User user) {
        if (validateLogin(user)) {
            try {
                DBConfigAluno configAluno = new DBConfigAluno();
                AlunoDAO dao = new AlunoDAO(configAluno);
                return dao.login(user);
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return null;
    }
}
