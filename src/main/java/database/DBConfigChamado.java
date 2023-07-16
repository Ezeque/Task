package database;

import tfw.Database.DatabaseConfiguration;

import java.sql.Connection;

public class DBConfigChamado extends DatabaseConfiguration {
    public DBConfigChamado() {
        super("root", "V3r3@dor3sMYSQL", "chamado", "planit", "mysql");
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
