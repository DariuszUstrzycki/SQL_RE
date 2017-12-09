package a_Zadania.a_Dzien_1.c_Pobieranie_danych;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main3 {
	/*Wybiorą wszystkie filmy na literę R.
	Wybiorą wszystkie bilety, których cena jest większa niż 15.30.
	Wybiorą wszystkie bilety, których ilość (liczba) jest większa niż 3.
	Wybiorą wszystkie filmy, które mają rating większy niż 6.5.*/
	
    private static String query1 = "SELECT * FROM movie WHERE name LIKE 'R%';";
    private static String query2 = "SELECT * FROM ticket WHERE price > 6.30;";
    private static String query3 = "SELECT * FROM ticket WHERE quantity > 3;";
    private static String query4 = "SELECT * FROM movie WHERE rating > 6.5;";
    
    public static void main(String[] args) {

		try (Connection conn = getConnection(); Statement stmt = conn.createStatement()){
			
			System.out.println("----------name LIKE 'R%'----------");
			stmt.executeQuery(query1);
			ResultSet rs = stmt.getResultSet();
			String name = "";
			double rating = -1;
			
			while(rs.next()) {
				name = rs.getString("name");
				rating = rs.getDouble("rating");
				System.out.printf("%-22s %10.1f\n", name, rating);
			}
			rs.close();
			
			//---------------------------------------------------
			System.out.println("---------rating > 6.5-----------");
			stmt.executeQuery(query4);
			rs = stmt.getResultSet();
			while(rs.next()) {
				name = rs.getString("name");
				rating = rs.getDouble("rating");
				System.out.printf("%-22s %10.1f\n", name, rating);
			}
			rs.close();
			//---------------------------------------------------
			System.out.println("---------price > 6.30-----------");
			stmt.executeQuery(query2);
			rs = stmt.getResultSet();
			int quantity = -1;
			double price = -1;
			while(rs.next()) {
				quantity = rs.getInt("quantity");
				price = rs.getDouble("price");
				System.out.printf("%-5d %6.2f\n", quantity, price);
			}
			rs.close();
			//---------------------------------------------------
			System.out.println("---------quantity > 3-----------");
			stmt.executeQuery(query3);
			rs = stmt.getResultSet();
			
			while(rs.next()) {
				quantity = rs.getInt("quantity");
				price = rs.getDouble("price");
				System.out.printf("%-5d %6.2f\n", quantity, price);
			}
			rs.close();
			
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
