package service;

import dao.ProjetoDAO;
import tfw.Database.DatabaseConfiguration;
import tfw.Entity.Project;
import tfw.Service.ProjectService;

import java.sql.SQLException;

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

    public boolean create(Project project, Usuario user) throws SQLException {
        if (validateCreation(project)) {
            ProjetoDAO dao = new ProjetoDAO(config);
            return dao.create(project, user);
        }
        return false;
    }
}
