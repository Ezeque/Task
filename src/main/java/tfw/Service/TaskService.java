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

    public boolean create(Task task){
        try {
            TaskDAO dao = new TaskDAO(this.dbConfig);
            if (validateCreation(task)) {
                return dao.create(task);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public Task search(Task task){
        TaskDAO dao = new TaskDAO(this.dbConfig);
        if (validateSearch(task)) {
            try{
                task = dao.getTaskById(task);
            }catch(SQLException e){
                System.out.println(e);
            }
        }
        return null;
    }

    public ArrayList<ConcreteTask> searchAllTasks(User user){
        TaskDAO dao = new TaskDAO(this.dbConfig);
        ArrayList<ConcreteTask> tasks = new ArrayList<>();
        if (validateAllTaskSearch(user)) {
            try{
                tasks = dao.getTasksByUser(user);
            }catch(SQLException e){
                System.out.println(e);
            }
        }
        return tasks;
    }

    protected abstract boolean validateAllTaskSearch(User user);

    public boolean update(Task task){
        TaskDAO dao = new TaskDAO(this.dbConfig);
        boolean success = false;
        if (validateUpdate(task)) {
            try{
                success = dao.update(task);
            }catch(SQLException e){
                System.out.println(e);
            }
        }
        return success;
    }

    public boolean delete(Task task){
        TaskDAO dao = new TaskDAO(this.dbConfig);
        boolean success = false;
        if (validateDeletion(task)) {
            try{
                success =  dao.delete(task.getId());
            }catch(SQLException e){
                System.out.println(e);
            }
        }
        return false;
    }
}
