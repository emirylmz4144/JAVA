package Business;

import Core.Helper;
import DAO.UserDAO;
import Entity.User;


//Adminler için
public class UserController {


    UserDAO userDAO;

    public UserController(){
        this.userDAO=new UserDAO();
    }

    public User findByLogin(String email,String password){
        if (!Helper.isEmailValid(email)) return null;
        return this.userDAO.findByLogin(email,password);
    }
}
