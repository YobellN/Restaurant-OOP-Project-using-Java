package panelView;

import control.KaryawanControl;
import java.awt.Component;
import exception.InputKosongException;
import exception.InputHarusAngkaException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.Karyawan;

public class KaryawanMainPanel extends javax.swing.JPanel {

    private KaryawanControl kc = new KaryawanControl();
    private Karyawan k = null;
    String actionKaryawan = null;

    private Component rootPane;
    private String selectedId = "";

    public KaryawanMainPanel() {
        initComponents();
        setOpaque(false);
        showKaryawan();
        setComponentsKaryawan(false);
        idKaryawanInputTextField.setEnabled(false); // langsung false saja karena rencananya id gak bisa di ubah
        setKaryawanEditDeleteButton(false);
        clearText();
    }

    public void inputKosongKaryawanException() throws InputKosongException {
        if (namaKaryawanInputTextField.getText().isEmpty() || gajiKaryawanInputTextfield.getText().isEmpty() || usernameKaryawanInputTextField.getText().isEmpty() || passwordKaryawanInputTextField.getText().isEmpty()) {
            throw new InputKosongException();
        }
    }

    private void InputHarusAngkaKaryawanException() throws InputHarusAngkaException { // exception khusus untuk gaji
        if (!isFloat(gajiKaryawanInputTextfield.getText())) {
            throw new InputHarusAngkaException();
        }
    }
    
    private boolean isFloat(String input) {
        try {
            Float.parseFloat(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    public void setComponentsKaryawan(boolean value) { // ngeset tempat input
        namaKaryawanInputTextField.setEnabled(value);
        gajiKaryawanInputTextfield.setEnabled(value);
        usernameKaryawanInputTextField.setEnabled(value);
        passwordKaryawanInputTextField.setEnabled(value);
        jabatanInputButton.setEnabled(value);
    }

    public void setKaryawanEditDeleteButton(boolean value) { // membuka/tutup tombol barukan dan hapus jika mau/tidak mau ngedit data
        barukanKaryawanButton.setEnabled(value);
        hapusKaryawanButton.setEnabled(value);
    }

    public void clearText() {
        namaKaryawanInputTextField.setText("");
        gajiKaryawanInputTextfield.setText("");
        jabatanInputButton.setText("    ");
        searchKaryawanInputTextField.setText("");
        usernameKaryawanInputTextField.setText("");
        passwordKaryawanInputTextField.setText("");
        idKaryawanInputTextField.setText("");
    }
    
    public void showKaryawan(){
        tabelKaryawan.setModel(kc.showTable(""));
        addHeaderClickListener(tabelKaryawan);
    }

    private void doSearchKaryawan() { // fungsi untuk search dipakai di : searchKaryawanInputButtonActionPerformed
        if (searchKaryawanInputTextField.getText().isEmpty()) {
            return;
        }

        k = kc.searchDataKaryawan(searchKaryawanInputTextField.getText()); // mencari berdasarkan ID

        if (k != null) { // jika ketemu datanya
            tabelKaryawan.setModel(kc.showTable(searchKaryawanInputTextField.getText()));
//            setKaryawanEditDeleteButton(true); // maka tombol edit dan delete dibuka
//            namaKaryawanInputTextField.setText(k.getNama_karyawan()); // // mencopy data yang ditemukan di field input
//            gajiKaryawanInputTextfield.setText(Float.toString(k.getGaji()));
//            usernameKaryawanInputTextField.setText(k.getUsername());
//            passwordKaryawanInputTextField.setText(k.getPassword());
//            jabatanInputButton.setText(k.getJabatan());
//            idKaryawanInputTextField.setText(k.getId_karyawan());
        } else {
            JOptionPane.showMessageDialog(rootPane, "NOT FOUND !!!");
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        searchKendaraanInputPanel = new javax.swing.JPanel();
        searchKaryawanInputLabel = new javax.swing.JLabel();
        searchKaryawanInputTextField = new javax.swing.JTextField();
        searchKaryawanInputButton = new javax.swing.JButton();
        kendaraanFormPanel = new javax.swing.JPanel();
        KendaraanButtonPanel = new javax.swing.JPanel();
        barukanKaryawanButton = new javax.swing.JButton();
        hapusKaryawanButton = new javax.swing.JButton();
        tambahKaryawanButton = new javax.swing.JButton();
        idKendaraanInputPanel = new javax.swing.JPanel();
        namaKaryawanInputLabel = new javax.swing.JLabel();
        namaKaryawanInputTextField = new javax.swing.JTextField();
        usernameInputPanel = new javax.swing.JPanel();
        usernameKaryawanInputLabel = new javax.swing.JLabel();
        usernameKaryawanInputTextField = new javax.swing.JTextField();
        hargaKendaraanInputPanel = new javax.swing.JPanel();
        gajiKaryawanInputLabel = new javax.swing.JLabel();
        gajiKaryawanInputTextfield = new javax.swing.JTextField();
        jenisKendaraanInputPanel = new javax.swing.JPanel();
        jenisJabatanInputLabel = new javax.swing.JLabel();
        jabatanInputButton = new javax.swing.JButton();
        passwordKaryawanInputPanel = new javax.swing.JPanel();
        passwordKaryawanInputTextField = new javax.swing.JTextField();
        passwordKaryawanInputLabel = new javax.swing.JLabel();
        usernameInputPanel4 = new javax.swing.JPanel();
        idKaryawanInputLabel = new javax.swing.JLabel();
        idKaryawanInputTextField = new javax.swing.JTextField();
        specialAtributeInputPanel = new javax.swing.JPanel();
        simpanKaryawanButton = new javax.swing.JButton();
        batalkanKaryawanButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelKaryawan = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 218, 182));

        mainPanel.setBackground(new java.awt.Color(255, 218, 182));

        searchKendaraanInputPanel.setBackground(new java.awt.Color(255, 218, 182));

        searchKaryawanInputLabel.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        searchKaryawanInputLabel.setForeground(new java.awt.Color(137, 92, 3));
        searchKaryawanInputLabel.setText("Pencarian Karyawan");

        searchKaryawanInputTextField.setBackground(new java.awt.Color(255, 255, 255));
        searchKaryawanInputTextField.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        searchKaryawanInputTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchKaryawanInputTextFieldKeyPressed(evt);
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

        kendaraanFormPanel.setBackground(new java.awt.Color(255, 218, 182));

        KendaraanButtonPanel.setBackground(new java.awt.Color(255, 218, 182));

        barukanKaryawanButton.setBackground(new java.awt.Color(255, 175, 47));
        barukanKaryawanButton.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        barukanKaryawanButton.setForeground(new java.awt.Color(255, 255, 255));
        barukanKaryawanButton.setText("Barukan");
        barukanKaryawanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barukanKaryawanButtonActionPerformed(evt);
            }
        });

        hapusKaryawanButton.setBackground(new java.awt.Color(237, 78, 5));
        hapusKaryawanButton.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        hapusKaryawanButton.setForeground(new java.awt.Color(255, 255, 255));
        hapusKaryawanButton.setText("Hapus");
        hapusKaryawanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusKaryawanButtonActionPerformed(evt);
            }
        });

        tambahKaryawanButton.setBackground(new java.awt.Color(51, 151, 56));
        tambahKaryawanButton.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        tambahKaryawanButton.setForeground(new java.awt.Color(255, 255, 255));
        tambahKaryawanButton.setText("Tambah");
        tambahKaryawanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahKaryawanButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout KendaraanButtonPanelLayout = new javax.swing.GroupLayout(KendaraanButtonPanel);
        KendaraanButtonPanel.setLayout(KendaraanButtonPanelLayout);
        KendaraanButtonPanelLayout.setHorizontalGroup(
            KendaraanButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KendaraanButtonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tambahKaryawanButton)
                .addGap(18, 18, 18)
                .addComponent(barukanKaryawanButton)
                .addGap(18, 18, 18)
                .addComponent(hapusKaryawanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        KendaraanButtonPanelLayout.setVerticalGroup(
            KendaraanButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KendaraanButtonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(KendaraanButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(barukanKaryawanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tambahKaryawanButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hapusKaryawanButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        idKendaraanInputPanel.setBackground(new java.awt.Color(255, 218, 182));

        namaKaryawanInputLabel.setBackground(new java.awt.Color(0, 0, 0));
        namaKaryawanInputLabel.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        namaKaryawanInputLabel.setForeground(new java.awt.Color(137, 92, 3));
        namaKaryawanInputLabel.setText("Nama");

        namaKaryawanInputTextField.setBackground(new java.awt.Color(255, 255, 255));
        namaKaryawanInputTextField.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N

        javax.swing.GroupLayout idKendaraanInputPanelLayout = new javax.swing.GroupLayout(idKendaraanInputPanel);
        idKendaraanInputPanel.setLayout(idKendaraanInputPanelLayout);
        idKendaraanInputPanelLayout.setHorizontalGroup(
            idKendaraanInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(idKendaraanInputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(idKendaraanInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(namaKaryawanInputLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                    .addGroup(idKendaraanInputPanelLayout.createSequentialGroup()
                        .addComponent(namaKaryawanInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        idKendaraanInputPanelLayout.setVerticalGroup(
            idKendaraanInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(idKendaraanInputPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(namaKaryawanInputLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(namaKaryawanInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        usernameInputPanel.setBackground(new java.awt.Color(255, 218, 182));

        usernameKaryawanInputLabel.setBackground(new java.awt.Color(0, 0, 0));
        usernameKaryawanInputLabel.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        usernameKaryawanInputLabel.setForeground(new java.awt.Color(137, 92, 3));
        usernameKaryawanInputLabel.setText("Username");

        usernameKaryawanInputTextField.setBackground(new java.awt.Color(255, 255, 255));
        usernameKaryawanInputTextField.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N

        javax.swing.GroupLayout usernameInputPanelLayout = new javax.swing.GroupLayout(usernameInputPanel);
        usernameInputPanel.setLayout(usernameInputPanelLayout);
        usernameInputPanelLayout.setHorizontalGroup(
            usernameInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(usernameInputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(usernameInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usernameKaryawanInputLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                    .addGroup(usernameInputPanelLayout.createSequentialGroup()
                        .addComponent(usernameKaryawanInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        usernameInputPanelLayout.setVerticalGroup(
            usernameInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(usernameInputPanelLayout.createSequentialGroup()
                .addComponent(usernameKaryawanInputLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameKaryawanInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        hargaKendaraanInputPanel.setBackground(new java.awt.Color(255, 218, 182));

        gajiKaryawanInputLabel.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        gajiKaryawanInputLabel.setForeground(new java.awt.Color(137, 92, 3));
        gajiKaryawanInputLabel.setText("Gaji");

        gajiKaryawanInputTextfield.setBackground(new java.awt.Color(255, 255, 255));
        gajiKaryawanInputTextfield.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        gajiKaryawanInputTextfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                gajiKaryawanInputTextfieldKeyTyped(evt);
            }
        });

        jenisKendaraanInputPanel.setBackground(new java.awt.Color(255, 218, 182));

        jenisJabatanInputLabel.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        jenisJabatanInputLabel.setForeground(new java.awt.Color(137, 92, 3));
        jenisJabatanInputLabel.setText("Jabatan");

        jabatanInputButton.setBackground(new java.awt.Color(70, 39, 7));
        jabatanInputButton.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        jabatanInputButton.setForeground(new java.awt.Color(255, 255, 255));
        jabatanInputButton.setText("Kasir");
        jabatanInputButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jabatanInputButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jenisKendaraanInputPanelLayout = new javax.swing.GroupLayout(jenisKendaraanInputPanel);
        jenisKendaraanInputPanel.setLayout(jenisKendaraanInputPanelLayout);
        jenisKendaraanInputPanelLayout.setHorizontalGroup(
            jenisKendaraanInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jenisKendaraanInputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jenisKendaraanInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jenisKendaraanInputPanelLayout.createSequentialGroup()
                        .addComponent(jabatanInputButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jenisJabatanInputLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jenisKendaraanInputPanelLayout.setVerticalGroup(
            jenisKendaraanInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jenisKendaraanInputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jenisJabatanInputLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jabatanInputButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout hargaKendaraanInputPanelLayout = new javax.swing.GroupLayout(hargaKendaraanInputPanel);
        hargaKendaraanInputPanel.setLayout(hargaKendaraanInputPanelLayout);
        hargaKendaraanInputPanelLayout.setHorizontalGroup(
            hargaKendaraanInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hargaKendaraanInputPanelLayout.createSequentialGroup()
                .addGroup(hargaKendaraanInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(hargaKendaraanInputPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(gajiKaryawanInputLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(gajiKaryawanInputTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jenisKendaraanInputPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        hargaKendaraanInputPanelLayout.setVerticalGroup(
            hargaKendaraanInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hargaKendaraanInputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(hargaKendaraanInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(hargaKendaraanInputPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(gajiKaryawanInputLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gajiKaryawanInputTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jenisKendaraanInputPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        passwordKaryawanInputPanel.setBackground(new java.awt.Color(255, 218, 182));

        passwordKaryawanInputTextField.setBackground(new java.awt.Color(255, 255, 255));
        passwordKaryawanInputTextField.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N

        passwordKaryawanInputLabel.setBackground(new java.awt.Color(0, 0, 0));
        passwordKaryawanInputLabel.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        passwordKaryawanInputLabel.setForeground(new java.awt.Color(137, 92, 3));
        passwordKaryawanInputLabel.setText("Password");

        javax.swing.GroupLayout passwordKaryawanInputPanelLayout = new javax.swing.GroupLayout(passwordKaryawanInputPanel);
        passwordKaryawanInputPanel.setLayout(passwordKaryawanInputPanelLayout);
        passwordKaryawanInputPanelLayout.setHorizontalGroup(
            passwordKaryawanInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(passwordKaryawanInputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(passwordKaryawanInputLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(passwordKaryawanInputPanelLayout.createSequentialGroup()
                .addComponent(passwordKaryawanInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        passwordKaryawanInputPanelLayout.setVerticalGroup(
            passwordKaryawanInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, passwordKaryawanInputPanelLayout.createSequentialGroup()
                .addComponent(passwordKaryawanInputLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(passwordKaryawanInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        usernameInputPanel4.setBackground(new java.awt.Color(255, 218, 182));

        idKaryawanInputLabel.setBackground(new java.awt.Color(0, 0, 0));
        idKaryawanInputLabel.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        idKaryawanInputLabel.setForeground(new java.awt.Color(137, 92, 3));
        idKaryawanInputLabel.setText("ID Karyawan");

        idKaryawanInputTextField.setBackground(new java.awt.Color(255, 255, 255));
        idKaryawanInputTextField.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N

        javax.swing.GroupLayout usernameInputPanel4Layout = new javax.swing.GroupLayout(usernameInputPanel4);
        usernameInputPanel4.setLayout(usernameInputPanel4Layout);
        usernameInputPanel4Layout.setHorizontalGroup(
            usernameInputPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(usernameInputPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(usernameInputPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idKaryawanInputLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                    .addGroup(usernameInputPanel4Layout.createSequentialGroup()
                        .addComponent(idKaryawanInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        usernameInputPanel4Layout.setVerticalGroup(
            usernameInputPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(usernameInputPanel4Layout.createSequentialGroup()
                .addComponent(idKaryawanInputLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idKaryawanInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout kendaraanFormPanelLayout = new javax.swing.GroupLayout(kendaraanFormPanel);
        kendaraanFormPanel.setLayout(kendaraanFormPanelLayout);
        kendaraanFormPanelLayout.setHorizontalGroup(
            kendaraanFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kendaraanFormPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kendaraanFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kendaraanFormPanelLayout.createSequentialGroup()
                        .addComponent(KendaraanButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 350, Short.MAX_VALUE))
                    .addGroup(kendaraanFormPanelLayout.createSequentialGroup()
                        .addGroup(kendaraanFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(usernameInputPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(idKendaraanInputPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(usernameInputPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(kendaraanFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hargaKendaraanInputPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(kendaraanFormPanelLayout.createSequentialGroup()
                                .addComponent(passwordKaryawanInputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        kendaraanFormPanelLayout.setVerticalGroup(
            kendaraanFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kendaraanFormPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(KendaraanButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(kendaraanFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(idKendaraanInputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hargaKendaraanInputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(kendaraanFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kendaraanFormPanelLayout.createSequentialGroup()
                        .addComponent(usernameInputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(usernameInputPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(passwordKaryawanInputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        specialAtributeInputPanel.setBackground(new java.awt.Color(255, 218, 182));

        javax.swing.GroupLayout specialAtributeInputPanelLayout = new javax.swing.GroupLayout(specialAtributeInputPanel);
        specialAtributeInputPanel.setLayout(specialAtributeInputPanelLayout);
        specialAtributeInputPanelLayout.setHorizontalGroup(
            specialAtributeInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 534, Short.MAX_VALUE)
        );
        specialAtributeInputPanelLayout.setVerticalGroup(
            specialAtributeInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );

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
        batalkanKaryawanButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                batalkanKaryawanButtonMouseClicked(evt);
            }
        });
        batalkanKaryawanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalkanKaryawanButtonActionPerformed(evt);
            }
        });

        tabelKaryawan.setBackground(new java.awt.Color(255, 255, 255));
        tabelKaryawan.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        tabelKaryawan.setForeground(new java.awt.Color(0, 0, 0));
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

        javax.swing.GroupLayout searchKendaraanInputPanelLayout = new javax.swing.GroupLayout(searchKendaraanInputPanel);
        searchKendaraanInputPanel.setLayout(searchKendaraanInputPanelLayout);
        searchKendaraanInputPanelLayout.setHorizontalGroup(
            searchKendaraanInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchKendaraanInputPanelLayout.createSequentialGroup()
                .addGroup(searchKendaraanInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchKendaraanInputPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(searchKendaraanInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(searchKaryawanInputLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(searchKendaraanInputPanelLayout.createSequentialGroup()
                                .addComponent(searchKaryawanInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(searchKaryawanInputButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 531, Short.MAX_VALUE))))
                    .addGroup(searchKendaraanInputPanelLayout.createSequentialGroup()
                        .addComponent(kendaraanFormPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(searchKendaraanInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(searchKendaraanInputPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(specialAtributeInputPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(14, 14, 14))
                            .addGroup(searchKendaraanInputPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(batalkanKaryawanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(simpanKaryawanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3))))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        searchKendaraanInputPanelLayout.setVerticalGroup(
            searchKendaraanInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchKendaraanInputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchKaryawanInputLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(searchKendaraanInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchKaryawanInputTextField)
                    .addComponent(searchKaryawanInputButton, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addGroup(searchKendaraanInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchKendaraanInputPanelLayout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(specialAtributeInputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                        .addGroup(searchKendaraanInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(batalkanKaryawanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(simpanKaryawanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(searchKendaraanInputPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kendaraanFormPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchKendaraanInputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void searchKaryawanInputTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKaryawanInputTextFieldKeyPressed

    }//GEN-LAST:event_searchKaryawanInputTextFieldKeyPressed

    private void searchKaryawanInputButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchKaryawanInputButtonActionPerformed
        doSearchKaryawan();
    }//GEN-LAST:event_searchKaryawanInputButtonActionPerformed

    private void barukanKaryawanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barukanKaryawanButtonActionPerformed
        actionKaryawan = "update"; 
        setComponentsKaryawan(true); // membuka akses field input
    }//GEN-LAST:event_barukanKaryawanButtonActionPerformed

    private void hapusKaryawanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusKaryawanButtonActionPerformed
        if (jabatanInputButton.getText().equalsIgnoreCase("owner")) {
            JOptionPane.showMessageDialog(rootPane, "OWNER TIDAK DAPAT DIHAPUS!!!");
            return;
        }
        int opsi = JOptionPane.showConfirmDialog(rootPane, "Yakin Ingin Hapus ?", "Hapus Data", JOptionPane.YES_NO_OPTION);
        if (opsi == JOptionPane.NO_OPTION || opsi == JOptionPane.CLOSED_OPTION) {
            return;
        }

        kc.deleteDataKaryawan(idKaryawanInputTextField.getText()); // delete berdasarkan id
        clearText(); // bersihin field input
        setKaryawanEditDeleteButton(false); 
        setComponentsKaryawan(false); // tutup field input
        showKaryawan(); // melakukan show ulang
    }//GEN-LAST:event_hapusKaryawanButtonActionPerformed

    private void tambahKaryawanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahKaryawanButtonActionPerformed
        actionKaryawan = "add";
        clearText(); // bersihin field input
        setKaryawanEditDeleteButton(false); // membatasi tombol edit dan hapus
        setComponentsKaryawan(true); // membuka field input

        idKaryawanInputTextField.setEnabled(false); // mastikan saja biar tidak dibuka 
        idKaryawanInputTextField.setText(kc.generateId()); // membuat ID baru berdasarkan nilai id tertinggi
        jabatanInputButton.setText("Kasir");
    }//GEN-LAST:event_tambahKaryawanButtonActionPerformed

    private void gajiKaryawanInputTextfieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gajiKaryawanInputTextfieldKeyTyped

    }//GEN-LAST:event_gajiKaryawanInputTextfieldKeyTyped

    private void jabatanInputButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jabatanInputButtonActionPerformed
        switch (jabatanInputButton.getText()) { // akan membalikkan nilai jika di pencet
            case "Kasir":
                jabatanInputButton.setText("Manajer");
                break;
            case "Manajer":
                jabatanInputButton.setText("Kasir");
                break;
        }
    }//GEN-LAST:event_jabatanInputButtonActionPerformed

    private void simpanKaryawanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanKaryawanButtonActionPerformed
        if (actionKaryawan == null) {
            return;
        }
        try {
            InputHarusAngkaKaryawanException();
            inputKosongKaryawanException();

            if (JOptionPane.showConfirmDialog(rootPane, "yakin ingin melakukan " + actionKaryawan + "?") == JOptionPane.CLOSED_OPTION) {
                return;
            }

            switch (actionKaryawan) {
                case "add":
                    k = new Karyawan (idKaryawanInputTextField.getText(), namaKaryawanInputTextField.getText(), jabatanInputButton.getText(), Float.parseFloat(gajiKaryawanInputTextfield.getText()), usernameKaryawanInputTextField.getText(), passwordKaryawanInputTextField.getText());
                    kc.insertDataKaryawan(k);
                    clearText();
                    setKaryawanEditDeleteButton(false);
                    setComponentsKaryawan(false);
                    showKaryawan();
                    break;
                case "update":
                    k = new Karyawan (idKaryawanInputTextField.getText(), namaKaryawanInputTextField.getText(), jabatanInputButton.getText(), Float.parseFloat(gajiKaryawanInputTextfield.getText()), usernameKaryawanInputTextField.getText(), passwordKaryawanInputTextField.getText());
                    kc.updateDataKaryawan(k);
                    clearText();
                    setKaryawanEditDeleteButton(false);
                    setComponentsKaryawan(false);
                    showKaryawan();
                    break;
                default:
                    break;
            }
            actionKaryawan = null;
        } catch (InputKosongException e) {
            JOptionPane.showMessageDialog(rootPane, e.message());
        } catch (InputHarusAngkaException e2) {
            JOptionPane.showMessageDialog(rootPane, e2.message());
        }
    }//GEN-LAST:event_simpanKaryawanButtonActionPerformed

    private void tabelKaryawanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelKaryawanMouseClicked
        actionKaryawan = "baharui";
        
        tambahKaryawanButton.setEnabled(false);
        batalkanKaryawanButton.setEnabled(true);
        simpanKaryawanButton.setEnabled(true);        
        setKaryawanEditDeleteButton(true);
        
        setComponentsKaryawan(false);
        
        int clickedRow = tabelKaryawan.getSelectedRow();
        TableModel tableModel = tabelKaryawan.getModel();
        if (tabelKaryawan.getRowSorter() != null) {
            clickedRow = tabelKaryawan.convertRowIndexToModel(clickedRow);
        }
        selectedId = tableModel.getValueAt(clickedRow, 0).toString();

        idKaryawanInputTextField.setText(tableModel.getValueAt(clickedRow, 0).toString()); 
        namaKaryawanInputTextField.setText(tableModel.getValueAt(clickedRow, 1).toString()); 
        jabatanInputButton.setText(tableModel.getValueAt(clickedRow, 2).toString());
        gajiKaryawanInputTextfield.setText(tableModel.getValueAt(clickedRow, 3).toString());
        usernameKaryawanInputTextField.setText(tableModel.getValueAt(clickedRow, 4).toString());
        passwordKaryawanInputTextField.setText(tableModel.getValueAt(clickedRow, 5).toString());
        
        batalkanKaryawanButton.setEnabled(true);
    }//GEN-LAST:event_tabelKaryawanMouseClicked

    private void batalkanKaryawanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalkanKaryawanButtonActionPerformed
        clearText();
        showKaryawan();
        setKaryawanEditDeleteButton(false);
        setComponentsKaryawan(false);
        tambahKaryawanButton.setEnabled(true);
        tabelKaryawan.clearSelection();
        
    }//GEN-LAST:event_batalkanKaryawanButtonActionPerformed

    private void batalkanKaryawanButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_batalkanKaryawanButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_batalkanKaryawanButtonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel KendaraanButtonPanel;
    private javax.swing.JButton barukanKaryawanButton;
    private javax.swing.JButton batalkanKaryawanButton;
    private javax.swing.JLabel gajiKaryawanInputLabel;
    private javax.swing.JTextField gajiKaryawanInputTextfield;
    private javax.swing.JButton hapusKaryawanButton;
    private javax.swing.JPanel hargaKendaraanInputPanel;
    private javax.swing.JLabel idKaryawanInputLabel;
    private javax.swing.JTextField idKaryawanInputTextField;
    private javax.swing.JPanel idKendaraanInputPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jabatanInputButton;
    private javax.swing.JLabel jenisJabatanInputLabel;
    private javax.swing.JPanel jenisKendaraanInputPanel;
    private javax.swing.JPanel kendaraanFormPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel namaKaryawanInputLabel;
    private javax.swing.JTextField namaKaryawanInputTextField;
    private javax.swing.JLabel passwordKaryawanInputLabel;
    private javax.swing.JPanel passwordKaryawanInputPanel;
    private javax.swing.JTextField passwordKaryawanInputTextField;
    private javax.swing.JButton searchKaryawanInputButton;
    private javax.swing.JLabel searchKaryawanInputLabel;
    private javax.swing.JTextField searchKaryawanInputTextField;
    private javax.swing.JPanel searchKendaraanInputPanel;
    private javax.swing.JButton simpanKaryawanButton;
    private javax.swing.JPanel specialAtributeInputPanel;
    private javax.swing.JTable tabelKaryawan;
    private javax.swing.JButton tambahKaryawanButton;
    private javax.swing.JPanel usernameInputPanel;
    private javax.swing.JPanel usernameInputPanel4;
    private javax.swing.JLabel usernameKaryawanInputLabel;
    private javax.swing.JTextField usernameKaryawanInputTextField;
    // End of variables declaration//GEN-END:variables
}
