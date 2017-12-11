package a_Zadania.a_Dzien_2.c_Relacje_1_1;


public class Main1 {
    //zapisz poniżej zapytania dodający tabelę do bazy pamiętaj o relacji
    public String tableAddQuery = "CREATE TABLE clientAddress( client_id INT, city VARCHAR(255), street VARCHAR(255), house_nr VARCHAR(255), "
    		+ " PRIMARY KEY(client_id), "
    		+ " FOREIGN KEY(client_id) REFERENCES client(id));";

    //zapisz poniżej kod dodania do bazy rekordów
    public String tableAddRow1 = "INSERT INTO clientAddress(client_id, city, street, house_nr) VALUES(6, 'New York', 'Tottenham Road', 234);";
    public String tableAddRow2 = "INSERT INTO clientAddress(client_id, city, street, house_nr) VALUES(4, 'Cracow', 'Mariacka', 15);";
    public String tableAddRow3 = "INSERT INTO clientAddress(client_id, city, street, house_nr) VALUES(7, 'Denver', 'Ashton Lane', 100);";
    public String tableAddRow4 = "INSERT INTO clientAddress(client_id, city, street, house_nr) VALUES(8, 'Chicago', 'Duke St', 45);";
    public String tableAddRow5 = "INSERT INTO clientAddress(client_id, city, street, house_nr) VALUES(10, 'Denver', 'Penny Lane', 20);";
}
