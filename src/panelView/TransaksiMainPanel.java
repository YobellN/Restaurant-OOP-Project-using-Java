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
import model.Menu;
import model.Pesanan;
import model.Minuman;
import model.Makanan;

import control.TransaksiControl;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import model.Pelanggan;
import model.Transaksi;
import table.TabelPesanan;

public class TransaksiMainPanel extends javax.swing.JPanel {

    private MenuControl menuControl = new MenuControl();
    private MakananControl makananControl = new MakananControl();
    private MinumanControl minumanControl = new MinumanControl();

    private Menu menu = null;
    private Minuman minuman = null;
    private Makanan makanan = null;

    private ArrayList<Pesanan> pesananList = new ArrayList();
    private Transaksi transaksi = null;
    private TransaksiControl tc = new TransaksiControl();

    private PesananControl pesananControl = new PesananControl();
    private Pesanan pesanan = null;

    private PelangganControl pelangganControl = new PelangganControl();
    private Pelanggan pelanggan = null;

    private Karyawan karyawan = null;

    String action = null;
    private Component rootPane;
    private String selectedId = "";
    double totalHarga = 0;

    /**
     * Creates new form KendaraanView
     */
    public boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public TransaksiMainPanel(Karyawan k) {
        initComponents();
        idPesananInputTextField.setText(tc.generateId());
        idKaryawanInputTextField.setText(k.getNama_karyawan());
        // Yang tidak perlu di ubah
        idProdukInputTextField.setEnabled(false);
        namaProdukInputTextField.setEnabled(false);
        hargaProdukInputTextfield.setEnabled(false);
        specialAtributeInputTextfield.setEnabled(false); // catatan
        idKaryawanInputTextField.setEnabled(false);
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

    private void setComponentsData(boolean value) {
        jumlahProdukInputTextfield.setEnabled(value);
    }

    private void setEditDeleteButton(boolean value) {
        barukanProdukButton.setEnabled(value);
        hapusProdukButton.setEnabled(value);
    }

    // Customer Set Edit Delete Button
    private void clearTextData() {
        idProdukInputTextField.setText("");
        namaProdukInputTextField.setText("");
        hargaProdukInputTextfield.setText("");
        searchProdukInputTextField.setText("");
        specialAtributeInputTextfield.setText("");
        specialAtributeInputLabel.setText("");
        jumlahProdukInputTextfield.setText("");

    }
    // Customer Clear Text    

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

    private void showTableMenuBySearch(String target) {
        tabelMakanan.setModel(makananControl.showTableBySearch(target));
        tabelMinuman.setModel(minumanControl.showTableBySearch(target));
        addHeaderMenu(tabelMakanan);
        addHeaderMenu(tabelMinuman);
    }

    private void showTabelPesananBySearch() {
        tabelPesanan.setModel(new TabelPesanan(pesananList));
        addHeaderPesanan(tabelPesanan);
    }
    
    private void setTotalTransaksi (){
        totalHarga = 0;
        for (Pesanan p : pesananList) {
            totalHarga += p.getSub_total();
        }
        totalProdukInputTextfield.setText(String.valueOf(totalHarga));
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
        idKaryawanInputTextField = new javax.swing.JTextField();
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
        idKaryawanLabel.setText("ID Karyawan");

        idKaryawanInputTextField.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        idKaryawanInputTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idKaryawanInputTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout idProdukInputPanel2Layout = new javax.swing.GroupLayout(idProdukInputPanel2);
        idProdukInputPanel2.setLayout(idProdukInputPanel2Layout);
        idProdukInputPanel2Layout.setHorizontalGroup(
            idProdukInputPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(idProdukInputPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(idProdukInputPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idKaryawanInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idKaryawanLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        idProdukInputPanel2Layout.setVerticalGroup(
            idProdukInputPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(idProdukInputPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(idKaryawanLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idKaryawanInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        idProdukInputPanel4.setBackground(new java.awt.Color(255, 221, 186));

        idPelangganLabel.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        idPelangganLabel.setForeground(new java.awt.Color(137, 92, 3));
        idPelangganLabel.setText("Nama Pelanggan");

        namaPelangganInputTextField.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        namaPelangganInputTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaPelangganInputTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout idProdukInputPanel4Layout = new javax.swing.GroupLayout(idProdukInputPanel4);
        idProdukInputPanel4.setLayout(idProdukInputPanel4Layout);
        idProdukInputPanel4Layout.setHorizontalGroup(
            idProdukInputPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(idProdukInputPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(idProdukInputPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(idPelangganLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(namaPelangganInputTextField))
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
        idPesananInputTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idPesananInputTextFieldActionPerformed(evt);
            }
        });

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
        idProdukInputTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idProdukInputTextFieldActionPerformed(evt);
            }
        });

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
        hargaProdukInputTextfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                hargaProdukInputTextfieldKeyTyped(evt);
            }
        });

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
        specialAtributeInputTextfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                specialAtributeInputTextfieldKeyTyped(evt);
            }
        });

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
        totalProdukInputTextfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                totalProdukInputTextfieldKeyTyped(evt);
            }
        });

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
                        .addGap(40, 40, 40)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(minumanScrollPane1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(totalProdukInputLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(totalProdukInputTextfield))))
                        .addContainerGap())
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(makananScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(minumanScrollPane)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(specialAtributeInputPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                                .addComponent(kendaraanFormPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
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
                    .addComponent(minumanScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
                    .addComponent(makananScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchProdukInputTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchProdukInputTextFieldKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyChar() == '\n') {
            showTableMenuBySearch(searchProdukInputTextField.getText());
        }
    }//GEN-LAST:event_searchProdukInputTextFieldKeyPressed

    private void searchProdukInputButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchProdukInputButtonActionPerformed
        // TODO add your handling code here:
        showTableMenuBySearch(searchProdukInputTextField.getText());
    }//GEN-LAST:event_searchProdukInputButtonActionPerformed

    private void hapusProdukButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusProdukButtonActionPerformed
        // TODO add your handling code here:
        int opsi = JOptionPane.showConfirmDialog(rootPane, "Yakin Ingin Hapus ?", "Hapus Data", JOptionPane.YES_NO_OPTION);
        if (opsi == JOptionPane.NO_OPTION || opsi == JOptionPane.CLOSED_OPTION) {
            return;
        }
        for (Pesanan p : pesananList) {
            if (p.getId_menu().equals(idProdukInputTextField.getText())) {
                pesananList.remove(p);
                break;
            }
        } 
        setTotalTransaksi();
        clearTextData();
        setEditDeleteButton(false);
        setComponentsData(false);
        showTableMenuBySearch("");
        showTabelPesananBySearch(); // UNTUK SHOW TABEL KANAN ATAS
    }//GEN-LAST:event_hapusProdukButtonActionPerformed

    private void idProdukInputTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idProdukInputTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idProdukInputTextFieldActionPerformed

    private void hargaProdukInputTextfieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_hargaProdukInputTextfieldKeyTyped
        // TODO add your handling code here:
        char key = evt.getKeyChar();
        if (!Character.isDigit(key) && key != KeyEvent.VK_BACK_SPACE || key == '.') {
            evt.consume();
            JOptionPane.showMessageDialog(
                    null, "Hanya bisa masukan angka !!", "Input Failure", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_hargaProdukInputTextfieldKeyTyped

    private void simpanProdukButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanProdukButtonActionPerformed
        // TODO add your handling code here:
        if (action == null) {
            return;
        }
        if (jumlahProdukInputTextfield.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Jumlah tidak boleh kosong!!! !!", "Input Failure", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int dialog = JOptionPane.showConfirmDialog(rootPane, "yakin ingin melakukan " + action + "?");
        if (dialog == JOptionPane.CLOSED_OPTION || dialog == JOptionPane.NO_OPTION || dialog == JOptionPane.CANCEL_OPTION) {
            return;
        }

        switch (action) {
            case "add":
                pesanan = new Pesanan(idPesananInputTextField.getText(),
                        idProdukInputTextField.getText(), namaProdukInputTextField.getText(),
                        Integer.parseInt(jumlahProdukInputTextfield.getText()),
                        (Float.parseFloat(hargaProdukInputTextfield.getText()) * Integer.parseInt(jumlahProdukInputTextfield.getText()))
                );
                pesananList.add(pesanan);
                setTotalTransaksi();
                clearTextData();
                setEditDeleteButton(false);
                setComponentsData(false);
                showTabelPesananBySearch();
                break;
            case "update":
                for (Pesanan p : pesananList) {
                    if (p.getId_menu().equals(idProdukInputTextField.getText())) {
                        // Update atribut dari pesanan
                        p.setId_menu(idProdukInputTextField.getText());
                        p.setNamaMenu(namaProdukInputTextField.getText());
                        p.setJumlah(Integer.parseInt(jumlahProdukInputTextfield.getText()));
                        p.setSub_total(menuControl.searchHargaMenu(idProdukInputTextField.getText()) * Integer.parseInt(jumlahProdukInputTextfield.getText()));
                        break;
                    }
                }
                setTotalTransaksi();
                clearTextData();
                setEditDeleteButton(false);
                setComponentsData(false);
                showTableMenuBySearch("");
                break;
            default:
                break;

        }
        tabelMakanan.setEnabled(true); // entah kenapa harus true baru tidak nge bug
        tabelMinuman.setEnabled(true);
        tabelPesanan.setEnabled(true);
        
        showTableMenuBySearch("");
        action = null;
    }//GEN-LAST:event_simpanProdukButtonActionPerformed

    private void specialAtributeInputTextfieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_specialAtributeInputTextfieldKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_specialAtributeInputTextfieldKeyTyped

    private void tabelMakananMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMakananMouseClicked
        tabelMinuman.clearSelection();
        action = "add"; // add karena bisa nambah langsung

        cancelButton.setEnabled(true);
        simpanProdukButton.setEnabled(true);
        setEditDeleteButton(false);

        setComponentsData(true);

        int clickedRow = tabelMakanan.getSelectedRow();

        if (tabelMakanan.getRowSorter() != null) {
            clickedRow = tabelMakanan.convertRowIndexToModel(clickedRow);
        }

        TableModel tableModel = tabelMakanan.getModel();

        selectedId = tableModel.getValueAt(clickedRow, 0).toString();

        idProdukInputTextField.setText(tableModel.getValueAt(clickedRow, 0).toString());
        namaProdukInputTextField.setText(tableModel.getValueAt(clickedRow, 1).toString());
        specialAtributeInputLabel.setText("Catatan");
        specialAtributeInputTextfield.setText(tableModel.getValueAt(clickedRow, 3).toString());
        hargaProdukInputTextfield.setText(tableModel.getValueAt(clickedRow, 4).toString());
        cancelButton.setEnabled(true);

    }//GEN-LAST:event_tabelMakananMouseClicked

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        clearTextData();
        setEditDeleteButton(false);
        setComponentsData(false);
        setEditDeleteButton(false);
        tabelMakanan.clearSelection();
        tabelMinuman.clearSelection();
        showTableMenuBySearch("");
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void tabelMinumanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMinumanMouseClicked
        tabelMakanan.clearSelection();
        action = "add";

        cancelButton.setEnabled(true);
        simpanProdukButton.setEnabled(true);
        setEditDeleteButton(true);

        setComponentsData(true);

        int clickedRow = tabelMinuman.getSelectedRow();
        TableModel tableModel = tabelMinuman.getModel();

        if (tabelMinuman.getRowSorter() != null) {
            clickedRow = tabelMinuman.convertRowIndexToModel(clickedRow);
        }

        selectedId = tableModel.getValueAt(clickedRow, 0).toString();

        idProdukInputTextField.setText(tableModel.getValueAt(clickedRow, 0).toString());
        namaProdukInputTextField.setText(tableModel.getValueAt(clickedRow, 1).toString());
        specialAtributeInputLabel.setText("Ukuran");
        specialAtributeInputTextfield.setText(tableModel.getValueAt(clickedRow, 3).toString());
        hargaProdukInputTextfield.setText(tableModel.getValueAt(clickedRow, 4).toString());
        cancelButton.setEnabled(true);
    }//GEN-LAST:event_tabelMinumanMouseClicked

    private void jumlahProdukInputTextfieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jumlahProdukInputTextfieldKeyTyped
        // TODO add your handling code here:
        char key = evt.getKeyChar();
        if (!Character.isDigit(key) && key != KeyEvent.VK_BACK_SPACE || key == '.') {
            evt.consume();
            JOptionPane.showMessageDialog(
                    null, "Hanya bisa masukan angka !!", "Input Failure", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jumlahProdukInputTextfieldKeyTyped

    private void tabelPesananMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelPesananMouseClicked
        // TODO add your handling code here:
        action = "update";

        setEditDeleteButton(true);

        cancelButton.setEnabled(true);
        simpanProdukButton.setEnabled(true);
        
        setComponentsData(false);
        
        int clickedRow = tabelPesanan.getSelectedRow();
        TableModel tableModel = tabelPesanan.getModel();

        if (tabelPesanan.getRowSorter() != null) {
            clickedRow = tabelPesanan.convertRowIndexToModel(clickedRow);
        }

        selectedId = tableModel.getValueAt(clickedRow, 0).toString();
        idProdukInputTextField.setText(tableModel.getValueAt(clickedRow, 0).toString());
        namaProdukInputTextField.setText(tableModel.getValueAt(clickedRow, 1).toString());
        specialAtributeInputLabel.setText("    ");
        jumlahProdukInputTextfield.setText(tableModel.getValueAt(clickedRow, 2).toString());
        cancelButton.setEnabled(true);
        
        hargaProdukInputTextfield.setText(""+menuControl.searchHargaMenu(idProdukInputTextField.getText()));
    }//GEN-LAST:event_tabelPesananMouseClicked

    private void simpanTransaksiProdukButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanTransaksiProdukButtonActionPerformed
        if (pesananList.isEmpty()) { 
            JOptionPane.showMessageDialog(rootPane, "DATA TIDAK BOLEH KOSONG!!!");
            return;
        }else if(namaPelangganInputTextField.getText().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Nama Pelanggan tidak boleh kosong!!!");
            return;
        }else if(jDateChooser.getDate() == null){
            JOptionPane.showMessageDialog(rootPane, "Tanggal tidak boleh kosong!!!");
            return;
        }
        
        int dialog = JOptionPane.showConfirmDialog(rootPane, "yakin ingin melakukan " + "Simpan Transaksi" + "?");
        if (dialog == JOptionPane.CLOSED_OPTION || dialog == JOptionPane.NO_OPTION || dialog == JOptionPane.CANCEL_OPTION) {
            return;
        }
        
        // untuk kalender
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
        
        // untuk input
        pelanggan = new Pelanggan(pelangganControl.generateId(), namaPelangganInputTextField.getText(), "-", "-");
        transaksi = new Transaksi(idPesananInputTextField.getText(), karyawan.getId_karyawan(), 
                pelangganControl.generateId(), formattedDate, Float.parseFloat(totalProdukInputTextfield.getText()));
        // untuk insert sql
        pelangganControl.insertDataPelanggan(pelanggan);
        tc.insertDataTransaksi(transaksi);
        pesananControl.insertDataPesanan(pesananList);
        
        // untuk bersihkan input field 
        clearTextData();
        namaPelangganInputTextField.setText(""); 
        jDateChooser.setDateFormatString("");
        
        setEditDeleteButton(false);
        setComponentsData(false);
        
        pesananList.removeAll(pesananList); // membersihkan list
        showTabelPesananBySearch();
        showTableMenuBySearch("");
        action = null;
        
        // melakukan increment ID jika masih stay 
        idPesananInputTextField.setText(tc.generateId());
    }//GEN-LAST:event_simpanTransaksiProdukButtonActionPerformed

    private void totalProdukInputTextfieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_totalProdukInputTextfieldKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_totalProdukInputTextfieldKeyTyped

    private void idKaryawanInputTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idKaryawanInputTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idKaryawanInputTextFieldActionPerformed

    private void namaPelangganInputTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaPelangganInputTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaPelangganInputTextFieldActionPerformed

    private void idPesananInputTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idPesananInputTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idPesananInputTextFieldActionPerformed

    private void barukanProdukButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barukanProdukButtonActionPerformed
        // TODO add your handling code here:
        action = "update";
        setComponentsData(true);
        tabelPesanan.setEnabled(false); // kalo lagi di edit jangan dipencet, bisa nimpa data nanti
        tabelMakanan.setEnabled(false); // kalo lagi di edit jangan dipencet, bisa nimpa data nanti
        tabelMinuman.setEnabled(false); // kalo lagi di edit jangan dipencet, bisa nimpa data nanti
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
    private javax.swing.JTextField idKaryawanInputTextField;
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
