package database;

import tfw.Database.DatabaseConfiguration;

import java.sql.Connection;

public class DBConfigProjeto extends DatabaseConfiguration {
    public DBConfigProjeto() {
        super("ezequiel", "", "projeto", "planit", "mysql");
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
