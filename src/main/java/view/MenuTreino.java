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
        System.out.println(" 1) Visualizar Treino \n 2) Modificar Treino \n 3) Deletar Treino");
        int opcao = scanner.nextInt();
        switch (opcao) {
            case 1:
                visualizarTreino(aluno);
                break;
            case 2:
                modificarTreino(aluno);
                break;
            case 3:
                deletarExercicio(aluno);
                break;
            default:
                System.out.println("Opção Inválida");
                break;
        }
    }

    private void visualizarTreino(Aluno aluno) throws SQLException {
        ArrayList<ConcreteTask> exercicios = controller.getAllUserTasks(aluno);
        if (exercicios != null) {
            System.out.println("\n Exercícios: \n");
            for (ConcreteTask exercicio : exercicios) {
                System.out.println(exercicio.getName() + " - " + exercicio.getType());
            }
        } else {
            System.out.println("Não há exercícios cadastrados para " + aluno.getName());
        }
        System.out.println("\n");
    }

    private void modificarTreino(Aluno aluno) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" 1) Criar Exercício \n 2) Editar Exercício \n 3) Excluir Exercício");
        int opcao = scanner.nextInt();
        try {
            switch (opcao) {
                case 1:
                    criarExercicio(aluno);
                    break;
                case 2:
                    editarExercicio(aluno);
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

    public void editarExercicio(Aluno aluno) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        ArrayList<ConcreteTask> exercicios = controller.getAllUserTasks(aluno);
        if (exercicios != null) {
            System.out.println("\n Selecione um Exercício: \n");
            for (ConcreteTask exercicio : exercicios) {
                System.out.println("[" + exercicios.indexOf(exercicio) + "] " + exercicio.getName() + " - " + exercicio.getType());
            }
            int opcao = scanner.nextInt();
            ConcreteTask exercicio = exercicios.get(opcao);
            System.out.println(exercicio.getName() + ": ");
            System.out.println("[1] Mudar Nome");
            System.out.println("[2] Mudar Membro");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    System.out.println("Informe um novo nome:");
                    String nome;
                    nome = scanner.nextLine();
                    exercicio.setName(nome);
                    controller.updateTask(exercicio, service);
                    break;
                case 2:
                    System.out.println("Informe um novo membro:");
                    String membro = scanner.nextLine();
                    exercicio.setType(membro);
                    controller.updateTask(exercicio, service);
                    break;
                default:
                    System.out.println("Opçao Inválida");
                    break;
            }
        } else {
            System.out.println("Não há exercícios cadastrados para " + aluno.getName());
        }
        System.out.println("\n");
    }

    public void deletarExercicio(Aluno aluno) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        ArrayList<ConcreteTask> exercicios = controller.getAllUserTasks(aluno);
        if (exercicios != null) {
            System.out.println("\n Selecione um Exercício: \n");
            for (ConcreteTask exercicio : exercicios) {
                System.out.println("[" + exercicios.indexOf(exercicio) + "] " + exercicio.getName() + " - " + exercicio.getType());
            }
            int opcao = scanner.nextInt();
            ConcreteTask exercicio = exercicios.get(opcao);
            System.out.println("Tem certeza que deseja deletar " + exercicio.getName() + "?");
            System.out.println("[1] Sim");
            System.out.println("[2] Não");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    controller.deleteTask(exercicio, service);
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Opçao Inválida");
                    break;
            }
        } else {
            System.out.println("Não há exercícios cadastrados para " + aluno.getName());
        }
        System.out.println("\n");
    }
}
