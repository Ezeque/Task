package view;

import database.DBConfigUsuario;
import entity.RelatorioUsuario;
import entity.Usuario;
import service.UsuarioService;
import tfw.Controller.UserController;
import tfw.Service.UserService;

import java.util.Map;
import java.util.Scanner;

public class MenuUsuario implements Menu {
    DBConfigUsuario config;
    UserService service;
    UserController controller;
    Usuario usuario;

    public MenuUsuario(Usuario usuario) {
        this.usuario = usuario;
        this.config = new DBConfigUsuario();
        this.service = new UsuarioService(config);
        this.controller = new UserController(service);
    }

    @Override
    public void show(Usuario usuario) {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        System.out.println("1) Editar Usuário \n2) Gerar Relatório de Usuário");
        opcao = scanner.nextInt();
        switch (opcao) {
            case 1 -> editarUsuario(usuario);
            case 2 -> gerarRelatorio(usuario);
        }
        MenuPrincipal menuPrincipal = new MenuPrincipal();

        menuPrincipal.show(usuario);
    }

    private void gerarRelatorio(Usuario usuario) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> metricas = usuario.setMetrics();
        RelatorioUsuario relatorioUsuario = new RelatorioUsuario(usuario.getId());
        relatorioUsuario.setStructure(metricas);
        relatorioUsuario.show();
        System.out.println("Digite Qualquer Tecla para Continuar...");
        scanner.next();
    }

    private void editarUsuario(Usuario usuario) {
        int opcao;
        Scanner scanner = new Scanner(System.in);
        System.out.println("1) Editar Nome \n2) Editar Email \n3) Editar Senha");
        opcao = scanner.nextInt();
        switch (opcao) {
            case 1:
                System.out.println("Informe seu novo nome de Usuário");
                scanner.nextLine();
                String nome = scanner.nextLine();
                usuario.setName(nome);
                break;
            case 2:
                System.out.println("Informe seu novo Email");
                scanner.nextLine();
                String email = scanner.nextLine();
                usuario.setEmail(email);
                break;
            case 3:
                System.out.println("Informe sua nova Senha");
                scanner.nextLine();
                String senha = scanner.nextLine();
                usuario.setPassword(senha);
                break;
            default:
                System.out.println("Opção inválida");
        }
        controller.update(usuario);
        System.out.println("Usuário aualizado com sucesso!");
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        menuPrincipal.show(usuario);
    }
}
