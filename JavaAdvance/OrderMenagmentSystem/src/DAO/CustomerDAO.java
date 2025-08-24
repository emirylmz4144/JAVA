package DAO;

import Core.Database;
import Entity.Customer;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAO {
    Connection connection;
        public CustomerDAO() {
            this.connection= Database.getInstance();
        }

        public boolean save(Customer customer) {
            String query="INSERT INTO customers " +
                    "(" +
                    "name, " +
                    "surname, " +
                    "person_type, " +
                    "phone, " +
                    "e_mail, " +
                    "address " +
                    ")" +
                    " VALUES (?,?,?::p_type,?,?,?)";

            try {
                PreparedStatement ps =this.connection.prepareStatement(query);
                ps.setString(1,customer.getName());
                ps.setString(2,customer.getSurname());
                ps.setString(3,customer.getPerson_type().toString());
                ps.setString(4,customer.getPhone());
                ps.setString(5,customer.getE_mail());
                ps.setString(6,customer.getAddress());
                return ps.executeUpdate()!=-1;
            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage());
            }

        }

        public boolean update(Customer customer) {
        String query = "UPDATE customers SET " +
                "name = ?, " +
                "surname = ?, " +
                "person_type = ?::p_type, " +  // Cast ifadesini ekledim
                "phone = ?, " +
                "e_mail = ?, " +
                "address = ? " +  // Son sütundan sonra virgül yok
                "WHERE id = ?";
        try {
            PreparedStatement ps = this.connection.prepareStatement(query);
            ps.setString(1, customer.getName());
            ps.setString(2, customer.getSurname());
            ps.setString(3, customer.getPerson_type().toString());  // Enum değeri burada String olarak ayarlanıyor
            ps.setString(4, customer.getPhone());
            ps.setString(5, customer.getE_mail());
            ps.setString(6, customer.getAddress());
            ps.setInt(7, customer.getId());
            return ps.executeUpdate() != -1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

        public boolean delete(int id){
            String query = "DELETE FROM customers WHERE id = ?";
        try {
            PreparedStatement ps=this.connection.prepareStatement(query);
            ps.setInt(1,id);
            return ps.executeUpdate()!=-1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

        public Customer getById(int id) {
            String query="SELECT * FROM customers WHERE id = ?";
            Customer customer=null;
            try{
                PreparedStatement ps=this.connection.prepareStatement(query);
                ps.setInt(1,id);
                ResultSet rs=ps.executeQuery();
                if(rs.next()){
                    customer=this.match(rs);
                }
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
            return customer;
        }

    public Customer getCustomerByName(String name) {
        String query="SELECT * FROM customers WHERE name = ?";
        Customer customer=null;
        try{
            PreparedStatement ps=this.connection.prepareStatement(query);
            ps.setString(1,name);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                customer=this.match(rs);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return customer;
    }

        public ArrayList<Customer> filterByQuery(String query){
            ArrayList<Customer> customerList=new ArrayList<>();
            try {
                System.out.println("CustomerDao query "+query);
                ResultSet rs=this.connection.createStatement().executeQuery(query);
                while (rs.next()) {
                    customerList.add(this.match(rs));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return customerList;
        }

        public ArrayList<Customer> getAll() {
        ArrayList<Customer> customers= new ArrayList<Customer>();
        try {
            ResultSet result=this.connection.createStatement().executeQuery("Select * from customers");

            while (result.next()){
                customers.add(this.match(result));
            }

        }catch (SQLException e){System.out.println(e.getMessage());}

        return customers;
    }

        public Customer match(ResultSet result) throws SQLException{
        Customer customer=new Customer();
        customer.setId(result.getInt("id"));
        customer.setName(result.getString("name"));
        customer.setSurname(result.getString("surname"));
        customer.setPerson_type(Customer.Type.valueOf(result.getString("person_type")));
        customer.setE_mail(result.getString("e_mail"));
        customer.setPhone(result.getString("phone"));
        customer.setAddress(result.getString("address"));
        return customer;
    }
}
