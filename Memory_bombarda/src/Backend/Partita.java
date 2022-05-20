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
 *
 * @author giuliobmb
 */
public class Partita implements Serializable {

    private Utente utente;
    private Utente avversario;
    private int puntiU;
    private int puntiA;
    private Tessera[] coppiaU;
    private Tessera[] coppiaA;
    private int turno;

    private ArrayList<Tessera> tessere;
    private int gameMode;
    private LocalDateTime data;

    public Partita(Utente u, Utente a, int Ntessere) {
        this.utente = u;
        this.avversario = a;
        this.tessere = new ArrayList<Tessera>();
        this.loadTessere(Ntessere);
        this.data = LocalDateTime.now();
        this.puntiA = 0;
        this.puntiU = 0;
        this.coppiaA = new Tessera[2];
        this.coppiaU = new Tessera[2];
        this.turno = 0;
    }

    public Partita(Utente u, int Ntessere) {
        this.utente = u;
        this.avversario = null;
        this.tessere = new ArrayList<Tessera>();
        this.loadTessere(Ntessere);
        this.data = LocalDateTime.now();
        this.puntiA = 0;
        this.puntiU = 0;
        this.coppiaA = new Tessera[2];
        this.coppiaU = new Tessera[2];
        this.turno = 0;
    }

    public Partita(int Ntessere) {
        this.utente = null;
        this.avversario = null;
        this.tessere = new ArrayList<Tessera>();
        this.loadTessere(Ntessere);
        this.data = LocalDateTime.now();
        this.puntiA = 0;
        this.puntiU = 0;
        this.coppiaA = new Tessera[2];
        this.coppiaU = new Tessera[2];
        this.turno = 0;
    }

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

    public void addPunto(char p) {
        if (p == 'a' || p == 'A') {
            this.puntiA++;
        } else {
            this.puntiU++;
        }
    }

    private Tessera cercaCoppia(Tessera t) {
        for (int i = 0; i < this.tessere.size(); i++) {
            if (tessere.get(i).getId().compareToIgnoreCase(t.getId()) == 0 && tessere.get(i).getPosition() != t.getPosition()) {
                return tessere.get(i);
            }
        }
        return null;

    }

    /*
    public void handleEvent(java.awt.event.MouseEvent evt) {
        //((Tessera)evt.getSource()).giraTessera();

        if (turno == 0) {
            System.out.println("turno utente");
            if (this.coppiaU[0] == null) {
                try {
                    this.coppiaA[0].giraTessera();
                    this.coppiaA[1].giraTessera();
                } catch (NullPointerException e) {
                }
                this.coppiaA = new Tessera[2];
                this.coppiaU[0] = (Tessera) evt.getSource();
                this.coppiaU[0].giraTessera();
            } else {
                this.coppiaU[1] = (Tessera) evt.getSource();
                if (this.coppiaU[0].getPosition() == this.coppiaU[1].getPosition()) {
                    return;
                }

                this.coppiaU[1].giraTessera();
                System.out.println(this.coppiaU[0].getId());
                System.out.println(this.coppiaU[1].getId());
                if (this.coppiaU[0].getId().compareToIgnoreCase(this.coppiaU[1].getId()) == 0) {
                    System.out.println("punto utente");
                    this.puntiU++;
                    //this.coppiaU[0].giraTessera();
                    //this.coppiaU[1].giraTessera();
                    tessere.remove(this.coppiaU[0]);
                    tessere.remove(this.coppiaU[1]);

                    this.coppiaU = new Tessera[2];
                    if (this.gameMode == 1 && this.gameMode == 2) {
                        this.turno = 1;
                    }
                } else {

                    this.turno = 1;
                }

            }
        } else {
            if (this.gameMode == 3) {
                System.out.println("turno bot");
                this.coppiaU[0].giraTessera();
                this.coppiaU[1].giraTessera();
                if (Math.random() * 100 < 12) {
                    this.coppiaA[0] = this.coppiaU[0];
                    this.coppiaA[1] = this.cercaCoppia(this.coppiaU[0]);
                    this.coppiaA[0].giraTessera();
                    this.coppiaA[1].giraTessera();
                } else {
                    this.coppiaA[0] = this.coppiaU[0];
                    this.coppiaA[1] = tessere.get((int) (Math.random() * tessere.size()));
                    this.coppiaA[0].giraTessera();
                    this.coppiaA[1].giraTessera();
                }
                this.coppiaU = new Tessera[2];
                System.out.println(this.coppiaA[0].getId());
                System.out.println(this.coppiaA[1].getId());
                if (this.coppiaA[0].getId().compareToIgnoreCase(this.coppiaA[1].getId()) == 0) {
                    System.out.println("punto bot");
                    this.puntiA++;
                    //this.coppiaU[0].giraTessera();
                    //this.coppiaU[1].giraTessera();
                    tessere.remove(this.coppiaA[0]);
                    tessere.remove(this.coppiaA[1]);

                }
                this.turno = 0;

            } else if (this.gameMode == 1) {
                this.coppiaU[1] = (Tessera) evt.getSource();
                if (this.coppiaU[0].getPosition() == this.coppiaU[1].getPosition()) {
                    return;
                }

                this.coppiaU[1].giraTessera();
                System.out.println(this.coppiaU[0].getId());
                System.out.println(this.coppiaU[1].getId());
                if (this.coppiaU[0].getId().compareToIgnoreCase(this.coppiaU[1].getId()) == 0) {
                    System.out.println("punto utente");
                    this.puntiU++;
                    //this.coppiaU[0].giraTessera();
                    //this.coppiaU[1].giraTessera();
                    tessere.remove(this.coppiaU[0]);
                    tessere.remove(this.coppiaU[1]);

                    this.coppiaU = new Tessera[2];
                    if (this.gameMode == 1) {
                        this.turno = 1;
                    }
                } else {
                    this.turno = 1;
                }
            }
        }

        System.out.println(turno);

    }
     */
    public void handleEvent(java.awt.event.MouseEvent evt) {
        //((Tessera)evt.getSource()).giraTessera();

        if (turno == 0) {
            System.out.println("turno utente");
            
            if (this.gameMode == 2 && this.coppiaU[1] != null) {
                try {
                    this.coppiaU[0].giraTessera();
                    this.coppiaU[1].giraTessera();
                    this.coppiaU = new Tessera[2];
                } catch (NullPointerException e) {
                    System.out.println("null pointer");
                }
            }
            if (this.coppiaU[0] == null) {

                try {
                    this.coppiaA[0].giraTessera();
                    this.coppiaA[1].giraTessera();

                } catch (NullPointerException e) {
                }
                this.coppiaA = new Tessera[2];
                this.coppiaU[0] = (Tessera) evt.getSource();
                this.coppiaU[0].giraTessera();
            } else {
                this.coppiaU[1] = (Tessera) evt.getSource();
                if (this.coppiaU[0].getPosition() == this.coppiaU[1].getPosition()) {
                    return;
                }

                this.coppiaU[1].giraTessera();
                System.out.println(this.coppiaU[0].getId());
                System.out.println(this.coppiaU[1].getId());
                if (this.coppiaU[0].getId().compareToIgnoreCase(this.coppiaU[1].getId()) == 0) {
                    System.out.println("punto utente");
                    this.puntiU++;
                    //this.coppiaU[0].giraTessera();
                    //this.coppiaU[1].giraTessera();
                    tessere.remove(this.coppiaU[0]);
                    tessere.remove(this.coppiaU[1]);

                    this.coppiaA = new Tessera[2];
                    this.turno = 0;
                } else {
                    if (this.gameMode == 1 || this.gameMode == 3) {
                        this.turno = 1;
                    } else {
                        this.turno = 0;
                    }
                }

            }
        } else {

            if (this.gameMode == 1) {

                System.out.println("turno avversario");
                if (this.coppiaA[0] == null) {
                    try {
                        this.coppiaU[0].giraTessera();
                        this.coppiaU[1].giraTessera();
                    } catch (NullPointerException e) {
                    }
                    this.coppiaU = new Tessera[2];
                    this.coppiaA[0] = (Tessera) evt.getSource();
                    this.coppiaA[0].giraTessera();
                } else {
                    this.coppiaA[1] = (Tessera) evt.getSource();
                    if (this.coppiaA[0].getPosition() == this.coppiaA[1].getPosition()) {
                        return;
                    }

                    this.coppiaA[1].giraTessera();
                    System.out.println(this.coppiaA[0].getId());
                    System.out.println(this.coppiaA[1].getId());
                    if (this.coppiaA[0].getId().compareToIgnoreCase(this.coppiaA[1].getId()) == 0) {
                        System.out.println("punto avversario");
                        this.puntiA++;
                        //this.coppiaU[0].giraTessera();
                        //this.coppiaU[1].giraTessera();
                        tessere.remove(this.coppiaA[0]);
                        tessere.remove(this.coppiaA[1]);

                        this.coppiaA = new Tessera[2];
                        this.turno = 1;
                    } else {

                        this.turno = 0;
                    }

                }
            } else if (this.gameMode == 3) {
                System.out.println("turno bot");
                try {
                    this.coppiaU[0].giraTessera();
                    this.coppiaU[1].giraTessera();
                } catch (NullPointerException e) {
                }
                if (Math.random() * 100 < 30) {
                    this.coppiaA[0] = this.coppiaU[0];
                    this.coppiaA[1] = this.cercaCoppia(this.coppiaU[0]);
                    if (this.coppiaA[0] == null) {
                        this.coppiaA[1] = tessere.get((int) (Math.random() * tessere.size()));
                    }
                    this.coppiaA[0].giraTessera();
                    this.coppiaA[1].giraTessera();
                } else {
                    this.coppiaA[0] = this.coppiaU[0];
                    this.coppiaA[1] = tessere.get((int) (Math.random() * tessere.size()));
                    this.coppiaA[0].giraTessera();
                    this.coppiaA[1].giraTessera();
                }

                System.out.println(this.coppiaA[0].getId());
                System.out.println(this.coppiaA[1].getId());
                if (this.coppiaA[0].getId().compareToIgnoreCase(this.coppiaA[1].getId()) == 0) {
                    System.out.println("punto bot");
                    this.puntiA++;
                    //this.coppiaU[0].giraTessera();
                    //this.coppiaU[1].giraTessera();
                    tessere.remove(this.coppiaA[0]);
                    tessere.remove(this.coppiaA[1]);
                    this.turno = 1;
                } else {
                    this.turno = 0;
                    this.coppiaU = new Tessera[2];
                }

            }

        }

        System.out.println(turno);

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
