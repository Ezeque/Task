package view;

import Controller.SetorController;
import database.DBConfigSetor;
import entity.Funcionario;
import entity.Setor;
import service.SetorService;
import tfw.Controller.ProjectController;
import tfw.Database.DatabaseConfiguration;
import tfw.Entity.Project;
import tfw.Service.ProjectService;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuSetores implements Menu{
    Scanner scanner = new Scanner(System.in);
    DatabaseConfiguration config = new DBConfigSetor();
    SetorService service = new SetorService(config);
    SetorController controller = new SetorController(service);

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

    public void viewSetores(){
        Setor setor = new Setor("");
        ArrayList<Setor> setores = new ArrayList<Setor>();
        ArrayList<Project> projetos = new ArrayList<Project>();
        projetos = controller.getAllProjects(setor);
        setores = controller.projectsToSetores(projetos);

        for(int i=0; i<setores.size(); i++){
            System.out.println(i + ") " + setores.get(i).getName());
        }
        System.out.println(setores.size() + ") Sair");
    }

}
