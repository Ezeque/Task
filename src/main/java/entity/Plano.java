package entity;

import tfw.Entity.Project;

import java.util.Map;

public class Plano extends Project {
    public Plano(int id, String name) {
        super(id, name);
    }

    @Override
    public Map<String, Object> setMetrics() {
        return null;
    }
}
