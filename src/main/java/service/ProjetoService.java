package service;

import tfw.Database.DatabaseConfiguration;
import tfw.Entity.Project;
import tfw.Service.ProjectService;

public class ProjetoService extends ProjectService {
    public ProjetoService(DatabaseConfiguration config) {
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
