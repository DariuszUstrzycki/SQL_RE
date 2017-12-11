package a_Zadania.a_Dzien_2.a_Zmiana_usuwanie_danych;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main2 {
	
	public static void main(String[] args) {

		try (Connection conn = getConnection(); Statement stmt = conn.createStatement();) {

			showAllTickets(stmt);
			
			Scanner sc = new Scanner(System.in);
			int id = readIntFromConsole(sc, "\nEnter the id of the row to update:");
			int ticketsSold = readIntFromConsole(sc, "\nEnter the number of sold tickets:");
			sc.close();

			String updateQuery = "UPDATE ticket SET quantity = ? WHERE id = ?;";
			PreparedStatement ps = conn.prepareStatement(updateQuery);
			ps.setInt(1, ticketsSold);
			ps.setInt(2, id);
			int rowCount = ps.executeUpdate();

			if (rowCount == 0) {
				System.out.println("The row has not been updated");
			} else {
				System.out.println("The row has been updated");
			}
			
			showAllTickets(stmt);
			
			ps.close();
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	
	private static int readIntFromConsole(Scanner sc, String message) {
		System.out.println(message);

		while (!sc.hasNextInt()) {
			System.out.println("Please try again!");
			sc.next();
		}
		return sc.nextInt();
	}

	private static void showAllTickets(Statement stmt) throws SQLException {
		String ticketssQuery = "SELECT * FROM ticket";
		stmt.executeQuery(ticketssQuery);
		ResultSet rs = stmt.getResultSet();

		while (rs.next()) {
			int id = rs.getInt("id");
			String quantity = rs.getString("quantity");
			float price = rs.getFloat("price");
			System.out.printf("%-4d %s %6.2f\n", id, quantity, price);
		}

		rs.close();
	}

	private static Connection getConnection() throws SQLException {
		String dbName = "cinemaDb";
		System.out.println("Connecting to database " + dbName);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName + "?useSSL=false", "root",
				"coderslab");
		System.out.println("Connected to database " + dbName + "\n");
		return conn;
	}

}
