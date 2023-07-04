package view;

import controller.PlanoController;
import database.DBConfigPlano;
import entity.Aluno;
import entity.Plano;
import entity.PlanoBasico;
import service.PlanoService;

import java.sql.SQLException;
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
                Plano plano = new PlanoBasico();
                plano = (Plano) controller.SearchPlano(plano, service);
                System.out.println(plano.getName());
                System.out.println("Valor: " + plano.getValor());
                System.out.println("Quantidade de Dias Permitidos: " + plano.getDiasPermitidos());
            }
        }
    }
}
