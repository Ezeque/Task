package service;

import tfw.Database.DatabaseConfiguration;
import tfw.Entity.Task;
import tfw.Entity.User;
import tfw.Service.TaskService;

public class TarefaService extends TaskService {
    public TarefaService(DatabaseConfiguration dbConfig) {
        super(dbConfig);
    }

    @Override
    public boolean validateCreation(Task task) {
        if (task.getName().length() > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean validateSearch(Task task) {
        if (task.getName().length() > 0 && task.getId() > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean validateUpdate(Task task) {
        if (task.getName().length() > 0 && task.getId() > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean validateDeletion(Task task) {
        if (task.getName().length() > 0 && task.getId() > 0) {
            return true;
        }
        return false;
    }

    @Override
    protected boolean validateAllTaskSearch(User user) {
        return true;
    }
}
