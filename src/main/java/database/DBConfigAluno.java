package database;

import db.DBConnection;
import db.DBDriver;
import tfw.Database.DatabaseConfiguration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfigAluno extends DatabaseConfiguration {

    public DBConfigAluno() {
        super("root", "V3r3@dor3sMYSQL", "aluno", "planit", "mysql");
    }
    @Override
    public Connection connect(){
        try{
            Connection con = getConnection();
            return con;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
}
