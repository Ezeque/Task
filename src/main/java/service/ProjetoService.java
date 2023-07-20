package service;

import dao.ProjetoDAO;
import entity.Usuario;
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
        if (project.getName().length() > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean validateSearch(Project project) {
        if (project.getName().length() > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean validateUpdate(Project project) {
        if (project.getName().length() > 0) {
            return true;
        }
        return false;
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
