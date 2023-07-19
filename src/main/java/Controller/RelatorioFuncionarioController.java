package Controller;

import database.DBConfigRelatorioFuncionario;
import entity.RelatorioFuncionario;
import service.RelatorioFuncionarioService;
import tfw.Controller.UserReportController;
import tfw.Entity.UserReport;
import tfw.Service.UserReportService;

import java.util.HashMap;
import java.util.Map;

public class RelatorioFuncionarioController extends UserReportController {
    RelatorioFuncionarioService service;
    DBConfigRelatorioFuncionario config = new DBConfigRelatorioFuncionario();


    public RelatorioFuncionarioController(UserReportService service) {
        super(service);
        this.service = new RelatorioFuncionarioService(config);
    }

    public boolean saveRelatorio(RelatorioFuncionario relatorio){
        return this.service.create(relatorio);
    }

    public RelatorioFuncionario reportToRelatorio(UserReport report){
        RelatorioFuncionario relatorio = new RelatorioFuncionario(report.getUserId());
        relatorio.setId(report.getId());
        return relatorio;
    }

    public boolean adicionarMetricas(RelatorioFuncionario relatorio, Map<String, Integer> metricas){
        return service.adicionarMetricas(relatorio, metricas);
    }

    public Map<String, Integer> getMetrics(RelatorioFuncionario relatorio){
        return service.getMetrics(relatorio);
    }
}
