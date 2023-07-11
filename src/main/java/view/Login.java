package view;

import database.DBConfigUsuario;
import entity.Usuario;
import service.UsuarioService;
import tfw.Controller.UserController;
import tfw.Service.UserService;

import java.util.Scanner;

public class Login implements Menu {
    @Override
    public void show() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1) Login \n2) SignIn");
        int opcao = scanner.nextInt();
        switch (opcao) {
            case 1:
                login();
                break;
            case 2:
                signIn();
                break;
        }
    }

    public void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Login:");
        String login = scanner.nextLine();
        System.out.println("Senha:");
        String senha = scanner.nextLine();
        Usuario user = new Usuario(login, "", senha);
        DBConfigUsuario config = new DBConfigUsuario();
        UserService service = new UsuarioService(config);
        UserController controller = new UserController(service);
        controller.login(user);
    }

    public void signIn() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Login:");
        String login = scanner.nextLine();
        System.out.println("Email:");
        String email = scanner.nextLine();
        System.out.println("Senha:");
        String senha = scanner.nextLine();
        Usuario user = new Usuario(login, "", senha);
        DBConfigUsuario config = new DBConfigUsuario();
        UserService service = new UsuarioService(config);
        UserController controller = new UserController(service);
        controller.create(user);
    }
}
