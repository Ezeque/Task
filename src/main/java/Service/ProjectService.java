package Service;

import Dao.DAO;
import Dao.ProjectDAO;
import Dao.ProjectDAOInterface;
import Entity.Project;
import Entity.User;

import java.sql.SQLException;

public abstract class ProjectService {
    public ProjectDAOInterface dao;

    public abstract boolean validateCreation(Project project);
    public abstract boolean validateSearch(Project project);
    public abstract boolean validateUpdate(Project project);
    public abstract boolean validateDeletion(Project project);
    public boolean create(Project project) throws SQLException {
        if(validateCreation(project)){
            return this.dao.create(project);
        }
        return false;
    }
    public Project search(Project   project) throws SQLException {
        if(validateSearch(project)){
            return this.dao.getProjectById(project);
        }
        return null;
    }
    public boolean update(Project   project) throws SQLException {
        if(validateUpdate(project)){
            return this.dao.update(project);
        }
        return false;
    }
    public boolean delete(Project   project) throws SQLException {
        if(validateDeletion(project)){
            return this.dao.delete(project.getId());
        }
        return false;
    }
}
