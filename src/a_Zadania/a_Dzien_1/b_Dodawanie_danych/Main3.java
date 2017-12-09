package a_Zadania.a_Dzien_1.b_Dodawanie_danych;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main3 {

    //zapisz poniżej zapytania dodające rekordy do pierwszej tabeli
    private static String table1row1 = "INSERT INTO movie(id, name, description, rating) VALUES(default, 'Silence of the Lamb', 'horror', 10);";
    private static String table1row2 = "INSERT INTO movie(id, name, description, rating) VALUES(default, 'Rainman', 'drama', 7);";
    private static String table1row3 = "INSERT INTO movie(id, name, description, rating) VALUES(default, 'Bond', 'thriller', 5);";
    private static String table1row4 = "INSERT INTO movie(id, name, description, rating) VALUES(default, 'the Cube', 'thriller', 10);";
    private static String table1row5 = "INSERT INTO movie(id, name, description, rating) VALUES(default, 'Mrs Robinson', 'comedy', 7);";
    private static String[] movieArr = {table1row1, table1row2, table1row3, table1row4, table1row5};

//zapisz poniżej zapytania dodające rekordy do drugiej tabeli
    private static String table2row1 = "INSERT INTO cinema(id, name, address) VALUES (default, 'Rialto', 'Wadowicka 5');";
    private static String table2row2 = "INSERT INTO cinema(id, name, address) VALUES (default, 'Multikino', 'Mickieowcza 59');";
    private static String table2row3 = "INSERT INTO cinema(id, name, address) VALUES (default, 'Kijow', 'al. Mokotowskie 5/9');";
    private static String table2row4 = "INSERT INTO cinema(id, name, address) VALUES (default, 'Tecza', 'Zakopianska 2');";
    private static String table2row5 = "INSERT INTO cinema(id, name, address) VALUES (default, 'Pod Baranami', 'Ludmilow 45');";
    private static String[] cinemaArr = {table2row1, table2row2, table2row3, table2row4, table2row5};

//zapisz poniżej zapytania dodające rekordy do trzeciej tabeli
    private static String table3row1 = "INSERT INTO payment (type , date) VALUES ('cash', '2017-11-15');";
    private static String table3row2 = "INSERT INTO payment (type , date) VALUES ('credit card', '2017-11-05');";
    private static String table3row3 = "INSERT INTO payment (type , date) VALUES ('credit card', '2017-07-10');";
    private static String table3row4 = "INSERT INTO payment (type , date) VALUES ('cash', '2017-11-09');";
    private static String table3row5 = "INSERT INTO payment (type , date) VALUES ('check', '2017-03-15');";
    private static String[] paymentArr = {table3row1, table3row2, table3row3, table3row4, table3row5};

//zapisz poniżej zapytania dodające rekordy do czwartej tabeli
    private static String table4row1 = "INSERT INTO ticket (quantity , price) VALUES (2, 4.5);";
    private static String table4row2 = "INSERT INTO ticket (quantity , price) VALUES (4, 6.5);";
    private static String table4row3 = "INSERT INTO ticket (quantity , price) VALUES (1, 7.0);";
    private static String table4row4 = "INSERT INTO ticket (quantity , price) VALUES (5, 8.0);";
    private static String table4row5 = "INSERT INTO ticket (quantity , price) VALUES (9, 5.7);";
    private static String[] ticketArr = {table4row1, table4row2, table4row3, table4row4, table4row5};

public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			
			insertData(movieArr, stmt);
			insertData(cinemaArr, stmt);
			insertData(paymentArr, stmt);
			insertData(ticketArr, stmt);
			System.out.println("The tables have been filled with data!");
			
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

private static void insertData(String[] queries, Statement stmt) throws SQLException {
	for(String query : queries) {
		stmt.executeUpdate(query);
	}
}
	
	private static Connection getConnection() throws SQLException {
		String dbName = "cinemaDb";
		System.out.println("Connecting to database" + dbName);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName + "?useSSL=false", "root", "coderslab");
		System.out.println("Connected to database" + dbName);
		return conn;
	}
}
