package view;

import Controller.ChamadoController;
import Controller.FuncionarioController;
import Controller.SetorController;
import database.DBConfigChamado;
import database.DBConfigFuncionario;
import database.DBConfigSetor;
import entity.Chamado;
import entity.Funcionario;
import entity.Setor;
import service.ChamadoService;
import service.FuncionarioService;
import service.SetorService;
import tfw.Database.DatabaseConfiguration;
import tfw.Entity.Project;
import tfw.Entity.User;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuChamados implements Menu{

    Scanner scanner = new Scanner(System.in);

    DatabaseConfiguration setorConfig = new DBConfigSetor();
    DatabaseConfiguration funcionarioConfig = new DBConfigFuncionario();
    DatabaseConfiguration config = new DBConfigChamado();
    SetorService setorService = new SetorService(setorConfig);
    FuncionarioService funcionarioService = new FuncionarioService(funcionarioConfig);
    ChamadoService service = new ChamadoService(config);
    SetorController setorController = new SetorController(setorService);
    FuncionarioController funcionarioController = new FuncionarioController(funcionarioService);
    ChamadoController controller = new ChamadoController(service);

    @Override
    public void show(Funcionario funcionario){
        boolean sair = false;
        while(!sair){
            System.out.println("1) Criar Chamado \n2) Meus Chamados \n3) Todos os Chamados \n4) Sair");
            int opcao = scanner.nextInt();
            switch(opcao){
                case 1:
                    this.createChamado();
                    break;
                case 2:
                    //chamar funcao de exibir todos os chamados do usuario
                    break;
                case 3:
                    //chamar funcao de exibir todos os chamados
                    break;
                case 4:
                    sair = true;
                    break;
            }
        }

    }

    public boolean createChamado(){
        System.out.println("Digite o nome do Chamado: ");
        scanner.nextLine();
        String nome = scanner.nextLine();
        System.out.println("Digite a descrição do Chamado: ");
        String descricao = scanner.nextLine();
        System.out.println("Selecione o Setor responsável: ");
        int setorId = this.viewSetores();
        System.out.println("Selecione um Funcionário responsável");
        int funcionarioId = this.viewFuncionariosSetor(setorId);

        Chamado chamado = new Chamado(nome, descricao, setorId, funcionarioId);
        controller.createTask(chamado);

        return true;
    }

    public int viewSetores(){
        ArrayList<Setor> setores = new ArrayList<Setor>();
        ArrayList<Project> projetos = new ArrayList<Project>();
        projetos = setorController.getAllProjects();
        setores = setorController.projectsToSetores(projetos);

        if(setores.size() == 0){
            System.out.println("Nenhum setor foi criado.");
            return -1;
        }
        System.out.println("\t\t\t[Setores]");
        for(int i=0; i<setores.size(); i++){
            System.out.println(i + ") " + setores.get(i).getName());
        }

        int opcao = scanner.nextInt();
        return setores.get(opcao).getId();
    }

    public int viewFuncionariosSetor(int setor_id){
        ArrayList<User> users = new ArrayList<>();
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        users = funcionarioController.getAllUsersByProjectId(setor_id);
        funcionarios = funcionarioController.usersToFuncionarios(users);

        if(funcionarios.size() == 0){
            System.out.println("Não há funcionários neste setor!");
            return -1;
        }

        System.out.println("\t\t\t[Funcionários]");

        for(int i=0; i<funcionarios.size(); i++){
            System.out.println(i + ") " + funcionarios.get(i).getName());
        }

        int opcao = scanner.nextInt();
        return funcionarios.get(opcao).getId();

    }
}
