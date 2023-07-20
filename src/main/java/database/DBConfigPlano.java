package database;

import db.DBConnection;
import db.DBDriver;
import tfw.Database.DatabaseConfiguration;

import java.sql.Connection;

public class DBConfigPlano extends DatabaseConfiguration {
    public DBConfigPlano() {
        super("ezequiel", "", "plano", "planit", "mysql");
    }

    @Override
    public Connection connect() {
        Connection con = new DBConnection().getConnection(DBDriver.MYSQL, this.getSchema(), this.getUsername(), this.getPassword());
        return con;
    }
}
