/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Frontend;

/**
 *
 * @author Studente Turno B
 */
import Backend.GestoreUtenti;
import Backend.Utente;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.*;

public class RegisterPanel extends JPanel {
    private JLabel nameLabel;
    private JTextField nickLabel;
    private JTextField pwdLabel;
    private JLabel jcomp4;
    private JLabel jcomp5;
    private JButton registerBtn;
    private JLabel errorLabel;
    private GestoreUtenti g;

    public RegisterPanel(GestoreUtenti g) {
        
        //construct components
        nameLabel = new JLabel ("JMemory - Registrati");
        nickLabel = new JTextField (5);
        pwdLabel = new JTextField (5);
        jcomp4 = new JLabel ("Nickname");
        jcomp5 = new JLabel ("Password");
        registerBtn = new JButton ("Registrati");
        errorLabel = new JLabel ("");

        //set components properties
        nickLabel.setToolTipText ("type your nickname");
        pwdLabel.setToolTipText ("type your password");

        //adjust size and set layout
        setPreferredSize (new Dimension (752, 430));
        setLayout (null);

        //add components
        add (nameLabel);
        add (nickLabel);
        add (pwdLabel);
        add (jcomp4);
        add (jcomp5);
        add (registerBtn);
        add (errorLabel);

        //set component bounds (only needed by Absolute Positioning)
        nameLabel.setBounds (315, 5, 180, 50);
        nickLabel.setBounds (305, 75, 170, 25);
        pwdLabel.setBounds (305, 115, 170, 25);
        jcomp4.setBounds (230, 75, 100, 25);
        jcomp5.setBounds (230, 110, 100, 25);
        registerBtn.setBounds (305, 175, 100, 25);
        errorLabel.setBounds (305, 230, 250, 35);
        
        initListeners();
        this.g = g;

    }
    
    public void initListeners() {
        ActionListener Listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(e.getSource() == registerBtn)
                    handleRegister();    
            }
        };
        registerBtn.addActionListener(Listener);
    }

    
    public void handleRegister() {
        if (nickLabel.getText().compareToIgnoreCase("") != 0 && pwdLabel.getText().compareToIgnoreCase("") != 0) {
            g.addUtente(new Utente(nickLabel.getText(), pwdLabel.getText()));
            System.out.println("utente aggiunto");
            errorLabel.setText("");
        } else {
            errorLabel.setText("campi invalidi");
        }
        
        
    }

}