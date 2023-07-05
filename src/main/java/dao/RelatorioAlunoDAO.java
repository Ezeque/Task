package dao;

import database.DBConfigRelatorioAluno;
import entity.RelatorioAluno;
import tfw.Dao.UserReportDAO;
import tfw.Database.DatabaseConfiguration;
import tfw.Entity.UserReport;

import java.sql.SQLException;

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
}
