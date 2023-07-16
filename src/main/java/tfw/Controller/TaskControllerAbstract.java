package tfw.Controller;

import tfw.Entity.Task;
import tfw.Service.TaskService;

import java.sql.SQLException;

public abstract class TaskControllerAbstract {
    protected TaskService service;

    public TaskControllerAbstract(TaskService service) {
        this.service = service;
    }

    public abstract void PrintTask(Task task);

    public abstract boolean deleteTask(Task task);

    public abstract boolean createTask(Task task);

    public abstract Task SearchTask(Task task);

    public abstract boolean updateTask(Task task);
}
