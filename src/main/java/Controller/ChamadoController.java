package Controller;

import entity.Chamado;
import tfw.Controller.TaskController;
import tfw.Entity.Task;
import tfw.Service.TaskService;

import java.util.ArrayList;

public class ChamadoController extends TaskController {
    public ChamadoController(TaskService service) {
        super(service);
    }

    public Chamado taskTochamado(Task task){
        Chamado chamado = new Chamado();

        chamado.setId(task.getId());
        chamado.setName(task.getName());
        chamado.setProjectID(task.getProjectID());
        chamado.setUserID(task.getUserID());
        chamado.setDescription(task.getDescription());

        return chamado;
    }

    public ArrayList<Chamado> tasksToChamados(ArrayList<Task> tasks){
        ArrayList<Chamado> chamados = new ArrayList<>();

        for(Task task : tasks){
            Chamado chamado = taskTochamado(task);
            chamados.add(chamado);
        }

        return chamados;
    }
}
