package Dao;

import Database.DatabaseConfiguration;
import Entity.Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjectDAO implements ProjectDAOInterface {
    protected Connection con;
    protected DatabaseConfiguration config;

    public ProjectDAO(DatabaseConfiguration config) {
        this.config = config;
        this.con = config.connect();
    }

    public Project buildProject(Project project, ResultSet rs) throws SQLException {
        project.setName(rs.getString("name"));
        project.setId(rs.getInt("id"));
        return project;
    }

    public PreparedStatement buildFullStatement(PreparedStatement pst, Project project) throws SQLException {
        pst.setString(1, project.getName());
        pst.setInt(2, project.getId());
        return pst;
    }

    public boolean create(Project project) throws SQLException {
        String query = "INSERT INTO " + config.getTable() + " (name, id) VALUES (?,?)";
        PreparedStatement pst;
        pst = con.prepareStatement(query);
        pst = buildFullStatement(pst, project);

        int res = pst.executeUpdate();

        if (res == 1) {
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        String string = "DELETE FROM " + config.getTable() + " WHERE id = ?";
        PreparedStatement pst;
        pst = con.prepareStatement(string);
        pst.setInt(1, id);

        int res = pst.executeUpdate();

        if (res == 1) {
            return true;
        }

        return false;
    }

    public Project getProjectById(Project project) throws SQLException {
        String query = "SELECT * FROM " + config.getTable();
        PreparedStatement ps;
        ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Project returnProject = buildProject(project, rs);
            if (returnProject.getId() == project.getId()) {
                return returnProject;
            }

        }
        return null;
    }

    public boolean update(Project project) throws SQLException {
        String query = "UPDATE project SET " + "name = ? WHERE id = ?";
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
