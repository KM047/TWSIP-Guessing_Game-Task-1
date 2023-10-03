/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.ui;

import java.awt.Image;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.*;
import javax.swing.JOptionPane;

/**
 *
 * @author kunal
 */
public class DemoGame_1 extends JFrame {
    
    private int randomNumber;
    
    private boolean isGameWon;
    
    private int attempts;

    
    
    
     
    

    /**
     * Creates new form DemoGame_1
     */
    public DemoGame_1() {
        initComponents();
        initializeValue();
        ScaleImage();
    }

    
    public void ScaleImage(){
        
        ImageIcon icon = new ImageIcon("C:\\Users\\kunal\\Downloads\\background-2.png");
        Image img = icon.getImage();
        Image imgSacle = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgSacle);
        label.setIcon(scaledIcon);
        
    }
    
    private void initializeValue(){
        
        Random random = new Random();
        randomNumber = random.nextInt(100) + 1;
        attempts = 0;
        attempts = 10;
        isGameWon = false;
        
    }
        
        
    
    private void GuessNumber(){
        
        if (isGameWon) {
            return;
            
        }
        
        try {
            
            String user = tfInput.getText();

            int user_input = Integer.parseInt(user);

            if(user_input < 0 || user_input > 100){

            JOptionPane.showMessageDialog(this,"Please enter a number between 1 and 100.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                tfInput.setText("");
                return;

        }
            
        take_attempts++;
        attempts--;
        
        
        if (attempts == 0){

            displayMessage("You have run out of tries");

            JOptionPane.showMessageDialog(this, "You have run out of tries");
            try {
                Thread.sleep(1000);
                this.dispose();
            } catch (InterruptedException ex) {
                Logger.getLogger(GameUi.class.getName()).log(Level.SEVERE, null, ex);
            }
            new GameOverUi().setVisible(true);

            
        }
        
        
        
        
        if (randomNumber == user_input) {

            displayMessage("You win!");
            JOptionPane.showMessageDialog(this, "You win!");
            isGameWon = true;
            btnSubmit.setEnabled(false); 
            try {
                Thread.sleep(1000);
                this.dispose();
            } catch (InterruptedException ex) {
                Logger.getLogger(GameUi.class.getName()).log(Level.SEVERE, null, ex);
            }
            new StartingUi().setVisible(true);

            

        }

        else if (randomNumber < user_input) {

//                System.out.println("Your guess number is high, try again.");
            displayMessage("Your guess number is high, try again.");
        }
        else if (randomNumber > user_input){

//                System.out.println("Too low, try again.");
            displayMessage("Too low, try again.");


        }

        
            
        } 
        
        catch (NumberFormatException e) {
            
            displayMessage("Please enter a valid number between 1 and 100.");
        }
        
        lblatempt.setText(""+attempts+"");
        lblchance.setText(""+take_attempts+"");
    }
    
    private void displayMessage(String message) {
        tfOutput.setText(message);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tfInput = new javax.swing.JTextField();
        btnSubmit = new javax.swing.JButton();
        tfOutput = new javax.swing.JTextField();
        lblatempt = new javax.swing.JLabel();
        lblchance = new javax.swing.JLabel();
        label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Game");
        setAlwaysOnTop(true);
        setMinimumSize(new java.awt.Dimension(500, 500));
        setSize(new java.awt.Dimension(500, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Enter Your Number");
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 102, 255)));
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 211, 56));

        tfInput.setFont(new java.awt.Font("Segoe Print", 1, 24)); // NOI18N
        tfInput.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuessNumber();
            }
        });
        getContentPane().add(tfInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 108, 70));

        btnSubmit.setBackground(new java.awt.Color(51, 255, 255));
        btnSubmit.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        btnSubmit.setText("Submit");
        btnSubmit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        btnSubmit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                GuessNumber();
            }
        });
        getContentPane().add(btnSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, 108, 49));

        tfOutput.setBackground(new java.awt.Color(0, 0, 0));
        tfOutput.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        tfOutput.setForeground(new java.awt.Color(255, 51, 51));
        tfOutput.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfOutput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfOutputActionPerformed(evt);
            }
        });
        getContentPane().add(tfOutput, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 410, 300, 50));

        lblatempt.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        lblatempt.setForeground(new java.awt.Color(255, 51, 51));
        lblatempt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblatempt.setText("0");
        lblatempt.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Attempt Take", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe Print", 1, 10), new java.awt.Color(255, 51, 51))); // NOI18N
        getContentPane().add(lblatempt, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 90, 60));

        lblchance.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        lblchance.setForeground(new java.awt.Color(51, 255, 51));
        lblchance.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblchance.setText("10");
        lblchance.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chance left", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe Print", 1, 10), new java.awt.Color(51, 255, 51))); // NOI18N
        getContentPane().add(lblchance, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, 90, 60));

        label.setMinimumSize(new java.awt.Dimension(500, 500));
        getContentPane().add(label, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        
        // This is logic 

        
        
            
        String user = tfInput.getText();

        int user_input = Integer.parseInt(user);

        if(user_input < 0 || user_input > 100){

            tfInput.setText("");
            tfOutput.setText("Invalid Number");

        }

        if (attempts < 0){

            displayMessage("You have run out of tries");

            JOptionPane.showMessageDialog(DemoGame_1.this, "You have run out of tries");
            try {
                Thread.sleep(1000);
                this.dispose();
            } catch (InterruptedException ex) {
                Logger.getLogger(DemoGame_1.class.getName()).log(Level.SEVERE, null, ex);
            }
            new GameOverUi().setVisible(true);

            
        }
//            


        if (randomNumber == user_input) {

            displayMessage("You win!");
            JOptionPane.showMessageDialog(DemoGame_1.this, "You win!");
            try {
                Thread.sleep(1000);
                this.dispose();
            } catch (InterruptedException ex) {
                Logger.getLogger(DemoGame_1.class.getName()).log(Level.SEVERE, null, ex);
            }
            new StartingUi().setVisible(true);

            

        }

        else if (randomNumber < user_input) {

//                System.out.println("Your guess number is high, try again.");
            displayMessage("Your guess number is high, try again.");
        }
        else {

//                System.out.println("Too low, try again.");
            displayMessage("Too low, try again.");


        }
        
//            System.out.println(attempts);
//                
//            System.out.println(take_attempts);
//            take_attempts++;
            
//            lblatempt.setText(Integer.toString(attempts));
//            lblchance.setText(Integer.toString(take_attempts));

        
    }                                         

    private void tfInputActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    private void tfOutputActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        
    

    int take_attempts = 1;
    private void btnSubmitKeyPressed(java.awt.event.KeyEvent evt) {                                     
        // TODO add your handling code here:
        
        attempts++; 
        lblatempt.setText(Integer.toString(attempts)); 
        
        take_attempts--; 
        lblchance.setText(Integer.toString(take_attempts)); 
        
        
    }                                    

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DemoGame_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DemoGame_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DemoGame_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DemoGame_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DemoGame_1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel label;
    private javax.swing.JLabel lblatempt;
    private javax.swing.JLabel lblchance;
    private javax.swing.JTextField tfInput;
    private javax.swing.JTextField tfOutput;
    // End of variables declaration                   
}