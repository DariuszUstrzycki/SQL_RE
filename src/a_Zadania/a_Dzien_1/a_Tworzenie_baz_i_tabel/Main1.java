package a_Zadania.a_Dzien_1.a_Tworzenie_baz_i_tabel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main1 {
	public static String query = "CREATE DATABASE ";
	public static String db = "productDb";

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		try {
			conn = getConnection();
			System.out.println("Connected to database");
			
			stmt = conn.createStatement();
			stmt.executeUpdate(query + db);
			System.out.println("Database created successfully...");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	private static Connection getConnection() throws SQLException {

		System.out.println("Connecting to database");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "?useSSL=false", "root", "coderslab");
	}

}
