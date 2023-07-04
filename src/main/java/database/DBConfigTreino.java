package database;

import db.DBConnection;
import db.DBDriver;
import tfw.Database.DatabaseConfiguration;

import java.sql.Connection;

public class DBConfigTreino extends DatabaseConfiguration {
    public DBConfigTreino() {
        super("ezequiel", "", "treino", "planit", "mysql");
    }

    public DBConfigTreino(String host) {
        super("ezequiel", "", "treino", "planit", "mysql", host);
    }

    @Override
    public Connection connect() {
        Connection con = new DBConnection().getConnection(DBDriver.MYSQL, this.getSchema(), this.getUsername(), this.getPassword());
        return con;
    }
}
