package a_Zadania.a_Dzien_1.b_Dodawanie_danych;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Main4 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the id of the cinema:");
		while (!sc.hasNextInt()) {
			sc.next(); // clear scanner
			System.out.print("Enter an integer:");
		}
		int id = sc.nextInt();
		sc.nextLine();  // Consume newline left-over after nextInt();
		
		System.out.println("Enter the name of the cinema:");
		String name = sc.nextLine();
		
		System.out.println("Enter the address of the cinema:");
		String address = sc.nextLine();

		addCinema(id, name, address);
		sc.close();

	}

	static void addCinema(int id, String name, String address) {

		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = getConnection();
			String sql = "INSERT INTO cinema(id, name, address) VALUES(?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, address);
			ps.executeUpdate();
			System.out.println("The cinema has been added.");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
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
