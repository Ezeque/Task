package Service;

import Dao.DAO;
import Entity.Task;
import Entity.User;

public abstract class TaskService {
    Task task;
    DAO dao;

    public abstract boolean validateCreation(Task user, String entityName);
    public abstract boolean validateSearch(Task user, String entityName);
    public abstract boolean validateUpdate(Task user, String entityName);
    public abstract boolean validateDeletion(Task user, String entityName);
}
