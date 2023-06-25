package Controller;

import Entity.Project;
import Service.ProjectService;

import java.sql.SQLException;

public abstract class ProjectControllerAbstract {
    Project project;
    ProjectService services;

    public ProjectControllerAbstract(Project project, ProjectService service){
        this.project = project;
        this.services = service;
    }

    public abstract void PrintProject(Project project);

    public abstract boolean deleteProject(Project project) throws SQLException;

    public abstract boolean createProject(Project project) throws SQLException;

    public abstract Project SearchProject(Project project) throws SQLException;

    public abstract boolean updateProject(Project project);
}
