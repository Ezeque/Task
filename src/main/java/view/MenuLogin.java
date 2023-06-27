package view;

import database.DBConfigAluno;
import entity.Aluno;
import service.AlunoService;
import tfw.Controller.UserController;

import java.util.Scanner;

public class MenuLogin implements MenuInterface {
    private UserController controller;
    private AlunoService service;

    public MenuLogin(){
        DBConfigAluno dbConfig = new DBConfigAluno();
        AlunoService service = new AlunoService(dbConfig);
        this.controller = new UserController(service);
    }

    @Override
    public void show(int opcao) {
        Scanner scanner = new Scanner(System.in);
        if(opcao == 1){
            System.out.println("Login: ");
            String login = scanner.nextLine();
            System.out.println("Senha: ");

            String senha = scanner.nextLine();
            Aluno aluno = new Aluno(login,"", senha,1);
            Aluno alunoEncontrado = (Aluno) controller.login(aluno);
        }
        if(opcao == 2){
            System.out.println("Login: ");
            String login = scanner.nextLine();
            System.out.println("Email: ");
            String email = scanner.nextLine();
            System.out.println("Senha: ");
            String senha = scanner.nextLine();
            Aluno aluno = new Aluno(login, email, senha, 1);
            controller.create(aluno);
        }
    }
}
