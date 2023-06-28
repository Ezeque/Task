package tfw.Dao;

import tfw.Database.DatabaseConfiguration;
import tfw.Entity.ConcreteTask;
import tfw.Entity.Task;
import tfw.Entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TaskDAO implements TaskDAOInterface {
    Connection con;
    DatabaseConfiguration config;

    public TaskDAO(DatabaseConfiguration DBConfig) {
        config = DBConfig;
        con = config.connect();
    }

    public Task buildTask(Task task, ResultSet rs) throws SQLException {
        task.setName(rs.getString("name"));
        task.setId(rs.getInt("id"));
        task.setType(rs.getString("type"));
        return task;
    }

    public PreparedStatement buildFullStatement(PreparedStatement pst, Task task) throws SQLException {
        pst.setString(1, task.getName());
        pst.setString(2, task.getType());
        pst.setInt(3, task.getId());
        return pst;
    }

    public PreparedStatement buildFullStatementTasksByUser(PreparedStatement pst, User user) throws SQLException {
        pst.setInt(1, user.getId());
        return pst;
    }

    public boolean create(Task task) throws SQLException {
        String query = "INSERT INTO " + config.getTable() + " (name, type, id) VALUES (?,?,?)";
        PreparedStatement pst;
        pst = con.prepareStatement(query);
        pst = buildFullStatement(pst, task);

        int res = pst.executeUpdate();

        if (res == 1) {
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        String string = "DELETE FROM " + config.getTable() + " WHERE id = ?";
        PreparedStatement pst;
        pst = con.prepareStatement(string);
        pst.setInt(1, id);

        int res = pst.executeUpdate();

        if (res == 1) {
            return true;
        }

        return false;
    }

    public Task getTaskById(Task task) throws SQLException {
        String query = "SELECT * FROM " + config.getTable();
        PreparedStatement ps;
        ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Task returnTask = buildTask(task, rs);
            if (returnTask.getId() == task.getId()) {
                return returnTask;
            }

        }
        return null;
    }

    public ArrayList<ConcreteTask> getTasksByUser(User user) throws SQLException {
        ArrayList<Task> tasks = new ArrayList<Task>();
        String query = "SELECT * FROM " + config.getTable() + " WHERE id = ?";
        PreparedStatement pst;
        pst = con.prepareStatement(query);
        pst = buildFullStatementTasksByUser(pst, user);

        ResultSet res = pst.executeQuery();

        if (res.next()) {
            int id = res.getInt("id");
            String name = res.getString("name");
            String type = res.getString("type");
            tasks.add(new ConcreteTask(id, name, type));
        }

        return null;
    }

    public boolean update(Task task) throws SQLException {
        String query = "UPDATE task SET " + "name = ?, type = ? WHERE id = ?";
        PreparedStatement pst;
        pst = con.prepareStatement(query);
        pst = buildFullStatement(pst, task);

        int res = pst.executeUpdate();

        if (res == 1) {
            return true;
        }

        return false;
    }
}
