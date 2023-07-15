package service;

import database.DBConfigSetor;
import tfw.Database.DatabaseConfiguration;
import tfw.Entity.Project;
import tfw.Service.ProjectService;

public class SetorService extends ProjectService {

    public SetorService(DatabaseConfiguration config) {
        super(config);
    }

    @Override
    public boolean validateCreation(Project project) {
        return true;
    }

    @Override
    public boolean validateSearch(Project project) {
        return true;
    }

    @Override
    public boolean validateUpdate(Project project) {
        return true;
    }

    @Override
    public boolean validateDeletion(Project project) {
        return true;
    }
}