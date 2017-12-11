package a_Zadania.a_Dzien_2.b_Modyfikacja_tabel;


public class Main2 {
    //zapisz poniżej zapytania do bazy
    public String query1 = "ALTER TABLE movie  ADD COLUMN watchCount INT;";
    public String query2 = "ALTER TABLE movie ADD COLUMN isTop TINYINT DEFAULT 0;";
    public String query3 = "ALTER TABLE cinema ADD COLUMN openTime TIME;";
    public String query4 = "ALTER TABLE cinema ADD COLUMN closeTime TIME;";
}
