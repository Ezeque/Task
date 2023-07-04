package dao;

import entity.Aluno;
import tfw.Dao.ProjectDAO;
import tfw.Database.DatabaseConfiguration;
import tfw.Entity.Project;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TreinoDAO extends ProjectDAO {
    public TreinoDAO(DatabaseConfiguration config) {
        super(config);
    }

    public boolean create(Project project, Aluno aluno) throws SQLException {
        String query = "INSERT INTO " + config.getTable() + " (name, id, idAluno) VALUES (?,?,?)";
        PreparedStatement pst;
        pst = con.prepareStatement(query);
        pst = buildFullStatement(pst, project, aluno);

        int res = pst.executeUpdate();

        if (res == 1) {
            return true;
        }

        return false;
    }

    public PreparedStatement buildFullStatement(PreparedStatement pst, Project project, Aluno aluno) throws SQLException {
        pst.setString(1, project.getName());
        pst.setInt(2, project.getId());
        pst.setInt(3, aluno.getId());
        return pst;
    }
}
