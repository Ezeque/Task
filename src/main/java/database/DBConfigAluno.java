package database;

import tfw.Database.DatabaseConfiguration;

import java.sql.Connection;

public class DBConfigAluno extends DatabaseConfiguration {

    public DBConfigAluno() {
        super("ezequiel", "", "aluno", "academia", "mysql");
    }

    @Override
    public Connection connect() {
        try {
            Connection con = getConnection();
            return con;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
