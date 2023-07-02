package dao;

import tfw.Dao.UserDAO;
import tfw.Database.DatabaseConfiguration;
import tfw.Entity.Project;
import tfw.Entity.User;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class alunoDAO extends UserDAO {
    public alunoDAO(DatabaseConfiguration config) {
        super(config);
    }

    public PreparedStatement buildFullStatementSavePlano(PreparedStatement pst, User user, Project plano) throws SQLException {
        pst.setInt(1, plano.getId());
        pst.setInt(2, user.getId());
        return pst;
    }

    public boolean savePlano(User aluno, Project plano) throws SQLException {
        String query = "UPDATE " + config.getTable() + " SET " + "planId = ? WHERE id = ?";
        PreparedStatement pst;
        pst = con.prepareStatement(query);
        pst = buildFullStatementSavePlano(pst, aluno, plano);

        int res = pst.executeUpdate();

        if (res == 1) {
            return true;
        }

        return false;
    }
}
