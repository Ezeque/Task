package entity;

import controller.TreinoController;
import tfw.Entity.Project;

import java.util.ArrayList;
import java.util.Map;

public class Treino extends Project {
    ArrayList<Exercicio> exercicios;

    TreinoController controller;

    public Treino(int id, String nome, ArrayList<Exercicio> exercicios) {
        super(id, nome);
        this.exercicios = exercicios;
    }

    public Treino(String nome, ArrayList<Exercicio> exercicios) {
        super(nome);
        this.exercicios = exercicios;
    }


    @Override
    public Map<String, Object> setMetrics() {
        return null;
    }
}
