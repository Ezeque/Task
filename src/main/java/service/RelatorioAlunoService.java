package service;

import dao.RelatorioAlunoDAO;
import database.DBConfigRelatorioAluno;
import entity.Aluno;
import entity.RelatorioAluno;
import tfw.Entity.UserReport;
import tfw.Service.UserReportService;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class RelatorioAlunoService extends UserReportService {

    public RelatorioAlunoService(DBConfigRelatorioAluno config) {
        super(config);
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

    public RelatorioAluno search(RelatorioAluno relatorio, int id_aluno){
        if (validateSearch(relatorio)) {
            RelatorioAlunoDAO dao = new RelatorioAlunoDAO(config);
            RelatorioAluno returnRelatorio = new RelatorioAluno(0);
            try{
                returnRelatorio = (RelatorioAluno) dao.getReportByUserId(relatorio, id_aluno);
            }
            catch(SQLException e){
                System.out.println(e);
            }
            return returnRelatorio;
        }
        return null;
    }

    public boolean adicionarMetricas(RelatorioAluno relatorio, Map<String, Integer> metricas){
        RelatorioAlunoDAO dao = new RelatorioAlunoDAO(config);
        boolean success = false;
        try{
            success = dao.adicionarMetricas(relatorio, metricas);
        }catch(SQLException e){
            System.out.println(e);
        }
        return success;
    }

    public Map<String, Integer> getMetrics(RelatorioAluno relatorio){
        Map<String, Integer> metrics = new HashMap<>();
        try{
            RelatorioAlunoDAO dao = new RelatorioAlunoDAO(config);
            metrics = dao.getMetrics(relatorio);
        }catch(SQLException e){
            System.out.println(e);
        }
        return metrics;
    }
}
