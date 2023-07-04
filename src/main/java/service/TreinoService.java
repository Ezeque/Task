package service;

import dao.TreinoDAO;
import database.DBConfigTreino;
import entity.Aluno;
import tfw.Entity.Project;
import tfw.Service.ProjectService;

import java.sql.SQLException;

public class TreinoService extends ProjectService {

    public TreinoService(DBConfigTreino config) {
        super(config);
    }

    @Override
    public boolean validateCreation(Project project) {
        return true;
    }

    @Override
    public boolean validateSearch(Project project) {
        return true;
    }

    @Override
    public boolean validateUpdate(Project project) {
        return true;
    }

    @Override
    public boolean validateDeletion(Project project) {
        return true;
    }

    public boolean create(Project project, Aluno aluno) throws SQLException {
        if (validateCreation(project)) {
            TreinoDAO dao = new TreinoDAO(config);
            return dao.create(project, aluno);
        }
        return false;
    }
}
