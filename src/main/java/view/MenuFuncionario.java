package view;

import entity.Funcionario;

import java.util.Scanner;

public class MenuFuncionario implements Menu {
    Scanner scanner = new Scanner(System.in);
    MenuChamados menu = new MenuChamados();

    @Override
    public void show(Funcionario funcionario) {
        boolean sair = false;
        System.out.println("Bem vindo(a) " + funcionario.getName() + "!\n");
        while(!sair){
            System.out.println("1) Meus Chamados \n2) Todos os Chamados \n3) Relatório \n4) Sair");
            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    this.menu.viewMeusChamados(funcionario);
                    break;
                case 2:
                    menu.viewChamados();
                    break;
                case 3:
                    Menu menuRelatorio = new MenuRelatorio();
                    menuRelatorio.show(funcionario);
                    break;
                case 4:
                    sair = true;
                    break;
            }
        }

    }
}
