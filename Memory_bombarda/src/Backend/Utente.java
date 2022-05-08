/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author giuliobmb
 */
public class Utente implements Serializable{
    private String nickName;
    private String password;
    private ArrayList<Partita> partite;

    public Utente(String nickName, String password) {
        this.nickName = nickName;
        this.password = password;
        this.partite = new ArrayList<Partita>();
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
    
    public ArrayList<Partita> getPartite() {
        return partite;
    }
    
    public void addPartita(Partita p){
        partite.add(p);
    }
}
