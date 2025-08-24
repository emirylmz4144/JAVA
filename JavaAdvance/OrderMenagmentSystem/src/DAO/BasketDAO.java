package DAO;

import Business.CustomerController;
import Business.ProductController;
import Core.Database;
import Entity.Basket;
import Entity.Customer;
import Entity.Product;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BasketDAO {

    Connection connection;
    ProductController productController;
    CustomerController customerController;

    public BasketDAO(){
        connection= Database.getInstance();
        productController= new ProductController();
        customerController= new CustomerController();

    }

    public boolean save(Basket basket) {
        String query="INSERT INTO baskets " +
                "(" +
                "product_id ," +
                "customer_id ,"+
                "product_name ,"+
                "product_code ,"+
                "customer_name ,"+
                "customer_address ,"+
                "total_price"+
                ")" +
                " VALUES (?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps =this.connection.prepareStatement(query);
            ps.setInt(1,basket.getProduct_id());
            ps.setInt(2,basket.getCustomer_id());
            ps.setString(3,basket.getProduct_name());
            ps.setString(4,basket.getProduct_code());
            ps.setString(5,basket.getCustomer_name());
            ps.setString(6,basket.getCustomer_address());
            ps.setInt(7,basket.getTotalPrice());
            return ps.executeUpdate()!=-1;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public ArrayList<Basket> getAll() {
        ArrayList<Basket> baskets= new ArrayList<Basket>();
        try {
            ResultSet result=this.connection.createStatement().executeQuery("Select * from baskets");

            while (result.next()){
                baskets.add(this.match(result));
            }

        }catch (SQLException e){System.out.println(e.getMessage());}

        return baskets;
    }



    public Basket match(ResultSet result) throws SQLException{
        Basket basket=new Basket();
        basket.setId(result.getInt("id"));
        basket.setProduct_id(result.getInt("product_id"));
        basket.setCustomer_id(result.getInt("customer_id"));
        basket.setProduct_name(result.getString("product_name"));
        basket.setProduct_code(result.getString("product_code"));
        basket.setCustomer_name(result.getString("customer_name"));
        basket.setCustomer_address(result.getString("customer_address"));
        basket.setTotalPrice(result.getInt("total_price"));
        return basket;
    }

}
