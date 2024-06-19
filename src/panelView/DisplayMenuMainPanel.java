/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package panelView;

import control.MakananControl;
import control.MinumanControl;
import dao.MakananDAO;
import dao.MinumanDAO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import model.Makanan;
import model.Menu;
import model.Minuman;

/**
 *
 * @author yobel
 */
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class DisplayMenuMainPanel extends JPanel {
    private MakananControl makananControl;
    private MinumanControl minumanControl;
    private ArrayList<Makanan> makananList;
    private ArrayList<Minuman> minumanList;

    /**
     * Creates new form DisplayMenuMainPanel
     */
    public DisplayMenuMainPanel() {
        makananControl = new MakananControl(new MakananDAO());
        minumanControl = new MinumanControl(new MinumanDAO());
        makananList = new ArrayList<>(makananControl.showListMenu());
        minumanList = new ArrayList<>(minumanControl.showListMenu());
        
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        this.setBackground(new Color(255, 218, 182));

        JPanel makananPanel = new JPanel();
        makananPanel.setLayout(new GridBagLayout());
        makananPanel.setBackground(new Color(255, 218, 182));

        JPanel minumanPanel = new JPanel();
        minumanPanel.setLayout(new GridBagLayout());
        minumanPanel.setBackground(new Color(255, 218, 182));

        initMenuDisplay(makananPanel, makananList);
        initMenuDisplay(minumanPanel, minumanList);

        
        JLabel makananLabel = new JLabel("Makanan", JLabel.CENTER);
        makananLabel.setFont(new Font("Serif", Font.BOLD, 24)); // Atur font di sini
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0.5;
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(10, 10, 10, 10);
        add(makananLabel, c);

        c.gridy = 1;
        add(makananPanel, c);

        // Menambahkan separator (garis pemisah)
        c.gridx = 1;
        c.gridy = 0;
        c.gridheight = 2;
        c.weightx = 0;
        c.insets = new Insets(0, 10, 0, 10);
        add(new JSeparator(SwingConstants.VERTICAL), c);

        
        JLabel minumanLabel = new JLabel("Minuman", JLabel.CENTER);
        minumanLabel.setFont(new Font("Serif", Font.BOLD, 24)); // Atur font di sini
        c.gridx = 2;
        c.gridy = 0;
        c.gridheight = 1;
        c.weightx = 0.5;
        c.insets = new Insets(10, 10, 10, 10);
        add(minumanLabel, c);

        c.gridy = 1;
        add(minumanPanel, c);
    }

    private void initMenuDisplay(JPanel panel, ArrayList<? extends Menu> menuList) {
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.NORTH;
        c.weightx = 0.5;
        c.weighty = 1;

        for (int i = 0; i < menuList.size(); i++) {
            Menu menu = menuList.get(i);

            JPanel menuPanel = new JPanel(new BorderLayout());
            menuPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
            menuPanel.setBackground(new Color(240, 240, 240));
            menuPanel.setPreferredSize(new Dimension(200, 250)); // Set ukuran preferensi untuk panel

            JPanel infoPanel1 = new JPanel();
            infoPanel1.setLayout(new GridLayout(1, 1));
            infoPanel1.setBackground(new Color(240, 240, 240));
            infoPanel1.setBorder(new EmptyBorder(10, 5, 5, 5));

            // Menampilkan gambar
            JLabel imageLabel = new JLabel();
            imageLabel.setHorizontalAlignment(JLabel.CENTER);
            imageLabel.setBorder(new EmptyBorder(5, 5, 5, 5));
            ImageIcon imageIcon = new ImageIcon(new ImageIcon(menu.getGambar()).getImage().getScaledInstance(150, 100, Image.SCALE_SMOOTH));
            imageLabel.setIcon(imageIcon);
            menuPanel.add(imageLabel, BorderLayout.CENTER);

            // Menampilkan informasi menu
            JPanel infoPanel2 = new JPanel();
            infoPanel2.setLayout(new GridLayout(3, 1));
            infoPanel2.setBackground(new Color(240, 240, 240));
            infoPanel2.setBorder(new EmptyBorder(5, 5, 10, 5));

            JLabel namaMenuLabel = new JLabel(menu.getNama_menu());
            namaMenuLabel.setHorizontalAlignment(JLabel.CENTER);
            namaMenuLabel.setFont(new Font("Arial", Font.BOLD, 13));

            JLabel jenisMenuLabel = new JLabel("Kategori : " + menu.getJenis_menu());
            jenisMenuLabel.setHorizontalAlignment(JLabel.CENTER);
            jenisMenuLabel.setFont(new Font("Arial", Font.PLAIN, 12));

            JLabel hargaLabel = new JLabel("Harga : " + menu.getHarga());
            hargaLabel.setHorizontalAlignment(JLabel.CENTER);
            hargaLabel.setFont(new Font("Arial", Font.PLAIN, 12));

            infoPanel1.add(namaMenuLabel);
            infoPanel2.add(jenisMenuLabel);
            infoPanel2.add(hargaLabel);
            menuPanel.add(infoPanel2, BorderLayout.SOUTH);
            menuPanel.add(infoPanel1, BorderLayout.NORTH);

            c.gridx = i % 2;
            c.gridy = i / 2;
            panel.add(menuPanel, c);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Display Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new DisplayMenuMainPanel());
        frame.pack();
        frame.setVisible(true);
    }


    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 218, 182));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1231, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 939, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
