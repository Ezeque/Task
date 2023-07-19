package entity;

import tfw.Entity.UserReport;

import java.util.Map;

public class RelatorioFuncionario extends UserReport {
    String structure;

    public RelatorioFuncionario(int id_funcionario){
        super(id_funcionario);
    }

    public void setStructure(Map<String, Integer> metrics){
        this.structure =  "==================================================================\n" +
                "\t\t\tRelatório de Usuario\n" +
                "==================================================================\n" +
                "Número de chamados abertos: " +  metrics.get("n_chamados") + "\n" +
                "Número de chamados resolvidos: " + metrics.get("n_chamados_concluidos") + "\n" +
                "Porcentagem de chamados resolvidos: " + metrics.get("porcentagem_chamados_concluidos") + "\n" +
                "==================================================================\n";

    }

    public void setMetrics(Map<String, Integer> metrics){
        this.setStructure(metrics);
    }

    public void show(){
        System.out.println(this.structure);
    }
}
