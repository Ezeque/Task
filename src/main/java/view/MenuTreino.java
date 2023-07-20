package view;

import controller.TreinoController;
import database.DBConfigExercicio;
import database.DBConfigTreino;
import entity.Aluno;
import entity.Exercicio;
import entity.Treino;
import service.ExercicioService;
import service.TreinoService;
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

    // APRESENTA AS OPÇÕES RELACIONADAS AO TREINO
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

    //   MOSTRA O TREINO DO USUÁRIO
    private void visualizarTreino(Aluno aluno) throws SQLException {
        ArrayList<ConcreteTask> exercicios = controller.getAllUserTasks(aluno);
        if (exercicios != null) {
            System.out.println("Exercícios:");
            for (ConcreteTask exercicio : exercicios) {
                System.out.println(exercicio.getName() + " - " + exercicio.getType());
            }
        } else {
            System.out.println("Não há exercícios cadastrados para " + aluno.getName());
        }
    }

    // CUIDA DA APRESENTAÇÃO DE MODIFICAÇÃO DE TREINO AO USUÁRIO
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

    // APRESENTA A CRIAÇÃO DE EXERCÍCIOS AO USUÁRIO
    private void criarExercicio(Aluno aluno) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Nome: ");
        String nome = scanner.nextLine();
        System.out.println(" Membro: ");
        String membro = scanner.nextLine();
        Exercicio exercicio = new Exercicio(nome, membro, aluno.getId());
        controller.createTask(exercicio, service);
    }

    // APRESENTA A CRIAÇÃO DE EXERCÍCIOS AO USUÁRIO
    public void editarExercicio(Aluno aluno) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        ArrayList<ConcreteTask> exercicios = controller.getAllUserTasks(aluno);
        if (exercicios != null) {
            System.out.println("Selecione um Exercício:");
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
    }

    // APRESENTA A DELEÇÃO DE EXERCÍCIOS AO USUÁRIO
    public void deletarExercicio(Aluno aluno) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        ArrayList<ConcreteTask> exercicios = controller.getAllUserTasks(aluno);
        if (exercicios != null) {
            System.out.println("Selecione um Exercício:");
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
    }

    public void criarTreino(Aluno aluno) throws SQLException {
        DBConfigTreino configTreino = new DBConfigTreino();
        TreinoService treinoService = new TreinoService(configTreino);
        TreinoController treinoController = new TreinoController(treinoService);
        Scanner scanner = new Scanner(System.in);
        String nome;
        System.out.println("Insira o Nome do Treino:");
        nome = scanner.nextLine();
        ArrayList<Exercicio> exercicios = new ArrayList<Exercicio>();
        Treino treino = new Treino(nome, exercicios);
        treinoController.create(treino, aluno);
    }
}
