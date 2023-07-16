package view;

import Controller.FuncionarioController;
import Controller.SetorController;
import database.DBConfigFuncionario;
import database.DBConfigSetor;
import entity.Chamado;
import entity.Funcionario;
import service.FuncionarioService;
import service.SetorService;
import tfw.Database.DatabaseConfiguration;

import java.util.Scanner;

public class MenuChamados implements Menu{

    Scanner scanner = new Scanner(System.in);

    DatabaseConfiguration setorConfig = new DBConfigSetor();
    DatabaseConfiguration funcionarioConfig = new DBConfigFuncionario();
    SetorService setorService = new SetorService(setorConfig);
    FuncionarioService funcionarioService = new FuncionarioService(funcionarioConfig);
    SetorController setorController = new SetorController(setorService);
    FuncionarioController funcionarioController = new FuncionarioController(funcionarioService);

    @Override
    public void show(Funcionario funcionario){
        boolean sair = false;
        while(!sair){
            System.out.println("1) Criar Chamado \n 2) Meus Chamados \n3) Todos os Chamados) \n 4) Sair");
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
        String nome = scanner.nextLine();
        System.out.println("Digite a descrição do Chamado: ");
        String descricao = scanner.nextLine();
        System.out.println("Digite o nome do Setor responsável: ");
        String setorNome = scanner.nextLine();
        System.out.println("Digite o nome do Funcionário responsável");
        String funcionarioNome = scanner.nextLine();

        //chama funcao get Setor By Name
        //chamar funcao get User By Name
//        Chamado chamado = new Chamado(nome, descricao, setor)

        return true;
    }
}
