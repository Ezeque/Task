package view;

import entity.Funcionario;

import java.util.Scanner;

public class MenuSetores implements Menu{
    Scanner scanner = new Scanner(System.in);

    @Override
    public void show(Funcionario funcionario){
        System.out.println("\t\t\t[Setores]");
        System.out.println("1) Criar Setor \n2)Visualizar Setores \n3) Pesquisar Setor \n4) Sair");
        int opcao = scanner.nextInt();
        switch (opcao) {
            case 1:
                //chama funcao para criar setor
                break;
            case 2:
                //chama funcao para visualizar setores
                break;
            case 3:
                //chama funcao de pesquisar setor
                break;
        }
    }
}
