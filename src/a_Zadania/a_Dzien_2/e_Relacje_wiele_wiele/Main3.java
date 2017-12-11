package a_Zadania.a_Dzien_2.e_Relacje_wiele_wiele;


public class Main3 {
    //poniżej zapisz zapytanie tworzące tabele i łączące je.
    public String query1 = "CREATE TABLE Screenings( "
    		+ " id INT AUTO_INCREMENT, "
    		+ " time DATETIME, "
    		+ " cinemas_id INT, "
    		+ " movies_id INT, "
    		+ " PRIMARY KEY(id), "
    		+ " FOREIGN KEY(cinemas_id) REFERENCES Cinemas(id), "
    		+ " FOREIGN KEY(movies_id) REFERENCES Movies(id) );";
}
