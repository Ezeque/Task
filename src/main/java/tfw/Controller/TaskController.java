package tfw.Controller;

import tfw.Entity.Task;
import tfw.Service.TaskService;

import java.sql.SQLException;

public class TaskController extends TaskControllerAbstract{

    @Override
    public void PrintTask(Task task, TaskService service) {
        System.out.println(task.getName());
    }

    @Override
    public boolean deleteTask(Task task, TaskService service) throws SQLException {
        return service.delete(task);
    }

    @Override
    public boolean createTask(Task task, TaskService service) throws SQLException {
        return service.create(task);
    }

    @Override
    public Task SearchTask(Task task, TaskService service) throws SQLException {
        return service.search(task);
    }

    @Override
    public boolean updateTask(Task task, TaskService service) throws SQLException {
        return service.update(task);
    }
}
