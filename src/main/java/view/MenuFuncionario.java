package view;

import entity.Funcionario;

import java.util.Scanner;

public class MenuFuncionario implements Menu {
    @Override
    public void show(Funcionario funcionario) {
        Scanner scanner = new Scanner(System.in);
        Menu menu;
        System.out.println("Bem vindo(a) " + funcionario.getName() + "!\n");
        System.out.println("1) Tarefas \n2) Perfil \n3) Sair");
        int opcao = scanner.nextInt();
        switch (opcao) {
            case 1:
                menu = new MenuSetor(funcionario);
                menu.show(funcionario);
                break;
            case 2:
//                menu = new MenuFuncionario(funcionario);
//                menu.show(funcionario);
                break;
            case 3:
                System.exit(0);
        }

    }
}
