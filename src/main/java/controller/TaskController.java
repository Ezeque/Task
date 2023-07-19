package Controller;

import Entity.ConcreteTask;
import Entity.Task;
import Entity.User;
import Service.TaskService;

import java.sql.SQLException;
import java.util.ArrayList;

public class TaskController extends TaskControllerAbstract {
    public TaskController(TaskService service) {
        super(service);
    }

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

    public ArrayList<ConcreteTask> getAllUserTasks(User user) throws SQLException {
        return service.searchAllTasks(user);
    }

    @Override
    public boolean updateTask(Task task, TaskService service) throws SQLException {
        return service.update(task);
    }
}
