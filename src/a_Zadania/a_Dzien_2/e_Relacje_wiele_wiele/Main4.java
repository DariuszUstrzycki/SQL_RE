package a_Zadania.a_Dzien_2.e_Relacje_wiele_wiele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main4 {
    //poniżej zapisz zapytanie tworzące tabele i łączące je.
   // public static String query1 = "";
    
    public static void main(String[] args) {
    	
    	String query1 = "SELECT Movies.id, Movies.name, Cinemas.name,  Screenings.time, Cinemas.id   "
    			+ "FROM Screenings "
    			+ "JOIN Movies "
    			+ "ON Movies.id = Screenings.movies_id "
    			+ "JOIN Cinemas ON Screenings.cinemas_id = Cinemas.id "
    			+ "WHERE Movies.id = ?" + 
    			"";
    	ResultSet rs = null;

		try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(query1);) {

			int filmID = 7;
			ps.setInt(1, filmID);
			rs = ps.executeQuery();

			System.out.printf("%-2s|%-45s|%-30s\t|%-25s\n", "id", "title", "cinema", "time");
			
			int previousId = -1;
			while (rs.next()) {
				int movieID = rs.getInt("Movies.id");
				String title = rs.getString("Movies.name");

				// print order info
				if (previousId != movieID) {
					previousId = movieID;
					System.out.printf("-------------------------------------------------------------------------------------------\n");
					System.out.printf("%-2d|%-45s|\n",movieID, title );
					System.out.printf("-------------------------------------------------------------------------------------------\n");
				}
				int cinemaID = rs.getInt("Cinemas.id");
				String cinema = rs.getString("Cinemas.name");
				String time = rs.getTime("Screenings.time").toString();
				String date = rs.getDate("Screenings.time").toString();
				System.out.printf("%-2s|%-42s%2d|%-30s\t|%-25s\n", "", "", cinemaID, cinema, (time + " " + date));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
    	
	}
    
    private static Connection getConnection() throws SQLException {
		String dbName = "cinemas_ex";
		System.out.println("Connecting to database " + dbName);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName + "?useSSL=false", "root", "coderslab");
		System.out.println("Connected to database " + dbName + "\n");
		return conn;
	}
}
