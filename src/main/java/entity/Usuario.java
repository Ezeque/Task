package entity;

import tfw.Entity.User;

import java.util.Map;

public class Usuario extends User {
    public Usuario(String name, String email, String password, int id) {
        super(name, email, password, id);
    }

    public Usuario(String name, String email, String password) {
        super(name, email, password);
    }

    public Usuario(int id, String email) {
        super(id, email);
    }

    public Usuario(int id, String name, String email, String password) {
        super(id, name, email, password);
    }

    @Override
    public Map<String, Integer> setMetrics() {
        return null;
    }
}
