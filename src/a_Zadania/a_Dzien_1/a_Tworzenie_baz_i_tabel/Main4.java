package a_Zadania.a_Dzien_1.a_Tworzenie_baz_i_tabel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main4 {
//Zapisz w poniższej zmiennej kod zapytania SQL tworzącego pierwszą tabelę
	static String queryCreateTable1 = "CREATE TABLE cinema("
			+ " id INT AUTO_INCREMENT,"
			+ " name VARCHAR(50),"
			+ " address VARCHAR(255)," // text - w wersji CodersLab
			+ " PRIMARY KEY(id) );";

//Zapisz w poniższej zmiennej kod zapytania SQL tworzącego drugą tabelę
	static String queryCreateTable2 = "CREATE TABLE movie("
			+ " id INT AUTO_INCREMENT,"
			+ " name VARCHAR(50),"
			+ " description VARCHAR(255),"  // text - w wersji CodersLab
			+ " rating DECIMAL(2,0)," // 4,2 w wersji CL
			+ " PRIMARY KEY(id) );";

//Zapisz w poniższej zmiennej kod zapytania SQL tworzącego trzecią tabelę
	static String queryCreateTable3 = "CREATE TABLE ticket("
			+ " id INT AUTO_INCREMENT,"
			+ " quantity INT,"
			+ " price DECIMAL(6,2)," // 5,2 CL
			+ " PRIMARY KEY(id) );";

//Zapisz w poniższej zmiennej kod zapytania SQL tworzącego czwartą tabelę
	static String queryCreateTable4 = "CREATE TABLE payment("
			+ " id INT AUTO_INCREMENT,"
			+ " type VARCHAR(55),"
			+ " date DATE,"
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
			stmt.executeUpdate(queryCreateTable4);
			
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
		String dbName = "cinemaDb";
		System.out.println("Connecting to database");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName + "?useSSL=false", "root", "coderslab");
	}
}
