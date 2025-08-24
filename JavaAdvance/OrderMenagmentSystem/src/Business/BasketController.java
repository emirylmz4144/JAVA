package Business;

import DAO.BasketDAO;
import Entity.Basket;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BasketController {

    private BasketDAO basketDAO;

    public BasketController() {
        basketDAO = new BasketDAO();
    }
    public boolean save(Basket basket) {
        return this.basketDAO.save(basket);
    }


    public ArrayList<Basket> getAll() {
        return this.basketDAO.getAll();
    }
    public Basket match(ResultSet result) throws SQLException {
        return this.basketDAO.match(result);
    }
}
