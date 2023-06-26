package tfw.Controller;

import tfw.Entity.Task;
import tfw.Service.TaskService;

import java.sql.SQLException;

public abstract class TaskControllerAbstract {
    Task task;
    TaskService service;

    public TaskControllerAbstract(Task task, TaskService service){
        this.task = task;
        this.service = service;
    }

    public abstract void PrintTask(Task task);

    public abstract boolean deleteTask(Task task) throws SQLException;

    public abstract boolean createTask(Task task) throws SQLException;

    public abstract Task SearchTask(Task task) throws SQLException;

    public abstract boolean updateTask(Task task) throws SQLException;
}
