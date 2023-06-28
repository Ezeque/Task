package view;

import database.DBConfigExercicio;
import entity.Aluno;
import entity.Exercicio;
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
                break;
            case 2:
                modificarTreino(aluno);
        }
    }

    private void visualizarTreino(Aluno aluno) throws SQLException {
        ArrayList<ConcreteTask> exercicios = controller.getAllUserTasks(aluno);
        if (exercicios != null) {
            for (ConcreteTask exercicio : exercicios) {
                System.out.println(exercicio.getName() + "\n");
            }
        } else {
            System.out.println("Não há exercícios cadastrados para " + aluno.getName());
        }
    }

    private void modificarTreino(Aluno aluno) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" 1) Criar Exercício \n 2) Edita Exercício \n 3) Excluir Exercício");
        int opcao = scanner.nextInt();
        try {
            switch (opcao) {
                case 1:
                    criarExercicio(aluno);
                    break;
                case 2:
                    break;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    private void criarExercicio(Aluno aluno) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Nome: ");
        String nome = scanner.nextLine();
        System.out.println(" Membro: ");
        String membro = scanner.nextLine();
        Exercicio exercicio = new Exercicio(nome, membro, aluno.getId());
        controller.createTask(exercicio, service);
    }
}
