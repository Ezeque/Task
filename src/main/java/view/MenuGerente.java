package view;

import entity.Funcionario;

import java.util.Scanner;

public class MenuGerente implements Menu {
    @Override
    public void show(Funcionario funcionario) {
        Scanner scanner = new Scanner(System.in);
        Menu menu;
        System.out.println("Bem vindo(a) " + funcionario.getName() + "!\n");
        System.out.println("1) Projetos \n2) Perfil \n3) Funcionarios \n4) Tarefas \n5) Sair");
        int opcao = scanner.nextInt();
        switch (opcao) {
            case 1:
                menu = new MenuSetor(funcionario);
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
                System.exit(0);
        }

    }
}
