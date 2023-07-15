package dao;

import entity.Usuario;
import tfw.Dao.ProjectDAO;
import tfw.Database.DatabaseConfiguration;
import tfw.Entity.ConcreteProject;
import tfw.Entity.Project;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProjetoDAO extends ProjectDAO {
    public ProjetoDAO(DatabaseConfiguration config) {
        super(config);
    }

    public ArrayList<Project> getUserProjects(Usuario user) throws SQLException {
        ArrayList<Project> projetos = new ArrayList<Project>();
        String query = "SELECT * FROM " + config.getTable() + " WHERE userId = ?";
        PreparedStatement ps;
        ps = con.prepareStatement(query);
        ps.setInt(1, user.getId());
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Project returnProject = new ConcreteProject(rs.getString(2), rs.getInt(4));
            projetos.add(returnProject);
        }
        return projetos;
    }

    public PreparedStatement buildFullStatement(PreparedStatement pst, Project project, Usuario user) throws SQLException {
        pst.setString(1, project.getName());
        pst.setInt(2, project.getId());
        pst.setInt(2, user.getId());
        return pst;
    }

    public boolean create(Project project, Usuario user) throws SQLException {
        String query = "INSERT INTO " + config.getTable() + " (name, id) VALUES (?,?,?)";
        PreparedStatement pst;
        pst = con.prepareStatement(query);
        pst = buildFullStatement(pst, project);

        int res = pst.executeUpdate();

        if (res == 1) {
            return true;
        }

        return false;
    }
}
