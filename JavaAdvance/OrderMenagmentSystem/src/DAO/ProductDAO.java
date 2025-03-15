package DAO;

import Core.Database;
import Entity.Customer;
import Entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDAO {

    Connection connection;
    public ProductDAO() {
        this.connection= Database.getInstance();
    }


    public ArrayList<Product> getAll() {
        ArrayList<Product> products= new ArrayList<Product>();
        try {
            ResultSet result=this.connection.createStatement().executeQuery("Select * from products");

            while (result.next()){
                products.add(this.match(result));
            }

        }catch (SQLException e){System.out.println(e.getMessage());}

        return products;
    }

    public Product getById(int id) {
        String query="SELECT * FROM products WHERE id = ?";
        Product product=null;
        try{
            PreparedStatement ps=this.connection.prepareStatement(query);
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                product=this.match(rs);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return product;
    }

    public boolean save(Product product) {
        String query = "INSERT INTO products " +
                "(" +
                "name," +
                " code, " +
                "stock, " +
                "price" +
                ") " +
                "VALUES (?, ?, ?, ?)";  // Sütunlar arasına virgül eklenmiş

        try {
            PreparedStatement ps = this.connection.prepareStatement(query);
            ps.setString(1, product.getName());
            ps.setString(2, product.getCode());
            ps.setInt(3, product.getStock());
            ps.setDouble(4, product.getPrice());  // Fiyatı Double olarak kaydediyoruz
            return ps.executeUpdate() != -1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean update(Product product) {
        String query = "UPDATE products SET " +
                "name = ?, " +
                "code = ?, " +
                "stock = ?, " +
                "price = ? " +
                "WHERE id = ?";

        try {
            PreparedStatement ps = this.connection.prepareStatement(query);
            ps.setString(1, product.getName());
            ps.setString(2, product.getCode());
            ps.setInt(3, product.getStock());
            ps.setDouble(4, product.getPrice());  // Fiyatı Double olarak güncelliyoruz
            ps.setInt(5, product.getId());
            return ps.executeUpdate() != -1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean delete(int id) {
        String query = "DELETE FROM products WHERE id = ?";
        try {
            PreparedStatement ps=this.connection.prepareStatement(query);
            ps.setInt(1,id);
            return ps.executeUpdate()!=-1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    public ArrayList<Product> filterByQuery(String query){
        ArrayList<Product> productList=new ArrayList<>();
        try {
            System.out.println("ProductDAO query "+query);
            ResultSet rs=this.connection.createStatement().executeQuery(query);
            while (rs.next()) {
                productList.add(this.match(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }


    public Product getProductByCode(String code) {
        String query="SELECT * FROM products WHERE code = ?";
        Product product=null;
        try{
            PreparedStatement ps=this.connection.prepareStatement(query);
            ps.setString(1,code);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                product=this.match(rs);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return product;
    }

    public Product match(ResultSet result) throws SQLException{
        Product product=new Product();
        product.setId(result.getInt("id"));
        product.setName(result.getString("name"));
        product.setCode(result.getString("code"));
        product.setStock(result.getInt("stock"));
        product.setPrice(result.getInt("price"));
        return product;
    }
}
