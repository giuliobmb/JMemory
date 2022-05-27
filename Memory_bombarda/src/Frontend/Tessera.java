/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Frontend;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *  classe tessera, estende il bottone che viene sollecitato per ogni click
 * @author giuliobmb
 */
public class Tessera extends JButton {

    private String id;
    private int tessera;
    private BufferedImage picture;
    private BufferedImage dorso;
    private int position;

    /**
     * la classe Tessera richiede in input un oggetto BufferedImage che conterrà il puntatore all'immagine della tessera, 
     * vengono inizializzate le variabili id e tessera e viene caricata e impostata l'immagine del dorso come icona sul bottone
     * l'immmagine è caricata come BufferedImage e viene creato un oggetto icona che verrà inserito nel bottone con il metodo setIcon()
     * @param picture 
     */
    
    public Tessera(BufferedImage picture) {
        this.id = this.id = UUID.randomUUID().toString();
        this.tessera = 0;
        this.picture = picture;
        try {
            this.dorso = ImageIO.read(new File("dorso.png"));
        } catch (IOException ex) {
            Logger.getLogger(Tessera.class.getName()).log(Level.SEVERE, null, ex);
        }

        ImageIcon i = new ImageIcon(this.dorso);

        this.setIcon(i);

    }

    /**
     * void giraTessera()
     * 
     * metodo che simula l'azione di girare la tessera invertendo l'immagine del dorso con quella della tessera
     */
    public void giraTessera() {

        if (tessera == 0) {
            this.tessera = 1;
            this.setIcon(new ImageIcon(this.picture));
        } else {
            this.tessera = 0;

            this.setIcon(new ImageIcon(this.dorso));
        }
    }



    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Tessera{" + "id=" + id + ", tessera=" + tessera + ", picture=" + picture + ", dorso=" + dorso + ", position=" + position + '}';
    }

}
