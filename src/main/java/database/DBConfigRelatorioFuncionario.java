package database;

import tfw.Database.DatabaseConfiguration;

import java.sql.Connection;

public class DBConfigRelatorioFuncionario extends DatabaseConfiguration {
    public DBConfigRelatorioFuncionario() {
        super("root", "V3r3@dor3sMYSQL", "relatorio_funcionario", "planit", "mysql");
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
