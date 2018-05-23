package Package;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class User {
    int idUser;
    String nameUser;
    String emailUser;
    String passUser;
    int pendingUser;

    public User(int idUser, String nameUser, String emailUser, String passUser, int pendingUser) {
        this.idUser = idUser;
        this.nameUser = nameUser;
        this.emailUser = emailUser;
        this.passUser = passUser;
        this.pendingUser = pendingUser;
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

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getPassUser() {
        return passUser;
    }

    public void setPassUser(String passUser) {
        this.passUser = passUser;
    }

    public int getPendingUser() {
        return pendingUser;
    }

    public void setPendingUser(int pendingUser) {
        this.pendingUser = pendingUser;
    }

    
    
}
