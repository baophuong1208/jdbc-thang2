package DAO;

import Connection.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

public class UserDAO {

    Connection connect = ConnectDB.openconnect();

    public List<User> getListUser() {
        try {
            List<User> listuser = new ArrayList<>();
            String user_query = "select * from user";

            Statement createStatement = connect.createStatement();
            ResultSet rs = createStatement.executeQuery(user_query);
            while (rs.next()) {
                User u = new User();
                String id = rs.getString(1);
                String name = rs.getString(2);
                String role = rs.getString(3);
                String id_parent = rs.getString(4);
                u.setId_user(id);
                u.setName_user(name);
                u.setRole(role);
                u.setId_parent(id_parent);
                listuser.add(u);
            }
            return listuser;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public boolean insertUser(User u) {
        try {

            String themUser = "insert into user values(?,?,?,?)";
            PreparedStatement createStatement = connect.prepareStatement(themUser);
            createStatement.setString(1, u.getId_user());
            createStatement.setString(2, u.getName_user());
            createStatement.setString(3, u.getRole());
            createStatement.setString(4, u.getId_parent());
            int rs = createStatement.executeUpdate();
            if (rs != 0) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public User getUserByID(String id) {
        try {
            User u = new User();
            String query = "select * from user where id=?";
            PreparedStatement prepareStatement = connect.prepareStatement(query);
            prepareStatement.setString(1, id);
            ResultSet rs = prepareStatement.executeQuery();
            while (rs.next()) {
//                String id = rs.getString(1);
//                String name = rs.getString(2);
//                String role = rs.getString(3);
//                String parent_id = rs.getString(4);
                u.setId_user(rs.getString(1));
                u.setName_user(rs.getString(2));
                u.setRole(rs.getString(3));
                u.setId_parent(rs.getString(4));
            }
            return u;

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean updateUserByID(User u, String id) {
        try {
            String query = "update user SET id=?, name=?, role=?, id_parent=? where id_user=?";
            PreparedStatement prepareStatement = connect.prepareStatement(query);
            prepareStatement.setString(1, u.getId_user());
            prepareStatement.setString(2, u.getName_user());
            prepareStatement.setString(3, u.getRole());
            prepareStatement.setString(4, u.getId_parent());
            prepareStatement.setString(5, id);
            int rs = prepareStatement.executeUpdate();
            if (rs != 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public boolean deleteUserByID(String id) {
        try {
            String query = "delete from user where id = ?";
            PreparedStatement prepareStatement = connect.prepareStatement(query);
            prepareStatement.setString(1, id);
            int rs = prepareStatement.executeUpdate();
            if (rs != 0) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}