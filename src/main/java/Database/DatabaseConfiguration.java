package Database;

import java.sql.Connection;

public abstract class DatabaseConfiguration {
    public abstract Connection connect();
}
