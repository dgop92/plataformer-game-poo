package interfaces;


public class Controls extends javax.swing.JFrame {

    boolean sw = false;

    public Controls() {
        initComponents();


    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        empezar = new javax.swing.JButton();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(900, 800));
        getContentPane().setLayout(null);

        empezar.setBackground(new java.awt.Color(204, 255, 204));
        empezar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        empezar.setBorderPainted(false);
        empezar.setContentAreaFilled(false);
        empezar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        empezar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        empezar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empezarActionPerformed(evt);
            }
        });
        getContentPane().add(empezar);
        empezar.setBounds(60, 550, 130, 40);

        Fondo.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        Fondo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/interfaces/controls2.png"))); // NOI18N
        Fondo.setToolTipText("");
        Fondo.setRequestFocusEnabled(false);
        getContentPane().add(Fondo);
        Fondo.setBounds(-30, -120, 830, 740);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void empezarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empezarActionPerformed
    
        this.dispose();
    }//GEN-LAST:event_empezarActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Controls().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    private javax.swing.JButton empezar;
    // End of variables declaration//GEN-END:variables
}
