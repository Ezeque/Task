package database;

import tfw.Database.DatabaseConfiguration;

import java.sql.Connection;

public class DBConfigUsuario extends DatabaseConfiguration {
    public DBConfigUsuario() {
        super("ezequiel", "", "usuario", "planit", "mysql");
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
