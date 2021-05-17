package interfaces;

import plataformer.map.GameSketch;
import plataformer.map.ScreenSize;

public class MainMenu extends javax.swing.JFrame {

    boolean sw = false;

    public MainMenu() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        empezar = new javax.swing.JButton();
        controles = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(900, 800));
        getContentPane().setLayout(null);

        empezar.setBackground(new java.awt.Color(204, 255, 204));
        empezar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        empezar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/interfaces/cartel_empezar2.png"))); // NOI18N
        empezar.setBorderPainted(false);
        empezar.setContentAreaFilled(false);
        empezar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        empezar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        empezar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                empezarMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                empezarMouseReleased(evt);
            }
        });
        empezar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empezarActionPerformed(evt);
            }
        });
        getContentPane().add(empezar);
        empezar.setBounds(270, 310, 250, 70);

        controles.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        controles.setForeground(new java.awt.Color(255, 255, 153));
        controles.setText("CONTROLES");
        controles.setBorderPainted(false);
        controles.setContentAreaFilled(false);
        controles.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        controles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                controlesActionPerformed(evt);
            }
        });
        getContentPane().add(controles);
        controles.setBounds(680, 470, 160, 130);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/interfaces/mando2.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(710, 480, 110, 90);

        Fondo.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        Fondo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/interfaces/pixil-gif-drawing (2).gif"))); // NOI18N
        Fondo.setToolTipText("");
        Fondo.setRequestFocusEnabled(false);
        getContentPane().add(Fondo);
        Fondo.setBounds(0, 0, 830, 620);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void controlesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_controlesActionPerformed
        Controls controls = new Controls();
        controls.setBounds(GUIUtils.getBounds(744, 656));
        controls.setVisible(true);
    }//GEN-LAST:event_controlesActionPerformed

    private void empezarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empezarActionPerformed
        GameSketch g = new GameSketch();
        g.setScreenSize(new ScreenSize(768, 768, 48));
        g.run();
        this.dispose();
    }//GEN-LAST:event_empezarActionPerformed

    private void empezarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_empezarMousePressed
        empezar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/interfaces/cartel_iluminado.png")));
    }//GEN-LAST:event_empezarMousePressed

    private void empezarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_empezarMouseReleased
        empezar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/interfaces/cartel_empezar2.png")));
    }//GEN-LAST:event_empezarMouseReleased

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    private javax.swing.JButton controles;
    private javax.swing.JButton empezar;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
