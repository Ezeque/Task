package tfw.Controller;

import tfw.Entity.Project;
import tfw.Service.ProjectService;

import java.sql.SQLException;

public class ProjectController extends ProjectControllerAbstract {

    public ProjectController(Project project, ProjectService service) {
        super();
    }

    @Override
    public void PrintProject(Project project) {
        System.out.println(project.getName());
    }

    @Override
    public boolean deleteProject(Project project, ProjectService service) throws SQLException {
        return service.delete(project);
    }

    @Override
    public boolean createProject(Project project, ProjectService service) throws SQLException {
        return service.create(project);
    }

    @Override
    public Project SearchProject(Project project, ProjectService service) throws SQLException {
        return service.search(project);
    }

    @Override
    public boolean updateProject(Project project, ProjectService service) throws SQLException {
        return service.update(project);
    }
}
