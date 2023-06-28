package view;

import entity.Aluno;

import java.util.Scanner;

public class MenuPrincipal implements MenuInterface {
    boolean isLogged;

    @Override
    public void show(Aluno aluno) {
        boolean sair = false;
        MenuInterface menu;
        Scanner scanner = new Scanner(System.in);
        System.out.println(" 1) Acessar Treino \n 2) Relatórios \n 3) Sair");
        while (!sair) {
            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    menu = new MenuTreino();
                    menu.show(aluno);
                    sair = true;
                    break;
                case 2:
                    menu = new MenuRelatorios();
                    menu.show(aluno);
                    sair = true;
                    break;
                case 3:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção Invalida!");
            }
        }
    }
}

