package view;

import entity.Aluno;

import java.sql.SQLException;
import java.util.Scanner;

import static java.lang.System.exit;

public class MenuPrincipal implements MenuInterface {
    boolean isLogged;

    // EXIBE AS PRINCIPAIS FUNÇÕES DO SISTEMA
    @Override
    public void show(Aluno aluno) throws SQLException {
        boolean sair = false;
        MenuInterface menu;
        Scanner scanner = new Scanner(System.in);
        System.out.println(" 1) Acessar Treino \n 2) Relatórios \n 3) Plano \n 4) Sair");
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
                    menu = new MenuPlano();
                    menu.show(aluno);
                    break;
                case 4:
                    exit(0);
                    break;
                default:
                    System.out.println("Opção Invalida!");
            }
        }
    }
}

