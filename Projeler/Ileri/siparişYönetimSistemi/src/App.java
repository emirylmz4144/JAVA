import Business.UserController;
import Core.Database;
import Core.Helper;
import DAO.UserDAO;
import Entity.User;
import View.DashboardUI;
import View.LoginUI;

import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class App {
    public static void main(String[] args) {
        Helper.setTheme();
        Helper.setTextConfiguration();
        LoginUI loginUI=new LoginUI();
    }
}
