package view;

import Controller.FuncionarioController;
import Controller.RelatorioFuncionarioController;
import database.DBConfigFuncionario;
import database.DBConfigRelatorioFuncionario;
import entity.Funcionario;
import service.FuncionarioService;
import service.RelatorioFuncionarioService;
import tfw.Entity.User;
import tfw.Service.UserService;

import java.util.Scanner;

public class Login implements MenuLogin {
    DBConfigRelatorioFuncionario relatorioFuncConfig = new DBConfigRelatorioFuncionario();
    RelatorioFuncionarioService relatorioFuncService = new RelatorioFuncionarioService(relatorioFuncConfig);
    RelatorioFuncionarioController relatorioFuncController = new RelatorioFuncionarioController(relatorioFuncService);
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

        if(funcionarioLogado.eGerente()){
            MenuGerente menu = new MenuGerente();
            menu.show(funcionarioLogado);
        }
        else{
            MenuFuncionario menu = new MenuFuncionario();
            menu.show(funcionarioLogado);
        }

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

        Funcionario user = new Funcionario(login, email, senha);
        return user;
    }

    public void gerenteSignUp(){

        Funcionario user = usuarioSignUp();
        controller.create(user);

        user = (Funcionario) controller.getUserByName(user);
        controller.setStatus(user, 1);

        this.funcionarioLogado = controller.UserToFuncionario(user);
        funcionarioLogado.setStatus(controller.getStatus(user));

        //chama funcao de criar relatorio de usuario

        MenuGerente menu = new MenuGerente();
        menu.show(funcionarioLogado);
    }

    public boolean createRelatorioFuncionario(Funcionario funcionario){
        return true;
    }

    public void funcionarioSignUp(){
        Funcionario user = usuarioSignUp();

        controller.create(user);

        user = (Funcionario) controller.getUserByName(user);
        controller.setStatus(user, 0);

        this.funcionarioLogado = controller.UserToFuncionario(user);
        funcionarioLogado.setStatus(controller.getStatus(user));


        MenuFuncionario menu = new MenuFuncionario();
        menu.show(funcionarioLogado);
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
