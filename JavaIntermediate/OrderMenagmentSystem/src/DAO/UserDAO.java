package DAO;

import Core.Database;
import Entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class UserDAO
{
    Connection connection;

    public UserDAO(){
        this.connection= Database.getInstance();
    }

    public User findByLogin(String email, String password){
        User user=null;
        String query="Select * from users where email=? AND password=?";
        try {
            PreparedStatement queryPrepared=this.connection.prepareStatement(query);
            queryPrepared.setString(1, email);
            queryPrepared.setString(2, password);
            ResultSet result=queryPrepared.executeQuery();

            while (result.next()){
               user=this.match(result);
            }

        }catch (SQLException sqlException){System.out.println(sqlException.getMessage());}

        return user;
    }

    public ArrayList<User> getAll() {
        ArrayList<User> users= new ArrayList<User>();
        try {
            ResultSet result=this.connection.createStatement().executeQuery("Select * from users");

            while (result.next()){
                users.add(this.match(result));
            }

        }catch (SQLException e){System.out.println(e.getMessage());}

        return users;
    }

    public User match(ResultSet result) throws SQLException{
        User user=new User();
        user.setId(result.getInt("id"));
        user.setName(result.getString("name"));
        user.setSurname(result.getString("surname"));
        user.setEmail(result.getString("email"));
        user.setPassword(result.getString("password"));
        return user;
    }
}
