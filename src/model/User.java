
package model;

import DAO.UserDAO;
import Service.PermissionService;
import Service.UserService;
import java.util.List;
import java.util.Scanner;
import thang2.MainClass;

public class User {
    private int idUser;
    private String nameUser;
    private String role;
    private int idParent;

    public User() {
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

  

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getIdParent() {
        return idParent;
    }

    public void setIdParent(int idParent) {
        this.idParent = idParent;
    }

 public void output(){
     System.out.println("Tai khoan nguoi dung");
     System.out.println("ID User: "+idUser);
     System.out.println("Name User: "+nameUser);
     System.out.println("Role: "+role);
     System.out.println("IP Parent: "+idParent);
     System.out.println("---------");
 }
 
 
}
     
    

