package service;

import dao.PlanoDAO;
import database.DBConfigPlano;
import entity.Aluno;
import entity.Plano;
import tfw.Entity.Project;
import tfw.Service.ProjectService;

import java.sql.SQLException;

public class PlanoService extends ProjectService {
    public PlanoService(DBConfigPlano config) {
        super(config);
    }

    @Override
    public boolean validateCreation(Project project) {
        return false;
    }

    @Override
    public boolean validateSearch(Project project) {
        return true;
    }

    @Override
    public boolean validateUpdate(Project project) {
        return false;
    }

    @Override
    public boolean validateDeletion(Project project) {
        return false;
    }

    public Plano search(Plano plano, Aluno aluno) throws SQLException {
        if (validateSearch(plano)) {
            PlanoDAO dao = new PlanoDAO(config);
            return dao.getProjectByAluno(plano, aluno);
        }
        return null;
    }
}
