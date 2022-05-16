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
    private int gameMode;
    private LocalDateTime data;

    public Partita(Utente u, Utente a, int Ntessere){
        this.utente = u;
        this.avversario = a;
        this.tessere = new ArrayList<Tessera>();
        this.loadTessere(Ntessere);
        this.data = LocalDateTime.now();
        this.puntiA = 0;
        this.puntiU = 0;
    }
    public Partita(Utente u, int Ntessere){
        this.utente = u;
        this.avversario = null;
        this.tessere = new ArrayList<Tessera>();
        this.loadTessere(Ntessere);
        this.data = LocalDateTime.now();
        this.puntiA = 0;
        this.puntiU = 0;
    }
    
    public Partita(int Ntessere) {
        this.utente = null;
        this.avversario = null;
        this.tessere = new ArrayList<Tessera>();
        this.loadTessere(Ntessere);
        this.data = LocalDateTime.now();
        this.puntiA = 0;
        this.puntiU = 0;
    }
    
    
    public void loadTessere(int nTessere){
        BufferedImage img = null;
        for (int i = 0; i < nTessere/2; i++) {
            try {
                img = ImageIO.read(new File("./tessere/" + String.valueOf(i) + ".png"));
            } catch (IOException ex) {
                    System.out.println("impossibile leggere le immagini");
            }
            tessere.add(new Tessera(img));
            tessere.add(new Tessera(img));
            
        }
        
    }
    
    public void addPunto(char p){
        if(p == 'a' || p == 'A'){
            this.puntiA++;
        }else{
            this.puntiU++;
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
