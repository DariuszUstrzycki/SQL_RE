package a_Zadania.a_Dzien_2.b_Modyfikacja_tabel;


public class Main1 {
    //zapisz poniżej zapytania do bazy
    public String query1 = "ALTER TABLE ticket ADD COLUMN priceUSD DECIMAL(6,2);";
    public String query2 = "ALTER TABLE movie ADD COLUMN director CHAR(80);";
    public String query3 = "ALTER TABLE movie MODIFY COLUMN director VARCHAR(50);";
    public String query4 = "ALTER TABLE ticket DROP COLUMN priceUSD;";
}
