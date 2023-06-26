package service;

import tfw.Dao.UserDAO;
import tfw.Database.DatabaseConfiguration;
import tfw.Entity.User;
import tfw.Service.UserService;

public class AlunoService extends UserService {
    public AlunoService(UserDAO dao) {
        super(dao);
    }
    public AlunoService() {
        DatabaseConfiguration configuration
        UserDAO dao = new UserDAO();
        super(dao); }

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
