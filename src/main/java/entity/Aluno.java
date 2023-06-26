package entity;

import tfw.Entity.User;

import java.util.Map;

public class Aluno extends User {
    public Aluno(String name, String email, String password, int id) {
        super(name, email, password, id);
    }

    @Override
    public Map<String, Object> setMetrics() {
        return null;
    }
}
