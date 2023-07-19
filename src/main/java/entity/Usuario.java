package entity;

import controller.ProjetoController;
import database.DBConfigProjeto;
import database.DBConfigTarefa;
import service.ProjetoService;
import service.TarefaService;
import tfw.Controller.TaskController;
import tfw.Database.DatabaseConfiguration;
import tfw.Entity.ConcreteTask;
import tfw.Entity.Project;
import tfw.Entity.User;
import tfw.Service.ProjectService;
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
//        CAPTURANDO DADOS DE TAREFAS PARA RELATÓRIO
        DatabaseConfiguration config = new DBConfigTarefa();
        TaskService service = new TarefaService(config);
        TaskController controller = new TaskController(service);
        Usuario user = new Usuario(this.getId(), this.getName(), this.getEmail(), this.getPassword());
        try {
            ArrayList<ConcreteTask> tarefas = controller.getAllUserTasks(user);
            ArrayList<ConcreteTask> tarefasConcluidas = new ArrayList<ConcreteTask>();
            for (ConcreteTask tarefa :
                    tarefas) {
                if (!tarefa.getStatus().equals("ongoing")) {
                    tarefasConcluidas.add(tarefa);
                }
            }
//            CAPTURANDO DADOS DE PROJETOS PARA RELATÓRIO

            DatabaseConfiguration configProjeto = new DBConfigProjeto();
            ProjectService serviceProjeto = new ProjetoService(configProjeto);
            ProjetoController controllerProjeto = new ProjetoController(serviceProjeto);
            ArrayList<Project> projetos = controllerProjeto.getAllUserProjects(user);

            Map<String, Integer> map = new HashMap<String, Integer>();
            map.put("qntTarefas", tarefas.size());
            map.put("qntTarefasConcluidas", tarefasConcluidas.size());
            map.put("porcentagemTarefasConcluidas", (tarefasConcluidas.size() / tarefas.size()) * 100);
            map.put("qntProjetos", projetos.size());
            return map;
        } catch (Exception e) {
            System.out.println("Erro ao processar métricas");
        }
        return null;
    }
}
