package a_Zadania.a_Dzien_2.e_Relacje_wiele_wiele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main5 {
    //poniżej zapisz zapytanie tworzące tabele i łączące je.
	 public static void main(String[] args) {
	    	
	    	String query1 = "SELECT Movies.id, Movies.name, Cinemas.name,  Screenings.time, Cinemas.id  "
	    			+ "FROM Screenings "
	    			+ "JOIN Movies "
	    			+ "ON Movies.id = Screenings.movies_id "
	    			+ "JOIN Cinemas ON Screenings.cinemas_id = Cinemas.id "
	    			+ "WHERE Cinemas.id = ?" + 
	    			"";
	    	ResultSet rs = null;

			try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(query1);) {

				int theaterID = 8;
				ps.setInt(1, theaterID);
				rs = ps.executeQuery();

				System.out.printf("%-2s|%-30s|%-45s\t|%-25s\n", "id", "cinema", "title" , "time");

				
				int previousId = -1;
				while (rs.next()) {
					
					int cinemaID = rs.getInt("Cinemas.id");
					String cinema = rs.getString("Cinemas.name");
					
					// print order info
					if (previousId != cinemaID) {
						previousId = cinemaID;
						System.out.printf("-------------------------------------------------------------------------------------------\n");
						System.out.printf("%-2d|%-30s|\n",cinemaID, cinema );
						System.out.printf("-------------------------------------------------------------------------------------------\n");
					}
					
					int movieID = rs.getInt("Movies.id");
					String title = rs.getString("Movies.name");
					String date = rs.getDate("Screenings.time").toString();
					String time = rs.getTime("Screenings.time").toString();
					System.out.printf("%-2s|%-27s|%2d|%-45s\t|%-25s\n", "", "", movieID, title, (time + " " + date));
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
