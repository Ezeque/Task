package database;

import tfw.Database.DatabaseConfiguration;

import java.sql.Connection;

public class DBConfigFuncionario extends DatabaseConfiguration {
    public DBConfigFuncionario() {
        super("root", "V3r3@dor3sMYSQL", "funcionario", "planit", "mysql");
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
