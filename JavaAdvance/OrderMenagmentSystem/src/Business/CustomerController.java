package Business;

import Core.Helper;
import DAO.CustomerDAO;
import DAO.UserDAO;
import Entity.Customer;
import Entity.User;

import java.util.ArrayList;

public class CustomerController {

    CustomerDAO customerDAO;

    public CustomerController(){
        this.customerDAO=new CustomerDAO();
    }


    public boolean save(Customer customer){
        return customerDAO.save(customer);
    }


    public boolean update(Customer customer){
        if (this.getById(customer.getId()) == null){
            Helper.showAutoMessage(customer.getId()+ "ID numaralı kişi bulunamadı");
            return false;
        }

        return this.customerDAO.update(customer);

    }


    public boolean delete(int id){
        if (this.getById(id)==null){
            Helper.showAutoMessage(id+ "ID numaralı kişi bulunamadı");
            return false;
        }
        return this.customerDAO.delete(id);
    }

    public ArrayList<Customer> getAll(){
        return customerDAO.getAll();
    }

    public ArrayList<Customer> filter(String name,Customer.Type type){
        String query="Select * from customers";

        ArrayList<String> whereList=new ArrayList<>();
        if (name!=null){
            whereList.add("name ilike '%"+name+"%'");
        }
        if (type!=null){
            whereList.add("person_type = '"+type+"'");
        }

        if (whereList.size()>0){
            String wherequery=String.join(" and ",whereList);
            query+=" where "+wherequery;
        }
        System.out.println("Customer controller :"+query);
        return this.customerDAO.filterByQuery(query);
    }


    public Customer getById(int id){
        return this.customerDAO.getById(id);
    }

    public Customer getByName(String name){
        return this.customerDAO.getCustomerByName(name);
    }

}
