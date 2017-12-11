package a_Zadania.a_Dzien_2.e_Relacje_wiele_wiele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main1 {
	// poniżej zapisz zapytanie tworzące tabele i łączące je.
	public String query1 = "CREATE TABLE  product_order( id INT AUTO_INCREMENT, product_id INT, order_data_id INT, "
			+ " PRIMARY KEY(id), " + " FOREIGN KEY(product_id) REFERENCES product(id), "
			+ " FOREIGN KEY(order_data_id) REFERENCES order_data(id));";
	// zapytania łączące produkty z zamówieniami
	public String query2 = "INSERT INTO product_order(id, product_id, order_data_id)  VALUES (default, 7, 9);";
	public String query3 = "INSERT INTO product_order(id, product_id, order_data_id)  VALUES (default, 2, 8);";
	public String query4 = "INSERT INTO product_order(id, product_id, order_data_id)  VALUES (default, 5, 8);";
	public String query5 = "INSERT INTO product_order(id, product_id, order_data_id)  VALUES (default, 5, 9);";

	public static void main(String[] args) {

		final String showAllOrders = "SELECT order_data.id, order_data.description, product.id, product.name "
				+ "FROM product_order " + "INNER JOIN product ON product_order.product_id = product.id "
				+ "INNER JOIN order_data ON product_order.order_data_id = order_data.id;";

		try (Connection conn = getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(showAllOrders)) {

			System.out.printf("%-2s|%-34s|%2s|%-12s|\n", "Order id", "     Description", "Product id", "Product name");

			int previousId = -1;
			while (rs.next()) {

				int orderID = rs.getInt("order_data.id");
				String desc = rs.getString("description");

				// print order info
				if (previousId != orderID) {
					previousId = orderID;
					System.out.printf("---------------------------------------------------------------------------\n");
					System.out.printf("%8d|%-34s|\n", orderID, desc);
					System.out.printf("---------------------------------------------------------------------------\n");
				}

				int productID = rs.getInt("product.id");
				String productName = rs.getString("name");
				System.out.printf("%8s|%-34s|%10d|%-12s|\n", "", "", productID, productName);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private static Connection getConnection() throws SQLException {
		String dbName = "productDb";
		System.out.println("Connecting to database " + dbName);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName + "?useSSL=false", "root",
				"coderslab");
		System.out.println("Connected to database " + dbName + "\n");
		return conn;
	}
}
