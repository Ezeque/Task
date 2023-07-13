package tfw.Controller;

import tfw.Entity.Project;
import tfw.Service.ProjectService;

import java.sql.SQLException;

public abstract class ProjectControllerAbstract {
    ProjectService service;

    public ProjectControllerAbstract(ProjectService service) {
        this.service = service;
    }

    public abstract void PrintProject(Project project);

    public abstract boolean deleteProject(Project project, ProjectService service) throws SQLException;

    public abstract boolean createProject(Project project, ProjectService service) throws SQLException;

    public abstract Project SearchProject(Project project, ProjectService service) throws SQLException;

    public abstract boolean updateProject(Project project, ProjectService service) throws SQLException;
}
