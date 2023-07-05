package service;

import dao.RelatorioAlunoDAO;
import database.DBConfigRelatorioAluno;
import entity.RelatorioAluno;
import tfw.Entity.UserReport;
import tfw.Service.UserReportService;

import java.sql.SQLException;

public class RelatorioAlunoService extends UserReportService {

    public RelatorioAlunoService(DBConfigRelatorioAluno dbConfig) {
        super(dbConfig);
    }

    @Override
    public boolean validateCreation(UserReport report){
        DBConfigRelatorioAluno  config = new DBConfigRelatorioAluno();
        RelatorioAlunoDAO dao = new RelatorioAlunoDAO(config);
        try{
            return dao.saveRelatorio(report);
        }
        catch(SQLException e){
            System.out.println(e);
        }
        return false;
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
