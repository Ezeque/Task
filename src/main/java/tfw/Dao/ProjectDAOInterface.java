package tfw.Dao;

import tfw.Entity.Project;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ProjectDAOInterface {
    public boolean create(Project project) throws SQLException;

    public Project getProjectById(Project project) throws SQLException;

    public boolean delete(int id) throws SQLException;

    public boolean update(Project project) throws SQLException;

    public ArrayList<Project> getAll(Project project) throws SQLException;
}
