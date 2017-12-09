package a_Zadania.a_Dzien_1.a_Tworzenie_baz_i_tabel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main2 {
//Zapisz w poniższej zmiennej kod zapytania SQL tworzącego pierwszą tabelę
	public static String queryCreateTable1 = "CREATE TABLE product("
			+ " id INT AUTO_INCREMENT,"
			+ " name VARCHAR(50),"
			+ " description VARCHAR(255),"
			+ " price DECIMAL(10,2),"
			+ " PRIMARY KEY(id) );";
			

//Zapisz w poniższej zmiennej kod zapytania SQL tworzącego drugą tabelę
	public static String queryCreateTable2 = "CREATE TABLE order_data("
			+ " id INT AUTO_INCREMENT,"
			+ " description VARCHAR(255),"
			+ " PRIMARY KEY(id) );";

//Zapisz w poniższej zmiennej kod zapytania SQL tworzącego trzecią tabelę
	public static String queryCreateTable3 = "CREATE TABLE client("
			+ " id INT AUTO_INCREMENT,"
			+ " name VARCHAR(50),"
			+ " surname VARCHAR(50),"
			+ " PRIMARY KEY(id) );";
	
	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			
			stmt.executeUpdate(queryCreateTable1);
			stmt.executeUpdate(queryCreateTable2);
			stmt.executeUpdate(queryCreateTable3);
			
			System.out.println("The tables have been created!");
			
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
		String dbName = "productDb";
		System.out.println("Connecting to database");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName + "?useSSL=false", "root", "coderslab");
	}
}
