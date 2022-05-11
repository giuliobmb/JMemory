/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Frontend;

import Backend.GestoreUtenti;
import Backend.Utente;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Studente Turno B
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static Semaphore Ls;
    public static Semaphore Rs;
    
    public static void main(String[] args) {
        // TODO code application logic here

        JFrame frame = new JFrame ("JMemory - giuliobmb");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

        /////////////////////////
        Ls = new Semaphore(0);
        Rs = new Semaphore(0);
        
        GestoreUtenti g = new GestoreUtenti();
        
        
        LoginPanel login = new LoginPanel(g);
        frame.add (login);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible (true);
        
        try {
            Ls.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Utente u = login.getUtente();
        ///////////////
        
        
        System.out.println(u.toString());
        
        //frame.removeAll();
        
    }
    
}
