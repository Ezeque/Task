package entity;

import tfw.Entity.UserReport;

import java.util.Map;

public class RelatorioUsuario extends UserReport {
    public RelatorioUsuario(int id_usuario) {
        super(id_usuario);
    }

    @Override
    public void setStructure(Map<String, Integer> metrics) {
        this.structure = "Total de tarefas: " + metrics.get("qntTarefas")
                + "\nTarefas Concluídas: " + metrics.get("qntTarefasConcluidas") +
                "\nPorcentagem de Tarefas Concluídas:" + metrics.get("porcentagemTarefasConcluidas")
                + "% \n ________________ \n\n Projetos: " + metrics.get("qntProjetos") + "\n";
    }
}
