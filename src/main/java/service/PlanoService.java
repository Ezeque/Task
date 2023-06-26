package service;

import tfw.Dao.ProjectDAOInterface;
import tfw.Entity.Project;
import tfw.Service.ProjectService;

public class PlanoService extends ProjectService {
    public PlanoService(ProjectDAOInterface dao) {
        super(dao);
    }

    @Override
    public boolean validateCreation(Project project) {
        return false;
    }

    @Override
    public boolean validateSearch(Project project) {
        return false;
    }

    @Override
    public boolean validateUpdate(Project project) {
        return false;
    }

    @Override
    public boolean validateDeletion(Project project) {
        return false;
    }
}
