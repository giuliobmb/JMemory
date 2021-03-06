/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.util.ArrayList;

/**
 * classe di backend che si occupa della gestione degli eventi
 *
 * @author giuliobmb
 */
public class GestoreUtenti {

    private ArrayList<Utente> utenti;
    private GestoreFile g;

    public GestoreUtenti() {
        g = new GestoreFile("utenti.bin", "logs.log");
        if (g.leggiUtenti() != null) {
            this.utenti = g.leggiUtenti();
        } else {
            this.utenti = new ArrayList<Utente>();
        }
    }
    
    /**
     * int addUtente(Utente u)
     * questo metodo permette di aggiungere un utente al database controllando che rispetti i criteri della password
     * @param u
     * @return 
     */
    public int addUtente(Utente u) {
        if(u.getNickName().equalsIgnoreCase("") || u.getPassword().equalsIgnoreCase(""))
            return -1;
        if(u.getPassword().length()<6)
            return -2;
        for (int i = 0; i < utenti.size(); i++) {
            if(utenti.get(i).getNickName().equalsIgnoreCase(u.getNickName()))
                return -3;
        }
        utenti.add(u);
        g.scriviUtenti(utenti);
        g.printLog("Aggiunto un nuovo utente " + u.toString());
        return 0;
    }

    /**
     * Utente logUtente(String nickName, String password)
     * metodo che permette di controllare l'accesso degli utenti, se ritorna null l'accesso è fallito, se ritorna l'utente l'accesso è avvenuto con successo
     * 
     * @param nickName
     * @param password
     * @return 
     */
    public Utente logUtente(String nickName, String password) {
        if (g.leggiUtenti() != null) {
            this.utenti = g.leggiUtenti();
        } else {
            this.utenti = new ArrayList<Utente>();
        }
        for (int i = 0; i < utenti.size(); i++) {
            Utente temp = utenti.get(i);
            if (temp.getNickName().equalsIgnoreCase(nickName) && temp.getPassword().equalsIgnoreCase(password)) {
                System.out.println("Loggato utente: " + temp.getNickName());
                g.printLog("Loggato utente: " + temp.getNickName());
                return temp;
            }
        }
        return null;
    }
    /**
     * void cambiaPassword(Utente u, String password)
     * metodo che aggiorna il database cambiando la password dell'utente che la richiede
     * 
     * @param u utente che richiede il cambio password
     * @param password nuova password
     */
    public void cambiaPassword(Utente u, String password) {
        Utente temp;
        for (int i = 0; i < utenti.size(); i++) {
            if (utenti.get(i).getId().compareToIgnoreCase(u.getId()) == 0) {
                temp = utenti.get(i);
                temp.setPassword(password);
                utenti.set(i, temp);
                System.out.println(temp.toString());
            }
            g.scriviUtenti(utenti);
            g.printLog("cambio password utente: " + u.getNickName());
        }

    }

    public ArrayList<Utente> getClassifica() {
        ArrayList<Utente> c = this.utenti;

        for (int i = 0; i < c.size(); i++) {
            for (int j = i; j < c.size(); j++) {
                if (c.get(i).getPunti() < c.get(j).getPunti()) {
                    Utente t = c.get(i);
                    c.set(i, c.get(j));
                    c.set(j, t);
                }
            }
        }
        return c;
    }

    public ArrayList<Utente> getUtenti() {
        return utenti;
    }

    public void scriviUtenti() {
        g.scriviUtenti(utenti);
    }

}
