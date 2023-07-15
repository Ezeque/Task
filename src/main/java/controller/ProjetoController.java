package controller;

import entity.Usuario;
import service.ProjetoService;
import tfw.Controller.ProjectController;
import tfw.Entity.Project;
import tfw.Service.ProjectService;

import java.sql.SQLException;
import java.util.ArrayList;

public class ProjetoController extends ProjectController {

    public ProjetoController(ProjectService service) {
        super(service);
    }

    public ArrayList<Project> getAllUserProjects(Usuario user) {
        return this.service.getProjects(user);
    }

    public boolean createProject(Project project, Usuario user, ProjetoService service) throws SQLException {
        return service.create(project, user);
    }
}
