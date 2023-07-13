package entity;

import tfw.Entity.User;

import java.util.Map;

public class Funcionario extends User {
    public Funcionario(){

    }
    public Funcionario(String name, String email, String password, int id) {
        super(name, email, password, id);
    }

    public Funcionario(String name, String email, String password) {
        super(name, email, password);
    }

    public Funcionario(int id, String email) {
        super(id, email);
    }

    public Funcionario(int id, String name, String email, String password) {
        super(id, name, email, password);
    }

    @Override
    public Map<String, Integer> setMetrics() {
        return null;
    }
}
