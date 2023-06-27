package database;

import db.DBConnection;
import db.DBDriver;
import tfw.Database.DatabaseConfiguration;

import java.sql.Connection;

public class DBConfigExercicio extends DatabaseConfiguration {
    public DBConfigExercicio() {
        super("root", "V3r3@dor3sMYSQL", "tarefa", "planit");
    }
    @Override
    public Connection connect() {
        Connection con = new DBConnection().getConnection(DBDriver.MYSQL, this.getSchema(), this.getUsername(), this.getPassword());
        return con;
    }
}
