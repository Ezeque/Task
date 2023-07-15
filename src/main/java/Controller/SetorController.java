package Controller;

import entity.Setor;
import tfw.Controller.ProjectController;
import tfw.Entity.Project;
import tfw.Service.ProjectService;

import java.util.ArrayList;

public class SetorController extends ProjectController {

    public SetorController(ProjectService service) {
        super(service);
    }

    public ArrayList<Setor> projectsToSetores(ArrayList<Project> projects){
        ArrayList<Setor> setores = new ArrayList<Setor>();

        for(Project project : projects){
            Setor setor = projectToSetor(project);
            setores.add(setor);
        }

        return setores;
    }

    public Setor projectToSetor(Project project){
        Setor setor = new Setor("");
        setor.setId(project.getId());
        setor.setName(project.getName());
        return setor;
    }
}
