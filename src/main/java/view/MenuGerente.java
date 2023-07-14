package view;

import entity.Funcionario;

import java.util.Scanner;

public class MenuGerente implements Menu {
    Scanner scanner = new Scanner(System.in);
    @Override
    public void show(Funcionario funcionario) {
        boolean sair = false;
        Menu menu;
        while(!sair){
            System.out.println("Bem vindo(a) " + funcionario.getName() + "!\n");
            System.out.println("1) Setores \n2) Perfil \n3) Funcionarios \n4) Tarefas \n5) Sair");
            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    menu = new MenuSetores();
                    menu.show(funcionario);
                    break;
                case 2:
                    //chamar Menu Funcionario
                    break;
                case 3:
                    //chamar menu usuarios
                    break;
                case 4:
                    //chamar menu tarefas
                    break;
                case 5:
                    sair = true;
//                System.exit(0);
            }
        }

    }
}
