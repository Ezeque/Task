package view;

import entity.Funcionario;

import java.util.Scanner;

public class MenuGerente implements Menu {
    Scanner scanner = new Scanner(System.in);
    @Override
    public void show(Funcionario funcionario) {
        boolean sair = false;
        Menu menu;
        System.out.println("Bem vindo(a) " + funcionario.getName() + "!\n");
        while(!sair){
            System.out.println("1) Setores \n2) Funcionarios \n3) Chamados \n4) Relatório \n5) Sair");
            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    menu = new MenuSetores();
                    menu.show(funcionario);
                    break;
                case 2:
                    //chamar menu usuarios
                    break;
                case 3:
                    menu = new MenuChamados();
                    menu.show(funcionario);
                    break;
                case 4:
                    menu = new MenuRelatorio();
                    menu.show(funcionario);
                case 5:
                    sair = true;
                    break;
            }
        }

    }
}
