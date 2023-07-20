package entity;

import tfw.Entity.User;

import java.util.HashMap;
import java.util.Map;

public class Aluno extends User {
    int planId;

    public Aluno(String name, String email, String password, int id) {
        super(name, email, password, id);
    }

    public Aluno(String name, String email, String password, int id, int planId) {
        super(name, email, password, id, planId);
        this.planId = planId;
    }

    @Override
    public Map<String, Integer> setMetrics() {
        Map<String, Integer> metrics = new HashMap<>();
        metrics.put("media_de_exercicios_treino", 0);
        metrics.put("n_treinos", 0);
        metrics.put("dias_seguidos", 0);

        return metrics;
    }

    public void setPlano(Plano plano) {
        this.planId = plano.getId();
    }

    public int getPlanId() {
        return planId;
    }
}
