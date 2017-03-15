package obochuk.vlad.DBAccess;

import obochuk.vlad.DBAccess.loginException.WrongPasswordException;
import obochuk.vlad.DBAccess.loginException.WrongUsernameException;
import obochuk.vlad.entites.User;

import javax.servlet.ServletException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;

public class DBWorker {

    private Connection connection = new DBConnector().getConnection();

    public int validate(String name, String password) throws WrongUsernameException, WrongPasswordException{
        try{
            String query = "SELECT userPassword, userID FROM users WHERE userName=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            ResultSet result = statement.executeQuery();
            if (!result.next())
                throw new WrongUsernameException();
            String queryPassword = result.getString("userPassword");
            if (!password.equals(queryPassword))
                throw new WrongPasswordException();
            return result.getInt("userID");
        } catch (SQLException e){
            e.printStackTrace();
        }
        return -1;
    }


    public User getUser(String name, String password) throws WrongPasswordException, WrongUsernameException {
            int id = validate(name, password);
            User user = new User();
            user.setName(name);
            user.setPassword(password);
            user.setId(id);
            return user;
    }

    private User getUser(int id, String name, String description){
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setDescription(description);
        return user;
    }

    public int addUser(String name, String password, String description, InputStream photo, InputStream cropedPhoto) throws ServletException{
        try {
            String query = "INSERT into users (userName, userPassword, userDescription, photo, cropedPhoto) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, password);
            statement.setString(3, description);
            statement.setBinaryStream(4,photo, photo.available());
            statement.setBinaryStream(5, cropedPhoto, cropedPhoto.available());
            statement.executeUpdate();
            return getID(name);
        }catch (Exception e){
            throw new ServletException(e);
        }
    }

    private int getID(String name){
        String query = "SELECT userID FROM users WHERE userName = ?";
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.next())
                throw new SQLException();
            return resultSet.getInt("userID");
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    public byte [] getCropedPhoto(int id){
        String par = "cropedPhoto";
        return getBlob(par, id);
    }

    public byte [] getPhoto(int id){
        String par = "photo";
        return getBlob(par, id);
    }

    private byte [] getBlob(String parName, int id){
        String query = "SELECT " + parName + " FROM users WHERE userID = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet set = statement.executeQuery();
                if(!set.next())
                    throw new SQLDataException("Is it wrog id: ? : " + id + ".SQL internal error. For more information see log");
            Blob picture = set.getBlob(1);
            return picture.getBytes(1, (int)picture.length());
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<User> getAllUsers(){
        String query = "SELECT userID, userName, userDescription FROM users";
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet userSet = statement.executeQuery();
            ArrayList<User> users = new ArrayList<>();
            while (userSet.next()){
                int id = userSet.getInt("userID");
                String name = userSet.getString("userName");
                String description = userSet.getString("userDescription");
                users.add(getUser(id, name, description));
            }
            return users;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

}

