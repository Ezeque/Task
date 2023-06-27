package database;

import db.DBConnection;
import db.DBDriver;
import tfw.Database.DatabaseConfiguration;

import java.sql.Connection;

public class DBConfigAluno extends DatabaseConfiguration {

    public DBConfigAluno() {
        super("root", "V3r3@dor3sMYSQL", "usuario", "planit");
    }
    @Override
    public Connection connect() {
        Connection con = new DBConnection().getConnection(DBDriver.MYSQL, this.getSchema(), this.getUsername(), this.getPassword());
        return con;
    }
}
