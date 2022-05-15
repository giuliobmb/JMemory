/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import Frontend.Tessera;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author giuliobmb
 */
public class Partita implements Serializable{
    private Utente utente;
    private Utente avversario;
    private int puntiU;
    private int puntiA;
    private ArrayList<Tessera> tessere;
    private int nTessere;
    private LocalDateTime data;

    public Partita(Utente u, Utente a, ArrayList<Tessera> tessere){
        this.utente = u;
        this.avversario = a;
        this.tessere = tessere;
        this.data = LocalDateTime.now();
        this.nTessere = 0;
    }
    public Partita(Utente u, ArrayList<Tessera> tessere){
        this.utente = u;
        this.avversario = null;
        this.tessere = tessere;
        this.data = LocalDateTime.now();
        this.nTessere = 0;
    }
    
    public Partita(ArrayList<Tessera> tessere) {
        this.utente = null;
        this.avversario = null;
        this.tessere = tessere;
        this.data = LocalDateTime.now();
        this.nTessere = 0;
    }
    
    
    public void loadTessere(){
        BufferedImage img = null;
        for (int i = 1; i < this.nTessere+1; i++) {
            try {
                img = ImageIO.read(new File(String.valueOf(i) + ".png"));
            } catch (IOException ex) {
                    System.out.println("impossibile leggere le immagini");
            }
            tessere.add(new Tessera(img));
            
        }
        
    }
    
    
    

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Utente getAvversario() {
        return avversario;
    }

    public void setAvversario(Utente avversario) {
        this.avversario = avversario;
    }

    public int getPuntiU() {
        return puntiU;
    }

    public void setPuntiU(int puntiU) {
        this.puntiU = puntiU;
    }

    public int getPuntiA() {
        return puntiA;
    }

    public void setPuntiA(int puntiA) {
        this.puntiA = puntiA;
    }

    public ArrayList<Tessera> getTessere() {
        return tessere;
    }

    public void setTessere(ArrayList<Tessera> tessere) {
        this.tessere = tessere;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Partita{" + "utente=" + utente + ", avversario=" + avversario + ", puntiU=" + puntiU + ", puntiA=" + puntiA + ", tessere=" + tessere + ", data=" + data + '}';
    }

    
    
}
