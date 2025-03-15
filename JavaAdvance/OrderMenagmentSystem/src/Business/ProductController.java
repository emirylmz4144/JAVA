package Business;
import Core.Database;
import Core.Helper;
import Core.Item;
import DAO.ProductDAO;
import Entity.Customer;
import Entity.Product;

import java.util.ArrayList;

public class ProductController {

    ProductDAO productDAO;


    public ProductController() {
        this.productDAO=new ProductDAO();
    }


    public boolean save(Product product){
        return productDAO.save(product);
    }


    public boolean update(Product product){
        if (this.getById(product.getId()) == null){
            Helper.showAutoMessage(product.getId()+ "ID numaralı ürün bulunamadı");
            return false;
        }

        return this.productDAO.update(product);

    }

    public boolean delete(int id){
        if (this.getById(id)==null){
            Helper.showAutoMessage(id+ "ID numaralı kişi bulunamadı");
            return false;
        }
        return this.productDAO.delete(id);
    }

    public ArrayList<Product> getAll(){
       return this.productDAO.getAll();
    }

    public Product getById(int id){
        return this.productDAO.getById(id);
    }

    public Product getProductByCode(String code){
        return this.productDAO.getProductByCode(code);
    }

    public ArrayList<Product> filter(String productName,String productCode, Item item){
        System.out.println("name "+productCode);
        System.out.println("code "+productCode);
        System.out.println("item "+item);
        String query="Select * from products";

        ArrayList<String> whereList=new ArrayList<>();
        if (productName!=null){
            whereList.add("name ilike '%"+productName+"%'");
        }
        if (productCode!=null){
            whereList.add("code ilike '%"+productCode+"%'");
        }
        if (item!=null){
            if (item.getKey()==1)
                whereList.add("stock>=1 and stock <=299");
            else if (item.getKey()==2)
                whereList.add("stock>=300 and stock <=599");
            else if (item.getKey()==3)
                whereList.add("stock>=600 and stock <=799");
            else if (item.getKey()==4)
                whereList.add("stock>=800 and stock <=1199");
            else if (item.getKey()==5)
                whereList.add("stock>=1200 and stock <=1499");
            else
                whereList.add("stock>=1500");

        }

        if (whereList.size()>0){
            String wherequery=String.join(" and ",whereList);
            query+=" where "+wherequery;
        }
        System.out.println("Product Controller :"+query);
        return this.productDAO.filterByQuery(query);
    }

}
