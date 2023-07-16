package tfw.Entity;

public class ConcreteTask extends Task {
    public ConcreteTask(String name, String type) {
        super(name, type);
    }

    public ConcreteTask(int id, String name, String type) {
        super(id, name, type);
    }

    public ConcreteTask(int id, String name, String type, int user_id, int project_id) {
        super(id, name, type, user_id, project_id);
    }

    public ConcreteTask(String name, String description, int projectId, int userId){
        super(name, description, userId, projectId);
    }


    public ConcreteTask(int id, String name, String type, int userId) {
        super(id, name, type, userId);
    }

    public ConcreteTask(String name, String type, int userId) {
        super(name, type, userId);
    }
}
