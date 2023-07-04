package service;

import database.DBConfigAluno;
import tfw.Entity.UserReport;
import tfw.Service.UserReportService;

public class RelatorioAlunoService extends UserReportService {

    public RelatorioAlunoService(DBConfigAluno dbConfig) {
        super(dbConfig);
    }

    @Override
    public boolean validateCreation(UserReport report) {
        return true;
    }

    @Override
    public boolean validateSearch(UserReport report) {
        return true;
    }

    @Override
    public boolean validateUpdate(UserReport report) {
        return true;
    }

    @Override
    public boolean validateDeletion(UserReport report) {
        return true;
    }
}
