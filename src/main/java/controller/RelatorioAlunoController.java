package controller;

import dao.RelatorioAlunoDAO;
import database.DBConfigRelatorioAluno;
import entity.RelatorioAluno;
import service.RelatorioAlunoService;
import tfw.Controller.UserReportController;
import tfw.Service.UserReportService;

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
}
