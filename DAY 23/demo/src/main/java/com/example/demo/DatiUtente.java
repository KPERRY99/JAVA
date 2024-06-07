package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DatiUtente {
    private String username;
    private String password;
    //private DatiFiglio datiFiglio;

    //@Value("${DatiUtente.datiFiglio}")DatiFiglio datiFiglio
    // public DatiUtente(@Value("${DatiUtente.username}")String username,
    // @Value("${DatiUtente.password}") String password 
    // ) {
    //     // this.username = username;
    //     // this.password = password;
    //     //this.datiFiglio = datiFiglio;
    // }
    @Override
    public String toString() {
        return "DatiUtente [username=" + username + ", password=" + password + "]";
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    // public DatiFiglio getDatiFiglio() {
    //     return datiFiglio;
    // }
    // public void setDatiFiglio(DatiFiglio datiFiglio) {
    //     this.datiFiglio = datiFiglio;
    // }

    


}
