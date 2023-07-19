package dao;

import tfw.Dao.ProjectDAO;
import tfw.Database.DatabaseConfiguration;
import tfw.Entity.Project;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProjetoDAO extends ProjectDAO {
    public ProjetoDAO(DatabaseConfiguration config) {
        super(config);
    }

    public PreparedStatement buildFullStatement(PreparedStatement pst, Project project, Usuario user) throws SQLException {
        pst.setString(1, project.getName());
        pst.setInt(2, project.getId());
        pst.setInt(3, user.getId());
        return pst;
    }

    public boolean create(Project project, Usuario user) throws SQLException {
        String query = "INSERT INTO " + config.getTable() + " (name, id, userId) VALUES (?,?,?)";
        PreparedStatement pst;
        pst = con.prepareStatement(query);
        pst = buildFullStatement(pst, project, user);

        int res = pst.executeUpdate();

        if (res == 1) {
            return true;
        }

        return false;
    }
}
