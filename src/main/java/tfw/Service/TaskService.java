package tfw.Service;

import tfw.Dao.TaskDAO;
import tfw.Database.DatabaseConfiguration;
import tfw.Entity.ConcreteTask;
import tfw.Entity.Task;
import tfw.Entity.User;

import java.sql.SQLException;
import java.util.ArrayList;

public abstract class TaskService {
    DatabaseConfiguration dbConfig;

    public TaskService(DatabaseConfiguration dbConfig) {
        this.dbConfig = dbConfig;
    }

    public abstract boolean validateCreation(Task task);

    public abstract boolean validateSearch(Task task);

    public abstract boolean validateUpdate(Task task);

    public abstract boolean validateDeletion(Task task);

    public boolean create(Task task) throws SQLException {
        TaskDAO dao = new TaskDAO(this.dbConfig);
        if (validateCreation(task)) {
            return dao.create(task);
        }
        return false;
    }

    public Task search(Task task) throws SQLException {
        TaskDAO dao = new TaskDAO(this.dbConfig);
        if (validateSearch(task)) {
            return dao.getTaskById(task);
        }
        return null;
    }

    public ArrayList<ConcreteTask> searchAllTasks(User user) throws SQLException {
        TaskDAO dao = new TaskDAO(this.dbConfig);
        if (validateAllTaskSearch(user)) {
            return dao.getTasksByUser(user);
        }
        return null;
    }

    protected abstract boolean validateAllTaskSearch(User user);

    public boolean update(Task task) throws SQLException {
        TaskDAO dao = new TaskDAO(this.dbConfig);
        if (validateUpdate(task)) {
            return dao.update(task);
        }
        return false;
    }

    public boolean delete(Task task) throws SQLException {
        TaskDAO dao = new TaskDAO(this.dbConfig);
        if (validateDeletion(task)) {
            return dao.delete(task.getId());
        }
        return false;
    }
}
