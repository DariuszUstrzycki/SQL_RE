package a_Zadania.a_Dzien_2.a_Zmiana_usuwanie_danych;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {

		try (Connection conn = getConnection(); Statement stmt = conn.createStatement();) {

			showAllMovies(stmt);

			int id = readIDFromConsole();

			String deleteQuery = "DELETE FROM movie WHERE id = ?;";
			PreparedStatement ps = conn.prepareStatement(deleteQuery);
			ps.setInt(1, id);
			int rowCount = ps.executeUpdate();

			if (rowCount == 0) {
				System.out.println("The movie has not been deleted");
			} else {
				System.out.println("The movie has been deleted");
			}
			
			showAllMovies(stmt);
			
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static int readIDFromConsole() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\nEnter the id of the movie to delete:");

		while (!sc.hasNextInt()) {
			System.out.println("Please try again!");
			sc.next();
		}

		int id = sc.nextInt();
		sc.close();
		return id;
	}

	private static void showAllMovies(Statement stmt) throws SQLException {
		String moviesQuery = "SELECT id, name FROM movie";
		stmt.executeQuery(moviesQuery);
		ResultSet rs = stmt.getResultSet();

		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			System.out.printf("%-4d %s\n", id, name);
		}

		rs.close();
		//stmt.close();
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
