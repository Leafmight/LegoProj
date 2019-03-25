package Data;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jacobfolkehildebrandt
 */
public class User {

    private String email;
    private String password; // Should be hashed and secured
    private boolean admin;

    public User(String email, boolean admin) {
        this.email = email;
        this.admin = admin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean role) {
        this.admin = role;
    }
}
