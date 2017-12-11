package a_Zadania.a_Dzien_2.c_Relacje_1_1;


public class Main3 {
    //zapisz poniżej zapytanie tworzące tabelę - pamiętaj o relacji i dodaniu odpowiedniej kolumny
    public String queryCreateTable = "CREATE TABLE Payments(tickets_id INT,  type VARCHAR(255), date DATE,  tickets_id INT, PRIMARY KEY(tickets_id), "
    		+ " FOREIGN KEY(tickets_id) REFERENCES Tickets(id) );";
}
