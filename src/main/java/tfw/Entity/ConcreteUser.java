package tfw.Entity;

import java.util.Map;

public class ConcreteUser extends User {
    public ConcreteUser(String name, String email, String password, int id) {
        super(name, email, password, id);
    }

    public ConcreteUser(int id, String email) {
        super(id, email);
    }

    public ConcreteUser(int id, String name, String email, String password) {
        super(id, name, email, password);
    }

    @Override
    public Map<String, Integer> setMetrics() {
        return null;
    }
}
