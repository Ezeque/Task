package entity;

import database.DBConfigUsuario;
import service.TarefaService;
import tfw.Controller.TaskController;
import tfw.Database.DatabaseConfiguration;
import tfw.Entity.ConcreteTask;
import tfw.Entity.User;
import tfw.Service.TaskService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Usuario extends User {
    public Usuario(String name, String email, String password, int id) {
        super(name, email, password, id);
    }

    public Usuario(String name, String email, String password) {
        super(name, email, password);
    }

    public Usuario(int id, String email) {
        super(id, email);
    }

    public Usuario(int id, String name, String email, String password) {
        super(id, name, email, password);
    }

    @Override
    public Map<String, Integer> setMetrics() {
        DatabaseConfiguration config = new DBConfigUsuario();
        TaskService service = new TarefaService(config);
        TaskController controller = new TaskController(service);
        Usuario user = new Usuario(this.getId(), this.getName(), this.getEmail(), this.getPassword());
        try {
            ArrayList<ConcreteTask> tarefas = controller.getAllUserTasks(user);
            Map<String, Integer> map = new HashMap<String, Integer>();
            map.put("qntTarefas", tarefas.size());
        } catch (Exception e) {
            System.out.println("Erro ao processar métricas");
        }
        return null;
    }
}
