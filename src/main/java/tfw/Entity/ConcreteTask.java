package tfw.Entity;

public class ConcreteTask extends Task {
    public ConcreteTask(String name, String type) {
        super(name, type);
    }

    public ConcreteTask(int id, String name, String type) {
        super(id, name, type);
    }

    public ConcreteTask(int id, String name, String type, int userId) {
        super(id, name, type, userId);
    }

    public ConcreteTask(String name, String type, int userId) {
        super(name, type, userId);
    }
}
