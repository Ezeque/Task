package entity;

import database.DBConfigTarefa;
import service.TarefaService;
import tfw.Controller.TaskController;
import tfw.Database.DatabaseConfiguration;
import tfw.Entity.ConcreteProject;
import tfw.Entity.ConcreteTask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Projeto extends ConcreteProject {
    public Projeto(int id, String name, int userId) {
        super(id, name, userId);
    }

    public Projeto(String name, int userId) {
        super(name, userId);
    }

    @Override
    public Map<String, Integer> setMetrics() {
        DatabaseConfiguration config = new DBConfigTarefa();
        TarefaService service = new TarefaService(config);
        TaskController controller = new TaskController(service);
        Projeto projeto = new Projeto(this.getId(), this.getName(), this.userId);
        try {
            ArrayList<ConcreteTask> tarefas = controller.getAllProjectTasks(projeto);
            Map<String, Integer> map = new HashMap<String, Integer>();
            map.put("NumTarefas", tarefas.size());
            return map;
        } catch (Exception e) {
            System.out.println("Erro ao Recuperar métricas");
        }
        return null;
    }
}
