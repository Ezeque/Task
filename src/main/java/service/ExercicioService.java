package service;

import database.DBConfigExercicio;
import tfw.Entity.Task;
import tfw.Entity.User;
import tfw.Service.TaskService;

public class ExercicioService extends TaskService {
    public ExercicioService(DBConfigExercicio dbConfig) {
        super(dbConfig);
    }

    @Override
    public boolean validateCreation(Task task) {
        return false;
    }

    @Override
    public boolean validateSearch(Task task) {
        return false;
    }

    @Override
    public boolean validateUpdate(Task task) {
        return false;
    }

    @Override
    public boolean validateDeletion(Task task) {
        return false;
    }

    @Override
    protected boolean validateAllTaskSearch(User user) {
        return true;
    }
}
