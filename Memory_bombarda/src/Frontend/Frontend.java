/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
public class Frontend {
    public static Semaphore lS;
    private JFrame mainFrame;
    GestoreUtenti g;
    
    public Frontend(){
        lS = new Semaphore(0);
        g = new GestoreUtenti();
        mainFrame = new JFrame ("JMemory - giuliobmb");
        mainFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(600, 400);
        game();
        
    }
    
    public void game(){
        LoginPanel login = new LoginPanel(g);
        mainFrame.add (login);

        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible (true);
        
        try {
            lS.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Utente u = login.getUtente();
        ///////////////
        
        
        System.out.println(u.toString());
        
        mainFrame.removeAll();
        mainFrame.add(new RegisterPanel(g));
    }
    
    
}
