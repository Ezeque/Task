package view;

import entity.Aluno;

public class MenuRelatorios implements MenuInterface {
    ;

    @Override
    public void show(Aluno aluno) {
        System.out.println(" 1) Ver Plano \n 2) Trocar de Plano \n");
    }
}
