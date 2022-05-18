/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/AWTForms/Frame.java to edit this template
 */
package Frontend;

import Backend.GestoreFile;
import Backend.GestoreUtenti;
import Backend.Partita;
import Backend.Utente;
import java.awt.GridLayout;
import java.awt.Label;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author giuliobmb
 */
public class MemoryGame extends java.awt.Frame {

    /**
     * Creates new form MemoryGame
     */
    
    private GestoreUtenti g;
    private GestoreFile f;
    private Utente utente;
    private Utente avversario;
    private Partita p;
    private int logMode;
    private int gameMode;
    private int ntessere;
    
    public MemoryGame() {
        initComponents();
        g = new GestoreUtenti();
        f = new GestoreFile();
        logMode = 0;
        GridLayout l = new GridLayout(4, 4);
        l.setHgap(20);
        l.setVgap(20);
        this.tesserePanel.setLayout(l);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LoginForm = new javax.swing.JFrame();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        label3 = new java.awt.Label();
        nickField = new java.awt.TextField();
        pwdField = new java.awt.TextField();
        loginBtn = new java.awt.Button();
        regBtn = new java.awt.Button();
        errorLabel = new java.awt.Label();
        RegisterForm = new javax.swing.JFrame();
        label4 = new java.awt.Label();
        nickLabel = new java.awt.TextField();
        pwdLabel = new java.awt.TextField();
        label5 = new java.awt.Label();
        label6 = new java.awt.Label();
        registerBtn = new java.awt.Button();
        CambiaPassword = new javax.swing.JFrame();
        jLabel1 = new javax.swing.JLabel();
        newPwdLabel = new java.awt.TextField();
        cambiaPwd = new java.awt.Button();
        Lobby = new javax.swing.JFrame();
        nicknameLabel = new javax.swing.JLabel();
        winsLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        label7 = new java.awt.Label();
        onevsone = new java.awt.Button();
        solitario = new java.awt.Button();
        onevsai = new java.awt.Button();
        lobbyPassword = new java.awt.Button();
        classificaBtn = new java.awt.Button();
        Classifica = new javax.swing.JFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        classificaL = new javax.swing.JList<>();
        jSeparator1 = new javax.swing.JSeparator();
        tesserePanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        utenteLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        puntiU = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        avversarioLabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        puntiA = new javax.swing.JLabel();

        LoginForm.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        LoginForm.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        label1.setText("JMemory - Login");
        LoginForm.getContentPane().add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 210, 60));

        label2.setText("Nickname");
        LoginForm.getContentPane().add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, -1, -1));

        label3.setText("Password");
        LoginForm.getContentPane().add(label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, -1, -1));

        nickField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        LoginForm.getContentPane().add(nickField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 120, -1));
        LoginForm.getContentPane().add(pwdField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 120, -1));

        loginBtn.setLabel("Login");
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });
        LoginForm.getContentPane().add(loginBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 120, 50));

        regBtn.setLabel("Registrati");
        regBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regBtnActionPerformed(evt);
            }
        });
        LoginForm.getContentPane().add(regBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 120, 40));
        LoginForm.getContentPane().add(errorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 190, -1));

        RegisterForm.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label4.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        label4.setText("Registrati");
        RegisterForm.getContentPane().add(label4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, -1, -1));
        RegisterForm.getContentPane().add(nickLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 110, -1));
        RegisterForm.getContentPane().add(pwdLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 110, -1));

        label5.setText("Nickname");
        RegisterForm.getContentPane().add(label5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, -1, -1));

        label6.setText("Password");
        RegisterForm.getContentPane().add(label6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, -1, -1));

        registerBtn.setLabel("Registrati");
        registerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerBtnActionPerformed(evt);
            }
        });
        RegisterForm.getContentPane().add(registerBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 180, 40));

        CambiaPassword.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Inserisci la nuova password");
        CambiaPassword.getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 140, 30));
        CambiaPassword.getContentPane().add(newPwdLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 150, 20));

        cambiaPwd.setLabel("Cambia password");
        cambiaPwd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiaPwdActionPerformed(evt);
            }
        });
        CambiaPassword.getContentPane().add(cambiaPwd, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, -1, -1));

        Lobby.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        Lobby.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nicknameLabel.setText("jLabel2");
        Lobby.getContentPane().add(nicknameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        winsLabel.setText("jLabel2");
        Lobby.getContentPane().add(winsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, -1, -1));

        jLabel2.setText("Partite vinte:");
        Lobby.getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        label7.setText("Seleziona modalità");
        Lobby.getContentPane().add(label7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, -1, -1));

        onevsone.setLabel("1VS1");
        onevsone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onevsoneActionPerformed(evt);
            }
        });
        Lobby.getContentPane().add(onevsone, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, -1, -1));

        solitario.setLabel("Solitario");
        solitario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                solitarioActionPerformed(evt);
            }
        });
        Lobby.getContentPane().add(solitario, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, -1, -1));

        onevsai.setLabel("1VSAI");
        onevsai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onevsaiActionPerformed(evt);
            }
        });
        Lobby.getContentPane().add(onevsai, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, -1, -1));

        lobbyPassword.setLabel("Cambia Password");
        lobbyPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lobbyPasswordActionPerformed(evt);
            }
        });
        Lobby.getContentPane().add(lobbyPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 130, 30));

        classificaBtn.setLabel("Visualizza classifica");
        classificaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classificaBtnActionPerformed(evt);
            }
        });
        Lobby.getContentPane().add(classificaBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 140, 30));

        jScrollPane1.setViewportView(classificaL);

        Classifica.getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        setLocationRelativeTo(null);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 640, 0));

        java.awt.GridBagLayout tesserePanelLayout = new java.awt.GridBagLayout();
        tesserePanelLayout.columnWidths = new int[] {0};
        tesserePanelLayout.rowHeights = new int[] {0};
        tesserePanel.setLayout(tesserePanelLayout);
        add(tesserePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 1190, 620));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        utenteLabel.setText("jLabel3");
        jPanel2.add(utenteLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, -1, -1));

        jLabel5.setText("Punteggio: ");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        puntiU.setText("jLabel8");
        jPanel2.add(puntiU, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, -1, -1));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 80));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        avversarioLabel.setText("jLabel4");
        jPanel3.add(avversarioLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, -1, -1));

        jLabel6.setText("Punteggio: ");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        puntiA.setText("jLabel7");
        jPanel3.add(puntiA, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, -1, -1));

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 0, 320, 80));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Exit the Application
     */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        // TODO add your handling code here:
        
        if(nickField.getText().compareToIgnoreCase("") != 0 && pwdField.getText().compareToIgnoreCase("") != 0){
            Utente u = g.logUtente(nickField.getText(), pwdField.getText());

            if(u != null){
                if(this.logMode == 0){
                    this.utente = u;
                    this.LoginForm.setVisible(false);
                    initLobby();
                }else{
                    this.avversario = u;
                    this.logMode = 0;
                    this.gameMode = 1;
                    this.LoginForm.setVisible(false);
                    initGame();
                }
                
            }else{
                errorLabel.setText("nickname o password non validi");
            }

        }else{
            errorLabel.setText("campi invalidi");
        }
        
    }//GEN-LAST:event_loginBtnActionPerformed

    private void lobbyPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lobbyPasswordActionPerformed
        // TODO add your handling code here:
        
        this.CambiaPassword.setSize(this.CambiaPassword.getMinimumSize());
        this.CambiaPassword.setLocationRelativeTo(null);
        this.CambiaPassword.setVisible(true);
        
    }//GEN-LAST:event_lobbyPasswordActionPerformed

    private void cambiaPwdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambiaPwdActionPerformed
        // TODO add your handling code here:
        
        this.g.cambiaPassword(utente, this.newPwdLabel.getText());
        
        this.CambiaPassword.setVisible(false);
        
    }//GEN-LAST:event_cambiaPwdActionPerformed

    private void regBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regBtnActionPerformed
        // TODO add your handling code here:
        this.RegisterForm.setSize(600, 400);
        this.RegisterForm.setLocationRelativeTo(null);
        this.RegisterForm.setVisible(true);
    }//GEN-LAST:event_regBtnActionPerformed

    private void registerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerBtnActionPerformed
        // TODO add your handling code here:
        if(nickLabel.getText().compareToIgnoreCase("") != 0 && pwdLabel.getText().compareToIgnoreCase("") != 0){
            g.addUtente(new Utente(nickLabel.getText(), pwdLabel.getText()));
            errorLabel.setText("");
            this.RegisterForm.setVisible(false);

        }else{
            errorLabel.setText("campi invalidi");
        }
        
    }//GEN-LAST:event_registerBtnActionPerformed

    private void onevsoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onevsoneActionPerformed
        // TODO add your handling code here:
        
        this.logMode = 1;
        this.gameMode = 1;
        this.LoginForm.setLocationRelativeTo(null);
        this.LoginForm.setVisible(true);
        
    }//GEN-LAST:event_onevsoneActionPerformed

    private void solitarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_solitarioActionPerformed
        // TODO add your handling code here:
        this.gameMode = 2;
        this.Lobby.setVisible(false);
        initGame();
        
    }//GEN-LAST:event_solitarioActionPerformed

    private void onevsaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onevsaiActionPerformed
        // TODO add your handling code here:
        this.gameMode = 3;
        this.Lobby.setVisible(false);
        initGame();
        
    }//GEN-LAST:event_onevsaiActionPerformed

    private void classificaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classificaBtnActionPerformed
        // TODO add your handling code here:
        ArrayList<Utente> classifica = 
        
        this.Classifica.setVisible(true);
        
    }//GEN-LAST:event_classificaBtnActionPerformed

    ///////////////////////
    
    private void initLobby(){
        
        this.Lobby.setSize(600, 400);
        this.nicknameLabel.setText(this.utente.getNickName());
        this.winsLabel.setText(String.valueOf(this.utente.getPunti()));
        this.Lobby.setLocationRelativeTo(null);
        this.Lobby.setVisible(true);
        
        
    }
    
    private void initGame(){
        ArrayList<Tessera> t;
        switch (this.gameMode) {
            case 1:
                this.ntessere = 8;
                this.setSize(this.getMinimumSize());
                this.utenteLabel.setText(this.utente.getNickName());
                this.avversarioLabel.setText(this.avversario.getNickName());
                
                this.p = new Partita(this.utente, this.avversario, ntessere);
                t = p.getTessere();
                
                this.puntiA.setText(String.valueOf(this.p.getPuntiA()));
                this.puntiU.setText(String.valueOf(this.p.getPuntiU()));
                
                for (int i = 0; i < t.size(); i++) {
                    t.get(i).addMouseListener(new java.awt.event.MouseAdapter() {
                        @Override
                        public void mouseReleased(java.awt.event.MouseEvent evt) {
                            eventHandle(evt);
                        }
                    });
                    Tessera te = t.get(i);
                    this.tesserePanel.add(te);
                    
                    this.puntiA.setText(String.valueOf(p.getPuntiA()));
                    this.puntiU.setText(String.valueOf(p.getPuntiU()));
                }
                
                this.Lobby.setVisible(false);
                this.setLocationRelativeTo(null);
                this.setVisible(true);
                
                
                
                break;

            case 2:
                this.ntessere = 8;
                this.setSize(this.getMinimumSize());
                this.utenteLabel.setText(this.utente.getNickName());
                this.avversarioLabel.setVisible(false);
                
                this.p = new Partita(this.utente, this.avversario, ntessere);
                t = p.getTessere();
                
                this.puntiA.setText(String.valueOf(this.p.getPuntiA()));
                
                for (int i = 0; i < t.size(); i++) {
                    t.get(i).addMouseListener(new java.awt.event.MouseAdapter() {
                        @Override
                        public void mouseReleased(java.awt.event.MouseEvent evt) {
                            eventHandle(evt);
                        }
                    });
                    Tessera te = t.get(i);
                    this.tesserePanel.add(te);
                    
                    this.puntiA.setText(String.valueOf(p.getPuntiA()));
                    this.puntiU.setText(String.valueOf(p.getPuntiU()));
                }
                
                this.Lobby.setVisible(false);
                this.setLocationRelativeTo(null);
                this.setVisible(true);
                
                
                break;
            case 3:
                
                
                break;
            default:
                break;
        }
        
    }
    
    public void eventHandle(java.awt.event.MouseEvent evt){
        
        p.handleEvent(evt);
        System.out.println("evt");
        //if(gameMode == 1){
            this.puntiA.setText(String.valueOf(p.getPuntiA()));
            this.puntiU.setText(String.valueOf(p.getPuntiU()));
        //}
        this.tesserePanel.removeAll();
        ArrayList<Tessera> t = p.getTessere();
        for (int i = 0; i < t.size(); i++) {
            Tessera te = t.get(i);
            this.tesserePanel.add(te);
        }
        System.out.println(p.getTessere().size());
        if(this.p.getTessere().size() == 0 && this.gameMode == 1){
            this.tesserePanel.removeAll();
            this.revalidate();
            this.repaint();
            Label victory = new Label();
            if(p.getPuntiU() > p.getPuntiA()){
                this.utente.addPunto();
                victory.setText("Vittoria " + p.getUtente().getNickName());
                System.out.println("vittoria utente");//this.add(new JLabel("Vittoria " + p.getUtente().getNickName()));
            }
            else{
                this.avversario.addPunto();
                victory.setText("Vittoria " + p.getAvversario().getNickName());
                System.out.println("vittoria avversario");//this.add(new JLabel("Vittoria " + p.getAvversario().getNickName()));
            }
            //this.tesserePanel.add(victory);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException ex) {
                Logger.getLogger(MemoryGame.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.setVisible(false);
            this.Lobby.setVisible(true);
            
        }else if(this.p.getTessere().size() == 0 && this.gameMode == 2){
            this.setVisible(false);
            this.Lobby.setVisible(true);
        }else if(this.p.getTessere().size() == 0 && this.gameMode == 3){
            this.setVisible(false);
            this.Lobby.setVisible(true);
        }
        
    }

    /////////////////////////
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MemoryGame g = new MemoryGame();
                g.LoginForm.setSize(400, 350);
                g.LoginForm.setLocationRelativeTo(null);
                g.LoginForm.setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame CambiaPassword;
    private javax.swing.JFrame Classifica;
    private javax.swing.JFrame Lobby;
    private javax.swing.JFrame LoginForm;
    private javax.swing.JFrame RegisterForm;
    private javax.swing.JLabel avversarioLabel;
    private java.awt.Button cambiaPwd;
    private java.awt.Button classificaBtn;
    private javax.swing.JList<String> classificaL;
    private java.awt.Label errorLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private java.awt.Label label5;
    private java.awt.Label label6;
    private java.awt.Label label7;
    private java.awt.Button lobbyPassword;
    private java.awt.Button loginBtn;
    private java.awt.TextField newPwdLabel;
    private java.awt.TextField nickField;
    private java.awt.TextField nickLabel;
    private javax.swing.JLabel nicknameLabel;
    private java.awt.Button onevsai;
    private java.awt.Button onevsone;
    private javax.swing.JLabel puntiA;
    private javax.swing.JLabel puntiU;
    private java.awt.TextField pwdField;
    private java.awt.TextField pwdLabel;
    private java.awt.Button regBtn;
    private java.awt.Button registerBtn;
    private java.awt.Button solitario;
    private javax.swing.JPanel tesserePanel;
    private javax.swing.JLabel utenteLabel;
    private javax.swing.JLabel winsLabel;
    // End of variables declaration//GEN-END:variables
}
