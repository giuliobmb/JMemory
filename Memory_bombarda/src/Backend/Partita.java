/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author giuliobmb
 */
public class Partita implements Serializable{
    private Utente vincitore;
    private Utente perdente;
    private LocalDateTime data;

    public Partita() {
        this.vincitore = null;
        this.perdente = null;
        this.data = LocalDateTime.now();
    }

    public Utente getVincitore() {
        return vincitore;
    }

    public void setVincitore(Utente vincitore) {
        this.vincitore = vincitore;
    }

    public Utente getPerdente() {
        return perdente;
    }

    public void setPerdente(Utente perdente) {
        this.perdente = perdente;
    }
    
}
