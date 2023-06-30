package view;

import entity.Aluno;

import java.sql.SQLException;

public interface MenuInterface {
    //    MÉTODO PRINCIPAL DE MENU, REALIZA TODA A LÓGICA DE CHAMAR OS OUTROS MÉTODOS PARA EXIBIR OS MENUS NECESSÁRIOS
    public void show(Aluno aluno) throws SQLException;
}
