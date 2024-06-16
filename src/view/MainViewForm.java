/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import panelView.*;
import java.awt.Color;
import javax.swing.JComponent;

public class MainViewForm extends javax.swing.JFrame {
    private int selectedIndex = -1;

    private void setForm(JComponent com){
        contentPanel.removeAll();
        contentPanel.add(com);
        contentPanel.repaint();
        contentPanel.revalidate();
    }
    
    private void recolorDefaultSwitchPanel(){
        repaint();
        singlePanel.setBackground(new Color(0, 0, 0, 0));
        multiplePanel.setBackground(new Color(0, 0, 0, 0));
        transaksiPanel.setBackground(new Color(0, 0, 0, 0));
        transaksiPanelDate.setBackground(new Color(0, 0, 0, 0));
    }
    
    public MainViewForm() {
        initComponents();
        recolorDefaultSwitchPanel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        sidePanel = new javax.swing.JPanel();
        logoPanel = new javax.swing.JPanel();
        logoIcon = new javax.swing.JLabel();
        logoLabel = new javax.swing.JLabel();
        singlePanel = new javax.swing.JPanel();
        customerLabel = new javax.swing.JLabel();
        multiplePanel = new javax.swing.JPanel();
        kendaraanLabel = new javax.swing.JLabel();
        transaksiPanel = new javax.swing.JPanel();
        transaksiLabel = new javax.swing.JLabel();
        transaksiPanelDate = new javax.swing.JPanel();
        transaksiLabelDate = new javax.swing.JLabel();
        contentPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        sidePanel.setBackground(new java.awt.Color(229, 171, 89));

        logoPanel.setBackground(new java.awt.Color(229, 171, 89));

        logoIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoIcon.setIcon(new javax.swing.ImageIcon("D:\\ATMA\\sem 4\\PBO A\\TubessPBO\\TubesPBO\\src\\icon\\restoo-01.png")); // NOI18N

        logoLabel.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 22)); // NOI18N
        logoLabel.setForeground(new java.awt.Color(137, 92, 3));
        logoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoLabel.setText("RESTO");

        javax.swing.GroupLayout logoPanelLayout = new javax.swing.GroupLayout(logoPanel);
        logoPanel.setLayout(logoPanelLayout);
        logoPanelLayout.setHorizontalGroup(
            logoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(logoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logoIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
                .addContainerGap())
        );
        logoPanelLayout.setVerticalGroup(
            logoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logoPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(logoIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        singlePanel.setBackground(new java.awt.Color(229, 171, 89));
        singlePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                singlePanelMouseClicked(evt);
            }
        });

        customerLabel.setBackground(new java.awt.Color(20, 60, 60));
        customerLabel.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        customerLabel.setForeground(new java.awt.Color(137, 92, 3));
        customerLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        customerLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-order-25.png"))); // NOI18N
        customerLabel.setText("  Menu");

        javax.swing.GroupLayout singlePanelLayout = new javax.swing.GroupLayout(singlePanel);
        singlePanel.setLayout(singlePanelLayout);
        singlePanelLayout.setHorizontalGroup(
            singlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(singlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(customerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        singlePanelLayout.setVerticalGroup(
            singlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(singlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(customerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        multiplePanel.setBackground(new java.awt.Color(229, 171, 89));
        multiplePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                multiplePanelMouseClicked(evt);
            }
        });

        kendaraanLabel.setBackground(new java.awt.Color(20, 60, 60));
        kendaraanLabel.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        kendaraanLabel.setForeground(new java.awt.Color(137, 92, 3));
        kendaraanLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        kendaraanLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-customer-30.png"))); // NOI18N
        kendaraanLabel.setText("Karyawan");

        javax.swing.GroupLayout multiplePanelLayout = new javax.swing.GroupLayout(multiplePanel);
        multiplePanel.setLayout(multiplePanelLayout);
        multiplePanelLayout.setHorizontalGroup(
            multiplePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(multiplePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kendaraanLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        multiplePanelLayout.setVerticalGroup(
            multiplePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(multiplePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kendaraanLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        transaksiPanel.setBackground(new java.awt.Color(229, 171, 89));

        transaksiLabel.setBackground(new java.awt.Color(20, 60, 60));
        transaksiLabel.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        transaksiLabel.setForeground(new java.awt.Color(137, 92, 3));
        transaksiLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        transaksiLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/penitipanIcon.png"))); // NOI18N
        transaksiLabel.setText("Penitipan");
        transaksiLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                transaksiLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout transaksiPanelLayout = new javax.swing.GroupLayout(transaksiPanel);
        transaksiPanel.setLayout(transaksiPanelLayout);
        transaksiPanelLayout.setHorizontalGroup(
            transaksiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transaksiPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(transaksiLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        transaksiPanelLayout.setVerticalGroup(
            transaksiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transaksiPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(transaksiLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                .addContainerGap())
        );

        transaksiPanelDate.setBackground(new java.awt.Color(229, 171, 89));

        transaksiLabelDate.setBackground(new java.awt.Color(229, 171, 89));
        transaksiLabelDate.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        transaksiLabelDate.setForeground(new java.awt.Color(137, 92, 3));
        transaksiLabelDate.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        transaksiLabelDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/penitipanIcon.png"))); // NOI18N
        transaksiLabelDate.setText("Penitipan");
        transaksiLabelDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                transaksiLabelDateMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout transaksiPanelDateLayout = new javax.swing.GroupLayout(transaksiPanelDate);
        transaksiPanelDate.setLayout(transaksiPanelDateLayout);
        transaksiPanelDateLayout.setHorizontalGroup(
            transaksiPanelDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transaksiPanelDateLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(transaksiLabelDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        transaksiPanelDateLayout.setVerticalGroup(
            transaksiPanelDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transaksiPanelDateLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(transaksiLabelDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout sidePanelLayout = new javax.swing.GroupLayout(sidePanel);
        sidePanel.setLayout(sidePanelLayout);
        sidePanelLayout.setHorizontalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(singlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(multiplePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(sidePanelLayout.createSequentialGroup()
                        .addGroup(sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(sidePanelLayout.createSequentialGroup()
                                .addComponent(logoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(transaksiPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(transaksiPanelDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        sidePanelLayout.setVerticalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(singlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(multiplePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(transaksiPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(transaksiPanelDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        contentPanel.setBackground(new java.awt.Color(255, 255, 255));
        contentPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        contentPanel.setOpaque(false);
        contentPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(sidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 799, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void singlePanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_singlePanelMouseClicked
        if(selectedIndex == 1)
            return;
        
        recolorDefaultSwitchPanel();
        singlePanel.setBackground(new Color(255,204,51));
        setForm(new MenuMainPanel());
        selectedIndex = 1;
    }//GEN-LAST:event_singlePanelMouseClicked

    private void multiplePanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_multiplePanelMouseClicked
        if(selectedIndex == 2)
            return;
        
        recolorDefaultSwitchPanel();
        multiplePanel.setBackground(new Color(255,204,51));
        setForm(new KaryawanMainPanel());
        selectedIndex = 2;
    }//GEN-LAST:event_multiplePanelMouseClicked

    private void transaksiLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transaksiLabelMouseClicked
        if(selectedIndex == 3)
            return;
        
        recolorDefaultSwitchPanel();
        transaksiPanel.setBackground(new Color(255,204,51));
        setForm(new DisplayMenuMainPanel());
        selectedIndex = 3;
    }//GEN-LAST:event_transaksiLabelMouseClicked

    private void transaksiLabelDateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transaksiLabelDateMouseClicked
        if(selectedIndex == 4)
            return;
        
        recolorDefaultSwitchPanel();
        transaksiPanelDate.setBackground(new Color(255,204,51));
        setForm(new PelangganMainPanel());
        selectedIndex = 4;
    }//GEN-LAST:event_transaksiLabelDateMouseClicked

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
            java.util.logging.Logger.getLogger(MainViewForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainViewForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainViewForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainViewForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainViewForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contentPanel;
    private javax.swing.JLabel customerLabel;
    private javax.swing.JLabel kendaraanLabel;
    private javax.swing.JLabel logoIcon;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JPanel logoPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel multiplePanel;
    private javax.swing.JPanel sidePanel;
    private javax.swing.JPanel singlePanel;
    private javax.swing.JLabel transaksiLabel;
    private javax.swing.JLabel transaksiLabelDate;
    private javax.swing.JPanel transaksiPanel;
    private javax.swing.JPanel transaksiPanelDate;
    // End of variables declaration//GEN-END:variables
}
