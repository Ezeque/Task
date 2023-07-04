package view;

import controller.AlunoController;
import controller.PlanoController;
import database.DBConfigAluno;
import database.DBConfigPlano;
import entity.*;
import service.AlunoService;
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
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        Scanner scanner = new Scanner(System.in);
        System.out.println(" 1) Ver Plano \n 2) Mudar Plano");
        int opcao = scanner.nextInt();
        switch (opcao) {
            case 1: {
                Plano plano = new Plano();
                plano = controller.SearchPlanoAluno(plano, service, aluno);
                System.out.println("Plano " + plano.getName());
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
                        System.out.println("[" + (planos.indexOf(plano)) + "] " + "Plano " + plano.getName());
                    }
                }
                opcao = scanner.nextInt();
                System.out.println("Tem Certeza Que Deseja Assinar o Plano " + planos.get(opcao).getName() + "?");
                System.out.println("[1] Sim\n[2] Não");
                int confirmacao = scanner.nextInt();
                if (confirmacao == 1) {
                    DBConfigAluno configAluno = new DBConfigAluno();
                    AlunoService alunoService = new AlunoService(configAluno);
                    AlunoController alunoController = new AlunoController(alunoService);
                    alunoController.savePlano(planos.get(opcao), aluno);
                }
                break;
            }
        }
        menuPrincipal.show(aluno);
    }
}
