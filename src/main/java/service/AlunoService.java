package service;

import tfw.Dao.UserDAO;
import tfw.Entity.User;
import tfw.Service.UserService;

public class AlunoService extends UserService {
    public AlunoService(UserDAO dao) {
        super(dao);
    }

    @Override
    public boolean validateCreation(User user, String entityName) {
        return false;
    }

    @Override
    public boolean validateSearch(User user, String entityName) {
        return false;
    }

    @Override
    public boolean validateUpdate(User user, String entityName) {
        return false;
    }

    @Override
    public boolean validateDeletion(User user, String entityName) {
        return false;
    }
}
