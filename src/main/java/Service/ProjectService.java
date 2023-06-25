package Service;

import Dao.DAO;
import Entity.Project;
import Entity.User;

public abstract class ProjectService {
    public DAO dao;

    public abstract boolean validateCreation(Project   user, String entityName);
    public abstract boolean validateSearch(Project   user, String entityName);
    public abstract boolean validateUpdate(Project   user, String entityName);
    public abstract boolean validateDeletion(Project   user, String entityName);
}
