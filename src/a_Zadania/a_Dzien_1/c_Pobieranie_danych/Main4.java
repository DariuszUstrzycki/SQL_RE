package a_Zadania.a_Dzien_1.c_Pobieranie_danych;


public class Main4 {
    //zapisz poniżej zapytania do bazy
	/*
	 * 
	Zliczy liczbę wszystkich biletów.
	 
	Zliczy liczbę wszystkich płatności, grupując ich po kolumnie type.
	
	Obliczy średną cenę biletu.
	
	Pobierze 3 płatności zaczynąć od drugiej.
	
	Pobierze listę wszystkich płatności grupując je po typie, których ilość będzie większa niż 2.
	
	Zliczy liczbę wszystkich biletów, których ilosć jest większa niż 1.*/
	
    public String query1 = "SELECT SUM(quantity)  FROM ticket;";
    public String query2 = "SELECT type, COUNT(*) FROM payment GROUP BY type;";
    public String query3 = "SELECT AVG(price) FROM ticket;";
    	public String query4 = "SELECT * FROM payments WHERE id > 1 LIMIT 3";// nie do konca...
    	public String query5 = "SELECT * FROM payments WHERE quantity > 2 GROUP BY type"; // payment table nie ma type...
    public String query6 = "SELECT SUM(quantity) FROM ticket WHERE quantity > 1;";
}
