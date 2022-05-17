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
 *
 * @author giuliobmb
 */
public class Tessera extends JButton {
    private String id;
    private int tessera;
    private BufferedImage picture;
    private BufferedImage dorso;
    private int position;
    
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
    
    public void giraTessera(){
        
        if(tessera == 0){
            this.tessera = 1;
            this.setIcon(new ImageIcon(this.picture));
        }else{
            this.tessera = 0;
            this.setIcon(new ImageIcon(this.dorso));
            
        }
    }
    
    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tessera other = (Tessera) obj;
        if (this.tessera != other.tessera) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
    
    
    
}
