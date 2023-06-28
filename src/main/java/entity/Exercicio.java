package entity;

import tfw.Entity.ConcreteTask;

public class Exercicio extends ConcreteTask {
    public Exercicio(int id, String name, String type) {
        super(id, name, type);
    }

    public Exercicio(int id, String name, String type, int userId) {
        super(id, name, type, userId);
    }

    public Exercicio(String name, String type, int userId) {
        super(name, type, userId);
    }

    public Exercicio(String name, String type) {
        super(name, type);
    }
}
