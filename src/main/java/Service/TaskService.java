package Service;

import Dao.DAO;
import Dao.TaskDAOInterface;
import Entity.Task;
import Entity.User;

import java.sql.SQLException;

public abstract class TaskService {
    Task task;
    TaskDAOInterface dao;

    public TaskService(TaskDAOInterface dao){
        this.dao = dao;
    }

    public abstract boolean validateCreation(Task task);
    public abstract boolean validateSearch(Task task);
    public abstract boolean validateUpdate(Task task);
    public abstract boolean validateDeletion(Task task);
    public boolean create(Task task) throws SQLException {
        if(validateCreation(task)){
            return this.dao.create(task);
        }
        return false;
    }
    public Task search(Task   task) throws SQLException {
        if(validateSearch(task)){
            return this.dao.getTaskById(task);
        }
        return null;
    }
    public boolean update(Task task) throws SQLException {
        if(validateUpdate(task)){
            return this.dao.update(task);
        }
        return false;
    }
    public boolean delete(Task task) throws SQLException {
        if(validateDeletion(task)){
            return this.dao.delete(task.getId());
        }
        return false;
    }
}
