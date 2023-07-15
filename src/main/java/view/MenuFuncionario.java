package view;

import entity.Funcionario;

import java.util.Scanner;

public class MenuFuncionario implements Menu {
    @Override
    public void show(Funcionario funcionario) {
        Scanner scanner = new Scanner(System.in);
        Menu menu;
        System.out.println("Bem vindo(a) " + funcionario.getName() + "!\n");
        System.out.println("1) Chamado \n2) Perfil \n3) Sair");
        int opcao = scanner.nextInt();
        switch (opcao) {
            case 1:
                //chamar menu chamados
                break;
            case 2:
                //chamar menu Perfil
                break;
            case 3:
                System.exit(0);
        }

    }
}
