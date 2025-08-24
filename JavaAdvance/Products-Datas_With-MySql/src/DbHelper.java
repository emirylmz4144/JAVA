import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DbHelper
{
    //MySql Bağlantı bilgileri
   private String name="root";
   private String pass="emirEmir41";

    private String dbUrl="jdbc:mysql://localhost:3306/products";

    Connection connection=null;
    Statement statement=null;//Ürünleri listelemek için bu komut kullanılacak
    ResultSet resultSet=null;//Ürünlerin tablolaştırılması için
    PreparedStatement preparedStatement=null; //Diğer Ürün işlemleri (ekleme,silme,güncelleme)

    static Scanner input=new Scanner(System.in);

    public  Connection dbConnect() throws SQLException
    {
        // Mysql'e bağlanma işlemi
        return DriverManager.getConnection(dbUrl,name,pass);
    }

    //Hataları daha efektif gösterme
    public void showErrorMessage(SQLException exception)
    {

        System.out.println("Hata alındı: "+exception.getMessage());
        System.out.println("Hata kodu: "+exception.getErrorCode());
    }

    public void listProducts() throws SQLException
    {

        connection=dbConnect();//Db ile bağlantı
        statement=connection.createStatement();//Verilecek komut bağlantıya entegre ediliri
        resultSet=statement.executeQuery("select * from infosproduct");//Veri sonucu komut'dan dönen sonucu alır
        ArrayList<Product> ourProducts=new ArrayList<Product>();
        while (resultSet.next())
        {
            ourProducts.add(new Product(resultSet.getString("Name"),Integer.parseInt(resultSet.getString("Price")),Integer.parseInt(resultSet.getString("StockAmount"))));
        }
        for (Product product:ourProducts)
        {
            System.out.println(product.getName()+" "+product.getPrice()+" "+product.getStockAmount());
        }
    }

    public void addProduct(Product product) throws  SQLException
    {
        connection=dbConnect();
        preparedStatement=connection.prepareStatement("insert into infosproduct (Name,Price,StockAmount) values(?,?,?)");
        preparedStatement.setString(1,product.getName());
        preparedStatement.setString(2,Integer.toString(product.getPrice()));
        preparedStatement.setString(3,Integer.toString(product.getStockAmount()));
       int result= preparedStatement.executeUpdate();
        if (result==1)
            System.out.println("Kayıt Başarılı");
        else
            System.out.println("Kayıt Başarısız");

    }
    public void updateProduct(int id,String dataToBeUpdate) throws SQLException
    {

        connection=dbConnect();
        preparedStatement=connection.prepareStatement("update infosproduct SET "+dataToBeUpdate+"= ? WHERE id=?");
        if (dataToBeUpdate.equals("Name"))
        {
            System.out.println("Yeni "+dataToBeUpdate+": "); String newValue=input.nextLine();

            //...setString(a,b) :a kaçıncı soru işareti b yeni değer
            preparedStatement.setString(1,newValue);
            preparedStatement.setInt(2,id);
        }
        else if (dataToBeUpdate.equals("Price")||dataToBeUpdate.equals("StockAmount"))
        {
            System.out.println("Yeni "+dataToBeUpdate+": ");int newValue=input.nextInt();
            preparedStatement.setInt(1,newValue);
            preparedStatement.setInt(2,id);
        }
        else
        {
            System.out.println("Hatalı işlem yaptınız");
            return;
        }

        int result=preparedStatement.executeUpdate();
        if (result==1)
            System.out.println("Güncelleme Başarılı");
        else
            System.out.println("Bir sorun oluştu");
    }

    public void deleteProduct(int id) throws SQLException
    {
        connection=dbConnect();
        preparedStatement=connection.prepareStatement("delete from infosproduct where id=?");
        preparedStatement.setInt(1,id);
        preparedStatement.executeUpdate();
    }
}
