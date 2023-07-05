package view;

import controller.AlunoController;
import controller.RelatorioAlunoController;
import database.DBConfigAluno;
import database.DBConfigRelatorioAluno;
import entity.Aluno;
import entity.RelatorioAluno;
import service.AlunoService;
import service.RelatorioAlunoService;
import tfw.Controller.UserController;

import java.sql.SQLException;
import java.util.Scanner;

public class MenuLogin implements MenuLoginInterface {
    private UserController controller;
    private AlunoService service;
    Aluno alunoLogado;
    boolean isLogged = false;

    public MenuLogin() {
        DBConfigAluno dbConfig = new DBConfigAluno();
        AlunoService service = new AlunoService(dbConfig);
        this.controller = new UserController(service);
    }

    @Override
    public void show() throws SQLException {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            int opcao;
            if (isLogged == true) {
                MenuInterface menuPrincipal = new MenuPrincipal();
                try {
                    menuPrincipal.show(alunoLogado);
                } catch (SQLException e) {
                    System.out.println(e);
                }
            } else {
                System.out.println(" 1) Login \n 2) Cadastrar-se");
                opcao = scanner.nextInt();
                MenuLoginInterface menuLogin = new MenuLogin();
                if (opcao == 1) {
                    fazerLogin();
                }
                if (opcao == 2) {
                    cadastrar();
                }
            }
        }
    }

    //  EXIBE O MENU DE LOGIN DE USUÁRIOS
    private void fazerLogin() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Login: ");
        String login = scanner.nextLine();
        System.out.println("Senha: ");

        String senha = scanner.nextLine();
        Aluno aluno = new Aluno(login, "", senha, 1);
        DBConfigAluno configAluno = new DBConfigAluno();
        AlunoService alunoService = new AlunoService(configAluno);
        AlunoController alunoController = new AlunoController(alunoService);
        alunoLogado = (Aluno) alunoController.login(aluno);
        if (alunoLogado != null) {
            isLogged = true;
        } else {
            System.out.println("Usuário Inexistente");
        }
    }

    // EXIBE O MENU DE REGISTRO DE USUÁRIOS
    public void cadastrar() {
        //cria o usuario
        Scanner scanner = new Scanner(System.in);
        System.out.println("Login: ");
        String login = scanner.nextLine();
        System.out.println("Email: ");
        String email = scanner.nextLine();
        System.out.println("Senha: ");
        String senha = scanner.nextLine();
        alunoLogado = new Aluno(login, email, senha, 1);
        controller.create(alunoLogado);

        //adiciona o relatorio do usuario
        Aluno alunoCadastrado = (Aluno) controller.getUserByName(alunoLogado);
        DBConfigRelatorioAluno relatorioConfig = new DBConfigRelatorioAluno();
        RelatorioAlunoService relatorioService = new RelatorioAlunoService(relatorioConfig);
        RelatorioAlunoController relatorioController = new RelatorioAlunoController(relatorioService);
        RelatorioAluno relatorio = new RelatorioAluno(alunoCadastrado.getId());
        relatorioController.saveRelatorio(relatorio);

        //
        isLogged = true;
        DBConfigAluno dbConfigAluno = new DBConfigAluno();
        AlunoService alunoService = new AlunoService(dbConfigAluno);
        AlunoController alunoController = new AlunoController(alunoService);
    }
}
