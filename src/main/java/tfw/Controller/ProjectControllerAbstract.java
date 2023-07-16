package tfw.Controller;

import tfw.Entity.Project;
import tfw.Service.ProjectService;

import java.sql.SQLException;
import java.util.ArrayList;

public abstract class ProjectControllerAbstract {
    ProjectService service;

    public ProjectControllerAbstract(ProjectService service) {
        this.service = service;
    }

    public abstract void PrintProject(Project project);

    public abstract boolean deleteProject(Project project);

    public abstract boolean createProject(Project project);

    public abstract Project SearchProject(Project project);
    public abstract Project getProjectByName(Project project);

    public abstract boolean updateProject(Project project);

    public abstract ArrayList<Project> getAllProjects();

}
