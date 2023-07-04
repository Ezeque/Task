package entity;

import tfw.Entity.User;

import java.util.Map;

public class Aluno extends User {
    int planId;

    public Aluno(String name, String email, String password, int id) {
        super(name, email, password, id);
    }

    public Aluno(String name, String email, String password, int id, int planId) {
        super(name, email, password, id);
        this.planId = planId;
    }

    @Override
    public Map<String, Object> setMetrics() {
        return null;
    }

    public void setPlano(Plano plano) {
        this.planId = plano.getId();
    }

    public int getPlanId() {
        return planId;
    }
}
