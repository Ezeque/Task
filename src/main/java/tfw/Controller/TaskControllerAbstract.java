package tfw.Controller;

import tfw.Entity.Task;
import tfw.Service.TaskService;

import java.sql.SQLException;

public abstract class TaskControllerAbstract {
    protected TaskService service;

    public TaskControllerAbstract(TaskService service) {
        this.service = service;
    }

    public abstract void PrintTask(Task task, TaskService service);

    public abstract boolean deleteTask(Task task, TaskService service) throws SQLException;

    public abstract boolean createTask(Task task, TaskService service) throws SQLException;

    public abstract Task SearchTask(Task task, TaskService service) throws SQLException;

    public abstract boolean updateTask(Task task, TaskService service) throws SQLException;
}
