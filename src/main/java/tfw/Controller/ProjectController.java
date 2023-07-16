package tfw.Controller;

import tfw.Entity.Project;
import tfw.Service.ProjectService;

import java.sql.SQLException;
import java.util.ArrayList;

public class ProjectController extends ProjectControllerAbstract {

    public ProjectController(ProjectService service) {
        super(service);
    }

    @Override
    public void PrintProject(Project project) {
        System.out.println(project.getName());
    }

    @Override
    public boolean deleteProject(Project project){
        return service.delete(project);
    }

    @Override
    public boolean createProject(Project project){
        return service.create(project);
    }

    @Override
    public Project SearchProject(Project project){
        return service.search(project);
    }

    @Override
    public Project getProjectByName(Project project){
        return service.getProjectByName(project);
    }

    @Override
    public boolean updateProject(Project project){
        return service.update(project);
    }

    @Override
    public ArrayList<Project> getAllProjects(){
        return service.getAllProjecs();
    }

}
