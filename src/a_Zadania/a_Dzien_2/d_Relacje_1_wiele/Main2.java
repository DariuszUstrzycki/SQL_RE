package a_Zadania.a_Dzien_2.d_Relacje_1_wiele;


public class Main2 {
//zapisz poniżej zapytania tworzące odpowiednie tabele
    public String queryAddCategories =  "CREATE TABLE category (id INT AUTO_INCREMENT,  name VARCHAR(255), PRIMARY KEY (id) );";

    public String queryAddCategoriesSub =  "CREATE TABLE subcategory( id INT AUTO_INCREMENT, main_id INT, name VARCHAR(255), PRIMARY KEY(id), FOREIGN KEY(main_id) REFERENCES category(id) );";

    public String queryRelationTable =  "";
}
