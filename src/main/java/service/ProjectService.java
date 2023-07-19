package Service;

import Dao.ProjectDAO;
import Dao.ProjectDAOInterface;
import Database.DatabaseConfiguration;
import Entity.Project;

import java.sql.SQLException;

public abstract class ProjectService {
    public DatabaseConfiguration config;

    public ProjectService(DatabaseConfiguration config) {
        this.config = config;
    }

    public abstract boolean validateCreation(Project project);

    public abstract boolean validateSearch(Project project);

    public abstract boolean validateUpdate(Project project);

    public abstract boolean validateDeletion(Project project);

    public boolean create(Project project) throws SQLException {
        if (validateCreation(project)) {
            ProjectDAOInterface dao = new ProjectDAO(config);
            return dao.create(project);
        }
        return false;
    }

    public Project search(Project project) throws SQLException {
        if (validateSearch(project)) {
            ProjectDAOInterface dao = new ProjectDAO(config);
            return dao.getProjectById(project);
        }
        return null;
    }

    public boolean update(Project project) throws SQLException {
        if (validateUpdate(project)) {
            ProjectDAOInterface dao = new ProjectDAO(config);
            return dao.update(project);
        }
        return false;
    }

    public boolean delete(Project project) throws SQLException {
        if (validateDeletion(project)) {
            ProjectDAOInterface dao = new ProjectDAO(config);
            return dao.delete(project.getId());
        }
        return false;
    }
}
