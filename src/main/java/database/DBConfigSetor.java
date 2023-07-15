package database;

import tfw.Database.DatabaseConfiguration;

import java.sql.Connection;

public class DBConfigSetor extends DatabaseConfiguration {
    public DBConfigSetor() {
        super("root", "V3r3@dor3sMYSQL", "setor", "planit", "mysql");
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
