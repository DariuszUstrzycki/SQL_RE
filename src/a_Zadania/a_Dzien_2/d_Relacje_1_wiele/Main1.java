package a_Zadania.a_Dzien_2.d_Relacje_1_wiele;


public class Main1 {
    //poniżej zapisz zapytania dodające rekordy dREATE To tabeli
    public String queryProduct1Opinion1 = "CREATE TABLE opinion(id INT AUTO_INCREMENT, description VARCHAR(255),  product_id INT,  PRIMARY KEY (id), FOREIGN KEY(product_id) REFERENCES product(id) );";
    public String queryProduct1Opinion2 = "INSERT INTO opinion VALUES (default, 'boring',7 );";
    public String queryProduct1Opinion3 = "INSERT INTO opinion VALUES (default, 'long',7 );";
    public String queryProduct1Opinion4 = "";
    public String queryProduct1Opinion5 = "";

    public String queryProduct2Opinion1 = "INSERT INTO opinion VALUES (default, 'hard to clean',11 );";
    public String queryProduct2Opinion2 = "INSERT INTO opinion VALUES (default, 'useful',11 );";
    public String queryProduct2Opinion3 = "";
    public String queryProduct2Opinion4 = "";
    public String queryProduct2Opinion5 = "";

    public String queryProduct3Opinion1 = "INSERT INTO opinion VALUES (default, 'very expensive',14 );";
    public String queryProduct3Opinion2 = "";
    public String queryProduct31Opinion3 = "";
    public String queryProduct3Opinion4 = "";
    public String queryProduct3Opinion5 = "";
}
