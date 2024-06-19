package panelView;

import control.KaryawanControl;
import dao.KaryawanDAO;
import java.awt.Component;
import exception.InputKosongException;
import exception.InputHarusAngkaException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Comparator;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.Karyawan;

public class laporanMainPanel extends javax.swing.JPanel {

    private final KaryawanControl kc;
    private Karyawan k = null;
    String actionKaryawan = null;

    private Component rootPane;

    public laporanMainPanel() {
        initComponents();
        kc = new KaryawanControl(new KaryawanDAO());
        showKaryawan();
    }



    private boolean isFloat(String input) {
        try {
            Float.parseFloat(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }




    private static void addHeaderClickListener(JTable table) {
        JTableHeader header = table.getTableHeader();
        header.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int col = header.columnAtPoint(e.getPoint());
            }
        });
        TableModel tableModel = table.getModel();
        TableRowSorter<TableModel> sorter = new TableRowSorter<>((TableModel) tableModel);

        sorter.setComparator(4, Comparator.comparingDouble(value -> {
            if (value instanceof Number) {
                return ((Number) value).doubleValue();
            }
            return Double.parseDouble(value.toString());
        }));
        table.setRowSorter(sorter);
    }

    private void showKaryawan() {
        tabelKaryawan.setModel(kc.showTableBySearch(""));
        addHeaderClickListener(tabelKaryawan);
    }

    private void doSearchKaryawan() { // fungsi untuk search dipakai di : searchKaryawanInputButtonActionPerformed
        if (searchKaryawanInputTextField.getText().isEmpty()) {
            return;
        }

       

        if (k != null) { // jika ketemu datanya
            tabelKaryawan.setModel(kc.showTableBySearch(searchKaryawanInputTextField.getText())); // maka akan show berdasarkan pencarian
        } else {
            JOptionPane.showMessageDialog(rootPane, "NOT FOUND !!!");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        mainPanel = new javax.swing.JPanel();
        searchKendaraanInputPanel = new javax.swing.JPanel();
        searchKaryawanInputLabel = new javax.swing.JLabel();
        searchKaryawanInputTextField = new javax.swing.JTextField();
        searchKaryawanInputButton = new javax.swing.JButton();
        simpanKaryawanButton = new javax.swing.JButton();
        batalkanKaryawanButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelKaryawan = new javax.swing.JTable();
        minumanScrollPane1 = new javax.swing.JScrollPane();
        tabelPesanan = new javax.swing.JTable();

        jMenuItem1.setText("jMenuItem1");

        setBackground(new java.awt.Color(255, 218, 182));

        mainPanel.setBackground(new java.awt.Color(255, 218, 182));

        searchKendaraanInputPanel.setBackground(new java.awt.Color(255, 218, 182));

        searchKaryawanInputLabel.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        searchKaryawanInputLabel.setForeground(new java.awt.Color(137, 92, 3));
        searchKaryawanInputLabel.setText("Pencarian Karyawan");

        searchKaryawanInputTextField.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        searchKaryawanInputTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchKaryawanInputTextFieldKeyTyped(evt);
            }
        });

        searchKaryawanInputButton.setBackground(new java.awt.Color(137, 92, 3));
        searchKaryawanInputButton.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        searchKaryawanInputButton.setForeground(new java.awt.Color(255, 255, 255));
        searchKaryawanInputButton.setText("Cari");
        searchKaryawanInputButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchKaryawanInputButtonActionPerformed(evt);
            }
        });

        simpanKaryawanButton.setBackground(new java.awt.Color(51, 151, 56));
        simpanKaryawanButton.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        simpanKaryawanButton.setForeground(new java.awt.Color(255, 255, 255));
        simpanKaryawanButton.setText("Simpan");
        simpanKaryawanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanKaryawanButtonActionPerformed(evt);
            }
        });

        batalkanKaryawanButton.setBackground(new java.awt.Color(237, 78, 5));
        batalkanKaryawanButton.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        batalkanKaryawanButton.setForeground(new java.awt.Color(255, 255, 255));
        batalkanKaryawanButton.setText("Batalkan");
        batalkanKaryawanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalkanKaryawanButtonActionPerformed(evt);
            }
        });

        tabelKaryawan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelKaryawan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelKaryawanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelKaryawan);

        tabelPesanan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        minumanScrollPane1.setViewportView(tabelPesanan);

        javax.swing.GroupLayout searchKendaraanInputPanelLayout = new javax.swing.GroupLayout(searchKendaraanInputPanel);
        searchKendaraanInputPanel.setLayout(searchKendaraanInputPanelLayout);
        searchKendaraanInputPanelLayout.setHorizontalGroup(
            searchKendaraanInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchKendaraanInputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchKendaraanInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchKaryawanInputLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(searchKendaraanInputPanelLayout.createSequentialGroup()
                        .addComponent(searchKaryawanInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(searchKaryawanInputButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 582, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchKendaraanInputPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(batalkanKaryawanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(simpanKaryawanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchKendaraanInputPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(minumanScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(216, 216, 216))
        );
        searchKendaraanInputPanelLayout.setVerticalGroup(
            searchKendaraanInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchKendaraanInputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchKaryawanInputLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(searchKendaraanInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchKaryawanInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchKaryawanInputButton, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addGap(74, 74, 74)
                .addComponent(minumanScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addGroup(searchKendaraanInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(simpanKaryawanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(batalkanKaryawanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchKendaraanInputPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchKendaraanInputPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchKaryawanInputButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchKaryawanInputButtonActionPerformed
        doSearchKaryawan(); // Mencari Karyawan
    }//GEN-LAST:event_searchKaryawanInputButtonActionPerformed

    private void simpanKaryawanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanKaryawanButtonActionPerformed
      
    }//GEN-LAST:event_simpanKaryawanButtonActionPerformed

    private void tabelKaryawanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelKaryawanMouseClicked
//        actionKaryawan = "baharui";
//
//        // setter Akses Field 
//        tambahKaryawanButton.setEnabled(false);
//        batalkanKaryawanButton.setEnabled(true);
//        simpanKaryawanButton.setEnabled(true);
//        setKaryawanEditDeleteButton(true);
//        setComponentsKaryawan(false);
//
//        // Getter Data dari tabel
//        int clickedRow = tabelKaryawan.getSelectedRow();
//        TableModel tableModel = tabelKaryawan.getModel();
//        if (tabelKaryawan.getRowSorter() != null) {
//            clickedRow = tabelKaryawan.convertRowIndexToModel(clickedRow);
//        }
//        // Setter Data dari tabel
//        idKaryawanInputTextField.setText(tableModel.getValueAt(clickedRow, 0).toString());
//        namaKaryawanInputTextField.setText(tableModel.getValueAt(clickedRow, 1).toString());
//        jabatanInputButton.setText(tableModel.getValueAt(clickedRow, 2).toString());
//        gajiKaryawanInputTextfield.setText(tableModel.getValueAt(clickedRow, 3).toString());
//        usernameKaryawanInputTextField.setText(tableModel.getValueAt(clickedRow, 4).toString());
//        passwordKaryawanInputTextField.setText(tableModel.getValueAt(clickedRow, 5).toString());
    }//GEN-LAST:event_tabelKaryawanMouseClicked

    private void batalkanKaryawanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalkanKaryawanButtonActionPerformed
//        clearText();
//        showKaryawan();
//        setKaryawanEditDeleteButton(false);
//        setComponentsKaryawan(false);
//        tambahKaryawanButton.setEnabled(true);
//        tabelKaryawan.clearSelection();
    }//GEN-LAST:event_batalkanKaryawanButtonActionPerformed

    private void searchKaryawanInputTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKaryawanInputTextFieldKeyTyped
        if (evt.getKeyChar() == '\n') {
            doSearchKaryawan();
        }
    }//GEN-LAST:event_searchKaryawanInputTextFieldKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton batalkanKaryawanButton;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JScrollPane minumanScrollPane1;
    private javax.swing.JButton searchKaryawanInputButton;
    private javax.swing.JLabel searchKaryawanInputLabel;
    private javax.swing.JTextField searchKaryawanInputTextField;
    private javax.swing.JPanel searchKendaraanInputPanel;
    private javax.swing.JButton simpanKaryawanButton;
    private javax.swing.JTable tabelKaryawan;
    private javax.swing.JTable tabelPesanan;
    // End of variables declaration//GEN-END:variables
}