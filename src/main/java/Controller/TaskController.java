package tfw.Controller;


import tfw.Entity.ConcreteTask;
import tfw.Entity.Project;
import tfw.Entity.Task;
import tfw.Entity.User;
import Service.TaskService;

import java.sql.SQLException;
import java.util.ArrayList;

public class TaskController extends tfw.Controller.TaskControllerAbstract {
    public TaskController(TaskService service) {
        super(service);
    }

    @Override
    public void PrintTask(Task task) {
        System.out.println(task.getName());
    }

    @Override
    public boolean deleteTask(Task task){
        return service.delete(task);
    }

    @Override
    public boolean createTask(Task task){
        return service.create(task);
    }

    @Override
    public Task SearchTask(Task task){
        return service.search(task);
    }

    public ArrayList<Task> getAllUserTasks(User user){
        return service.searchAllTasks(user);
    }


    public ArrayList<Task> getAllTasks() {
        return service.getAllTasks();
    }

    public ArrayList<ConcreteTask> getAllProjectTasks(Project project) throws SQLException {
        return service.searchAllProjectTasks(project);
    }

    @Override
    public boolean updateTask(Task task){
        return service.update(task);
    }
}
