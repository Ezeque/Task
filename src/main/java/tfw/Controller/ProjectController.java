package tfw.Controller;

import tfw.Entity.Project;
import tfw.Service.ProjectService;

import java.sql.SQLException;

public class ProjectController extends ProjectControllerAbstract {

    public ProjectController(Project project, ProjectService service) {
        super(project, service);
    }

    @Override
    public void PrintProject(Project project) {
        System.out.println(project.getName());
    }

    @Override
    public boolean deleteProject(Project project) throws SQLException {
        return this.services.delete(project);
    }

    @Override
    public boolean createProject(Project project) throws SQLException {
        return this.services.create(project);
    }

    @Override
    public Project SearchProject(Project project) throws SQLException {
        return this.services.search(project);
    }

    @Override
    public boolean updateProject(Project project) throws SQLException {
        return this.services.update(project);
    }
}
