package view;

import controller.ProjetoController;
import database.DBConfigProjeto;
import entity.Usuario;
import service.ProjetoService;
import tfw.Entity.ConcreteProject;
import tfw.Entity.Project;
import tfw.Service.ProjectService;

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