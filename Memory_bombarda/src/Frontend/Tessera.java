/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Frontend;

import java.awt.image.BufferedImage;
import java.util.Objects;
import java.util.UUID;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author giuliobmb
 */
public class Tessera extends javax.swing.JPanel {

    /**
     * Creates new form Tessera
     */
    private String id;
    private int tessera;
    private JLabel pic;
    
    public Tessera(BufferedImage picture ) {
        initComponents();
        this.id = this.id = UUID.randomUUID().toString();
        this.tessera = 0;
        this.pic = new JLabel(new ImageIcon(picture));
    }
    
    public void giraTessera(){
        if(tessera == 0){
            this.tessera = 1;
            this.add(this.pic);
        }else{
            this.tessera = 0;
            this.removeAll();
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
        if (!Objects.equals(this.pic, other.pic)) {
            return false;
        }
        return true;
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(153, 0, 153));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 77, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}