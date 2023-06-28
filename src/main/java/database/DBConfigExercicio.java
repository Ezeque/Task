package database;

import db.DBConnection;
import db.DBDriver;
import tfw.Database.DatabaseConfiguration;

import java.sql.Connection;

public class DBConfigExercicio extends DatabaseConfiguration {
    public DBConfigExercicio() {
        super("ezequiel", "", "exercicio", "planit", "mysql");
    }

    @Override
    public Connection connect() {
        Connection con = new DBConnection().getConnection(DBDriver.MYSQL, this.getSchema(), this.getUsername(), this.getPassword());
        return con;
    }
}
