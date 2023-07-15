package controller;

import entity.Usuario;
import tfw.Controller.ProjectController;
import tfw.Entity.Project;
import tfw.Service.ProjectService;

import java.util.ArrayList;

public class ProjetoController extends ProjectController {

    public ProjetoController(ProjectService service) {
        super(service);
    }

    public ArrayList<Project> getAllUserProjects(Usuario user) {
        return this.service.getProjects(user);
    }
}
