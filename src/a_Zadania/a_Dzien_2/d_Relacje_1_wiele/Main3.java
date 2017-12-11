package a_Zadania.a_Dzien_2.d_Relacje_1_wiele;


public class Main3 {
    public String query1 = "SELECT * FROM product JOIN opinion ON opinion.product_id = product.id;";
    public String query2 = "SELECT product.name, opinion.description FROM product LEFT JOIN opinion ON product.id = opinion.product_id;";
    public String query3 = "SELECT name, product.description, price, opinion.description FROM product JOIN opinion ON product.id = opinion.product_id WHERE product.id = 7;";

}
