package view;

import Controller.FuncionarioController;
import database.DBConfigFuncionario;
import entity.Funcionario;
import service.FuncionarioService;
import tfw.Controller.UserController;
import tfw.Entity.User;
import tfw.Service.UserService;

import java.util.Scanner;

public class Login implements MenuLogin {
    DBConfigFuncionario config = new DBConfigFuncionario();
    UserService service = new FuncionarioService(config);
    FuncionarioController controller = new FuncionarioController(service);
    Funcionario funcionarioLogado;
    Scanner scanner = new Scanner(System.in);

    @Override
    public void show() {
        boolean login = false;
        while(!login){
            System.out.println("Bem vindo ao SuportMaster!");
            System.out.println("Possui cadastro? (s/n)");
            String opcao = scanner.nextLine();
            switch (opcao) {
                case "s":
                    login = login();
                    break;
                case "n":
                    signUp();
                    break;
            }
        }
    }

    public boolean login() {
        boolean success = false;

        System.out.println("Login:");
        String login = scanner.nextLine();

        System.out.println("Senha:");
        String senha = scanner.nextLine();

        Funcionario user = new Funcionario(login, "", senha);

        User userLogado = controller.login(user);

        if(userLogado == null){
            return false;
        }

        this.funcionarioLogado = controller.UserToFuncionario(userLogado);
        funcionarioLogado.setStatus(controller.getStatus(user));
        
        user = (Funcionario) controller.getUserByName(user);
        MenuPrincipal menu = new MenuPrincipal();
        menu.show(user);
        return true;
    }

    public Funcionario usuarioSignUp(){
        System.out.println("Login:");
        scanner.nextLine();
        String login = scanner.nextLine();

        System.out.println("Email:");
        String email = scanner.nextLine();

        System.out.println("Senha:");
        String senha = scanner.nextLine();

        Funcionario user = new Funcionario(login, "", senha);
        return user;
    }

    public void gerenteSignUp(){

        Funcionario user = usuarioSignUp();
        controller.create(user);

        user = (Funcionario) controller.getUserByName(user);
        controller.setStatus(user, 1);

        MenuPrincipal menu = new MenuPrincipal();
        menu.show(user);
    }

    public void funcionarioSignUp(){
        Funcionario user = usuarioSignUp();

        controller.create(user);

        user = (Funcionario) controller.getUserByName(user);
        controller.setStatus(user, 0);

        MenuPrincipal menu = new MenuPrincipal();
        menu.show(user);
    }


    public void signUp() {
        System.out.println("Qual tipo de conta deseja cadastrar?");
        System.out.println("[1] Gerente");
        System.out.println("[2] Funcionario");
        int opcao = scanner.nextInt();

        if(opcao == 1){
            this.gerenteSignUp();
        }
        else{
            this.funcionarioSignUp();
        }

    }
}
