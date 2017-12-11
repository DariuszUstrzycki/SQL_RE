package a_Zadania.a_Dzien_2.c_Relacje_1_1;


public class Main4 {
    public String query1 = "SELECT * FROM Tickets JOIN Payments ON Tickets.id = Payments.tickets_id WHERE type = 'cash';";
    public String query2 = "SELECT * FROM Tickets JOIN Payments ON Tickets.id = Payments.tickets_id WHERE type = 'transfer';";
    public String query3 = "SELECT * FROM Tickets JOIN Payments ON Tickets.id = Payments.tickets_id WHERE type = 'transfer';";
    public String query4 = "SELECT * FROM Tickets LEFT JOIN Payments ON Tickets.id = Payments.tickets_id WHERE type IS NULL;";

}
