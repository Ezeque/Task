package view;

import controller.AlunoController;
import entity.Aluno;
import service.AlunoService;

import java.util.Scanner;

public class MenuLogin implements MenuInterface {
    @Override
    public void show(int opcao) {
        Scanner scanner = new Scanner(System.in);
        if(opcao == 1){
            System.out.println("Login: ");
            String login = scanner.nextLine();
            System.out.println("Email: ");
            String email = scanner.nextLine();
            System.out.println("Senha: ");
            String senha = scanner.nextLine();
            Aluno aluno = new Aluno(login, email, senha, 1);
            AlunoService service = new AlunoService();
            AlunoController controller = new AlunoController(aluno, service);
            controller.create(aluno);
        }
    }
}
