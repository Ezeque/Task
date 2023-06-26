package controller;

import tfw.Controller.ProjectController;
import tfw.Entity.Project;
import tfw.Service.ProjectService;

public class PlanoController extends ProjectController {
    public PlanoController(Project project, ProjectService service) {
        super(project, service);
    }
}
