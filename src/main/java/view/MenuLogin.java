package view;

import controller.AlunoController;
import database.DBConfigAluno;
import entity.Aluno;
import service.AlunoService;
import tfw.Dao.UserDAO;

import java.util.Scanner;

public class MenuLogin implements MenuInterface {
    private AlunoController controller = new AlunoController();
    private DBConfigAluno dbConfig = new DBConfigAluno();
    private AlunoService service = new AlunoService(dbConfig);


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
            controller.create(aluno, service);
        }
    }
}
