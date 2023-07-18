package view;

import entity.Usuario;

import java.util.Scanner;

public class MenuPrincipal implements Menu {
    @Override
    public void show(Usuario usuario) {
        Scanner scanner = new Scanner(System.in);
        Menu menu;
        System.out.println(usuario.getName() + "\n");
        System.out.println("1) Projetos \n2) Perfil de Usuário \n3) Sair");
        int opcao = scanner.nextInt();
        switch (opcao) {
            case 1:
                menu = new MenuProjetos(usuario);
                menu.show(usuario);
                break;
            case 2:
                menu = new MenuUsuario(usuario);
                menu.show(usuario);
                break;
            case 3:
                System.exit(0);
        }

    }
}
