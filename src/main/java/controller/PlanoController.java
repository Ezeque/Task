package controller;

import dao.PlanoDAO;
import database.DBConfigPlano;
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

    public Plano SearchPlano(Plano project, PlanoService service) throws SQLException {
        return service.search(project);
    }
}
