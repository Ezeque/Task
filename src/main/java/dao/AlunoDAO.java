package dao;

import entity.Aluno;
import entity.Plano;
import tfw.Dao.UserDAO;
import tfw.Database.DatabaseConfiguration;
import tfw.Entity.Project;
import tfw.Entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AlunoDAO extends UserDAO {
    public AlunoDAO(DatabaseConfiguration config) {
        super(config);
    }

    public PreparedStatement buildFullStatementSavePlano(PreparedStatement pst, User user, Project plano) throws SQLException {
        pst.setInt(1, plano.getId());
        pst.setInt(2, user.getId());
        return pst;
    }

    public boolean savePlano(Aluno aluno, Plano plano) throws SQLException {
        String query = "UPDATE " + config.getTable() + " SET " + "planId = ? WHERE id = ?";
        PreparedStatement pst;
        pst = con.prepareStatement(query);
        pst = buildFullStatementSavePlano(pst, aluno, plano);

        int res = pst.executeUpdate();

        if (res == 1) {
            aluno.setPlano(plano);
            return true;
        }

        return false;
    }

    public Plano getProjectByAluno(Plano plano, Aluno aluno) throws SQLException {

        String query = "SELECT * FROM " + config.getTable() + " WHERE planID = ?";
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

    public Plano buildProject(Plano project, ResultSet rs) throws SQLException {
        project.setName(rs.getString("name"));
        project.setId(rs.getInt("id"));
        project.setValor(rs.getInt("valor"));
        project.setDiasPermitidos(rs.getInt("diasPermitidos"));
        project.setId(rs.getInt("id"));
        return project;
    }

    @Override
    public User login(User user) throws SQLException {
        String string = "SELECT * FROM " + config.getTable() + " WHERE name = ? AND password = ?";
        PreparedStatement pst;
        pst = con.prepareStatement(string);
        pst.setString(1, user.getName());
        pst.setString(2, user.getPassword());

        ResultSet res = pst.executeQuery();

        if (res.next()) {
            int id = res.getInt("id");
            String nome = res.getString("name");
            String email = res.getString("email");
            String senha = res.getString("password");
            int idPlano = res.getInt("planId");
            return new Aluno(nome, email, senha, id, idPlano);
        }
        return null;
    }
}
