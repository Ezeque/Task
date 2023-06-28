package view;

import database.DBConfigAluno;
import entity.Aluno;
import service.AlunoService;
import tfw.Controller.UserController;

import java.util.Scanner;

public class MenuLogin implements MenuLoginInterface {
    private UserController controller;
    private AlunoService service;
    Aluno alunoLogado;
    boolean isLogged = false;

    public MenuLogin(){
        DBConfigAluno dbConfig = new DBConfigAluno();
        AlunoService service = new AlunoService(dbConfig);
        this.controller = new UserController(service);
    }

    @Override
    public void show() {
        while(true){
            Scanner scanner = new Scanner(System.in);
            int opcao;
            if(isLogged == true){
                MenuInterface menuPrincipal = new MenuPrincipal();
                menuPrincipal.show(alunoLogado);
            }
            else {
                System.out.println(" 1) Login \n 2) Cadastrar-se");
                opcao = scanner.nextInt();
                MenuLoginInterface menuLogin = new MenuLogin();
                if(opcao == 1){
                    fazerLogin();
                }
                if(opcao == 2){
                    cadastrar();
                }
            }
        }
    }

    private void fazerLogin(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Login: ");
        String login = scanner.nextLine();
        System.out.println("Senha: ");

        String senha = scanner.nextLine();
        Aluno aluno = new Aluno(login,"", senha,1);
        alunoLogado = (Aluno) controller.login(aluno);
        if(alunoLogado != null){
            isLogged = true;
        }
        else {
            System.out.println("Usuário Inexistente");
        }
    }

    public void cadastrar(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Login: ");
        String login = scanner.nextLine();
        System.out.println("Email: ");
        String email = scanner.nextLine();
        System.out.println("Senha: ");
        String senha = scanner.nextLine();
        alunoLogado = new Aluno(login, email, senha, 1);
        controller.create(alunoLogado);
        isLogged = true;
    }
}
