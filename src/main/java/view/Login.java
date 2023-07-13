package view;

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
    UserController controller = new UserController(service);
    User funcionarioLogado;
    @Override
    public void show() {
        boolean login = false;
        while(!login){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Bem vindo ao SuportMaster!");
            System.out.println("Possui cadastro? (s/n)");
            String opcao = scanner.nextLine();
            switch (opcao) {
                case "s":
                    login = login();
                    break;
                case "n":
                    signIn();
                    break;
            }
        }
    }

    public boolean login() {
        boolean success = false;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Login:");
        String login = scanner.nextLine();

        System.out.println("Senha:");
        String senha = scanner.nextLine();

        Funcionario user = new Funcionario(login, "", senha);

        this.funcionarioLogado = controller.login(user);
        if(funcionarioLogado == null){
            return false;
        }
        user = (Funcionario) controller.getUserByName(user);
        MenuPrincipal menu = new MenuPrincipal();
        menu.show(user);
        return true;
    }

    public void signIn() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Login:");
        String login = scanner.nextLine();

        System.out.println("Email:");
        String email = scanner.nextLine();

        System.out.println("Senha:");
        String senha = scanner.nextLine();

        Funcionario user = new Funcionario(login, "", senha);

        controller.create(user);
        user = (Funcionario) controller.getUserByName(user);
        MenuPrincipal menu = new MenuPrincipal();
        menu.show(user);
    }
}
