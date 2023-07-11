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
