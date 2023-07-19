package service;

import DAO.RelatorioFuncionarioDAO;
import database.DBConfigRelatorioFuncionario;
import entity.RelatorioFuncionario;
import tfw.Entity.UserReport;
import tfw.Service.UserReportService;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

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

    public boolean adicionarMetricas(RelatorioFuncionario relatorio, Map<String, Integer> metricas){
        RelatorioFuncionarioDAO dao = new RelatorioFuncionarioDAO(dbconfig);
        boolean success = false;
        try{
            success = dao.adicionarMetricas(relatorio, metricas);
        }catch(SQLException e){
            System.out.println(e);
        }
        return success;
    }

    public Map<String, Integer> getMetrics(RelatorioFuncionario relatorio){
        Map<String, Integer> metrics = new HashMap<>();
        try{
            RelatorioFuncionarioDAO dao = new RelatorioFuncionarioDAO(dbconfig);
            metrics = dao.getMetrics(relatorio);
        }catch(SQLException e){
            System.out.println(e);
        }
        return metrics;
    }
}
