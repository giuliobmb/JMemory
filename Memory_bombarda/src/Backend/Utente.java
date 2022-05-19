/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author giuliobmb
 */
public class Utente implements Serializable{
    private String nickName;
    private String password;
    private String id;
    private int punti;

    public Utente(String nickName, String password) {
        this.nickName = nickName;
        this.password = password;
        this.id = UUID.randomUUID().toString();
        this.punti = 0;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPunti() {
        return punti;
    }

    public void setPunti(int punti) {
        this.punti = punti;
    }
    
    public void addPunto(){
        this.punti++;
        
    }
    

    @Override
    public String toString() {
        return "Utente{" + "nickName=" + nickName + ", password=" + password + ", id=" + id + ", punti=" + punti + '}';
    }

    

}
