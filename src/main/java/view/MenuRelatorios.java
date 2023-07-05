package view;

import controller.RelatorioAlunoController;
import database.DBConfigRelatorioAluno;
import entity.Aluno;
import entity.RelatorioAluno;
import service.RelatorioAlunoService;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MenuRelatorios implements MenuInterface {

    RelatorioAlunoController controller;
    RelatorioAlunoService service;
    DBConfigRelatorioAluno config = new DBConfigRelatorioAluno();
    ;

    @Override
    public void show(Aluno aluno) {
        System.out.println(" 1) Exibir Relatório \n 2) Voltar \n");
        Scanner scanner = new Scanner(System.in);
        int opcao = scanner.nextInt();
        if(opcao == 1){
            RelatorioAluno relatorio = new RelatorioAluno(aluno.getId());
            service = new RelatorioAlunoService(config);
             controller = new RelatorioAlunoController(service);
            relatorio =  controller.SearchRelatorioAluno(relatorio, service, aluno);
            Map<String, Integer> metrics = new HashMap<>();
            metrics = controller.getMetrics(relatorio);
            relatorio.setMetrics(metrics);
            relatorio.show();
        }
    }
}
