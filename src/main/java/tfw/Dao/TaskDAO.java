package tfw.Dao;

import tfw.Database.DatabaseConfiguration;
import tfw.Entity.ConcreteTask;
import tfw.Entity.Project;
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
        task.setDescription(rs.getString("description"));
        task.setDescription(rs.getString("status"));

        return task;
    }

    public PreparedStatement buildFullStatement(PreparedStatement pst, Task task) throws SQLException {
        pst.setString(1, task.getName());
        pst.setString(2, task.getType());
        pst.setInt(3, task.getId());
        pst.setInt(4, task.getUserID());
        pst.setInt(5, task.getProjectID());
        pst.setString(6, task.getDescription());
        pst.setString(7, task.getStatus());
        return pst;
    }

    public PreparedStatement buildFullStatementUpdate(PreparedStatement pst, Task task) throws SQLException {
        pst.setString(1, task.getName());
        pst.setString(2, task.getType());
        pst.setString(3, task.getDescription());
        pst.setString(4, task.getStatus());
        pst.setInt(5, task.getId());
        return pst;
    }

    public PreparedStatement buildFullStatementTasksByUser(PreparedStatement pst, User user) throws SQLException {
        pst.setInt(1, user.getId());
        return pst;
    }

    public PreparedStatement buildFullStatementTasksByProject(PreparedStatement pst, Project project) throws SQLException {
        pst.setInt(1, project.getId());
        return pst;
    }

    public boolean create(Task task) throws SQLException {
        String query = "INSERT INTO " + config.getTable() + " (name, type, id, userId, project_id, description, status) VALUES (?,?,?,?,?,?,?)";
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
        ArrayList<ConcreteTask> tasks = new ArrayList<ConcreteTask>();
        String query = "SELECT * FROM " + config.getTable() + " WHERE userId = ?";
        PreparedStatement pst;
        pst = con.prepareStatement(query);
        pst = buildFullStatementTasksByUser(pst, user);

        ResultSet res = pst.executeQuery();
        while (res.next()) {
            int id = res.getInt("id");
            String name = res.getString("name");
            String type = res.getString("type");
            String description = res.getString("description");
            ConcreteTask task = new ConcreteTask(id, name, type);
            task.setDescription(description);
            tasks.add(task);
        }
        if (tasks.size() > 0) {
            return tasks;
        }
        return null;
    }

    public boolean update(Task task) throws SQLException {
        String query = "UPDATE " + config.getTable() + " SET " + "name = ?, type = ?, description = ?, status = ? WHERE id = ?";
        PreparedStatement pst;
        pst = con.prepareStatement(query);
        pst = buildFullStatementUpdate(pst, task);

        int res = pst.executeUpdate();

        if (res == 1) {
            return true;
        }

        return false;
    }

    @Override
    public ArrayList<ConcreteTask> getTasksByProject(Project project) throws SQLException {
        ArrayList<ConcreteTask> tasks = new ArrayList<ConcreteTask>();
        String query = "SELECT * FROM " + config.getTable() + " WHERE project_id = ?";
        PreparedStatement pst;
        pst = con.prepareStatement(query);
        pst = buildFullStatementTasksByProject(pst, project);

        ResultSet res = pst.executeQuery();
        while (res.next()) {
            int id = res.getInt("id");
            String name = res.getString("name");
            String type = res.getString("type");
            String description = res.getString("description");
            String status = res.getString("status");
            ConcreteTask task = new ConcreteTask(id, name, type);
            task.setDescription(description);
            task.setStatus(status);
            tasks.add(task);
        }
        if (tasks.size() > 0) {
            return tasks;
        }
        return null;
    }
}
