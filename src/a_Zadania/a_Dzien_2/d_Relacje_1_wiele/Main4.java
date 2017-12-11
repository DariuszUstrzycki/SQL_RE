package a_Zadania.a_Dzien_2.d_Relacje_1_wiele;


public class Main4 {
    public String query1 = "SELECT * FROM category JOIN subcategory ON category.id = subcategory.main_id WHERE category.id = 1;";
    public String query2 = "SELECT DISTINCT category.id, category.name FROM category JOIN subcategory ON category.id = subcategory.main_id ;";

}
