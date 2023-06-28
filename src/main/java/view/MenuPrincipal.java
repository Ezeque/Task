package view;

import entity.Aluno;

import java.util.Scanner;

public class MenuPrincipal implements MenuInterface {
    boolean isLogged;
    @Override
    public void show(Aluno aluno) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" 1) Acessar Treino \n 2) Relatórios \n 3) Sair");
        int opcao = scanner.nextInt();
    }
}
