/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Moi
 */
public class IHMPrincipale extends javax.swing.JFrame implements ActionListener {

    JMenuBar menuBar;
    JMenu fileMenu, fileSauvegarde;
    JMenuItem lancer, Sauvegarder;
    private IHMRegle ihm = new IHMRegle();
    private Random r;
    private int points;
    private int numDrap, nbpoints = 0;
    private String compreponse;
    private Color BulgarieV = new Color(0, 155, 117);
    private Color BulgarieR = new Color(208, 28, 31);
    private Color AutricheR = new Color(239, 51, 64);
    private Color IndeV = new Color(18, 136, 7);
    private Color IndeB = new Color(0, 0, 136);
    private Color IndeO = new Color(255, 153, 51);
    private Color RussieR = new Color(213, 43, 30);
    private Color RussieB = new Color(0, 57, 166);
    private Color ArmenieR = new Color(217, 0, 18);
    private Color ArmenieB = new Color(0, 51, 160);
    private Color ArmenieO = new Color(242, 168, 0);
    private Color JaponR = new Color(188, 0, 45);
    private Color LaosR = new Color(206, 17, 38);
    private Color LaosB = new Color(0, 40, 104);
    private Color PakistanV = new Color(1, 65, 28);
    private Color AllemagneN = new Color(0, 0, 0);
    private Color AllemagneR = new Color(255, 0, 0);
    private Color AllemagneO = new Color(255, 204, 0);
    private Color FranceB = new Color(0, 85, 164);
    private Color FranceR = new Color(239, 65, 53);
    private boolean Russie = false, blanc = false, Inde = false, Autriche = false, Bulgarie = false, Armenie = false, Japon = false, Laos = false, Pakistan = false, Allemagne = false,
            france = false;

    public IHMPrincipale() {
        initComponents();
        menuBar = new JMenuBar();
        fileMenu = new JMenu("Jouer");
        fileSauvegarde = new JMenu("Sauvegarde");
        lancer = new JMenuItem("Lancer");
        Sauvegarder = new JMenuItem("Sauvegarder");
        lancer.addActionListener(this);
        Sauvegarder.addActionListener(this);
        fileMenu.add(lancer);
        fileSauvegarde.add(Sauvegarder);
        menuBar.add(fileMenu);
        menuBar.add(fileSauvegarde);
        this.setJMenuBar(menuBar);
        charger();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == lancer) {
            Jeu();
        }
        if (e.getSource() == Sauvegarder) {
            write();
        }
    }

    public void charger() {
        read();
        jLabelnbPoints1.setText("" + points);
    }

    public void read() {
        try {
            InputStream ips = new FileInputStream("src/Donnees.txt");
            InputStreamReader ipsr = new InputStreamReader(ips);
            BufferedReader br = new BufferedReader(ipsr);
            points = Integer.parseInt(br.readLine());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(IHMPrincipale.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(IHMPrincipale.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void write() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("src/Donnees.txt"));
            bw.write(String.valueOf(nbpoints));
            bw.flush();
            bw.newLine();
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(IHMPrincipale.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void check() {
        if (nbpoints > points) {
            jLabelnbPoints1.setText("" + nbpoints);
            write();
        }
    }

    public void Jeu() {
        check();
        numero();
        clear();
        comparaison();
        jPanel1.repaint();
    }

    public void numero() {
        r = new Random();
        numDrap = r.nextInt(10);
    }

    public void clear() {
        Russie = false;
        Inde = false;
        Autriche = false;
        Bulgarie = false;
        Armenie = false;
        Japon = false;
        Laos = false;
        Pakistan = false;
        Allemagne = false;
        france = false;
        blanc = true;
    }

    public void comparaison() {
        if (numDrap == 0) {
            Russie = true;
            compreponse = "Russie";
        }
        if (numDrap == 1) {
            Inde = true;
            compreponse = "Inde";
        }
        if (numDrap == 2) {
            Autriche = true;
            compreponse = "Autriche";
        }
        if (numDrap == 3) {
            Bulgarie = true;
            compreponse = "Bulgarie";
        }
        if (numDrap == 4) {
            Armenie = true;
            compreponse = "Arménie";
        }
        if (numDrap == 5) {
            Japon = true;
            compreponse = "Japon";
        }
        if (numDrap == 6) {
            Laos = true;
            compreponse = "Laos";
        }
        if (numDrap == 7) {
            Pakistan = true;
            compreponse = "Pakistan";
        }
        if (numDrap == 8) {
            Allemagne = true;
            compreponse = "Allemagne";
        }
        if(numDrap == 9) {
            france = true;
            compreponse = "France";
        }
    }

    public void point() {
        jLabelnbPoints.setText("" + nbpoints);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel(){
            public void paintComponent(Graphics g)   {
                if(blanc){
                    g.setColor(Color.WHITE);
                    for(int i=0;i < 500 ; i++){
                        g.drawLine(0,i,1000,i);
                    }
                    g.setColor(Color.BLACK);
                    g.drawLine(0,0,999,0);
                    g.drawLine(999,0,999,500);
                    g.drawLine(0,0,0,500);
                    g.drawLine(0,499,999,499);
                }
                if(Allemagne){
                    g.setColor(AllemagneN);
                    for(int i=0;i < 166 ; i++){
                        g.drawLine(0, i, 1000, i);
                    }
                    g.setColor(AllemagneR);
                    for(int i=166;i < 333 ; i++){
                        g.drawLine(0, i, 1000, i);
                    }
                    g.setColor(AllemagneO);
                    for(int i=333;i < 500 ; i++){
                        g.drawLine(0, i, 1000, i);
                    }
                }
                if(Pakistan){
                    g.setColor(PakistanV);
                    for(int i=0;i < 500 ; i++){
                        g.drawLine(0,i,1000,i);
                    }
                    g.setColor(Color.WHITE);
                    g.drawOval(350, 200, 150, 150);
                    g.fillOval(350, 200, 150, 150);
                    g.setColor(PakistanV);
                    g.drawOval(380, 170, 150, 150);
                    g.fillOval(380, 170, 150, 150);
                }
                if(Laos){
                    g.setColor(LaosR);
                    for(int i=0;i < 166 ; i++){
                        g.drawLine(0, i, 1000, i);
                    }
                    g.setColor(LaosB);
                    for(int i=166;i < 333 ; i++){
                        g.drawLine(0, i, 1000, i);
                    }
                    g.setColor(LaosR);
                    for(int i=333;i < 500 ; i++){
                        g.drawLine(0, i, 1000, i);
                    }
                    g.setColor(Color.WHITE);
                    g.drawOval(430, 170, 150, 150);
                    g.fillOval(430, 170, 150, 150);
                }
                if(Armenie){
                    g.setColor(ArmenieR);
                    for(int i=0;i < 166 ; i++){
                        g.drawLine(0, i, 1000, i);
                    }
                    g.setColor(ArmenieB);
                    for(int i=166;i < 333 ; i++){
                        g.drawLine(0, i, 1000, i);
                    }
                    g.setColor(ArmenieO);
                    for(int i=333;i < 500 ; i++){
                        g.drawLine(0, i, 1000, i);
                    }
                }
                if(Bulgarie){
                    g.setColor(Color.WHITE);
                    for(int i=0;i < 166 ; i++){
                        g.drawLine(0, i, 1000, i);
                    }
                    g.setColor(BulgarieV);
                    for(int i=166;i < 333 ; i++){
                        g.drawLine(0, i, 1000, i);
                    }
                    g.setColor(BulgarieR);
                    for(int i=333;i < 500 ; i++){
                        g.drawLine(0, i, 1000, i);
                    }
                }
                if(Autriche){
                    g.setColor(AutricheR);
                    for(int i=0;i < 166 ; i++){
                        g.drawLine(0, i, 1000, i);
                    }
                    g.setColor(Color.WHITE);
                    for(int i=166;i < 333 ; i++){
                        g.drawLine(0, i, 1000, i);
                    }
                    g.setColor(AutricheR);
                    for(int i=333;i < 500 ; i++){
                        g.drawLine(0, i, 1000, i);
                    }
                }
                if(Russie){
                    g.setColor(Color.WHITE);
                    for(int i=0;i < 166 ; i++){
                        g.drawLine(0, i, 1000, i);
                    }
                    g.setColor(RussieB);
                    for(int i=166;i < 333 ; i++){
                        g.drawLine(0, i, 1000, i);
                    }
                    g.setColor(RussieR);
                    for(int i=333;i < 500 ; i++){
                        g.drawLine(0, i, 1000, i);
                    }
                }
                if(france){
                    g.setColor(FranceB);
                    for(int i=0;i < 333 ; i++){
                        g.drawLine(i, 0, i, 1000);
                    }
                    g.setColor(Color.WHITE);
                    for(int i=333;i < 666 ; i++){
                        g.drawLine(i, 0, i, 1000);
                    }
                    g.setColor(FranceR);
                    for(int i=666;i < 1000 ; i++){
                        g.drawLine(i, 0, i, 1000);
                    }
                }
                if(Japon){
                    g.setColor(JaponR);
                    g.drawOval(430, 170, 150, 150);
                    g.fillOval(430, 170, 150, 150);
                }
                if(Inde){
                    g.setColor(IndeO);
                    for(int i=0;i < 166 ; i++){
                        g.drawLine(0, i, 1000, i);
                    }
                    g.setColor(Color.WHITE);
                    for(int i=166;i < 333 ; i++){
                        g.drawLine(0, i, 1000, i);
                    }
                    g.setColor(IndeV);
                    for(int i=333;i < 500 ; i++){
                        g.drawLine(0, i, 1000, i);
                    }
                    g.setColor(IndeB);
                    g.drawOval(430, 170, 150, 150);
                    g.drawOval(490, 230, 25, 25);
                    g.fillOval(490, 230, 25, 25);

                }
            }
        };
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jTextFieldReponse = new javax.swing.JTextField();
        jButtonQuitter = new javax.swing.JButton();
        jButtonRegles = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabelPoints = new javax.swing.JLabel();
        jLabelnbPoints = new javax.swing.JLabel();
        jLabelnbPoints1 = new javax.swing.JLabel();
        jLabelPoints1 = new javax.swing.JLabel();
        jButtonRegles1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Jeu - Devines le drapeau !");

        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel1MouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Devinez le drapeau représenté ci-dessus :");

        jTextFieldReponse.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldReponseKeyPressed(evt);
            }
        });

        jButtonQuitter.setText("Quitter");
        jButtonQuitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQuitterActionPerformed(evt);
            }
        });

        jButtonRegles.setText("Règles");
        jButtonRegles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReglesActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabelPoints.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelPoints.setText("Vos points :");

        jLabelnbPoints.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelnbPoints.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelnbPoints.setText("0");

        jLabelnbPoints1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelnbPoints1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabelPoints1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelPoints1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelPoints1.setText("Record :");

        jButtonRegles1.setText("Pays au hasard");
        jButtonRegles1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegles1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(300, 300, 300))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonRegles, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(355, 355, 355)
                        .addComponent(jButtonRegles1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonQuitter, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabelnbPoints, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelPoints, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldReponse))
                        .addGap(239, 239, 239)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabelnbPoints1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelPoints1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabelPoints))
                        .addGap(18, 18, 18)
                        .addComponent(jLabelnbPoints, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelPoints1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelnbPoints1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldReponse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonQuitter, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonRegles, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonRegles1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldReponseKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldReponseKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String reponse = jTextFieldReponse.getText();
            if (compreponse.equals(reponse)) {
                jLabel2.setText("Correct, vous avez deviné " + reponse);
                nbpoints++;
                point();
                compreponse = "";
                Jeu();
            } else {
                jLabel2.setText("Faux, vous aurez plus de chance la prochaine fois");
                nbpoints--;
                point();
            }
        }
    }//GEN-LAST:event_jTextFieldReponseKeyPressed

    private void jButtonQuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuitterActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButtonQuitterActionPerformed

    private void jButtonReglesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReglesActionPerformed
        ihm.setVisible(true);
    }//GEN-LAST:event_jButtonReglesActionPerformed

    private void jPanel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseEntered

    }//GEN-LAST:event_jPanel1MouseEntered

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        jLabel2.setText("Le pays était " + compreponse);
        nbpoints = nbpoints - 2;
        point();
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jButtonRegles1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegles1ActionPerformed
        Jeu();
    }//GEN-LAST:event_jButtonRegles1ActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IHMPrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IHMPrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IHMPrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IHMPrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IHMPrincipale().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonQuitter;
    private javax.swing.JButton jButtonRegles;
    private javax.swing.JButton jButtonRegles1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelPoints;
    private javax.swing.JLabel jLabelPoints1;
    private javax.swing.JLabel jLabelnbPoints;
    private javax.swing.JLabel jLabelnbPoints1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextFieldReponse;
    // End of variables declaration//GEN-END:variables

}
