package controller;

import entity.Aluno;
import service.TreinoService;
import tfw.Controller.ProjectController;
import tfw.Entity.Project;

import java.sql.SQLException;

public class TreinoController extends ProjectController {
    TreinoService service;

    public TreinoController(TreinoService service) {
        this.service = service;
    }

    public boolean create(Project treino, Aluno aluno) throws SQLException {
        return service.create(treino, aluno);
    }
}
