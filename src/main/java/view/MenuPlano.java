package view;

import controller.PlanoController;
import database.DBConfigPlano;
import entity.*;
import service.PlanoService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuPlano implements MenuInterface {

    PlanoController controller = new PlanoController();
    PlanoService service;

    public MenuPlano() {
        DBConfigPlano config = new DBConfigPlano();
        service = new PlanoService(config);
    }

    @Override
    public void show(Aluno aluno) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" 1) Ver Plano \n 2) Mudar Plano");
        int opcao = scanner.nextInt();
        switch (opcao) {
            case 1: {
                Plano plano = new Plano();
                plano = controller.SearchPlanoAluno(plano, service, aluno);
                System.out.println(plano.getName());
                System.out.println("Valor: " + plano.getValor());
                System.out.println("Quantidade de Dias Permitidos: " + plano.getDiasPermitidos());
                break;
            }
            case 2: {
                ArrayList<Plano> planos = new ArrayList<Plano>(3);
                planos.add(new PlanoBasico());
                planos.add(new PlanoPlus());
                planos.add(new PlanoPremium());
                Plano planoAtual = controller.SearchPlanoAluno(new Plano(), service, aluno);
                System.out.println("Qual Plano Deseja Assinar? \n");
                for (Plano plano :
                        planos) {
                    if (plano.getId() != planoAtual.getId()) {
                        System.out.println("[" + planos.indexOf(plano) + "] " + "Plano " + plano.getName());
                    }
                }
            }
        }
    }
}
