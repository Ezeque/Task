package DAO;

import entity.RelatorioFuncionario;
import tfw.Dao.UserReportDAO;
import tfw.Database.DatabaseConfiguration;
import tfw.Entity.UserReport;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class RelatorioFuncionarioDAO extends UserReportDAO {
    public RelatorioFuncionarioDAO(DatabaseConfiguration config) {
        super(config);
    }

    public boolean saveRelatorio(UserReport report) throws SQLException {
        RelatorioFuncionario relatorio = new RelatorioFuncionario(report.getUserId());
        relatorio.setId(0);
        return this.create(relatorio);
    }

    public PreparedStatement buildMetricsStatement(PreparedStatement pst, Map<String, Integer> metricas, RelatorioFuncionario relatorio) throws SQLException {
        pst.setInt(1, metricas.get("n_chamados"));
        pst.setInt(2, metricas.get("n_chamados_concluidos"));
        pst.setInt(3, metricas.get("porcentagem_chamados_concluidos"));
        pst.setInt(4, relatorio.getId());
        return pst;

    }

    public boolean adicionarMetricas(RelatorioFuncionario relatorio, Map<String, Integer> metricas) throws SQLException{
        String query = "UPDATE " + config.getTable() + " SET n_chamados = ?, n_chamados_concluidos = ?, porcentagem_chamados_concluidos = ? WHERE id = ?";
        PreparedStatement pst;
        pst = con.prepareStatement(query);
        pst = buildMetricsStatement(pst, metricas, relatorio);
        int res = pst.executeUpdate();

        if(res == 1){
            return true;
        }

        return false;
    }


    public int getNChamados(RelatorioFuncionario relatorio) throws SQLException {
        String query = "SELECT n_chamados FROM relatorio_funcionario WHERE id = ?";
        int nChamados = 0;
        PreparedStatement pst;
        pst = con.prepareStatement(query);

        pst.setInt(1, relatorio.getId());
        ResultSet resultSet = pst.executeQuery();

        if (resultSet.next()) {
            nChamados = resultSet.getInt("n_chamados");
        }

        return nChamados;
    }

    public int getNChamadosConcluidos(RelatorioFuncionario relatorio) throws SQLException {
        String query = "SELECT n_chamados_concluidos FROM relatorio_funcionario WHERE id = ?";
        int nChamadosConcluidos = 0;
        PreparedStatement pst;
        pst = con.prepareStatement(query);

        pst.setInt(1, relatorio.getId());
        ResultSet resultSet = pst.executeQuery();

        if (resultSet.next()) {
            nChamadosConcluidos = resultSet.getInt("n_chamados_concluidos");
        }

        return nChamadosConcluidos;
    }

    public int getPorcentagemConcluidos(RelatorioFuncionario relatorio) throws SQLException {
        String query = "SELECT porcentagem_chamados_concluidos FROM relatorio_funcionario WHERE id = ?";
        int porcentagem = 0;
        PreparedStatement pst;
        pst = con.prepareStatement(query);

        pst.setInt(1, relatorio.getId());
        ResultSet resultSet = pst.executeQuery();

        if (resultSet.next()) {
            porcentagem = resultSet.getInt("porcentagem_chamados_concluidos");
        }

        return porcentagem;
    }

    public Map<String, Integer> getMetrics(RelatorioFuncionario relatorio) throws SQLException{
        Map<String, Integer> metrics = new HashMap<>();
        this.getReportById(relatorio);
        metrics.put("n_chamados", this.getNChamados(relatorio));
        metrics.put("n_chamados_concluidos", this.getNChamadosConcluidos(relatorio));
        metrics.put("porcentagem_chamados_concluidos", this.getPorcentagemConcluidos(relatorio));

        return metrics;
    }

}
