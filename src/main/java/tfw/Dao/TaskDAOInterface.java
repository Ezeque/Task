package tfw.Dao;

import tfw.Entity.ConcreteTask;
import tfw.Entity.Project;
import tfw.Entity.Task;

import java.sql.SQLException;
import java.util.ArrayList;

public interface TaskDAOInterface {
    public boolean create(Task task) throws SQLException;

    public Task getTaskById(Task task) throws SQLException;

    public boolean delete(int id) throws SQLException;

    public boolean update(Task task) throws SQLException;

    ArrayList<ConcreteTask> getTasksByProject(Project project) throws SQLException;
}
