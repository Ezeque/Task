package view;

import database.DBConfigTarefa;
import tfw.Controller.TaskController;
import tfw.Entity.ConcreteTask;
import tfw.Entity.Project;
import tfw.Entity.Task;
import tfw.Service.TaskService;

import java.util.Scanner;

public class MenuTarefas {
    DBConfigTarefa config;
    TaskService service;
    TaskController controller;

    public MenuTarefas(TaskService service) {
        this.config = new DBConfigTarefa();
        this.service = service;
        this.controller = new TaskController(service);
    }

    public void criarTarefa(Project projeto) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira o nome da tarefa:");
        String nome = scanner.nextLine();
        ConcreteTask task = new ConcreteTask(projeto.getId(), nome);
        System.out.println("Insira a Descrição da Tarefa:");
        String descricao = scanner.nextLine();
        task.setDescription(descricao);
        task.setStatus("andamento");
        try {
            controller.createTask(task, service);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void gerenciarTarefa(Task tarefa) {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        System.out.println("TAREFA: " + tarefa.getName());
        System.out.println("DESCRICAO: " + tarefa.getDescription());
        System.out.println("[1] Editar");
        System.out.println("[2] Marcar Como Concluída");
        System.out.println("[3] Adicionar Participante");
        System.out.println("[4] Sair");
        opcao = scanner.nextInt();

    }
}
