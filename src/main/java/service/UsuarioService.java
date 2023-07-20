package service;

import tfw.Database.DatabaseConfiguration;
import tfw.Entity.User;
import tfw.Service.UserService;

public class UsuarioService extends UserService {

    public UsuarioService(DatabaseConfiguration dbconfig) {
        super(dbconfig);
    }

    @Override
    public boolean validateCreation(User user) {

        if (user.getName().length() > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean validateSearch(User user) {
        if (user.getName().length() > 0 && user.getId() > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean validateSearchByName(User user) {
        if (user.getName().length() > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean validateSearchByEmail(User user) {
        return true;
    }

    @Override
    public boolean validateLogin(User user) {
        return true;
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
