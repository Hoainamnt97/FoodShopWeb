/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Package;

import java.util.Date;

/**
 *
 * @author Bang
 */
public class Comment {
    String username;
    Date date;
    String comment;

    public Comment() {
    }

    public Comment(String username, Date date, String comment) {
        this.username = username;
        this.date = date;
        this.comment = comment;
    }

    public String getUsername() {
        return username;
    }

    public Date getDate() {
        return date;
    }

    public String getComment() {
        return comment;
    }
  
}
