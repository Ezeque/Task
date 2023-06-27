package database;

import db.DBConnection;
import db.DBDriver;
import tfw.Database.DatabaseConfiguration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfigAluno extends DatabaseConfiguration {

    public DBConfigAluno() {
        super("ezequiel", "", "aluno", "planit");
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

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + this.getSchema(), this.getUsername(), this.getPassword());
        return con;
    }
}
