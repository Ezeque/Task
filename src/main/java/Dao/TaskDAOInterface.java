package Dao;

import Entity.Task;

import java.sql.SQLException;

public interface TaskDAOInterface {
    public boolean create(Task task) throws SQLException;

    public Task getTaskById(Task task) throws SQLException;

    public boolean delete(int id) throws SQLException;

    public boolean update(Task task) throws SQLException;
}
