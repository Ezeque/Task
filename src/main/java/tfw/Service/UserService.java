package tfw.Service;

import database.DBConfigAluno;
import tfw.Database.DatabaseConfiguration;
import tfw.Entity.User;
import tfw.Dao.UserDAO;

import java.sql.SQLException;
import java.util.regex.Pattern;


public abstract class UserService {
    public boolean emailExists(User user) throws InvalidEmailException{
        try{
            UserDAO dao = new UserDAO();
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
    public abstract boolean validateUpdate(User user);
    public abstract boolean validateDeletion(User user);


    public boolean create(User user){
        boolean success = false;
        if(validateCreation(user)){
            try{
                UserDAO dao = new UserDAO();
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
                UserDAO dao = new UserDAO();
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
                UserDAO dao = new UserDAO();
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
                UserDAO dao = new UserDAO();
                success =  dao.delete(user);
            } catch (SQLException e) {
                System.out.println(e);
            }
        }

        return success;
    }
}
