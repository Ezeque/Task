package tfw.Service;

import database.DBConfigAluno;
import tfw.Database.DatabaseConfiguration;
import tfw.Entity.User;
import tfw.Dao.UserDAO;

import java.sql.SQLException;
import java.util.regex.Pattern;


public abstract class UserService {
    private DatabaseConfiguration dbconfig;
    public UserService(DatabaseConfiguration dbconfig){
        this.dbconfig = dbconfig;
    }

    public boolean emailExists(User user) throws InvalidEmailException{
        try{
            UserDAO dao = new UserDAO(this.dbconfig);
            if(dao.emailExists(user)){
                throw new InvalidEmailException(1);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return false;
    }

    public boolean validateEmail(String email) throws InvalidEmailException{
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailRegex);
        if(!pattern.matcher(email).matches()){
            throw new InvalidEmailException(2);
        }
        return true;
    }

    public abstract boolean validateCreation(User user);
    public abstract boolean validateSearch(User user);
    public abstract boolean validateSearchByName(User user);
    public abstract boolean validateLogin(User user);
    public abstract boolean validateUpdate(User user);
    public abstract boolean validateDeletion(User user);


    public boolean create(User user){
        boolean success = false;
        if(validateCreation(user)){
            try{
                UserDAO dao = new UserDAO(this.dbconfig);
                success = dao.create(user);
            }catch(SQLException e){
                System.out.println(e);
            }
        }

        return success;
    }

    public User getUserById(User user){

        if(validateSearch(user)){
            try {
                UserDAO dao = new UserDAO(this.dbconfig);
                user =  dao.getUserById(user);
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return user;
    }

    public User getUserByName(User user){

        if(validateSearchByName(user)){
            try {
                UserDAO dao = new UserDAO(this.dbconfig);
                user =  dao.getUserById(user);
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return user;
    }

    public boolean update(User user){
        boolean success = false;

        if(validateUpdate(user)){
            try {
                UserDAO dao = new UserDAO(this.dbconfig);
                success = dao.update(user);
            } catch (SQLException e) {
                System.out.println(e);
            }
        }

        return success;
    }

    public boolean delete(User user){
        boolean success = false;

        if(validateDeletion(user)){
            try {
                UserDAO dao = new UserDAO(this.dbconfig);
                success =  dao.delete(user);
            } catch (SQLException e) {
                System.out.println(e);
            }
        }

        return success;
    }

    public User login(User user) {
        if(validateLogin(user)){
            try {
                UserDAO dao = new UserDAO(this.dbconfig);
                return dao.login(user);
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return null;
    }
}
