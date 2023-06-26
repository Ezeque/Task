package view;

import java.util.Scanner;

public class MenuPrincipal implements MenuPrincipalInterface {
    boolean isLogged;

    public MenuPrincipal(){
        this.isLogged = false;
    }
    @Override
    public void show() {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        if(isLogged){
            scanner = new Scanner(System.in);
            System.out.println(" 1) Acessar Treino \n 2) Gerar Relatório \n 3) Alterar Usuário");
            opcao = scanner.nextInt();
        }
        else {
            System.out.println(" 1) Login \n 2) Cadastrar-se");
            opcao = scanner.nextInt();
            MenuInterface menuLogin = new MenuLogin();
            menuLogin.show(opcao);
        }
    }
}
