/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import Frontend.Tessera;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *  classe Partita, gestisce la parte di backend della partita: gli utenti, i punti e si sincronizza con la classe MemoryGame di frontend
 * @author giuliobmb
 */
public class Partita implements Serializable {

    private Utente utente;
    private Utente avversario;
    private int puntiU;
    private int puntiA;
    private Tessera[] buffer;
    private int turno;
    private boolean gira;

    private ArrayList<Tessera> tessere;
    private ArrayList<Tessera> tessereD;
    private ArrayList<Tessera> memoria;
    private int gameMode;
    private LocalDateTime data;

    public Partita(Utente u, Utente a, int Ntessere) {
        this.gira = true;
        this.utente = u;
        this.avversario = a;
        this.tessere = new ArrayList<Tessera>();
        this.tessereD = new ArrayList<Tessera>();
        this.memoria = new ArrayList<Tessera>();
        this.loadTessere(Ntessere);
        this.data = LocalDateTime.now();
        this.puntiA = 0;
        this.puntiU = 0;
        this.buffer = new Tessera[2];
        this.turno = 0;
    }

    public Partita(Utente u, int Ntessere) {
        this.gira = true;
        this.utente = u;
        this.avversario = null;
        this.tessere = new ArrayList<Tessera>();
        this.tessereD = new ArrayList<Tessera>();
        this.memoria = new ArrayList<Tessera>();
        this.loadTessere(Ntessere);
        this.data = LocalDateTime.now();
        this.puntiA = 0;
        this.puntiU = 0;
        this.buffer = new Tessera[2];
        this.turno = 0;
    }

    public Partita(int Ntessere) {
        this.gira = true;
        this.utente = null;
        this.avversario = null;
        this.tessere = new ArrayList<Tessera>();
        this.tessereD = new ArrayList<Tessera>();
        this.memoria = new ArrayList<Tessera>();
        this.loadTessere(Ntessere);
        this.data = LocalDateTime.now();
        this.puntiA = 0;
        this.puntiU = 0;
        this.buffer = new Tessera[2];
        this.turno = 0;
    }
    /**
     * void loadTessere(int nTessere)
     * lettura delle immagini contenute nelle tessere e caricamento degli oggetti Tessera in arraylist
     * @param nTessere numero di tessere da istanziare
     */
    public void loadTessere(int nTessere) {
        BufferedImage img = null;
        int index = 0;
        for (int i = 0; i < nTessere / 2; i++) {

            try {
                img = ImageIO.read(new File("./tessere/" + String.valueOf(i) + ".png"));
            } catch (IOException ex) {
                System.out.println("impossibile leggere le immagini");
            }
            Tessera t = new Tessera(img);
            t.setPosition(index);
            tessere.add(t);
            index++;

        }
        for (int i = 0; i < nTessere / 2; i++) {

            try {
                img = ImageIO.read(new File("./tessere/" + String.valueOf(i) + ".png"));
            } catch (IOException ex) {
                System.out.println("impossibile leggere le immagini");
            }
            Tessera t = new Tessera(img);
            t.setId(tessere.get(i).getId());
            t.setPosition(index);
            tessere.add(t);
            index++;

        }
        Collections.shuffle(tessere);

    }

    /**
     * Tessera cercaCoppia(Tessera t)
     * ricerca della tessera uguale ma con indice opposto nella collezione di tessere
     * @param t tessera da cercare
     * @return 
     */
    private Tessera cercaCoppia(Tessera t) {
        for (int i = 0; i < this.memoria.size(); i++) {
            if (memoria.get(i).equals(t)) {
                return memoria.get(i);
            }
        }
        return null;

    }

   /** void handleEvent(java.awt.event.MouseEvent evt)
    * gestione dell'evento click su ogni tessera, per ogni modalità di gioco
    * @param evt evento di cui è stato sollecitato il bottone
    */
    public void handleEvent(java.awt.event.MouseEvent evt) {
        //((Tessera)evt.getSource()).giraTessera();
        switch(this.gameMode){
            case 1:
                handle1v1(evt);
                break;
            case 2:
                handleSolo(evt);
                break;
            case 3:
                handleAi(evt);
                break;
        }

    }
    
    
    public void handle1v1(java.awt.event.MouseEvent evt) {
        if(tessereD.contains((Tessera)evt.getSource()))
            return;
        
        if(this.buffer[1] != null && this.gira == true){
            try{
               this.buffer[0].giraTessera();
               this.buffer[1].giraTessera();
               this.buffer[0] = null;
               this.buffer[1] = null;
           }catch(NullPointerException e){}   
        }else if(this.buffer[1] != null){
            this.buffer[0] = null;
            this.buffer[1] = null;
        }
        
        if(this.buffer[0] == null){
            this.buffer[0] = (Tessera)evt.getSource();
            this.buffer[0].giraTessera();
        }else{
            this.buffer[1] = (Tessera)evt.getSource();
            this.buffer[1].giraTessera();
            if(this.buffer[0].equals(this.buffer[1])){
                tessereD.add(this.buffer[0]);
                tessereD.add(this.buffer[1]);
                if(turno == 0)
                    this.puntiU++;
                else
                    this.puntiA++;
                this.gira = false;
            }else{
                this.gira = true;
                turno = (turno+1)%1;
            }
        }
        
        
    }
    
    public void handleSolo(java.awt.event.MouseEvent evt) {
        if(tessereD.contains((Tessera)evt.getSource()))
            return;
        
        if(this.buffer[1] != null && this.gira == true){
            try{
               this.buffer[0].giraTessera();
               this.buffer[1].giraTessera();
               this.buffer[0] = null;
               this.buffer[1] = null;
           }catch(NullPointerException e){}   
        }else if(this.buffer[1] != null){
            this.buffer[0] = null;
            this.buffer[1] = null;
        }
        
        if(this.buffer[0] == null){
            this.buffer[0] = (Tessera)evt.getSource();
            this.buffer[0].giraTessera();
        }else{
            this.buffer[1] = (Tessera)evt.getSource();
            this.buffer[1].giraTessera();
            if(this.buffer[0].equals(this.buffer[1])){
                tessereD.add(this.buffer[0]);
                tessereD.add(this.buffer[1]);
                this.puntiU++;
                this.gira = false;
            }else
                this.gira = true;
            
        }
        
    }
    
    public void handleAi(java.awt.event.MouseEvent evt) {
        if(tessereD.contains((Tessera)evt.getSource()))
            return;
        
        if(this.buffer[1] != null && this.gira == true){
            try{
               this.buffer[0].giraTessera();
               this.buffer[1].giraTessera();
               this.buffer[0] = null;
               this.buffer[1] = null;
           }catch(NullPointerException e){}   
        }else if(this.buffer[1] != null){
            this.buffer[0] = null;
            this.buffer[1] = null;
        }
        
        if(turno == 0){
        
            if (this.buffer[0] == null) {
                this.buffer[0] = (Tessera) evt.getSource();
                this.buffer[0].giraTessera();
            } else {
                this.buffer[1] = (Tessera) evt.getSource();
                this.buffer[1].giraTessera();
                if (this.buffer[0].equals(this.buffer[1])) {
                    tessereD.add(this.buffer[0]);
                    tessereD.add(this.buffer[1]);
                    this.puntiU++;
                    this.gira = false;
                }else {
                    this.gira = true;
                    turno = (turno + 1) % 1;
                }
            }
            
        }else{
            if(Math.random()*100<10){
                this.buffer[0] = this.memoria.get((int)Math.random()*memoria.size());
                this.buffer[1] = this.cercaCoppia(this.buffer[0]);
                this.buffer[0].giraTessera();
            }else{
                this.buffer[0] = this.memoria.get((int)Math.random()*memoria.size());
                this.buffer[1] = this.memoria.get((int)Math.random()*memoria.size());
            }
            
            
            if(this.buffer[0] == null){
                this.buffer[0] = (Tessera)evt.getSource();
                this.buffer[0].giraTessera();
                this.memoria.add(buffer[0]);
            }else{
                this.buffer[1] = (Tessera)evt.getSource();
                this.buffer[1].giraTessera();
                this.memoria.add(buffer[0]);
                if(this.buffer[0].equals(this.buffer[1])){
                    tessereD.add(this.buffer[0]);
                    tessereD.add(this.buffer[1]);
                    this.puntiA++;
                    this.gira = false;
                }else{
                    this.gira = true;
                    turno = (turno+1)%1;
                }
            
        }
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

    public int getGameMode() {
        return gameMode;
    }

    public void setGameMode(int gameMode) {
        this.gameMode = gameMode;
    }

}
