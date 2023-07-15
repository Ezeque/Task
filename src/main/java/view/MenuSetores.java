package view;

import Controller.FuncionarioController;
import Controller.SetorController;
import com.sun.security.jgss.GSSUtil;
import database.DBConfigFuncionario;
import database.DBConfigSetor;
import entity.Funcionario;
import entity.Setor;
import service.FuncionarioService;
import service.SetorService;
import tfw.Controller.ProjectController;
import tfw.Database.DatabaseConfiguration;
import tfw.Entity.Project;
import tfw.Entity.User;
import tfw.Service.ProjectService;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuSetores implements Menu{
    Scanner scanner = new Scanner(System.in);
    DatabaseConfiguration config = new DBConfigSetor();
    SetorService service = new SetorService(config);
    SetorController controller = new SetorController(service);
    DatabaseConfiguration funcConfig = new DBConfigFuncionario();
    FuncionarioService funcService = new FuncionarioService(funcConfig);

    FuncionarioController funcController = new FuncionarioController(funcService);

    @Override
    public void show(Funcionario funcionario){
        boolean sair = false;
        while(!sair){
            System.out.println("\t\t\t[Setores]");
            System.out.println("1) Criar Setor \n2) Visualizar Setores \n3) Pesquisar Setor \n4) Sair");
            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    this.createSetor();
                    break;
                case 2:
                    this.viewSetores();
                    break;
                case 3:
                    //chama funcao de pesquisar setor
                    break;
                case 4:
                    sair = true;
                    break;

            }
        }
    }

    public void createSetor(){
        System.out.println("Digite o nome do projeto: ");
        scanner.nextLine();
        String nome = scanner.nextLine();
        Setor setor = new Setor(nome);
        if(controller.createProject(setor)){
            System.out.println("Projeto criado com sucesso!");
        }
        else{
            System.out.println("Não foi possível criar o projeto!");
        }

    }

    public void showOptions(Setor setor){
        boolean sair = false;

        while(!sair){
            System.out.println("1) Adicionar Chamado \n2) Adicionar Funcionario \n3) Visualizar Funcionários do Setor \n4) Sair");

            int opcao = scanner.nextInt();
            switch (opcao){
                case 1:
                    this.addChamado(setor);
                    break;
                case 2:
                    this.addFuncionario(setor);
                    break;
                case 3:
                    this.viewFuncionariosSetor(setor);
                    break;
                case 4:
                    sair = true;
                    break;
            }
        }
    }

    public void addChamado(Setor setor){

    }

    public void viewFuncionariosSetor(Setor setor){
        ArrayList<User> users = new ArrayList<>();
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        users = funcController.getAllUsersByProjectId(setor.getId());
        funcionarios = funcController.usersToFuncionarios(users);
        
        if(funcionarios.size() == 0){
            System.out.println("Não há funcionários neste setor!");
            return;
        }
        System.out.println("\t\t\t[Funcionários]");
        for(int i=0; i<funcionarios.size(); i++){
            System.out.println(i + ") " + funcionarios.get(i).getName());
        }
        System.out.println(funcionarios.size() + ") Sair");
        int opcao = scanner.nextInt();
        if(opcao < funcionarios.size()){
            funcionarios.get(opcao).printFuncionario();
        }
        System.out.println();
    }

    public void addFuncionario(Setor setor){
        System.out.println("Selecione o funcionario que deseja adicionar ao setor");
        ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
        ArrayList<User>  users = new ArrayList<User>();
        users = funcController.getAllUsers();
        funcionarios = funcController.usersToFuncionarios(users);

        for(int i=0; i<funcionarios.size(); i++){
            System.out.println(i + ") " + funcionarios.get(i).getName());
        }
        System.out.println(funcionarios.size() + ") Sair");

        int opcao = scanner.nextInt();
        if(opcao < funcionarios.size()){
            if(funcController.adicionarFuncionarioSetor(funcionarios.get(opcao), setor.getId())){
                System.out.println("Funcionario adicionado com sucesso!");
            }
            else{
                System.out.println("Não foi possível adicionar o funcionário");
            }
        }


    }

    public void viewSetores(){
        ArrayList<Setor> setores = new ArrayList<Setor>();
        ArrayList<Project> projetos = new ArrayList<Project>();
        projetos = controller.getAllProjects();
        setores = controller.projectsToSetores(projetos);

        if(setores.size() == 0){
            System.out.println("Nenhum setor foi criado.");
            return;
        }
        System.out.println("\t\t\t[Setores]");
        for(int i=0; i<setores.size(); i++){
            System.out.println(i + ") " + setores.get(i).getName());
        }
        System.out.println(setores.size() + ") Sair");

        int opcao = scanner.nextInt();

        if(opcao < setores.size()){
            this.showOptions(setores.get(opcao));
        }


    }

}
