package Database;

import java.sql.Connection;

public abstract class DatabaseConfiguration {
    String username;
    String password;
    String table;
    public abstract Connection connect();
}
