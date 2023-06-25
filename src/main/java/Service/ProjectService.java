package Service;

import Dao.DAO;
import Entity.Project;

public abstract class ProjectService {
    public DAO dao;

    public abstract boolean validate(Project project);

}
