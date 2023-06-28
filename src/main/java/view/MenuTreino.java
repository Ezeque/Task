package view;

import database.DBConfigExercicio;
import entity.Aluno;
import service.ExercicioService;
import tfw.Controller.TaskController;
import tfw.Entity.ConcreteTask;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuTreino implements MenuInterface {
    private TaskController controller;
    private ExercicioService service;

    public MenuTreino() {
        DBConfigExercicio dbConfig = new DBConfigExercicio();
        this.service = new ExercicioService(dbConfig);
        this.controller = new TaskController(service);
    }

    @Override
    public void show(Aluno aluno) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" 1) Visualizar Treino \n 2) Modificar Treino");
        int opcao = scanner.nextInt();
        switch (opcao) {
            case 1:
                visualizarTreino(aluno);
        }
    }

    private void visualizarTreino(Aluno aluno) throws SQLException {
        ArrayList<ConcreteTask> exercicios = controller.getAllUserTasks(aluno);
        for (ConcreteTask exercicio : exercicios) {
            System.out.println(exercicio.getName() + "\n");
        }
    }
}
