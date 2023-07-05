package database;

import tfw.Database.DatabaseConfiguration;

import java.sql.Connection;

public class DBConfigRelatorioAluno extends DatabaseConfiguration {

    public DBConfigRelatorioAluno() {
        super("root", "V3r3@dor3sMYSQL", "relatorio_aluno", "planit", "mysql");
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
