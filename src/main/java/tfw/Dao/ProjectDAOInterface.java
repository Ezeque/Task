package tfw.Dao;

import tfw.Entity.Project;

import java.sql.SQLException;

public interface ProjectDAOInterface {
    public boolean create(Project project) throws SQLException;

    public Project getProjectById(Project project) throws SQLException;

    public boolean delete(int id) throws SQLException;

    public boolean update(Project project) throws SQLException;
}
