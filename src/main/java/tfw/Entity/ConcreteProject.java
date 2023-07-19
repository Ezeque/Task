package tfw.Entity;

import java.util.Map;

public class
ConcreteProject extends Project {
    public ConcreteProject(String name, int userId) {
        super(name, userId);
    }

    public ConcreteProject(int id, String name, int userId) {
        super(id, name, userId);
    }
    @Override
    public Map<String, Object> setMetrics() {
        return null;
    }
}
