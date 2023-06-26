package tfw.Controller;

import tfw.Entity.Task;
import tfw.Service.TaskService;

import java.sql.SQLException;

public class TaskController extends TaskControllerAbstract{

    public TaskController(Task task, TaskService service) {
        super(task, service);
    }

    @Override
    public void PrintTask(Task task) {
        System.out.println(task.getName());
    }

    @Override
    public boolean deleteTask(Task task) throws SQLException {
        return this.service.delete(task);
    }

    @Override
    public boolean createTask(Task task) throws SQLException {
        return this.service.create(task);
    }

    @Override
    public Task SearchTask(Task task) throws SQLException {
        return this.service.search(task);
    }

    @Override
    public boolean updateTask(Task task) throws SQLException {
        return this.service.update(task);
    }
}
