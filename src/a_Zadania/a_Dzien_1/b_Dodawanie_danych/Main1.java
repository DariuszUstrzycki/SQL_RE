package a_Zadania.a_Dzien_1.b_Dodawanie_danych;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main1 {

    //zapisz poniżej zapytania dodające rekordy do pierwszej tabeli
    private static String table1row1 = "INSERT INTO product (id, name, description, price)    VALUES(default,'book', 'about various cars', 32.50);";
    private static String table1row2 = "INSERT INTO product  (id, name, description, price)   VALUES(default,'pen', 'Italian', 9.50);";
    private static String table1row3 = "INSERT INTO product  (id, name, description, price)   VALUES(default,'notebook', 'white', 3.20);";
    private static String table1row4 = "INSERT INTO product  (id, name, description, price)   VALUES(default,'marker', 'green', 5.40);";
    private static String table1row5 = "INSERT INTO product  (id, name, description, price)   VALUES(default,'whiteboard', 'modern', 158.00);";
    private static String[] productArr = {table1row1, table1row2, table1row3, table1row4, table1row5};
//zapisz poniżej zapytania dodające rekordy do drugiej tabeli
    private static String table2row1 = "INSERT INTO client(id, name, surname) VALUES(default, 'John', 'Brown');";
    private static String table2row2 = "INSERT INTO client(id, name, surname) VALUES(default, 'Mike', 'Brown');";
    private static String table2row3 = "INSERT INTO client(id, name, surname) VALUES(default, 'Lucy', 'Smith');";
    private static String table2row4 = "INSERT INTO client(id, name, surname) VALUES(default, 'Terry', 'White');";
    private static String table2row5 = "INSERT INTO client(id, name, surname) VALUES(default, 'Tony', 'Clark');";
    private static String[] clientArr = {table2row1, table2row2, table2row3, table2row4, table2row5};

//zapisz poniżej zapytania dodające rekordy do trzeciej tabeli
    private static String table3row1 = "INSERT INTO order_data(id, description) VALUES(default,'UPC');";
    private static String table3row2 = "INSERT INTO order_data(id, description) VALUES(default,'UPC');";
    private static String table3row3 = "INSERT INTO order_data(id, description) VALUES(default,'Pocztex');";
    private static String table3row4 = "INSERT INTO order_data(id, description) VALUES(default,'Inpost');";
    private static String table3row5 = "INSERT INTO order_data(id, description) VALUES(default,'Inpost');";
    private static String[] orderArr = {table3row1, table3row2, table3row3, table3row4, table3row5};

public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			System.out.println("Connected to database");
			
			insertData(productArr, stmt);
			insertData(clientArr, stmt);
			insertData(orderArr, stmt);
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
		String dbName = "productDb";
		System.out.println("Connecting to database");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName + "?useSSL=false", "root", "coderslab");
	}
}
