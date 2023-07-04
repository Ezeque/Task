package controller;

import dao.AlunoDAO;
import database.DBConfigAluno;
import entity.Aluno;
import entity.Plano;
import service.AlunoService;
import tfw.Controller.UserController;
import tfw.Database.DatabaseConfiguration;
import tfw.Entity.User;
import tfw.Service.UserService;

import java.sql.SQLException;

public class AlunoController extends UserController {
    AlunoService alunoService;
    AlunoDAO dao;
    DBConfigAluno config;

    public AlunoController(UserService service) {
        super(service);
        this.config = new DBConfigAluno();
        this.dao = new AlunoDAO(config);
        this.alunoService = new AlunoService(config);
    }

    public boolean savePlano(Plano plano, Aluno aluno) throws SQLException {
        DatabaseConfiguration config = new DBConfigAluno();
        AlunoService alunoService = new AlunoService((DBConfigAluno) config);
        if (alunoService.validateSetPlano(plano)) {
            return dao.savePlano(aluno, plano);
        }
        return false;
    }

    public Plano SearchPlanoAluno(Plano project, AlunoService service, Aluno aluno) throws SQLException {
        return service.searchPlanoAluno(project, aluno);
    }

    @Override
    public User login(User user) {
        return this.alunoService.login(user);
    }
}
