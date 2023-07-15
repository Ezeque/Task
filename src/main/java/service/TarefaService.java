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
        return true;
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
