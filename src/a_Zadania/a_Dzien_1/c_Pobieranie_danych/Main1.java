package a_Zadania.a_Dzien_1.c_Pobieranie_danych;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main1 {
	// Zapisz w poniższej zmiennej kod zapytania SQL pobierającego odpowiednie dane
	private static String query = "SELECT * FROM product";

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			stmt = conn.createStatement();
			stmt.executeQuery(query);

			rs = stmt.getResultSet();
			int id = -1;
			String name = "";
			String description = "";
			double price = -1.0;
			while (rs.next()) {
				id = rs.getInt("id");
				name = rs.getString("name");
				description = rs.getString("description");
				if(description.length() > 20) {
					description = description.substring(0, 20) + "...";
				}
				price = rs.getDouble("price");
				System.out.printf("%3d %-15s %-24s %10.2f\n", id, name, description, price);
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stmt != null)
					stmt.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private static Connection getConnection() throws SQLException {
		String dbName = "productDb";
		System.out.println("Connecting to database " + dbName);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName + "?useSSL=false", "root",
				"coderslab");
		System.out.println("Connected to database " + dbName);
		return conn;
	}

}
