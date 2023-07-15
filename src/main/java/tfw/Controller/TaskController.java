package tfw.Controller;

import tfw.Entity.ConcreteTask;
import tfw.Entity.Project;
import tfw.Entity.Task;
import tfw.Entity.User;
import tfw.Service.TaskService;

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

    public ArrayList<ConcreteTask> getAllProjectTasks(Project project) throws SQLException {
        return service.searchAllProjectTasks(project);
    }

    @Override
    public boolean updateTask(Task task, TaskService service) throws SQLException {
        return service.update(task);
    }
}
