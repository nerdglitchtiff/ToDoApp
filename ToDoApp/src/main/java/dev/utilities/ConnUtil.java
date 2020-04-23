package dev.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnUtil {
	public static Connection createConnection() {
		try {
			Properties props = new Properties();
			Class.forName("org.mariadb.jdbc.Driver");
			FileInputStream in = new FileInputStream(ConnUtil.class.getClassLoader().getResource("conn.properties").getFile());
			props.load(in);
			String details = props.getProperty("connexion");
			Connection conn = DriverManager.getConnection(details);
			return conn;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;

		}

	}//createConn closure

}//class closure
