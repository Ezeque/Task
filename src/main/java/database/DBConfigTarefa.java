package database;

import tfw.Database.DatabaseConfiguration;

import java.sql.Connection;

public class DBConfigTarefa extends DatabaseConfiguration {
    public DBConfigTarefa() {
        super("ezequiel", "", "tarefa", "planit", "mysql");
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
