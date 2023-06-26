package controller;

import tfw.Controller.TaskController;
import tfw.Entity.Task;
import tfw.Service.TaskService;

public class ExercicioController extends TaskController {
    public ExercicioController(Task task, TaskService service) {
        super(task, service);
    }
}
