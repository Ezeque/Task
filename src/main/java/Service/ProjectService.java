package Service;

import tfw.Dao.ProjectDAO;
import tfw.Dao.ProjectDAOInterface;
import tfw.Database.DatabaseConfiguration;
import tfw.Entity.Project;

import java.sql.SQLException;
import java.util.ArrayList;

public abstract class ProjectService {
    public DatabaseConfiguration config;

    public ProjectService(DatabaseConfiguration config) {
        this.config = config;
    }

    public abstract boolean validateCreation(Project project);

    public abstract boolean validateSearch(Project project);

    public abstract boolean validateUpdate(Project project);

    public abstract boolean validateDeletion(Project project);

    public boolean create(Project project){
        if (validateCreation(project)) {
            ProjectDAOInterface dao = new ProjectDAO(config);
            try {
                return dao.create(project);
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return false;
    }

    public Project search(Project project){
        if (validateSearch(project)) {
            ProjectDAOInterface dao = new ProjectDAO(config);
            try {
                return dao.getProjectById(project);
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return null;
    }

    public Project getProjectByName(Project project){
        if (validateSearch(project)) {
            ProjectDAOInterface dao = new ProjectDAO(config);
            try {
                return dao.getProjectByName(project);
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return null;
    }

    public boolean update(Project project){
        if (validateUpdate(project)) {
            ProjectDAOInterface dao = new ProjectDAO(config);
            try {
                return dao.update(project);
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return false;
    }

    public boolean delete(Project project){
        if (validateDeletion(project)) {
            ProjectDAOInterface dao = new ProjectDAO(config);
            try {
                return dao.delete(project.getId());
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return false;
    }

    public ArrayList<Project> getAllProjecs(){
        ArrayList<Project> projects = new ArrayList<Project>();
        ProjectDAOInterface dao = new ProjectDAO(config);
        try{
            projects = dao.getAll();
        }catch(SQLException e){
            System.out.println(e);
        }
        return projects;
    }

}
