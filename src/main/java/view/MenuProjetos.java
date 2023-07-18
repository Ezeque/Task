package view;

import controller.ProjetoController;
import database.DBConfigProjeto;
import database.DBConfigTarefa;
import entity.Usuario;
import service.ProjetoService;
import service.TarefaService;
import tfw.Controller.TaskController;
import tfw.Entity.ConcreteProject;
import tfw.Entity.ConcreteTask;
import tfw.Entity.Project;
import tfw.Entity.Task;
import tfw.Service.ProjectService;
import tfw.Service.TaskService;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuProjetos implements Menu {
    Usuario usuario;
    DBConfigProjeto config;
    ProjectService service;
    ProjetoController controller;

    public MenuProjetos(Usuario usuario) {
        this.usuario = usuario;
        this.config = new DBConfigProjeto();
        this.service = new ProjetoService(config);
        this.controller = new ProjetoController(service);
    }

    @Override
    public void show(Usuario usuario) {
        int opcao = 0;
        Scanner scanner = new Scanner(System.in);
        ArrayList<Project> projetos;
        projetos = this.controller.getAllUserProjects(MenuProjetos.this.usuario);
        int index = 0;
        if (projetos.size() > 0) {
            for (Project projeto :
                    projetos) {
                System.out.println("[" + index + "] " + projeto.getName());
                index++;
            }
            System.out.println("____________________");
            System.out.println("[" + index + "] Criar Novo projeto");
            index++;
            System.out.println("[" + index + "] Sair");
            opcao = scanner.nextInt();
            if (opcao == index) {
                MenuPrincipal menuPrincipal = new MenuPrincipal();
                menuPrincipal.show(usuario);
            } else if (opcao == index - 1) {
                criarProjeto(usuario);
            } else if (opcao < index - 1) {
                Project projeto = projetos.get(opcao);
                gerenciarProjeto(projeto);
            }
        } else {
            System.out.println("Não há projetos para esse usuário. Deseja criar um novo projeto? \n1) Sim \n2) Não");
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    criarProjeto(usuario);
            }
        }
    }

    private void gerenciarProjeto(Project projeto) {
        int opcao;
        Scanner scanner = new Scanner(System.in);
        System.out.println(projeto.getName() + ":");
        DBConfigTarefa config = new DBConfigTarefa();
        TaskService service = new TarefaService(config);
        TaskController controller = new TaskController(service);
        try {
            MenuTarefas menuTarefas = new MenuTarefas(service);
            ArrayList<ConcreteTask> tarefas = controller.getAllProjectTasks(projeto);
            int index = 0;
            if (tarefas != null) {
                for (Task tarefa :
                        tarefas) {
                    System.out.println("[" + index + "] " + tarefa.getName() + " ["
                            + (tarefa.getStatus().equals("ongoing") ? " " : "X") + "]");
                    index++;
                }
                System.out.println("_________________");
                System.out.println(index + ") Criar Nova tarefa");
                index++;
                System.out.println(index + ") Excluir Projeto");
                index++;
                System.out.println(index + ") Gerar relatório do Projeto");
                index++;
                System.out.println(index + ") Sair");
                opcao = scanner.nextInt();
                if (opcao < index - 3) {
                    Task tarefa = tarefas.get(opcao);
                    menuTarefas.gerenciarTarefa(tarefa);
                    gerenciarProjeto(projeto);
                } else if (opcao == index - 3) {
                    menuTarefas.criarTarefa(projeto);
                    gerenciarProjeto(projeto);
                    show(usuario);
                } else if (opcao == index - 2) {
                    this.controller.deleteProject(projeto, this.service);
                    gerenciarProjeto(projeto);
                    show(usuario);
                } else if (opcao == index - 1) {
                    this.controller.deleteProject(projeto, this.service);
                    gerenciarProjeto(projeto);
                    show(usuario);
                } else if (opcao >= index) {
                    show(usuario);
                }
            } else {
                System.out.println("Não há tarefas neste projeto. Deseja criar uma nova tarefa? \n1) Sim \n2) Não");
                opcao = scanner.nextInt();
                switch (opcao) {
                    case 1:
                        menuTarefas.criarTarefa(projeto);
                        gerenciarProjeto(projeto);
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void criarProjeto(Usuario usuario) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o Nome do Projeto:");
        String nome = scanner.nextLine();
        Project projeto = new ConcreteProject(nome, usuario.getId());
        try {
            ProjetoService projetoService = new ProjetoService(config);
            controller.createProject(projeto, usuario, projetoService);
        } catch (Exception e) {
            System.out.println(e);
        }
        show(usuario);
    }
}
