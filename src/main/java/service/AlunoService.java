package service;

import database.DBConfigAluno;
import entity.Plano;
import tfw.Entity.User;
import tfw.Service.UserService;

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
        return false;
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
}
