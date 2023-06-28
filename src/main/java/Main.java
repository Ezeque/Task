import view.MenuLogin;
import view.MenuLoginInterface;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        MenuLoginInterface menuLogin = new MenuLogin();
        try {
            menuLogin.show();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
