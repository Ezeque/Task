package service;

import database.DBConfigAluno;
import tfw.Dao.UserDAO;
import tfw.Database.DatabaseConfiguration;
import tfw.Entity.User;
import tfw.Service.UserService;

public class AlunoService extends UserService {

    public AlunoService(DBConfigAluno dbConfig) {
        super(dbConfig);
    }


    @Override
    public boolean validateCreation(User user) {
        if(user.getName().length() > 1 && user.getPassword().length() > 1 &&
                user.getEmail().contains("@")){
            return true;
        }
        return false;
    }

    @Override
    public boolean validateSearch(User user) {
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
}
