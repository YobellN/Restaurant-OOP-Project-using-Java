/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package panelView;

import control.MenuControl;
import control.MinumanControl;
import control.MakananControl;
import control.PelangganControl;
import control.PesananControl;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Comparator;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.Karyawan;
import model.Pesanan;

import control.TransaksiControl;
import dao.MakananDAO;
import dao.MinumanDAO;
import dao.PelangganDAO;
import dao.TransaksiDAO;
import exception.InputKosongException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import model.Pelanggan;
import model.Transaksi;
import table.TabelPesanan;

public class TransaksiMainPanel extends javax.swing.JPanel {

    // MODEL
    private Transaksi transaksi = null; // DIPAKAI UNTUK INSERT
    private Pesanan pesanan = null; // DIPAKAI UNTUK INSERT
    private Pelanggan pelanggan = null; // DIPAKAI UNTUK INSERT PELANGGAN
    private Karyawan karyawan = null; // DIPAKAI UNTUK MENGAMBIL ID KARYAWAN (UNTUK NEW TRANSAKSI)

    // CONTROL
    // FINAL KARENA TIDAK PERLU DI UBAH DI DALAM PANEL TRANSAKSI
    // DIPAKAI UNTUK MENCARI HARGA
    private final MenuControl menuControl = null;
    private final MakananControl makananControl;
    private final MinumanControl minumanControl;
    private final TransaksiControl tc; // DIPAKAI UNTUK generateID dan INSERT SQL
    private final PesananControl pesananControl = new PesananControl(); // DIPAKAI UNTUK INSERT SQL PESANAN
    private final PelangganControl pelangganControl; // DIPAKAI UNTUK GenerateID dan INSERT SQL PELANGGAN

    // TAMBAHAN
    private ArrayList<Pesanan> pesananList = new ArrayList(); // DIPAKAI UNTUK MENJADI KERANJANG
    String action = null; // DIPAKAI UNTUK MENENTUKAN AKSI
    private Component rootPane;

    /**
     * Creates new form KendaraanView
     */
    public TransaksiMainPanel(Karyawan k) {
        initComponents();
        tc = new TransaksiControl(new TransaksiDAO());
        makananControl = new MakananControl(new MakananDAO());
        minumanControl = new MinumanControl(new MinumanDAO());
        pelangganControl = new PelangganControl((new PelangganDAO()));
        idPesananInputTextField.setText(tc.generateId());
        namaKaryawanInputTextField.setText(k.getNama_karyawan());
        // Yang tidak perlu di ubah
        idProdukInputTextField.setEnabled(false);
        namaProdukInputTextField.setEnabled(false);
        hargaProdukInputTextfield.setEnabled(false);
        specialAtributeInputTextfield.setEnabled(false); // catatan
        namaKaryawanInputTextField.setEnabled(false);
        idPesananInputTextField.setEnabled(false);
        totalProdukInputTextfield.setEnabled(false);

        // gapapa di ubah
        jDateChooser.setEnabled(true);
        namaPelangganInputTextField.setEnabled(true);

        this.karyawan = k; // dapat dari login

        setComponentsData(false);
        showTableMenuBySearch("");
        setEditDeleteButton(false);

        clearTextData();

    }

    private void setComponentsData(boolean value) { // DIPAKAI UNTUK MENGATUR AKSES EDITABLE FIELD
        jumlahProdukInputTextfield.setEnabled(value);
    }

    private void setEditDeleteButton(boolean value) { // DIPAKAI UNTUK MENGATUR AKSES EDIT DELETE
        barukanProdukButton.setEnabled(value);
        hapusProdukButton.setEnabled(value);
    }

    private void clearTextData() { // DIPAKAI UNTUK CLEAR FIELF TEKS TRANSAKSI 
        idProdukInputTextField.setText("");
        namaProdukInputTextField.setText("");
        hargaProdukInputTextfield.setText("");
        searchProdukInputTextField.setText("");
        specialAtributeInputTextfield.setText("");
        specialAtributeInputLabel.setText("");
        jumlahProdukInputTextfield.setText("");
    }

    // DIPAKAI UNTUK SORTIR TABEL
    private static void addHeaderMenu(JTable table) {
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

    private static void addHeaderPesanan(JTable table) {
        JTableHeader header = table.getTableHeader();
        header.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int col = header.columnAtPoint(e.getPoint());
            }
        });
        TableModel tableModel = table.getModel();
        TableRowSorter<TableModel> sorter = new TableRowSorter<>((TableModel) tableModel);

        sorter.setComparator(3, Comparator.comparingDouble(value -> {
            if (value instanceof Number) {
                return ((Number) value).doubleValue();
            }
            return Double.parseDouble(value.toString());
        }));
        table.setRowSorter(sorter);
    }

    // DIPAKAI UNTUK MENG SHOW MENU NYA BERDASARKAN SEARCH
    private void showTableMenuBySearch(String target) {
        tabelMakanan.setModel(makananControl.showTableBySearch(target));
        tabelMinuman.setModel(minumanControl.showTableBySearch(target));
        addHeaderMenu(tabelMakanan);
        addHeaderMenu(tabelMinuman);
    }

    // DIPAKAI UNTUK MENG SHOW TABEL PESANAN 
    private void showTabelPesanan() {
        tabelPesanan.setModel(new TabelPesanan(pesananList));
        addHeaderPesanan(tabelPesanan);
    }

    // DIPAKAI UNTUK MENGESET FIELD TOTAL PRODUK
    private void setTotalTransaksi() {
        double totalHarga = 0;
        for (Pesanan p : pesananList) {
            totalHarga += p.getSub_total();
        }
        totalProdukInputTextfield.setText(String.valueOf(totalHarga));
    }

    // DIPAKAI UNTUK EXCEPTION
    public void inputKosongPesananException() throws InputKosongException {
        if (jumlahProdukInputTextfield.getText().isEmpty()) {
            throw new InputKosongException();
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

        jPopupMenu1 = new javax.swing.JPopupMenu();
        mainPanel = new javax.swing.JPanel();
        searchProdukInputPanel = new javax.swing.JPanel();
        searchProdukInputLabel = new javax.swing.JLabel();
        searchProdukInputTextField = new javax.swing.JTextField();
        searchProdukInputButton = new javax.swing.JButton();
        idProdukInputPanel2 = new javax.swing.JPanel();
        idKaryawanLabel = new javax.swing.JLabel();
        namaKaryawanInputTextField = new javax.swing.JTextField();
        idProdukInputPanel4 = new javax.swing.JPanel();
        idPelangganLabel = new javax.swing.JLabel();
        namaPelangganInputTextField = new javax.swing.JTextField();
        idProdukInputPanel5 = new javax.swing.JPanel();
        idKaryawanLabel1 = new javax.swing.JLabel();
        idPesananInputTextField = new javax.swing.JTextField();
        ProdukFormPanel = new javax.swing.JPanel();
        ProdukButtonPanel = new javax.swing.JPanel();
        barukanProdukButton = new javax.swing.JButton();
        hapusProdukButton = new javax.swing.JButton();
        simpanProdukButton = new javax.swing.JButton();
        idProdukInputPanel = new javax.swing.JPanel();
        idProdukInputLabel = new javax.swing.JLabel();
        idProdukInputTextField = new javax.swing.JTextField();
        namaProdukInputPanel = new javax.swing.JPanel();
        hargaProdukInputTextfield = new javax.swing.JTextField();
        hargaProdukInputLabel = new javax.swing.JLabel();
        hargaProdukInputPanel = new javax.swing.JPanel();
        namaProdukInputTextField = new javax.swing.JTextField();
        namaProdukInputLabel = new javax.swing.JLabel();
        jenisProdukInputPanel = new javax.swing.JPanel();
        specialAtributeInputTextfield = new javax.swing.JTextField();
        specialAtributeInputLabel = new javax.swing.JLabel();
        specialAtributeInputPanel = new javax.swing.JPanel();
        totalProdukInputLabel = new javax.swing.JLabel();
        jumlahProdukInputTextfield = new javax.swing.JTextField();
        kendaraanFormPanel2 = new javax.swing.JPanel();
        makananScrollPane = new javax.swing.JScrollPane();
        tabelMakanan = new javax.swing.JTable();
        minumanScrollPane = new javax.swing.JScrollPane();
        tabelMinuman = new javax.swing.JTable();
        minumanScrollPane1 = new javax.swing.JScrollPane();
        tabelPesanan = new javax.swing.JTable();
        kendaraanFormPanel3 = new javax.swing.JPanel();
        simpanTransaksiProdukButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        specialAtributeInputPanel1 = new javax.swing.JPanel();
        totalProdukInputTextfield = new javax.swing.JTextField();
        totalProdukInputLabel1 = new javax.swing.JLabel();
        jDateChooser = new com.toedter.calendar.JDateChooser();

        mainPanel.setBackground(new java.awt.Color(255, 221, 186));

        searchProdukInputPanel.setBackground(new java.awt.Color(255, 221, 186));

        searchProdukInputLabel.setBackground(new java.awt.Color(255, 221, 186));
        searchProdukInputLabel.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        searchProdukInputLabel.setForeground(new java.awt.Color(137, 92, 3));
        searchProdukInputLabel.setText("Pencarian Produk");

        searchProdukInputTextField.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        searchProdukInputTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchProdukInputTextFieldKeyPressed(evt);
            }
        });

        searchProdukInputButton.setBackground(new java.awt.Color(137, 92, 3));
        searchProdukInputButton.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        searchProdukInputButton.setForeground(new java.awt.Color(255, 255, 255));
        searchProdukInputButton.setText("Cari");
        searchProdukInputButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchProdukInputButtonActionPerformed(evt);
            }
        });

        idProdukInputPanel2.setBackground(new java.awt.Color(255, 221, 186));

        idKaryawanLabel.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        idKaryawanLabel.setForeground(new java.awt.Color(137, 92, 3));
        idKaryawanLabel.setText("Nama Karyawan");

        namaKaryawanInputTextField.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N

        javax.swing.GroupLayout idProdukInputPanel2Layout = new javax.swing.GroupLayout(idProdukInputPanel2);
        idProdukInputPanel2.setLayout(idProdukInputPanel2Layout);
        idProdukInputPanel2Layout.setHorizontalGroup(
            idProdukInputPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(idProdukInputPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(idProdukInputPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(namaKaryawanInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idKaryawanLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        idProdukInputPanel2Layout.setVerticalGroup(
            idProdukInputPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(idProdukInputPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(idKaryawanLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(namaKaryawanInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        idProdukInputPanel4.setBackground(new java.awt.Color(255, 221, 186));

        idPelangganLabel.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        idPelangganLabel.setForeground(new java.awt.Color(137, 92, 3));
        idPelangganLabel.setText("Nama Pelanggan");

        namaPelangganInputTextField.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N

        javax.swing.GroupLayout idProdukInputPanel4Layout = new javax.swing.GroupLayout(idProdukInputPanel4);
        idProdukInputPanel4.setLayout(idProdukInputPanel4Layout);
        idProdukInputPanel4Layout.setHorizontalGroup(
            idProdukInputPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(idProdukInputPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(idProdukInputPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idPelangganLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(namaPelangganInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        idProdukInputPanel4Layout.setVerticalGroup(
            idProdukInputPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(idProdukInputPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(idPelangganLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(namaPelangganInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        idProdukInputPanel5.setBackground(new java.awt.Color(255, 221, 186));

        idKaryawanLabel1.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        idKaryawanLabel1.setForeground(new java.awt.Color(137, 92, 3));
        idKaryawanLabel1.setText("ID Pesanan");

        idPesananInputTextField.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N

        javax.swing.GroupLayout idProdukInputPanel5Layout = new javax.swing.GroupLayout(idProdukInputPanel5);
        idProdukInputPanel5.setLayout(idProdukInputPanel5Layout);
        idProdukInputPanel5Layout.setHorizontalGroup(
            idProdukInputPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(idProdukInputPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(idProdukInputPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idPesananInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idKaryawanLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        idProdukInputPanel5Layout.setVerticalGroup(
            idProdukInputPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(idProdukInputPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(idKaryawanLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idPesananInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout searchProdukInputPanelLayout = new javax.swing.GroupLayout(searchProdukInputPanel);
        searchProdukInputPanel.setLayout(searchProdukInputPanelLayout);
        searchProdukInputPanelLayout.setHorizontalGroup(
            searchProdukInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchProdukInputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchProdukInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchProdukInputLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(searchProdukInputPanelLayout.createSequentialGroup()
                        .addComponent(searchProdukInputTextField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchProdukInputButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(86, 86, 86)
                .addComponent(idProdukInputPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(idProdukInputPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idProdukInputPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        searchProdukInputPanelLayout.setVerticalGroup(
            searchProdukInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchProdukInputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchProdukInputLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(searchProdukInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchProdukInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchProdukInputButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchProdukInputPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(searchProdukInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idProdukInputPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(searchProdukInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(idProdukInputPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(idProdukInputPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        ProdukFormPanel.setBackground(new java.awt.Color(255, 221, 186));

        ProdukButtonPanel.setBackground(new java.awt.Color(255, 221, 186));

        barukanProdukButton.setBackground(new java.awt.Color(255, 175, 47));
        barukanProdukButton.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        barukanProdukButton.setForeground(new java.awt.Color(255, 255, 255));
        barukanProdukButton.setText("Barukan");
        barukanProdukButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barukanProdukButtonActionPerformed(evt);
            }
        });

        hapusProdukButton.setBackground(new java.awt.Color(237, 78, 5));
        hapusProdukButton.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        hapusProdukButton.setForeground(new java.awt.Color(255, 255, 255));
        hapusProdukButton.setText("Hapus");
        hapusProdukButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusProdukButtonActionPerformed(evt);
            }
        });

        simpanProdukButton.setBackground(new java.awt.Color(51, 151, 56));
        simpanProdukButton.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        simpanProdukButton.setForeground(new java.awt.Color(255, 255, 255));
        simpanProdukButton.setText("Simpan");
        simpanProdukButton.setPreferredSize(new java.awt.Dimension(81, 21));
        simpanProdukButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanProdukButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ProdukButtonPanelLayout = new javax.swing.GroupLayout(ProdukButtonPanel);
        ProdukButtonPanel.setLayout(ProdukButtonPanelLayout);
        ProdukButtonPanelLayout.setHorizontalGroup(
            ProdukButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProdukButtonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(simpanProdukButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(barukanProdukButton)
                .addGap(18, 18, 18)
                .addComponent(hapusProdukButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        ProdukButtonPanelLayout.setVerticalGroup(
            ProdukButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProdukButtonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ProdukButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(ProdukButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(barukanProdukButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(simpanProdukButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(hapusProdukButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        idProdukInputPanel.setBackground(new java.awt.Color(255, 221, 186));

        idProdukInputLabel.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        idProdukInputLabel.setForeground(new java.awt.Color(137, 92, 3));
        idProdukInputLabel.setText("ID Produk");

        idProdukInputTextField.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N

        javax.swing.GroupLayout idProdukInputPanelLayout = new javax.swing.GroupLayout(idProdukInputPanel);
        idProdukInputPanel.setLayout(idProdukInputPanelLayout);
        idProdukInputPanelLayout.setHorizontalGroup(
            idProdukInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(idProdukInputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(idProdukInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(idProdukInputTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                    .addComponent(idProdukInputLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        idProdukInputPanelLayout.setVerticalGroup(
            idProdukInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(idProdukInputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(idProdukInputLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idProdukInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        namaProdukInputPanel.setBackground(new java.awt.Color(255, 221, 186));

        hargaProdukInputTextfield.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N

        hargaProdukInputLabel.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        hargaProdukInputLabel.setForeground(new java.awt.Color(137, 92, 3));
        hargaProdukInputLabel.setText("Harga");

        javax.swing.GroupLayout namaProdukInputPanelLayout = new javax.swing.GroupLayout(namaProdukInputPanel);
        namaProdukInputPanel.setLayout(namaProdukInputPanelLayout);
        namaProdukInputPanelLayout.setHorizontalGroup(
            namaProdukInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(namaProdukInputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(namaProdukInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hargaProdukInputTextfield)
                    .addGroup(namaProdukInputPanelLayout.createSequentialGroup()
                        .addComponent(hargaProdukInputLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        namaProdukInputPanelLayout.setVerticalGroup(
            namaProdukInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(namaProdukInputPanelLayout.createSequentialGroup()
                .addComponent(hargaProdukInputLabel)
                .addGap(12, 12, 12)
                .addComponent(hargaProdukInputTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        hargaProdukInputPanel.setBackground(new java.awt.Color(255, 221, 186));

        namaProdukInputTextField.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N

        namaProdukInputLabel.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        namaProdukInputLabel.setForeground(new java.awt.Color(137, 92, 3));
        namaProdukInputLabel.setText("Nama Produk");

        javax.swing.GroupLayout hargaProdukInputPanelLayout = new javax.swing.GroupLayout(hargaProdukInputPanel);
        hargaProdukInputPanel.setLayout(hargaProdukInputPanelLayout);
        hargaProdukInputPanelLayout.setHorizontalGroup(
            hargaProdukInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hargaProdukInputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(hargaProdukInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(namaProdukInputTextField)
                    .addGroup(hargaProdukInputPanelLayout.createSequentialGroup()
                        .addComponent(namaProdukInputLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        hargaProdukInputPanelLayout.setVerticalGroup(
            hargaProdukInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hargaProdukInputPanelLayout.createSequentialGroup()
                .addComponent(namaProdukInputLabel)
                .addGap(12, 12, 12)
                .addComponent(namaProdukInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jenisProdukInputPanel.setBackground(new java.awt.Color(255, 221, 186));

        specialAtributeInputTextfield.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N

        specialAtributeInputLabel.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        specialAtributeInputLabel.setForeground(new java.awt.Color(137, 92, 3));
        specialAtributeInputLabel.setText("Catatan");

        javax.swing.GroupLayout jenisProdukInputPanelLayout = new javax.swing.GroupLayout(jenisProdukInputPanel);
        jenisProdukInputPanel.setLayout(jenisProdukInputPanelLayout);
        jenisProdukInputPanelLayout.setHorizontalGroup(
            jenisProdukInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jenisProdukInputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jenisProdukInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(specialAtributeInputTextfield)
                    .addGroup(jenisProdukInputPanelLayout.createSequentialGroup()
                        .addComponent(specialAtributeInputLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jenisProdukInputPanelLayout.setVerticalGroup(
            jenisProdukInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jenisProdukInputPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(specialAtributeInputLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(specialAtributeInputTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        specialAtributeInputPanel.setBackground(new java.awt.Color(255, 221, 186));

        totalProdukInputLabel.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        totalProdukInputLabel.setForeground(new java.awt.Color(137, 92, 3));
        totalProdukInputLabel.setText("Jumlah");

        jumlahProdukInputTextfield.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        jumlahProdukInputTextfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jumlahProdukInputTextfieldKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout specialAtributeInputPanelLayout = new javax.swing.GroupLayout(specialAtributeInputPanel);
        specialAtributeInputPanel.setLayout(specialAtributeInputPanelLayout);
        specialAtributeInputPanelLayout.setHorizontalGroup(
            specialAtributeInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(specialAtributeInputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(totalProdukInputLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(specialAtributeInputPanelLayout.createSequentialGroup()
                .addComponent(jumlahProdukInputTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        specialAtributeInputPanelLayout.setVerticalGroup(
            specialAtributeInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(specialAtributeInputPanelLayout.createSequentialGroup()
                .addComponent(totalProdukInputLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jumlahProdukInputTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        kendaraanFormPanel2.setBackground(new java.awt.Color(255, 221, 186));

        javax.swing.GroupLayout kendaraanFormPanel2Layout = new javax.swing.GroupLayout(kendaraanFormPanel2);
        kendaraanFormPanel2.setLayout(kendaraanFormPanel2Layout);
        kendaraanFormPanel2Layout.setHorizontalGroup(
            kendaraanFormPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 262, Short.MAX_VALUE)
        );
        kendaraanFormPanel2Layout.setVerticalGroup(
            kendaraanFormPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout ProdukFormPanelLayout = new javax.swing.GroupLayout(ProdukFormPanel);
        ProdukFormPanel.setLayout(ProdukFormPanelLayout);
        ProdukFormPanelLayout.setHorizontalGroup(
            ProdukFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProdukFormPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ProdukFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ProdukFormPanelLayout.createSequentialGroup()
                        .addComponent(ProdukButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(ProdukFormPanelLayout.createSequentialGroup()
                        .addGroup(ProdukFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ProdukFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(namaProdukInputPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(idProdukInputPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(ProdukFormPanelLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(specialAtributeInputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(ProdukFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ProdukFormPanelLayout.createSequentialGroup()
                                .addComponent(kendaraanFormPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 6, Short.MAX_VALUE))
                            .addComponent(jenisProdukInputPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(hargaProdukInputPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        ProdukFormPanelLayout.setVerticalGroup(
            ProdukFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProdukFormPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ProdukButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(ProdukFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(idProdukInputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hargaProdukInputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ProdukFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(namaProdukInputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jenisProdukInputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ProdukFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kendaraanFormPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(specialAtributeInputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tabelMakanan.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelMakanan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMakananMouseClicked(evt);
            }
        });
        makananScrollPane.setViewportView(tabelMakanan);

        tabelMinuman.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelMinuman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMinumanMouseClicked(evt);
            }
        });
        minumanScrollPane.setViewportView(tabelMinuman);

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
        tabelPesanan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelPesananMouseClicked(evt);
            }
        });
        minumanScrollPane1.setViewportView(tabelPesanan);

        kendaraanFormPanel3.setBackground(new java.awt.Color(255, 221, 186));

        simpanTransaksiProdukButton.setBackground(new java.awt.Color(51, 151, 56));
        simpanTransaksiProdukButton.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        simpanTransaksiProdukButton.setForeground(new java.awt.Color(255, 255, 255));
        simpanTransaksiProdukButton.setText("Simpan Transaksi");
        simpanTransaksiProdukButton.setPreferredSize(new java.awt.Dimension(81, 21));
        simpanTransaksiProdukButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanTransaksiProdukButtonActionPerformed(evt);
            }
        });

        cancelButton.setBackground(new java.awt.Color(237, 78, 5));
        cancelButton.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        cancelButton.setForeground(new java.awt.Color(255, 255, 255));
        cancelButton.setText("Batalkan");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kendaraanFormPanel3Layout = new javax.swing.GroupLayout(kendaraanFormPanel3);
        kendaraanFormPanel3.setLayout(kendaraanFormPanel3Layout);
        kendaraanFormPanel3Layout.setHorizontalGroup(
            kendaraanFormPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kendaraanFormPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(simpanTransaksiProdukButton, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        kendaraanFormPanel3Layout.setVerticalGroup(
            kendaraanFormPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kendaraanFormPanel3Layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addGroup(kendaraanFormPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(simpanTransaksiProdukButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        specialAtributeInputPanel1.setBackground(new java.awt.Color(255, 221, 186));

        javax.swing.GroupLayout specialAtributeInputPanel1Layout = new javax.swing.GroupLayout(specialAtributeInputPanel1);
        specialAtributeInputPanel1.setLayout(specialAtributeInputPanel1Layout);
        specialAtributeInputPanel1Layout.setHorizontalGroup(
            specialAtributeInputPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 249, Short.MAX_VALUE)
        );
        specialAtributeInputPanel1Layout.setVerticalGroup(
            specialAtributeInputPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );

        totalProdukInputTextfield.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N

        totalProdukInputLabel1.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        totalProdukInputLabel1.setForeground(new java.awt.Color(137, 92, 3));
        totalProdukInputLabel1.setText("Total");

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(ProdukFormPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(152, 152, 152)
                                .addComponent(totalProdukInputLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(minumanScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(makananScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(specialAtributeInputPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(totalProdukInputTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(kendaraanFormPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(minumanScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(searchProdukInputPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchProdukInputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ProdukFormPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(minumanScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(totalProdukInputLabel1)
                                .addGap(9, 9, 9)
                                .addComponent(totalProdukInputTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(specialAtributeInputPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(kendaraanFormPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(makananScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                    .addComponent(minumanScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchProdukInputTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchProdukInputTextFieldKeyPressed
        if (evt.getKeyChar() == '\n') { // KALAU ENTER LANGSUNG SEARCH
            showTableMenuBySearch(searchProdukInputTextField.getText());
        }
    }//GEN-LAST:event_searchProdukInputTextFieldKeyPressed

    private void searchProdukInputButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchProdukInputButtonActionPerformed
        showTableMenuBySearch(searchProdukInputTextField.getText());
    }//GEN-LAST:event_searchProdukInputButtonActionPerformed

    private void hapusProdukButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusProdukButtonActionPerformed
        // AKSI
        if (action == null) {
            return;
        }
        int opsi = JOptionPane.showConfirmDialog(rootPane, "Yakin Ingin Hapus ?", "Hapus Data", JOptionPane.YES_NO_OPTION);
        if (opsi == JOptionPane.NO_OPTION || opsi == JOptionPane.CLOSED_OPTION) {
            return;
        }

        for (Pesanan p : pesananList) { // MENCARI DATA YANG AKAN DIHAPUS BERDASARKAN ID
            if (p.getId_menu().equals(idProdukInputTextField.getText())) {
                pesananList.remove(p);
                break;
            }
        }
        clearTextData(); // DIPAKAI UNTUK CLEAR TEKS
        setTotalTransaksi(); // DIPAKAI UNTUK MEREFRESH TOTAL
        showTabelPesanan(); // DIPAKAI UNTUK SHOW TABEL PESANAN / KERANJANG
        // MENGUBAH AKSES FIELD
        setEditDeleteButton(false);
        setComponentsData(false);
        simpanTransaksiProdukButton.setEnabled(true);
    }//GEN-LAST:event_hapusProdukButtonActionPerformed

    private void simpanProdukButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanProdukButtonActionPerformed
        // AKSI KOSONG
        if (action == null) {
            return;
        }
        int dialog = JOptionPane.showConfirmDialog(rootPane, "yakin ingin melakukan " + action + "?");
        if (dialog == JOptionPane.CLOSED_OPTION || dialog == JOptionPane.NO_OPTION || dialog == JOptionPane.CANCEL_OPTION) {
            return;
        }
        
        try {
            inputKosongPesananException(); // EXCEPTION
            switch (action) {
                case "add":
                    pesanan = new Pesanan(idPesananInputTextField.getText(),
                            idProdukInputTextField.getText(), namaProdukInputTextField.getText(),
                            Integer.parseInt(jumlahProdukInputTextfield.getText()),
                            (Float.parseFloat(hargaProdukInputTextfield.getText()) * Integer.parseInt(jumlahProdukInputTextfield.getText()))
                    );
                    pesananList.add(pesanan);
                    break;
                case "update":
                    for (Pesanan p : pesananList) {
                        if (p.getId_menu().equals(idProdukInputTextField.getText())) { // DIPAKAI UNTUK MENCARI LALU UPDATE
                            p.setId_menu(idProdukInputTextField.getText());
                            p.setNamaMenu(namaProdukInputTextField.getText());
                            p.setJumlah(Integer.parseInt(jumlahProdukInputTextfield.getText()));
                            p.setSub_total(menuControl.searchHarga(idProdukInputTextField.getText()) * Integer.parseInt(jumlahProdukInputTextfield.getText()));
                            break;
                        }
                    }
                    break;
                default:
                    break;
            }
        } catch (InputKosongException e) {
            JOptionPane.showMessageDialog(rootPane, e.message());
        }
        // PROSES LANJUTAN SETIAP MELAKUKAN ADD / DELETE
        clearTextData(); // Clear teks
        setTotalTransaksi(); // Set Total
        setEditDeleteButton(false); // Set Akses Edit Delete
        setComponentsData(false); // Set Akses Field Input
        showTabelPesanan(); // Set / Show Tabel Pesanan
        showTableMenuBySearch(""); // SHOW ULANG MENU
        
        // Mengeset seluruh tabel agar bisa di akses
        tabelMakanan.setEnabled(true); 
        tabelMinuman.setEnabled(true);
        tabelPesanan.setEnabled(true);
        simpanTransaksiProdukButton.setEnabled(true);
        action = null; // MERESET AKSI MENJADI NULL
    }//GEN-LAST:event_simpanProdukButtonActionPerformed

    private void tabelMakananMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMakananMouseClicked
        tabelMinuman.clearSelection(); // DIPAKAI MENGHAPUS PILIHAN DI TABEL LAIN
        action = "add"; // AKSI ADD SUPAYA LANGSUNG MENAMBAH KERANJANG KALAU MAU

        // MENGESET AKSES SAAT KLIK TABEL MAKANAN
        setComponentsData(true); // BOLEH EDIT JUMLAH
        setEditDeleteButton(false); // TIDAK BISA EDIT / DELETE
        cancelButton.setEnabled(true); // BOLEH CANCEL
        simpanProdukButton.setEnabled(true); // BOLEH SIMPAN PRODUK
        simpanTransaksiProdukButton.setEnabled(false); // TIDAK BISA SIMPAN TRANSAKSI
        
        // DIPAKAI UNTUK MEMILIH SECTION TABEL
        int clickedRow = tabelMakanan.getSelectedRow();
        if (tabelMakanan.getRowSorter() != null) { 
            clickedRow = tabelMakanan.convertRowIndexToModel(clickedRow);
        }
        // DIPAKAI UNTUK MENGAMBIL DATA TABEL
        TableModel tableModel = tabelMakanan.getModel();
        // DIPAKAI UNTUK SET DATA DARI TABEL
        idProdukInputTextField.setText(tableModel.getValueAt(clickedRow, 0).toString());
        namaProdukInputTextField.setText(tableModel.getValueAt(clickedRow, 1).toString());
        specialAtributeInputLabel.setText("Catatan");
        specialAtributeInputTextfield.setText(tableModel.getValueAt(clickedRow, 3).toString());
        hargaProdukInputTextfield.setText(tableModel.getValueAt(clickedRow, 4).toString());
    }//GEN-LAST:event_tabelMakananMouseClicked

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // DIPAKAI UNTUK MEMBATALKAN AKSI
        clearTextData(); // MEMBERSIHKAN TEKS
        setEditDeleteButton(false); // MEMBATALKAN IZIN 
        setComponentsData(false); // YANG TIDAK PERLU
        setEditDeleteButton(false); // YANG TIDAK PERLU
        tabelMakanan.clearSelection(); // MEMBERSIHKAN SELECTION TABEL MAKANAN
        tabelMinuman.clearSelection();  // MEMBERSIHKAN SELECTION TABEL MINUMAN
        tabelPesanan.clearSelection();  // MEMBERSIHKAN SELECTION TABEL PESANAN
        showTableMenuBySearch(""); // SHOW ULANG MENU
        showTabelPesanan(); // SHOW ULANG PESANAN
        simpanTransaksiProdukButton.setEnabled(true); // MEMBUKA AKSES SIMPAN TRANSAKSI
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void tabelMinumanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMinumanMouseClicked
        tabelMakanan.clearSelection(); // DIPAKAI MENGHAPUS PILIHAN DI TABEL LAIN
        action = "add"; // AKSI ADD SUPAYA LANGSUNG MENAMBAH KERANJANG KALAU MAU

        // MENGESET AKSES SAAT KLIK TABEL MAKANAN
        setComponentsData(true); // BOLEH EDIT JUMLAH
        setEditDeleteButton(false); // TIDAK BISA EDIT / DELETE
        cancelButton.setEnabled(true); // BOLEH CANCEL
        simpanProdukButton.setEnabled(true); // BOLEH SIMPAN PRODUK
        simpanTransaksiProdukButton.setEnabled(false); // TIDAK BISA SIMPAN TRANSAKSI
        
        // DIPAKAI UNTUK MEMILIH SECTION TABEL
        int clickedRow = tabelMinuman.getSelectedRow();
        if (tabelMinuman.getRowSorter() != null) {
            clickedRow = tabelMinuman.convertRowIndexToModel(clickedRow);
        }
        // DIPAKAI UNTUK MENGAMBIL DATA TABEL
        TableModel tableModel = tabelMinuman.getModel();
        // DIPAKAI UNTUK SET DATA DARI TABEL
        idProdukInputTextField.setText(tableModel.getValueAt(clickedRow, 0).toString());
        namaProdukInputTextField.setText(tableModel.getValueAt(clickedRow, 1).toString());
        specialAtributeInputLabel.setText("Ukuran");
        specialAtributeInputTextfield.setText(tableModel.getValueAt(clickedRow, 3).toString());
        hargaProdukInputTextfield.setText(tableModel.getValueAt(clickedRow, 4).toString());
        cancelButton.setEnabled(true);
    }//GEN-LAST:event_tabelMinumanMouseClicked

    private void jumlahProdukInputTextfieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jumlahProdukInputTextfieldKeyTyped
        // exception UNTUK MENGECEK HANYA ANGKA YANG BISA DI INPUT
        char key = evt.getKeyChar();
        if (!Character.isDigit(key) && key != KeyEvent.VK_BACK_SPACE || key == '.') {
            evt.consume();
            JOptionPane.showMessageDialog(
                    null, "Hanya bisa masukan angka !!", "Input Failure", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jumlahProdukInputTextfieldKeyTyped

    private void tabelPesananMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelPesananMouseClicked
        tabelMakanan.clearSelection(); // DIPAKAI MENGHAPUS PILIHAN DI TABEL LAIN
        tabelMinuman.clearSelection(); // DIPAKAI MENGHAPUS PILIHAN DI TABEL LAIN

        action = "update"; // UNTUK UPDATE PESANAN

        // MENGESET AKSES SAAT KLIK TABEL PESANAN
        setComponentsData(true); // BOLEH EDIT JUMLAH
        setEditDeleteButton(false); // TIDAK BISA EDIT / DELETE
        cancelButton.setEnabled(true); // BOLEH CANCEL
        simpanProdukButton.setEnabled(true); // BOLEH SIMPAN PRODUK
        simpanTransaksiProdukButton.setEnabled(false); // TIDAK BISA SIMPAN TRANSAKSI

        // DIPAKAI UNTUK MEMILIH SECTION TABEL
        int clickedRow = tabelPesanan.getSelectedRow();
        if (tabelPesanan.getRowSorter() != null) {
            clickedRow = tabelPesanan.convertRowIndexToModel(clickedRow);
        }
        // DIPAKAI UNTUK MENGAMBIL DATA TABEL
        TableModel tableModel = tabelPesanan.getModel();
        // DIPAKAI UNTUK SET DATA DARI TABEL
        idProdukInputTextField.setText(tableModel.getValueAt(clickedRow, 0).toString());
        namaProdukInputTextField.setText(tableModel.getValueAt(clickedRow, 1).toString());
        specialAtributeInputLabel.setText("    ");
        jumlahProdukInputTextfield.setText(tableModel.getValueAt(clickedRow, 2).toString());
        hargaProdukInputTextfield.setText("" + menuControl.searchHarga(idProdukInputTextField.getText()));
    }//GEN-LAST:event_tabelPesananMouseClicked

    private void simpanTransaksiProdukButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanTransaksiProdukButtonActionPerformed
        // Exception
        if (pesananList.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "DATA TIDAK BOLEH KOSONG!!!");
            return;
        } else if (namaPelangganInputTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Nama Pelanggan tidak boleh kosong!!!");
            return;
        } else if (jDateChooser.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Tanggal tidak boleh kosong!!!");
            return;
        }
        // Aksi
        int dialog = JOptionPane.showConfirmDialog(rootPane, "yakin ingin melakukan " + "Simpan Transaksi" + "?");
        if (dialog == JOptionPane.CLOSED_OPTION || dialog == JOptionPane.NO_OPTION || dialog == JOptionPane.CANCEL_OPTION) {
            return;
        }

        // DIPAKAI UNTUK CONVERT FORMAT CALENDER
        String toDate = jDateChooser.getDate().toString();
        SimpleDateFormat inputFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
        Date date = null;
        try {
            date = inputFormat.parse(toDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = outputFormat.format(date);

        // DIPAKAI UNTUK MEMBUAT OBJEK
        pelanggan = new Pelanggan(pelangganControl.generateId(), namaPelangganInputTextField.getText(), "-", "-");
        transaksi = new Transaksi(idPesananInputTextField.getText(), karyawan.getId_karyawan(),
                pelangganControl.generateId(), formattedDate, 0);
        
        // untuk insert sql
        pelangganControl.insert(pelanggan);
        tc.insert(transaksi);
        pesananControl.insertDataPesanan(pesananList);
        tc.insertTotalHarga(transaksi);
        // UNTUK MEMBERSIHKAN FIELD
        clearTextData();
        namaPelangganInputTextField.setText("");
        jDateChooser = null;
        pesananList.removeAll(pesananList); 
        
        // UNTUK SET AKSES FIELD
        setEditDeleteButton(false);
        setComponentsData(false);
        tc.createReceipt(idPesananInputTextField.getText());
        pesananList.removeAll(pesananList); // membersihkan list
        showTabelPesanan();
        showTableMenuBySearch("");
        
        // UNTUK MERESET AKSI
        action = null;

        // UNTUK MEREGENERATE ID PESANAN
        idPesananInputTextField.setText(tc.generateId());
    }//GEN-LAST:event_simpanTransaksiProdukButtonActionPerformed

    private void barukanProdukButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barukanProdukButtonActionPerformed
        // DIPAKAI UNTUK MENGEDIT PESANAN
        action = "update";
        setComponentsData(true);
        tabelPesanan.setEnabled(false); // kalo lagi di edit jangan dipencet, bisa nimpa data nanti
        tabelMakanan.setEnabled(false); // kalo lagi di edit jangan dipencet, bisa nimpa data nanti
        tabelMinuman.setEnabled(false); // kalo lagi di edit jangan dipencet, bisa nimpa data nanti
        simpanTransaksiProdukButton.setEnabled(true);
    }//GEN-LAST:event_barukanProdukButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ProdukButtonPanel;
    private javax.swing.JPanel ProdukFormPanel;
    private javax.swing.JButton barukanProdukButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton hapusProdukButton;
    private javax.swing.JLabel hargaProdukInputLabel;
    private javax.swing.JPanel hargaProdukInputPanel;
    private javax.swing.JTextField hargaProdukInputTextfield;
    private javax.swing.JLabel idKaryawanLabel;
    private javax.swing.JLabel idKaryawanLabel1;
    private javax.swing.JLabel idPelangganLabel;
    private javax.swing.JTextField idPesananInputTextField;
    private javax.swing.JLabel idProdukInputLabel;
    private javax.swing.JPanel idProdukInputPanel;
    private javax.swing.JPanel idProdukInputPanel2;
    private javax.swing.JPanel idProdukInputPanel4;
    private javax.swing.JPanel idProdukInputPanel5;
    private javax.swing.JTextField idProdukInputTextField;
    private com.toedter.calendar.JDateChooser jDateChooser;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPanel jenisProdukInputPanel;
    private javax.swing.JTextField jumlahProdukInputTextfield;
    private javax.swing.JPanel kendaraanFormPanel2;
    private javax.swing.JPanel kendaraanFormPanel3;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JScrollPane makananScrollPane;
    private javax.swing.JScrollPane minumanScrollPane;
    private javax.swing.JScrollPane minumanScrollPane1;
    private javax.swing.JTextField namaKaryawanInputTextField;
    private javax.swing.JTextField namaPelangganInputTextField;
    private javax.swing.JLabel namaProdukInputLabel;
    private javax.swing.JPanel namaProdukInputPanel;
    private javax.swing.JTextField namaProdukInputTextField;
    private javax.swing.JButton searchProdukInputButton;
    private javax.swing.JLabel searchProdukInputLabel;
    private javax.swing.JPanel searchProdukInputPanel;
    private javax.swing.JTextField searchProdukInputTextField;
    private javax.swing.JButton simpanProdukButton;
    private javax.swing.JButton simpanTransaksiProdukButton;
    private javax.swing.JLabel specialAtributeInputLabel;
    private javax.swing.JPanel specialAtributeInputPanel;
    private javax.swing.JPanel specialAtributeInputPanel1;
    private javax.swing.JTextField specialAtributeInputTextfield;
    private javax.swing.JTable tabelMakanan;
    private javax.swing.JTable tabelMinuman;
    private javax.swing.JTable tabelPesanan;
    private javax.swing.JLabel totalProdukInputLabel;
    private javax.swing.JLabel totalProdukInputLabel1;
    private javax.swing.JTextField totalProdukInputTextfield;
    // End of variables declaration//GEN-END:variables
}
