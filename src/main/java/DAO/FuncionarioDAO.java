package DAO;

import entity.Funcionario;
import tfw.Dao.UserDAO;
import tfw.Database.DatabaseConfiguration;
import tfw.Entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FuncionarioDAO extends UserDAO {
    public FuncionarioDAO(DatabaseConfiguration config){
        super(config);
    }

    public boolean setStatus(Funcionario funcionario) throws SQLException {
        Connection con = config.connect();
        String query = "UPDATE " + config.getTable() + " SET gerente = ? WHERE id = ?";
        PreparedStatement pst;
        pst = con.prepareStatement(query);
        pst.setInt(1, funcionario.getStatus());
        pst.setInt(2, funcionario.getId());
        int res = pst.executeUpdate();

        if (res == 1) {
            return true;
        }

        return false;
    }

    public int getStatus(Funcionario funcionario) throws SQLException {
        Connection con = config.connect();
        String query = "SELECT * FROM " + config.getTable() + " WHERE name = ?;";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, funcionario.getName());
        ResultSet rs = ps.executeQuery();
        int status = -1;

        while (rs.next()) {
            status = rs.getInt("gerente");
        }
        return status;
    }
}
