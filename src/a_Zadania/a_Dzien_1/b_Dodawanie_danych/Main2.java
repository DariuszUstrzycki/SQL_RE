package a_Zadania.a_Dzien_1.b_Dodawanie_danych;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by dell on 08.02.17.
 */
public class Main2 {

    private static String query1 = "INSERT INTO Products SET id=0, name=produkt1, description=name, price=904";
    private static String query1fixed = "INSERT INTO product VALUES(default, 'paper', name, 904)";

    private static String query2 = "INSERT INTO Clients VALUES(\"Jan\", \"Kowalski\", 4, \"Mr.\")";
    private static String query2fixed = "INSERT INTO client VALUES(4, 'Jan', 'Kowalski')";

    private static String query3 = "INSERT INTO Movies(id, rating, name) VALUES(null, \"bardzo dobry\", \"Szybcy i wściekli\")";
    private static String query3fixed = "INSERT INTO movie(id, rating, name) VALUES(default, 5, 'Szybcy i wściekli')";

    private static String query4 = "INSERT INTO Payments SET id=90 AND VALUES(\"cash\", NOW())";
    private static String query4fixed = "INSERT INTO payment VALUES( default, 'cash', NOW())";
    
    public static void main(String[] args) {
    
    Connection conn = null;
	Statement stmt = null;
	
	try {
		
		String dbName = "productDb";
		System.out.println("Connecting to database" + dbName);
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName + "?useSSL=false", "root", "coderslab");
		System.out.println("Connected to database" + dbName);
		stmt = conn.createStatement();
		stmt.executeUpdate(query1fixed);
		stmt.executeUpdate(query2fixed);
		System.out.println("The tables have been filled with data!");
		if (conn != null)
			conn.close();
		if (stmt != null)
			stmt.close();
		
		dbName = "cinemaDb";
		System.out.println("Connecting to database" + dbName);
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName + "?useSSL=false", "root", "coderslab");
		System.out.println("Connected to database" + dbName);
		stmt = conn.createStatement();
		stmt.executeUpdate(query3fixed);
		stmt.executeUpdate(query4fixed);
		System.out.println("The tables have been filled with data!");
		if (conn != null)
			conn.close();
		if (stmt != null)
			stmt.close();
		
	} catch (SQLException e) {
		e.printStackTrace();
	} 
}



private static Connection getConnection() throws SQLException {
	String dbName = "productDb";
	System.out.println("Connecting to database");
	return DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName + "?useSSL=false", "root", "coderslab");
}
}
