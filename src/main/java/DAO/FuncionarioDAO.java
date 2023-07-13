package DAO;

import tfw.Dao.UserDAO;
import tfw.Database.DatabaseConfiguration;

public class FuncionarioDAO extends UserDAO {
    public FuncionarioDAO(DatabaseConfiguration config){
        super(config);
    }
}
