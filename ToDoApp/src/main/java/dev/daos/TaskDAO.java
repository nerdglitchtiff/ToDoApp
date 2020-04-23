package dev.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import dev.entities.task.Task;
import dev.utilities.ConnUtil;

public class TaskDAO implements TaskDAOI{

	@Override
	public Task createTask(Task task) {
		String sql = "Insert into Task values(?,?,?,?)";
		try(Connection conn = ConnUtil.createConnection()){
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, 0);
			ps.setString(2, task.getDescri());
			ps.setString(3, task.getPriority());
			ps.setBoolean(4, task.isComplete());
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			int key = rs.getInt("tId");
			task.settId(key);
			} catch (SQLException e) {
			e.printStackTrace();
		}
		return task;
	}//closure

    @Override

    public Task getTaskById(int id) {

        

        String sql = "SELECT * FROM Task WHERE tId = ?";

        try(Connection conn = ConnUtil.createConnection()){

            

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            rs.next();

            Task t = new Task();

            t.settId(rs.getInt("tId"));

            t.setDescri(rs.getString("descri"));

            t.setPriority(rs.getString("priority"));

            t.setComplete(rs.getBoolean("complete"));

            return t;

        } catch (SQLException e) {

            e.printStackTrace();

        }

        

        return null;

    }

    @Override

    public List<Task> getAllTasks() {

    

        try(Connection conn = ConnUtil.createConnection()){

            String sql = "SELECT * FROM Task";

            List<Task> tasks = new ArrayList<Task>();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs =  ps.executeQuery();
            while(rs.next()) {

                Task t = new Task();
                t.settId(rs.getInt("tId"));

                t.setDescri(rs.getString("descri"));

                t.setPriority(rs.getString("priority"));

                t.setComplete(rs.getBoolean("complete"));

                tasks.add(t);

            }

            return tasks;
        } catch (SQLException e) {

            e.printStackTrace();

        }
        return null;
    }//closure

    @Override

    public List<Task> getAllCompleteTasks() {

        try(Connection conn = ConnUtil.createConnection()){

            String sql = "SELECT * FROM Task WHERE complete = 1";

            List<Task> tasks = new ArrayList<Task>();

            

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs =  ps.executeQuery();

            

            while(rs.next()) {

                Task t = new Task();

                t.settId(rs.getInt("tId"));

                t.setDescri(rs.getString("descri"));

                t.setPriority(rs.getString("priority"));

                t.setComplete(rs.getBoolean("complete"));

                tasks.add(t);
            }

            return tasks;

            

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return null;

    }

    @Override

    public List<Task> getAllPendingTasks() {

        

        try(Connection conn = ConnUtil.createConnection()){

            String sql = "SELECT * FROM Task WHERE complete = 0";

            List<Task> tasks = new ArrayList<Task>();

            

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs =  ps.executeQuery();

            

            while(rs.next()) {

                Task t = new Task();

                t.settId(rs.getInt("tId"));

                t.setDescri(rs.getString("descri"));

                t.setPriority(rs.getString("priority"));

                t.setComplete(rs.getBoolean("complete"));

                tasks.add(t);

            }

            return tasks;

            

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return null;

    }//closure

    @Override

    public Task updateTask(Task task) {
        try(Connection conn = ConnUtil.createConnection()){
            String sql = "UPDATE Task SET descri = ?, priority = ?, complete = ? where  tId = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(4, task.gettId());
            ps.setString(1, task.getDescri());
            ps.setString(2, task.getPriority());
            ps.setBoolean(3, task.isComplete());
            ps.execute();
            return task;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }//closure

  
	@Override
	public boolean deleteTask(Task task) {
		boolean result = true;
		if(task.isComplete()) result = false;
		return result;
	}

}
