/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author giuliobmb
 */
public class GestoreFile {
    private FileOutputStream fileUtentiW; 
    private FileInputStream fileUtentiR;
    private String fileLogs;

    public GestoreFile(String fileUtenti, String fileLogs) {
        try {
            this.fileUtentiW = new FileOutputStream(fileUtenti);
            this.fileUtentiR = new FileInputStream(fileUtenti);
            this.fileLogs = fileLogs;
        } catch (IOException ex) {
            System.out.println("errore in apertura file");
        }
    }
    
    public GestoreFile() {
        try {
            this.fileUtentiW = new FileOutputStream("utenti.bin");
            this.fileUtentiR = new FileInputStream("utenti.bin");
            this.fileLogs = "logs.log";
        } catch (IOException ex) {
            System.out.println("errore in apertura file");
        }
    }
    
    public ArrayList<Utente> leggiUtenti(){
        try {
            ObjectInputStream s = new ObjectInputStream(this.fileUtentiR);
            ArrayList<Utente> a = (ArrayList<Utente>)s.readObject();
            s.close();
            return a;
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("errore lettura file" + ex);
        }
        return null;
    }
    
    public void scriviUtenti(ArrayList<Utente> a){
        try {
            ObjectOutputStream s = new ObjectOutputStream(this.fileUtentiW);
            s.writeObject(a);
            s.close();
        } catch (IOException ex) {
            System.out.println("errore scrittura file" + ex);
        }
    }
    
    public void printLog(String log){
        try {
            FileWriter logsFile = new FileWriter(this.fileLogs);
            logsFile.append(log);
            logsFile.close();
        } catch (IOException ex) {
            System.out.println("Errore scrittura log" + ex);
        }
    }
}
