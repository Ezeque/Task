package view;

import Controller.RelatorioFuncionarioController;
import database.DBConfigRelatorioFuncionario;
import entity.Funcionario;
import entity.RelatorioFuncionario;
import service.RelatorioFuncionarioService;
import tfw.Entity.UserReport;

import java.util.HashMap;
import java.util.Map;

public class MenuRelatorio implements Menu{
    DBConfigRelatorioFuncionario config = new DBConfigRelatorioFuncionario();
    RelatorioFuncionarioService service = new RelatorioFuncionarioService(config);
    RelatorioFuncionarioController controller = new RelatorioFuncionarioController(service);
    @Override
    public void show(Funcionario funcionario){
        RelatorioFuncionario relatorio = new RelatorioFuncionario(funcionario.getId());
        UserReport report = controller.getReportByUserId(relatorio);
        relatorio = controller.reportToRelatorio(report);
        Map<String, Integer> metricas = new HashMap<>();
        metricas = controller.getMetrics(relatorio);
        relatorio.setMetrics(metricas);
        relatorio.show();
    }
}
