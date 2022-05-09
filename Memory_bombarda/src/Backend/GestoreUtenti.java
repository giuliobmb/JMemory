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
        g.printLog("Aggiunto un nuovo utente " + u.toString());
    }
    
    public Utente logUtente(String nickName, String password){
        if(g.leggiUtenti() != null)
            this.utenti = g.leggiUtenti();
        else
            this.utenti = new ArrayList<Utente>();
        for (int i = 0; i < utenti.size(); i++) {
            Utente temp = utenti.get(i);
            if(temp.getNickName().equalsIgnoreCase(nickName) && temp.getPassword().equalsIgnoreCase(password)){
                System.out.println("Loggato utente: " + temp.toString());
                g.printLog("Loggato utente: " + temp.toString());
                return temp;
            }    
        }
        return null;
    }
    
    public void cambiaPassword(Utente u, String password){
        Utente temp;
        for (int i = 0; i < utenti.size(); i++) {
            if(utenti.get(i).getId().compareToIgnoreCase(u.getId()) == 0){
                temp = utenti.get(i);
                temp.setPassword(password);
                utenti.set(i, temp);
                System.out.println(temp.toString());
            }
            g.scriviUtenti(utenti);
            g.printLog("cambio password utente: " + u.toString());
        }
        
    }

    public ArrayList<Utente> getUtenti() {
        return utenti;
    }
    
    
}
