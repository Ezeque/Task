package entity;

import tfw.Entity.User;

import java.util.Map;

public class Aluno extends User {
    int planId;

    public Aluno(String name, String email, String password, int id) {
        super(name, email, password, id);
    }

    @Override
    public Map<String, Object> setMetrics() {
        return null;
    }

    public void setPlano(Plano plano) {
        this.planId = plano.getId();
    }
}
