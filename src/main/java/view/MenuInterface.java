package view;

import entity.Aluno;

import java.sql.SQLException;

public interface MenuInterface {
    public void show(Aluno aluno) throws SQLException;
}
