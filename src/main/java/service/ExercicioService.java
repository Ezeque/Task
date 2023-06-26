package service;

import tfw.Dao.TaskDAOInterface;
import tfw.Entity.Task;
import tfw.Service.TaskService;

public class ExercicioService extends TaskService {
    public ExercicioService(TaskDAOInterface dao) {
        super(dao);
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
}
