package view;

import database.DBConfigTarefa;
import entity.Usuario;
import tfw.Controller.TaskController;
import tfw.Entity.ConcreteTask;
import tfw.Entity.Project;
import tfw.Service.TaskService;

import java.util.Scanner;

public class MenuTarefas implements Menu {
    DBConfigTarefa config;
    TaskService service;
    TaskController controller;

    public MenuTarefas(TaskService service) {
        this.config = new DBConfigTarefa();
        this.service = service;
        this.controller = new TaskController(service);
    }

    @Override
    public void show(Usuario usuario) {

    }

    public void criarTarefa(Project projeto) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira o nome da tarefa:");
        String nome = scanner.nextLine();
        ConcreteTask task = new ConcreteTask(projeto.getId(), nome);
        try {
            controller.createTask(task, service);
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
}
