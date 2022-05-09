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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author giuliobmb
 */
public class GestoreFile {
    private String nomeBin;
    private String fileLogs;

    public GestoreFile(String fileUtenti, String fileLogs) {
        this.nomeBin = fileUtenti;
        this.fileLogs = fileLogs;

    }
    
    public GestoreFile() {
        this.nomeBin = "utenti.bin";
        this.fileLogs = "logs.log";
        this.fileLogs = "logs.log";

    }
    
    public ArrayList<Utente> leggiUtenti(){
        try {
            FileInputStream f = new FileInputStream(this.nomeBin);
            ObjectInputStream s = new ObjectInputStream(f);
            ArrayList<Utente> a = (ArrayList<Utente>)s.readObject();
            f.close();
            return a;
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("errore leggiUtenti: " + ex);
        }

        return null;
    }
    
    public void scriviUtenti(ArrayList<Utente> a){
        try {
            FileOutputStream f = new FileOutputStream(this.nomeBin);
            ObjectOutputStream s = new ObjectOutputStream(f);
            s.writeObject(a);
            f.close();
        } catch (IOException ex) {
            System.out.println("errore scriviUtenti" + ex);
        }
    }
    
    public void printLog(String log){
        try {
            FileWriter logsFile = new FileWriter(this.fileLogs, true);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
            LocalDateTime now = LocalDateTime.now();  
            logsFile.write(dtf.format(now) + " | " + log + "\n");
            logsFile.close();
        } catch (IOException ex) {
            System.out.println("Errore scrittura log" + ex);
        }
    }
    
}
