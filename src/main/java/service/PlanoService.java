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

        if (project.getName().length() > 0 && project.getId() > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean validateSearch(Project project) {
        if (project.getName().length() > 0 && project.getId() > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean validateUpdate(Project project) {
        if (project.getName().length() > 0 && project.getId() > 0) {
            return true;
        }
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
