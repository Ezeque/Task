package tfw.Service;

import tfw.Entity.User;
import tfw.Dao.UserDAO;

import java.sql.SQLException;
import java.util.regex.Pattern;


public abstract class UserService {
    private UserDAO dao = new UserDAO();

    public UserService(UserDAO dao){
        this.dao = dao;
    }


    public boolean emailExists(User user, String entityName) throws InvalidEmailException{
        try{
            if(dao.emailExists(user, entityName)){
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

    public abstract boolean validateCreation(User user, String entityName);
    public abstract boolean validateSearch(User user, String entityName);
    public abstract boolean validateUpdate(User user, String entityName);
    public abstract boolean validateDeletion(User user, String entityName);


    public boolean create(User user, String entityName){
        boolean success = false;
        if(validateCreation(user, entityName)){
            try{
                success = dao.create(user, entityName);
            }catch(SQLException e){
                System.out.println(e);
            }
        }

        return success;
    }

    public User getUserById(User user, String entityName){

        if(validateSearch(user, entityName)){
            try {
                user =  dao.getUserById(user, entityName);
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return user;
    }

    public boolean update(User user, String entityName){
        boolean success = false;

        if(validateUpdate(user, entityName)){
            try {
                success = dao.update(user, entityName);
            } catch (SQLException e) {
                System.out.println(e);
            }
        }

        return success;
    }

    public boolean delete(User user, String entityName){
        boolean success = false;

        if(validateDeletion(user, entityName)){
            try {
                success =  dao.delete(user, entityName);
            } catch (SQLException e) {
                System.out.println(e);
            }
        }

        return success;
    }
}
