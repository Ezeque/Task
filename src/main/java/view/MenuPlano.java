package view;

import entity.Aluno;
import tfw.Controller.ProjectController;
import tfw.Service.ProjectService;

import java.sql.SQLException;
import java.util.Scanner;

public class MenuPlano implements MenuInterface {

    ProjectController controller;
    ProjectService service;

    @Override
    public void show(Aluno aluno) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" 1) Ver Plano \n 2) Mudar Plano");
        int opcao = scanner.nextInt();
        switch (opcao) {
            case 1: {
                
            }
        }
    }
}
