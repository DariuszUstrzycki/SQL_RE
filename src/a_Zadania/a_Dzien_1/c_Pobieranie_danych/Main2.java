package a_Zadania.a_Dzien_1.c_Pobieranie_danych;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;import com.sun.org.apache.xerces.internal.impl.dv.DatatypeValidator;

public class Main2 {
	
	public static void main(String[] args) {

		try (Connection conn = getConnection(); Statement stmt = conn.createStatement()){
			
			String averageQuery = "SELECT AVG(rating) FROM movie;";
			stmt.executeQuery(averageQuery);
			ResultSet rs = stmt.getResultSet();
			
			double average = -1;
			if(rs.next()) {
				average = rs.getDouble(1);
			}
			
			System.out.println("Average rating is " + average);
			//stmt.close(); SQLException: No operations allowed after statement closed.
			rs.close();
			
			String aboveAverage = "SELECT name, rating FROM movie WHERE rating > 7.8;";
			stmt.executeQuery(aboveAverage);
			rs = stmt.getResultSet();
			String name = "";
			double rating = -1;
			while(rs.next()) {
				name = rs.getString("name");
				rating = rs.getDouble("rating");
				System.out.printf("%-22s %.1f\n", name, rating);
			}
			System.out.println("\nA compact way of doing this:");
			rs.close();			
			
			String aboveAverage2 = "SELECT name, rating FROM movie "
					+ "WHERE rating > (SELECT AVG(rating) FROM movie);";
			stmt.executeQuery(aboveAverage2);
			rs = stmt.getResultSet();
			String name2 = "";
			double rating2 = -1;
			while(rs.next()) {
				name2 = rs.getString("name");
				rating2 = rs.getDouble("rating");
				System.out.printf("%-22s %.1f\n", name2, rating2);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static Connection getConnection() throws SQLException {
		String dbName = "cinemaDb";
		System.out.println("Connecting to database " + dbName);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName + "?useSSL=false", "root",
				"coderslab");
		System.out.println("Connected to database " + dbName);
		return conn;
	}

}
