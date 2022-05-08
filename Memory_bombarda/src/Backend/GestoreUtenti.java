/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.util.ArrayList;

/**
 *
 * @author giuliobmb
 */
public class GestoreUtenti {
    private ArrayList<Utente> utenti;
    private GestoreFile g;

    public GestoreUtenti() {
        g = new GestoreFile("utenti.bin", "logs.log");
        if(g.leggiUtenti() != null)
            this.utenti = g.leggiUtenti();
        else
            this.utenti = new ArrayList<Utente>();
    }
    
    public void addUtente(Utente u){
        utenti.add(u);
        g.scriviUtenti(utenti);
    }
    
    public Utente logUtente(String nickName, String password){
        for (int i = 0; i < utenti.size(); i++) {
            Utente temp = utenti.get(i);
            if(temp.getNickName().equalsIgnoreCase(nickName) && temp.getPassword().equalsIgnoreCase(password))
                return temp;
        }
        return null;
    }
    
}
