/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package panelView;

import control.MenuControl;
import control.MinumanControl;
import control.MakananControl;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.Menu;
import model.Minuman;
import model.Makanan;

public class MenuMainPanel extends javax.swing.JPanel {
    private MenuControl menuControl = new MenuControl();
    private MakananControl makananControl = new MakananControl();
    private MinumanControl minumanControl = new MinumanControl();
    private Menu menu = null;
    private Minuman minuman = null;
    private Makanan makanan = null;
    String action = null;
    String actionTambahGambar = null;
    private Component rootPane;
    private String selectedId = "";
    private File selectedFile;
    private String selectedFilePath;
    private byte[] gambarBytes;
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
    
    public MenuMainPanel() {
        initComponents();
        setComponentsData(false);
        showTableBySearch("");
        setEditDeleteButton(false);
        
        clearTextData();
    }
    
    private void setComponentsData(boolean value){
        idProdukInputTextField.setEnabled(value);
        namaProdukInputTextField.setEnabled(value);
        hargaProdukInputTextfield.setEnabled(value);
        jenisProdukInputButton.setEnabled(value);
        specialAtributeInputTextfield.setEnabled(value);
        jenisProdukInputButton.setEnabled(value);
        tambahGambarButton.setEnabled(value);
    }
    
    private void setEditDeleteButton(boolean value){
        barukanProdukButton.setEnabled(value);
        hapusProdukButton.setEnabled(value);
    }
    
    private void setImageIcon(byte[] gambarBytes) {
        if (gambarBytes != null) {
            try {
                BufferedImage img = ImageIO.read(new ByteArrayInputStream(gambarBytes));
                Image dimg = img.getScaledInstance(gambarLabel.getWidth(), gambarLabel.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(dimg);
                gambarLabel.setIcon(icon);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            gambarLabel.setIcon(null);
        }
    }
    
    private String getFileExtension(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return ""; // Jika tidak ada ekstensi
        }
        return name.substring(lastIndexOf + 1).toLowerCase();
    }

    // Customer Set Edit Delete Button
    
    private void clearTextData(){
        idProdukInputTextField.setText("");
        namaProdukInputTextField.setText("");
        hargaProdukInputTextfield.setText("");
        jenisProdukInputButton.setText("");
        searchProdukInputTextField.setText("");
        specialAtributeInputTextfield.setText("");
        specialAtributeInputLabel.setText("");
        setImageIcon(null);
        
    }
    
    // Customer Clear Text    
    private void setSpecialAtributeLabel(){
        if(jenisProdukInputButton.getText().equals("Makanan")){
            specialAtributeInputLabel.setText("Catatan");
        }else{
            specialAtributeInputLabel.setText("Ukuran");
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
    
    private static byte[] ubahGambar(JLabel labelGambar) throws IOException {
        ImageIcon icon = (ImageIcon) labelGambar.getIcon();
        Image img = icon.getImage();

        BufferedImage bufferedImage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = bufferedImage.createGraphics();
        g2.drawImage(img, 0, 0, null);
        g2.dispose();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "jpg", baos); 
        baos.flush();
        byte[] gambarBytes = baos.toByteArray();
        baos.close();

        return gambarBytes;
    }
 
    private boolean makananIsSelected(){
        return jenisProdukInputButton.getText().equals("Makanan");
    }
    

    
    private void showTableBySearch(String target){
        tabelMakanan.setModel(makananControl.showTableBySearch(target));
        tabelMinuman.setModel(minumanControl.showTableBySearch(target));
        addHeaderClickListener(tabelMakanan);
        addHeaderClickListener(tabelMinuman);
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
        ProdukFormPanel = new javax.swing.JPanel();
        ProdukButtonPanel = new javax.swing.JPanel();
        barukanProdukButton = new javax.swing.JButton();
        hapusProdukButton = new javax.swing.JButton();
        tambahProdukButton = new javax.swing.JButton();
        idProdukInputPanel = new javax.swing.JPanel();
        idProdukInputLabel = new javax.swing.JLabel();
        idProdukInputTextField = new javax.swing.JTextField();
        namaProdukInputPanel = new javax.swing.JPanel();
        namaProdukInputLabel = new javax.swing.JLabel();
        namaProdukInputTextField = new javax.swing.JTextField();
        hargaProdukInputPanel = new javax.swing.JPanel();
        hargaProdukInputLabel = new javax.swing.JLabel();
        hargaProdukInputTextfield = new javax.swing.JTextField();
        jenisProdukInputPanel = new javax.swing.JPanel();
        jenisProdukInputLabel = new javax.swing.JLabel();
        jenisProdukInputButton = new javax.swing.JButton();
        kendaraanFormPanel2 = new javax.swing.JPanel();
        simpanProdukButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        specialAtributeInputPanel = new javax.swing.JPanel();
        specialAtributeInputLabel = new javax.swing.JLabel();
        specialAtributeInputTextfield = new javax.swing.JTextField();
        gambarPanel = new javax.swing.JPanel();
        gambarLabel = new javax.swing.JLabel();
        tambahGambarButton = new javax.swing.JButton();
        makananScrollPane = new javax.swing.JScrollPane();
        tabelMakanan = new javax.swing.JTable();
        minumanScrollPane = new javax.swing.JScrollPane();
        tabelMinuman = new javax.swing.JTable();

        mainPanel.setBackground(new java.awt.Color(255, 221, 186));

        searchProdukInputPanel.setBackground(new java.awt.Color(255, 221, 186));

        searchProdukInputLabel.setBackground(new java.awt.Color(255, 221, 186));
        searchProdukInputLabel.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        searchProdukInputLabel.setForeground(new java.awt.Color(137, 92, 3));
        searchProdukInputLabel.setText("Pencarian Produk");

        searchProdukInputTextField.setBackground(new java.awt.Color(255, 255, 255));
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

        javax.swing.GroupLayout searchProdukInputPanelLayout = new javax.swing.GroupLayout(searchProdukInputPanel);
        searchProdukInputPanel.setLayout(searchProdukInputPanelLayout);
        searchProdukInputPanelLayout.setHorizontalGroup(
            searchProdukInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchProdukInputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchProdukInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchProdukInputLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(searchProdukInputPanelLayout.createSequentialGroup()
                        .addComponent(searchProdukInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(searchProdukInputButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        searchProdukInputPanelLayout.setVerticalGroup(
            searchProdukInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchProdukInputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchProdukInputLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(searchProdukInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchProdukInputTextField)
                    .addComponent(searchProdukInputButton, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addContainerGap(35, Short.MAX_VALUE))
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

        tambahProdukButton.setBackground(new java.awt.Color(51, 151, 56));
        tambahProdukButton.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        tambahProdukButton.setForeground(new java.awt.Color(255, 255, 255));
        tambahProdukButton.setText("Tambah");
        tambahProdukButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahProdukButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ProdukButtonPanelLayout = new javax.swing.GroupLayout(ProdukButtonPanel);
        ProdukButtonPanel.setLayout(ProdukButtonPanelLayout);
        ProdukButtonPanelLayout.setHorizontalGroup(
            ProdukButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProdukButtonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tambahProdukButton)
                .addGap(18, 18, 18)
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
                    .addComponent(barukanProdukButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tambahProdukButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hapusProdukButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        idProdukInputPanel.setBackground(new java.awt.Color(255, 221, 186));

        idProdukInputLabel.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        idProdukInputLabel.setForeground(new java.awt.Color(137, 92, 3));
        idProdukInputLabel.setText("ID Produk");

        idProdukInputTextField.setBackground(new java.awt.Color(255, 255, 255));
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

        namaProdukInputLabel.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        namaProdukInputLabel.setForeground(new java.awt.Color(137, 92, 3));
        namaProdukInputLabel.setText("Nama Produk");

        namaProdukInputTextField.setBackground(new java.awt.Color(255, 255, 255));
        namaProdukInputTextField.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N

        javax.swing.GroupLayout namaProdukInputPanelLayout = new javax.swing.GroupLayout(namaProdukInputPanel);
        namaProdukInputPanel.setLayout(namaProdukInputPanelLayout);
        namaProdukInputPanelLayout.setHorizontalGroup(
            namaProdukInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(namaProdukInputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(namaProdukInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(namaProdukInputTextField)
                    .addComponent(namaProdukInputLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        namaProdukInputPanelLayout.setVerticalGroup(
            namaProdukInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(namaProdukInputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(namaProdukInputLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(namaProdukInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        hargaProdukInputPanel.setBackground(new java.awt.Color(255, 221, 186));

        hargaProdukInputLabel.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        hargaProdukInputLabel.setForeground(new java.awt.Color(137, 92, 3));
        hargaProdukInputLabel.setText("Harga");

        hargaProdukInputTextfield.setBackground(new java.awt.Color(255, 255, 255));
        hargaProdukInputTextfield.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        hargaProdukInputTextfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                hargaProdukInputTextfieldKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout hargaProdukInputPanelLayout = new javax.swing.GroupLayout(hargaProdukInputPanel);
        hargaProdukInputPanel.setLayout(hargaProdukInputPanelLayout);
        hargaProdukInputPanelLayout.setHorizontalGroup(
            hargaProdukInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hargaProdukInputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(hargaProdukInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(hargaProdukInputTextfield, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                    .addComponent(hargaProdukInputLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        hargaProdukInputPanelLayout.setVerticalGroup(
            hargaProdukInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hargaProdukInputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(hargaProdukInputLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hargaProdukInputTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jenisProdukInputPanel.setBackground(new java.awt.Color(255, 221, 186));

        jenisProdukInputLabel.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        jenisProdukInputLabel.setForeground(new java.awt.Color(137, 92, 3));
        jenisProdukInputLabel.setText("Jenis Produk");

        jenisProdukInputButton.setBackground(new java.awt.Color(70, 39, 7));
        jenisProdukInputButton.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        jenisProdukInputButton.setForeground(new java.awt.Color(255, 255, 255));
        jenisProdukInputButton.setText("Minuman");
        jenisProdukInputButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jenisProdukInputButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jenisProdukInputPanelLayout = new javax.swing.GroupLayout(jenisProdukInputPanel);
        jenisProdukInputPanel.setLayout(jenisProdukInputPanelLayout);
        jenisProdukInputPanelLayout.setHorizontalGroup(
            jenisProdukInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jenisProdukInputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jenisProdukInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jenisProdukInputPanelLayout.createSequentialGroup()
                        .addComponent(jenisProdukInputButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jenisProdukInputLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jenisProdukInputPanelLayout.setVerticalGroup(
            jenisProdukInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jenisProdukInputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jenisProdukInputLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jenisProdukInputButton, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addContainerGap())
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
                        .addGap(0, 248, Short.MAX_VALUE))
                    .addGroup(ProdukFormPanelLayout.createSequentialGroup()
                        .addGroup(ProdukFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(namaProdukInputPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(idProdukInputPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(ProdukFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                .addContainerGap(16, Short.MAX_VALUE))
        );

        kendaraanFormPanel2.setBackground(new java.awt.Color(255, 221, 186));

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

        cancelButton.setBackground(new java.awt.Color(237, 78, 5));
        cancelButton.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        cancelButton.setForeground(new java.awt.Color(255, 255, 255));
        cancelButton.setText("Batalkan");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        specialAtributeInputPanel.setBackground(new java.awt.Color(255, 221, 186));

        specialAtributeInputLabel.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        specialAtributeInputLabel.setForeground(new java.awt.Color(137, 92, 3));
        specialAtributeInputLabel.setText("Catatan");

        specialAtributeInputTextfield.setBackground(new java.awt.Color(255, 255, 255));
        specialAtributeInputTextfield.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        specialAtributeInputTextfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                specialAtributeInputTextfieldKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout specialAtributeInputPanelLayout = new javax.swing.GroupLayout(specialAtributeInputPanel);
        specialAtributeInputPanel.setLayout(specialAtributeInputPanelLayout);
        specialAtributeInputPanelLayout.setHorizontalGroup(
            specialAtributeInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(specialAtributeInputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(specialAtributeInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(specialAtributeInputTextfield, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                    .addComponent(specialAtributeInputLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        specialAtributeInputPanelLayout.setVerticalGroup(
            specialAtributeInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(specialAtributeInputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(specialAtributeInputLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(specialAtributeInputTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gambarPanel.setBackground(new java.awt.Color(254, 254, 254));
        gambarPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));

        gambarLabel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout gambarPanelLayout = new javax.swing.GroupLayout(gambarPanel);
        gambarPanel.setLayout(gambarPanelLayout);
        gambarPanelLayout.setHorizontalGroup(
            gambarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gambarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gambarLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                .addContainerGap())
        );
        gambarPanelLayout.setVerticalGroup(
            gambarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gambarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gambarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tambahGambarButton.setText("Tambah Gambar");
        tambahGambarButton.setMinimumSize(new java.awt.Dimension(125, 21));
        tambahGambarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahGambarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kendaraanFormPanel2Layout = new javax.swing.GroupLayout(kendaraanFormPanel2);
        kendaraanFormPanel2.setLayout(kendaraanFormPanel2Layout);
        kendaraanFormPanel2Layout.setHorizontalGroup(
            kendaraanFormPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kendaraanFormPanel2Layout.createSequentialGroup()
                .addComponent(specialAtributeInputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(kendaraanFormPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kendaraanFormPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(gambarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tambahGambarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(simpanProdukButton, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        kendaraanFormPanel2Layout.setVerticalGroup(
            kendaraanFormPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kendaraanFormPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(specialAtributeInputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(gambarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(kendaraanFormPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(simpanProdukButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tambahGambarButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchProdukInputPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ProdukFormPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(makananScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(191, 191, 191)
                                .addComponent(kendaraanFormPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(minumanScrollPane)))))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(searchProdukInputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ProdukFormPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kendaraanFormPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(minumanScrollPane)
                    .addComponent(makananScrollPane))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchProdukInputTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchProdukInputTextFieldKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyChar()=='\n'){
            showTableBySearch(searchProdukInputTextField.getText());
        }
    }//GEN-LAST:event_searchProdukInputTextFieldKeyPressed

    private void searchProdukInputButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchProdukInputButtonActionPerformed
        // TODO add your handling code here:
        showTableBySearch(searchProdukInputTextField.getText());
    }//GEN-LAST:event_searchProdukInputButtonActionPerformed

    private void barukanProdukButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barukanProdukButtonActionPerformed
        // TODO add your handling code here:
        action = "update";
        setComponentsData(true);
        idProdukInputTextField.setEnabled(false);
    }//GEN-LAST:event_barukanProdukButtonActionPerformed

    private void hapusProdukButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusProdukButtonActionPerformed
        // TODO add your handling code here:
        int opsi = JOptionPane.showConfirmDialog(rootPane, "Yakin Ingin Hapus ?", "Hapus Data", JOptionPane.YES_NO_OPTION);
        if( opsi == JOptionPane.NO_OPTION || opsi == JOptionPane.CLOSED_OPTION)
        return;

        menuControl.deleteDataMenu(idProdukInputTextField.getText());
        clearTextData();
        setEditDeleteButton(false);
        setComponentsData(false);
        tambahProdukButton.setEnabled(true);
        showTableBySearch("");
    }//GEN-LAST:event_hapusProdukButtonActionPerformed

    private void tambahProdukButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahProdukButtonActionPerformed
        // TODO add your handling code here:
        action = "add";
        clearTextData();
        setEditDeleteButton(false);
        setComponentsData(true);
        setEditDeleteButton(false);

        idProdukInputTextField.setEnabled(false);
        idProdukInputTextField.setText(menuControl.generateId());
        jenisProdukInputButton.setText("Minuman");
        setSpecialAtributeLabel();
    }//GEN-LAST:event_tambahProdukButtonActionPerformed

    private void idProdukInputTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idProdukInputTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idProdukInputTextFieldActionPerformed

    private void hargaProdukInputTextfieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_hargaProdukInputTextfieldKeyTyped
        // TODO add your handling code here:
        char key = evt.getKeyChar();
        if(!Character.isDigit(key) && key != KeyEvent.VK_BACK_SPACE || key == '.'){
            evt.consume();
            JOptionPane.showMessageDialog(
                null, "Hanya bisa masukan angka !!", "Input Failure", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_hargaProdukInputTextfieldKeyTyped

    private void jenisProdukInputButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jenisProdukInputButtonActionPerformed
        // TODO add your handling code here:
        switch(jenisProdukInputButton.getText()){
            case "Makanan": 
                jenisProdukInputButton.setText("Minuman"); 
                break;
            case "Minuman": 
                jenisProdukInputButton.setText("Makanan"); 
                break;
        }
        setSpecialAtributeLabel();
    }//GEN-LAST:event_jenisProdukInputButtonActionPerformed

    private void simpanProdukButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanProdukButtonActionPerformed
        // TODO add your handling code here:
        if(action == null)
        return;
        
            int dialog = JOptionPane.showConfirmDialog(rootPane, "yakin ingin melakukan " + action + "?");
            if(dialog == JOptionPane.CLOSED_OPTION || dialog == JOptionPane.NO_OPTION || dialog == JOptionPane.CANCEL_OPTION)
            return;

            switch (action){
                case "add":
                if(makananIsSelected()){
                    makanan = new Makanan(specialAtributeInputTextfield.getText(), namaProdukInputTextField.getText(),
                        jenisProdukInputButton.getText(), Float.parseFloat(hargaProdukInputTextfield.getText()), gambarBytes);
                    makananControl.insertDataMenu(makanan);
                }else{
                    minuman = new Minuman(specialAtributeInputTextfield.getText(), namaProdukInputTextField.getText(),
                        jenisProdukInputButton.getText(), Float.parseFloat(hargaProdukInputTextfield.getText()), gambarBytes);
                    minumanControl.insertDataMenu(minuman);
                }
                clearTextData();
                setEditDeleteButton(false);
                setComponentsData(false);
                showTableBySearch("");
                break;
                case "update":        
                if(makananIsSelected()){
                    try {
                        makanan = new Makanan(specialAtributeInputTextfield.getText(),idProdukInputTextField.getText(), namaProdukInputTextField.getText(),
                                jenisProdukInputButton.getText(), Float.parseFloat(hargaProdukInputTextfield.getText()), ubahGambar(gambarLabel));
                    } catch (IOException ex) {
                        Logger.getLogger(MenuMainPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                        makananControl.updateDataProduk(makanan);
                }else{
                    try {
                        minuman = new Minuman(specialAtributeInputTextfield.getText(),idProdukInputTextField.getText(), namaProdukInputTextField.getText(),
                                jenisProdukInputButton.getText(), Float.parseFloat(hargaProdukInputTextfield.getText()), ubahGambar(gambarLabel));
                    } catch (IOException ex) {
                        Logger.getLogger(MenuMainPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    minumanControl.updateDataProduk(minuman);
                }
                clearTextData();
                setEditDeleteButton(false);
                setComponentsData(false);
                showTableBySearch("");
                break;
                default:
                break;
                
            }
            showTableBySearch("");
            tambahProdukButton.setEnabled(true);
            actionTambahGambar = null;
            action = null;
    }//GEN-LAST:event_simpanProdukButtonActionPerformed

    private void specialAtributeInputTextfieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_specialAtributeInputTextfieldKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_specialAtributeInputTextfieldKeyTyped

    private void tabelMakananMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMakananMouseClicked
        tabelMinuman.clearSelection();
        action = "update";
        
        tambahProdukButton.setEnabled(false);
        cancelButton.setEnabled(true);
        simpanProdukButton.setEnabled(true);        
        setEditDeleteButton(true);
        
        setComponentsData(false);
        
        int clickedRow = tabelMakanan.getSelectedRow();
        
        if (tabelMakanan.getRowSorter() != null) {
            clickedRow = tabelMakanan.convertRowIndexToModel(clickedRow);
        }
        
        TableModel tableModel = tabelMakanan.getModel();

        selectedId = tableModel.getValueAt(clickedRow, 0).toString();
        
        idProdukInputTextField.setText(tableModel.getValueAt(clickedRow, 0).toString());
        namaProdukInputTextField.setText(tableModel.getValueAt(clickedRow, 1).toString());
        jenisProdukInputButton.setText(tableModel.getValueAt(clickedRow, 2).toString());
        specialAtributeInputTextfield.setText(tableModel.getValueAt(clickedRow, 3).toString());
        hargaProdukInputTextfield.setText(tableModel.getValueAt(clickedRow, 4).toString());
        setSpecialAtributeLabel();
        setImageIcon((byte[]) tableModel.getValueAt(clickedRow, 5));
        cancelButton.setEnabled(true);
    }//GEN-LAST:event_tabelMakananMouseClicked

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        clearTextData();
        setEditDeleteButton(false);
        setComponentsData(false);
        setEditDeleteButton(false);
        tambahProdukButton.setEnabled(true);
        tabelMakanan.clearSelection();
        tabelMinuman.clearSelection();
        gambarLabel.setIcon(null);
        showTableBySearch("");
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void tabelMinumanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMinumanMouseClicked
        tabelMakanan.clearSelection();

        action = "update";
        
        tambahProdukButton.setEnabled(false);
        cancelButton.setEnabled(true);
        simpanProdukButton.setEnabled(true);        
        setEditDeleteButton(true);
        
        setComponentsData(false);

        
        int clickedRow = tabelMinuman.getSelectedRow();
        TableModel tableModel = tabelMinuman.getModel();
        
        if (tabelMinuman.getRowSorter() != null) {
            clickedRow = tabelMinuman.convertRowIndexToModel(clickedRow);
        }
         
        selectedId = tableModel.getValueAt(clickedRow, 0).toString();
        
        idProdukInputTextField.setText(tableModel.getValueAt(clickedRow, 0).toString());
        namaProdukInputTextField.setText(tableModel.getValueAt(clickedRow, 1).toString());
        jenisProdukInputButton.setText(tableModel.getValueAt(clickedRow, 2).toString());
        specialAtributeInputTextfield.setText(tableModel.getValueAt(clickedRow, 3).toString());
        hargaProdukInputTextfield.setText(tableModel.getValueAt(clickedRow, 4).toString());
        setSpecialAtributeLabel();
        setImageIcon((byte[]) tableModel.getValueAt(clickedRow, 5));
        cancelButton.setEnabled(true);
    }//GEN-LAST:event_tabelMinumanMouseClicked

    private void tambahGambarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahGambarButtonActionPerformed
        if(action == null)
        return;
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Gambar", "jpg", "png", "jpeg"));
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                BufferedImage img = ImageIO.read(selectedFile);
                Image dimg = img.getScaledInstance(gambarLabel.getWidth(), gambarLabel.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(dimg);
                gambarLabel.setIcon(icon);

                // Tentukan format berdasarkan ekstensi file
                String extension = getFileExtension(selectedFile);
                if (!extension.equals("jpg") && !extension.equals("jpeg") && !extension.equals("png")) {
                    throw new IOException("Unsupported file format: " + extension);
                }

                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write(img, extension, baos);
                baos.flush();
                gambarBytes = baos.toByteArray();
                baos.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
    }//GEN-LAST:event_tambahGambarButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ProdukButtonPanel;
    private javax.swing.JPanel ProdukFormPanel;
    private javax.swing.JButton barukanProdukButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel gambarLabel;
    private javax.swing.JPanel gambarPanel;
    private javax.swing.JButton hapusProdukButton;
    private javax.swing.JLabel hargaProdukInputLabel;
    private javax.swing.JPanel hargaProdukInputPanel;
    private javax.swing.JTextField hargaProdukInputTextfield;
    private javax.swing.JLabel idProdukInputLabel;
    private javax.swing.JPanel idProdukInputPanel;
    private javax.swing.JTextField idProdukInputTextField;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JButton jenisProdukInputButton;
    private javax.swing.JLabel jenisProdukInputLabel;
    private javax.swing.JPanel jenisProdukInputPanel;
    private javax.swing.JPanel kendaraanFormPanel2;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JScrollPane makananScrollPane;
    private javax.swing.JScrollPane minumanScrollPane;
    private javax.swing.JLabel namaProdukInputLabel;
    private javax.swing.JPanel namaProdukInputPanel;
    private javax.swing.JTextField namaProdukInputTextField;
    private javax.swing.JButton searchProdukInputButton;
    private javax.swing.JLabel searchProdukInputLabel;
    private javax.swing.JPanel searchProdukInputPanel;
    private javax.swing.JTextField searchProdukInputTextField;
    private javax.swing.JButton simpanProdukButton;
    private javax.swing.JLabel specialAtributeInputLabel;
    private javax.swing.JPanel specialAtributeInputPanel;
    private javax.swing.JTextField specialAtributeInputTextfield;
    private javax.swing.JTable tabelMakanan;
    private javax.swing.JTable tabelMinuman;
    private javax.swing.JButton tambahGambarButton;
    private javax.swing.JButton tambahProdukButton;
    // End of variables declaration//GEN-END:variables
}
