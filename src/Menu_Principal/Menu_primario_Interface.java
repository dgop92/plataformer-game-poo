package Menu_Principal;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Menu_primario_Interface extends javax.swing.JFrame {

    boolean sw = false;

    public Menu_primario_Interface() {
        initComponents();

        //Fondo.setSize(500, 500);
         //String path = "/Menu_Principal/mando2.png";

        //URL url = this.getClass().getResource(path);
//System.out.println(this.getClass().getResource(path));
        //Image img = new ImageIcon(this.getClass().getResource(path)).getImage();
       
        //ImageIcon img2 = new ImageIcon(img.getScaledInstance(500, 500, Image.SCALE_SMOOTH));

        //Fondo.setIcon(img2);
        //this.repaint();
        Music_off.setVisible(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Music_off = new javax.swing.JLabel();
        Nota = new javax.swing.JLabel();
        empezar = new javax.swing.JButton();
        musica = new javax.swing.JButton();
        controles = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(900, 800));
        getContentPane().setLayout(null);

        Music_off.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Music_off.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Menu_Principal/equiz_roja.png"))); // NOI18N
        getContentPane().add(Music_off);
        Music_off.setBounds(740, 0, 90, 70);

        Nota.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Nota.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Menu_Principal/nota.png"))); // NOI18N
        getContentPane().add(Nota);
        Nota.setBounds(760, 10, 50, 50);

        empezar.setBackground(new java.awt.Color(204, 255, 204));
        empezar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        empezar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Menu_Principal/cartel_empezar2.png"))); // NOI18N
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

        musica.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        musica.setText("MUSIC ON");
        musica.setBorderPainted(false);
        musica.setContentAreaFilled(false);
        musica.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        musica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                musicaActionPerformed(evt);
            }
        });
        getContentPane().add(musica);
        musica.setBounds(710, 50, 150, 31);

        controles.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        controles.setForeground(new java.awt.Color(255, 255, 153));
        controles.setText("CONTROLES");
        controles.setBorderPainted(false);
        controles.setContentAreaFilled(false);
        controles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                controlesActionPerformed(evt);
            }
        });
        getContentPane().add(controles);
        controles.setBounds(680, 560, 160, 40);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Menu_Principal/mando2.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(710, 480, 110, 90);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 153));
        jButton1.setText("CREDITOS");
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        getContentPane().add(jButton1);
        jButton1.setBounds(10, 580, 130, 31);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Menu_Principal/creditos2.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 500, 90, 80);

        Fondo.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        Fondo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Menu_Principal/pixil-gif-drawing (2).gif"))); // NOI18N
        Fondo.setToolTipText("");
        Fondo.setRequestFocusEnabled(false);
        getContentPane().add(Fondo);
        Fondo.setBounds(0, 0, 830, 620);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void musicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_musicaActionPerformed
        sw = !sw;
        Music_off.setVisible(sw);
        if (sw)
            musica.setText("MUSIC OFF");
        else
            musica.setText("MUSIC ON");
    }//GEN-LAST:event_musicaActionPerformed

    private void controlesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_controlesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_controlesActionPerformed

    private void empezarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empezarActionPerformed
      
    }//GEN-LAST:event_empezarActionPerformed

    private void empezarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_empezarMousePressed
       empezar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Menu_Principal/cartel_iluminado.png")));
    }//GEN-LAST:event_empezarMousePressed

    private void empezarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_empezarMouseReleased
         empezar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Menu_Principal/cartel_empezar2.png")));
    }//GEN-LAST:event_empezarMouseReleased

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_primario_Interface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    private javax.swing.JLabel Music_off;
    private javax.swing.JLabel Nota;
    private javax.swing.JButton controles;
    private javax.swing.JButton empezar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton musica;
    // End of variables declaration//GEN-END:variables
}
