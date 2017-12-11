package a_Zadania.a_Dzien_2.a_Zmiana_usuwanie_danych;


public class Main4 {
    //zapisz poniżej zapytania do bazy
    public String query1 = "UPDATE cinema SET address='Stadion Narodowy' WHERE name LIKE '%e';";
    public String query2 = "DELETE FROM payment WHERE date <  DATE_SUB(NOW(), INTERVAL 4 DAY_SECOND);";
    public String query3 = "UPDATE movie SET rating=5.4 WHERE CHAR_LENGTH(description) > 40;";
    public String query4 = "UPDATE ticket SET price=0.5 * price WHERE quantity > 9;";

}
