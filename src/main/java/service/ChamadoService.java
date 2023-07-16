package service;

import tfw.Database.DatabaseConfiguration;
import tfw.Entity.Task;
import tfw.Entity.User;
import tfw.Service.TaskService;

public class ChamadoService extends TaskService {

    public ChamadoService(DatabaseConfiguration config){
        super(config);
    }

    @Override
    public boolean validateGetAllTask(){
        return true;
    }


    @Override
    public boolean validateCreation(Task task) {
        return true;
    }

    @Override
    public boolean validateSearch(Task task) {
        return true;
    }

    @Override
    public boolean validateUpdate(Task task) {
        return true;
    }

    @Override
    public boolean validateDeletion(Task task) {
        return true;
    }

    @Override
    protected boolean validateAllTaskSearch(User user) {
        return true;
    }
}
