package a_Zadania.a_Dzien_2.e_Relacje_wiele_wiele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main2 {

	public static void main(String[] args) {

		final String showAllOrders = "SELECT product.name, product.id, order_data.description, order_data.id  "
				+ "FROM product_order  "
				+ "RIGHT JOIN product "
				+ "ON product_order.product_id = product.id "
				+ "LEFT JOIN order_data "
				+ "ON product_order.order_data_id = order_data.id "
				+ "ORDER BY product.name;";

		try (Connection conn = getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(showAllOrders)) {

			System.out.printf("%-10s\t|%2s|%-30s\t|%-2s\n", "Product name", "Product id", "     Order description", "Order id");

			int previousId = -1;
			while (rs.next()) {
				
				String prodName = rs.getString("product.name");
				int prodID = rs.getInt("product.id");

				// print order info
				if (previousId != prodID) {
					previousId = prodID;
					System.out.printf("---------------------------------------------------------------------------\n");
					System.out.printf("%-10s\t|%-10s|\n", prodName, prodID);
					System.out.printf("---------------------------------------------------------------------------\n");
				}
				String orderDesc = rs.getString("order_data.description");
				int orderID = rs.getInt("order_data.id");
				if(orderID == 0) {
					System.out.printf("%-10s\t|%10s|%-30s\t|%-2s\n", "", "", "", "");
				} else {
					System.out.printf("%-10s\t|%10s|%-30s\t|%-2d\n", "", "", orderDesc, orderID);

				}
				

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
