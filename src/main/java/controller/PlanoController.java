package controller;

import dao.PlanoDAO;
import database.DBConfigPlano;
import entity.Aluno;
import entity.Plano;
import service.PlanoService;
import tfw.Controller.ProjectController;

import java.sql.SQLException;

public class PlanoController extends ProjectController {
    PlanoService service;
    PlanoDAO dao;
    DBConfigPlano config;

    public PlanoController() {
        super();
        this.config = new DBConfigPlano();
        this.dao = new PlanoDAO(config);
        this.service = new PlanoService(config);
    }

    public Plano SearchPlanoAluno(Plano project, Aluno aluno) throws SQLException {
        return this.service.search(project, aluno);
    }
}
