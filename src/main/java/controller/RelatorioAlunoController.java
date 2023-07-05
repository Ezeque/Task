package controller;

import dao.RelatorioAlunoDAO;
import database.DBConfigRelatorioAluno;
import entity.Aluno;
import entity.Plano;
import entity.RelatorioAluno;
import service.RelatorioAlunoService;
import tfw.Controller.UserReportController;
import tfw.Service.UserReportService;

import java.sql.SQLException;
import java.util.Map;

public class RelatorioAlunoController extends UserReportController {

    RelatorioAlunoService service;
    RelatorioAlunoDAO dao;
    DBConfigRelatorioAluno config;

    public RelatorioAlunoController(UserReportService service) {
        super(service);
        this.config = new DBConfigRelatorioAluno();
        this.dao = new RelatorioAlunoDAO(config);
        this.service = new RelatorioAlunoService(config);
    }

    public boolean saveRelatorio(RelatorioAluno report){
        return  this.service.validateCreation(report);
    }

    public RelatorioAluno SearchRelatorioAluno(RelatorioAluno relatorio, RelatorioAlunoService service, Aluno aluno) {
        return service.search(relatorio, aluno.getId());
    }

    public boolean adicionarMetricas(RelatorioAluno relatorio, Map<String, Integer> metricas){
        return service.adicionarMetricas(relatorio, metricas);
    }

    public Map<String, Integer> getMetrics(RelatorioAluno relatorio){
        return service.getMetrics(relatorio);
    }

}
