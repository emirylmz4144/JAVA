import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    static Scanner input=new Scanner(System.in);
   static DbHelper dbHelper=new DbHelper();
   static ResultSet resultSet=null;
    public static void main(String[] args)
    {
           AllExceptions(()->deleteProduct());
    }


    //Metot delegasyonu sayesinde her yerde try - catch yazmadık
    public static void AllExceptions(FuncInterface ourMethod)
    {
        try {
            ourMethod.Invoke();
        }catch (SQLException sqlException)
        {
          dbHelper.showErrorMessage(sqlException);
        }
    }
    public static void listOurProduct() throws SQLException
    {
        dbHelper.listProducts();
    }
    public static void addProductToProductDB()throws SQLException
    {
        System.out.print("Ürün Adı: ");String name=input.nextLine();
        System.out.print("Ürün Fiyatı: "); int price=input.nextInt();
        System.out.print("Ürün Stok Miktarı: "); int stockAmount=input.nextInt();
        Product product=new Product(name,price,stockAmount);

        dbHelper.addProduct(product);
    }
    public static void updateProduct() throws SQLException
    {

        System.out.print("Lütfen güncelleme yapacağınız yeri seçiniz(Örnek StockAmount): ");String where=input.nextLine();
        System.out.print("Lütfen güncelleme yapacağınız ürün Id sini giriniz: "); int id=input.nextInt();
        if (where.equals("StockAmount")||where.equals("Price")||where.equals("Name"))
        {
            dbHelper.updateProduct(id,where);

        }
        else
        {
            System.out.println("Geçerli bir seçim yapmadınız");
        }
    }

    public static void deleteProduct() throws SQLException
    {
        System.out.println("Lütfen silmek istediğiniz ürünün id numarasını giriniz");int id=input.nextInt();
        dbHelper.deleteProduct(id);
    }
}