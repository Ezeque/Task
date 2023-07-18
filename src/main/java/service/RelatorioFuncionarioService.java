package service;

import database.DBConfigRelatorioFuncionario;
import tfw.Entity.UserReport;
import tfw.Service.UserReportService;

public class RelatorioFuncionarioService extends UserReportService {
    public RelatorioFuncionarioService(DBConfigRelatorioFuncionario config) {
        super(config);
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
