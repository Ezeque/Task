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
        if (tarefa.getStatus().equals("ongoing")) System.out.println("[2] Marcar Como Concluída");
        else System.out.println("[2] Marcar Como Não Concluída");
        System.out.println("[3] Excluir tarefa");
        System.out.println("[4] Sair");
        opcao = scanner.nextInt();
        try {
            switch (opcao) {
                case 1 -> editarTarefa(tarefa);
                case 2 -> atualizarStatus(tarefa);
                case 3 -> controller.deleteTask(tarefa, service);
            }
        } catch (Exception e) {
            System.out.println("Houve um erro ao processar a tarefa.");
        }


    }

    public void atualizarStatus(Task tarefa) {
        if (tarefa.getStatus().equals("ongoing")) {
            tarefa.setStatus("finished");
        } else if (tarefa.getStatus().equals("finished")) {
            tarefa.setStatus("ongoing");
        }
        try {
            controller.updateTask(tarefa, service);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void editarTarefa(Task tarefa) {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        System.out.println("1) Editar Nome \n2) Editar Descrição \n3) Voltar");
        opcao = scanner.nextInt();
        switch (opcao) {
            case 1:
                System.out.println("Insira um novo Nome:");
                scanner.nextLine();
                String nome = scanner.nextLine();
                tarefa.setName(nome);
                break;
            case 2:
                System.out.println("Insira uma nova Descrição:");
                scanner.nextLine();
                String descricao = scanner.nextLine();
                tarefa.setDescription(descricao);
                break;
            case 3:
                gerenciarTarefa(tarefa);
                break;
        }
        try {
            controller.updateTask(tarefa, service);
        } catch (Exception e) {
            System.out.println("Não foi possível editar a tarefa.");
        }
    }
}
