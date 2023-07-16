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
            System.out.println("1) Criar Chamado \n2) Meus Chamados \n3) Todos os Chamados) \n4) Sair");
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
        System.out.println("Digite o nome do Setor responsável: ");
        String setorNome = scanner.nextLine();
        System.out.println("Digite o nome do Funcionário responsável");
        String funcionarioNome = scanner.nextLine();

        Setor setor = new Setor(setorNome);
        Project project = setorController.getProjectByName(setor);
        setor = setorController.projectToSetor(project);

        Funcionario funcionario = new Funcionario();
        funcionario.setName(funcionarioNome);
        User user = funcionarioController.getUserByName(funcionario);
        funcionario = funcionarioController.userToFuncionario(user);

        Chamado chamado = new Chamado(nome, descricao, setor.getId(), funcionario.getId());
        controller.createTask(chamado);

        return true;
    }
}
