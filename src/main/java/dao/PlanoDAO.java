package dao;

import entity.Aluno;
import entity.Plano;
import tfw.Dao.ProjectDAO;
import tfw.Database.DatabaseConfiguration;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlanoDAO extends ProjectDAO {
    public PlanoDAO(DatabaseConfiguration config) {
        super(config);
    }

    public Plano buildProject(Plano project, ResultSet rs) throws SQLException {
        project.setName(rs.getString("name"));
        project.setId(rs.getInt("id"));
        project.setValor(rs.getInt("valor"));
        project.setDiasPermitidos(rs.getInt("diasPermitidos"));
        return project;
    }

    public Plano getProjectByAluno(Plano plano, Aluno aluno) throws SQLException {

        String query = "SELECT * FROM " + config.getTable() + " WHERE ID = ?";
        PreparedStatement ps;
        ps = con.prepareStatement(query);
        ps.setInt(1, aluno.getPlanId());
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Plano returnProject = buildProject(plano, rs);
            if (returnProject.getId() == plano.getId()) {
                return returnProject;
            }

        }
        return null;
    }
}
