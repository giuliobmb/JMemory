/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Frontend;

import Backend.GestoreFile;
import Backend.GestoreUtenti;
import Backend.Utente;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * @author Studente Turno B
 */

public class LoginPanel extends JPanel {

    private JLabel nameLabel;
    private JTextField nickLabel;
    private JTextField pwdLabel;
    private JLabel jcomp4;
    private JLabel jcomp5;
    private JButton loginBtn;
    private JButton registerBtn;
    private JLabel errorLabel;
    private Utente utente;
    private GestoreUtenti g;
    private GestoreFile f;

    public LoginPanel(GestoreUtenti g) {
        //construct components
        nameLabel = new JLabel("JMemory - Login");
        nickLabel = new JTextField(5);
        pwdLabel = new JTextField(5);
        jcomp4 = new JLabel("Nickname");
        jcomp5 = new JLabel("Password");
        loginBtn = new JButton("Login");
        registerBtn = new JButton("Register");
        errorLabel = new JLabel("");

        //set components properties
        nickLabel.setToolTipText("type your nickname");
        pwdLabel.setToolTipText("type your password");

        //adjust size and set layout
        setPreferredSize(new Dimension(752, 430));
        setLayout(null);

        //add components
        add(nameLabel);
        add(nickLabel);
        add(pwdLabel);
        add(jcomp4);
        add(jcomp5);
        add(loginBtn);
        add(registerBtn);
        add(errorLabel);

        //set component bounds (only needed by Absolute Positioning)
        nameLabel.setBounds(315, 5, 100, 50);
        nickLabel.setBounds(305, 75, 170, 25);
        pwdLabel.setBounds(305, 115, 170, 25);
        jcomp4.setBounds(230, 75, 100, 25);
        jcomp5.setBounds(230, 110, 100, 25);
        loginBtn.setBounds(305, 175, 100, 25);
        registerBtn.setBounds(305, 235, 100, 25);
        errorLabel.setBounds(305, 270, 300, 25);

        this.g = g;
        this.f = new GestoreFile();

        this.utente = null;
        this.initListeners();

    }

    public void initListeners() {
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == loginBtn)
                    handleLogin();
                else if(e.getSource() == registerBtn)
                    handleRegister();
            }
            

        };

        loginBtn.addActionListener(listener);
        registerBtn.addActionListener(listener);
    }

    public void handleLogin() {
        if (nickLabel.getText().compareToIgnoreCase("") != 0 && pwdLabel.getText().compareToIgnoreCase("") != 0) {
            Utente u = g.logUtente(nickLabel.getText(), pwdLabel.getText());
            if (u != null) {
                this.utente = u;
                Main.lS.release();
            } else {
                errorLabel.setText("nickname o password non validi");
            }
        } else {
            errorLabel.setText("campi invalidi");
        }
    }
    
    public void handleRegister(){
        JFrame frame = new JFrame ("JMemory - Registrati");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.add(new RegisterPanel(g));
        frame.pack();
        frame.setVisible (true);
        
        try {
            Main.rS.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(LoginPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        frame.setVisible(false);
        
    }
    
    public Utente getUtente(){
        return this.utente;
    }

}
