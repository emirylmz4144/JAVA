import java.sql.*;

public class Main {
    public static void main(String[] args)
    {
        //Veri çekme
        String read="SELECT * FROM infosproduct";
        //Veri ekleme
        String create="INSERT INTO infosproduct (Name,StockAmount,Price) VALUES(?,?,?)";
        //Veri güncelleme
        String update="UPDATE infosproduct SET Name=? WHERE Id=?";
        //Veri silme
        String delete="DELETE FROM infosproduct WHERE Id=?";
        try {
            //Veri tabanına bağlanma
            Connection connection= DriverManager.getConnection(DBSettings.URL,DBSettings.userName,DBSettings.password);

            //Veri tabanındaki bilgileri okuma
            Statement statementForRead=connection.createStatement();
            ResultSet datasOfDatebase=statementForRead.executeQuery(read);
            while (datasOfDatebase.next())
            {
                System.out.println("ID: "+datasOfDatebase.getObject(1).toString());
                System.out.println("AD: "+datasOfDatebase.getString("Name"));
                System.out.println("Stok Miktarı: "+datasOfDatebase.getInt("StockAmount"));
                System.out.println("Fiyat: "+datasOfDatebase.getInt("Price"));
                System.out.println("----------------------");
            }
            //Veri tabanına veri ekleme
            PreparedStatement preparedStatementForAddToConnection=connection.prepareStatement(create);
            preparedStatementForAddToConnection.setString(1,"Emir");
            preparedStatementForAddToConnection.setInt(2,0);
            preparedStatementForAddToConnection.setInt(3,10000);


            //Veri tabanından veri güncelleme
            PreparedStatement preparedStatementForUpdateToConnection=connection.prepareStatement(update);
            preparedStatementForUpdateToConnection.setString(1,"EMİR YILMAZ");
            preparedStatementForUpdateToConnection.setInt(2,15);
            preparedStatementForUpdateToConnection.executeUpdate();

            //Veri tabanından veri silme
            PreparedStatement preparedStatementForDeleteToConnection=connection.prepareStatement(delete);
            preparedStatementForDeleteToConnection.setInt(1,21);
            preparedStatementForDeleteToConnection.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            System.out.println("VERİ TABANI CRUD İŞLEMLERİ ");
        }
    }
}