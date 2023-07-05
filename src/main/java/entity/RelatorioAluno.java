package entity;

import tfw.Entity.UserReport;

import java.util.Map;

public class RelatorioAluno extends UserReport {

    String structure;

    public RelatorioAluno(int id_aluno){
        super(id_aluno);
    }

    public void setStructure(Map<String, Integer> metrics){
        this.structure =  "==================================================================\n" +
                "\t\t\tRelatório de Usuario\n" +
                "==================================================================\n" +
                "Media de exercícios por treino: " +  metrics.get("media_de_exercicios_treino") + "\n" +
                "Número de treinos: " + metrics.get("n_treinos") + "\n" +
                "Número de dias seguidos treinando: " + metrics.get("dias_seguidos") + "\n" +
                "==================================================================\n";

    }

    public void setMetrics(Map<String, Integer> metrics){
        this.setStructure(metrics);
    }

    public void show(){
        System.out.println(this.structure);
    }
}
