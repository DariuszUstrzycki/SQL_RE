package a_Zadania.a_Dzien_2.a_Zmiana_usuwanie_danych;


public class Main3 {
	
	/*Usunie wiersz z tabeli o id =4.
			Usunie wiersze z tabeli o nazwie helios.
			Ustawi dla wszystkich biletów ilość na 10.
			Usunie wszystkie płatności któych data jest mniejsza niż 2017-01-01.
*/
    //zapisz poniżej zapytania do bazy
    public String query1 = "DELETE FROM ticket WHERE id = 3;";
    public String query2 = "DELETE FROM cinema WHERE name='Helios';";
    public String query3 = "UPDATE ticket SET quantity=10;";
    public String query4 = "DELETE FROM payment WHERE date < '2017-10-10';";

}
