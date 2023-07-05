package dao;

import database.DBConfigRelatorioAluno;
import entity.RelatorioAluno;
import tfw.Dao.UserReportDAO;
import tfw.Database.DatabaseConfiguration;
import tfw.Entity.UserReport;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public class RelatorioAlunoDAO extends UserReportDAO {

    public RelatorioAlunoDAO(DatabaseConfiguration config) {
        super(config);
    }

    public boolean saveRelatorio(UserReport report) throws SQLException {
        DBConfigRelatorioAluno relatorioConfig = new DBConfigRelatorioAluno();
        RelatorioAlunoDAO relatorioDAO = new RelatorioAlunoDAO(relatorioConfig);
        RelatorioAluno relatorio = new RelatorioAluno(report.getUserId());
        relatorio.setId(0);
        return relatorioDAO.create(relatorio);
    }

    public PreparedStatement buildMetricsStatement(PreparedStatement pst, Map<String, Integer> metricas, RelatorioAluno relatorio) throws SQLException {
        pst.setInt(1, metricas.get("media_de_exercicios_treino"));
        pst.setInt(2, metricas.get("n_treinos"));
        pst.setInt(3, metricas.get("dias_seguidos"));
        pst.setInt(4, relatorio.getId());
        return pst;

    }

    public boolean adicionarMetricas(RelatorioAluno relatorio, Map<String, Integer> metricas) throws SQLException{
        String query = "UPDATE " + config.getTable() + " SET media_de_exercicios_treino = ?, n_treinos = ?, dias_seguidos = ? WHERE id = ?";
        PreparedStatement pst;
        pst = con.prepareStatement(query);
        pst = buildMetricsStatement(pst, metricas, relatorio);
        int res = pst.executeUpdate();

        if(res == 1){
            return true;
        }

        return false;
    }
}
