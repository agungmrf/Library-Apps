/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Agung Ma'ruf
 */
public class MenuPerpustakaan extends javax.swing.JFrame {

    private DefaultTableModel model;
    private JasperDesign JasDes;
    private JasperReport JasRep;
    private Map param;
    private JasperPrint JasPri;

    public MenuPerpustakaan() {
        initComponents();
        setLocationRelativeTo(this);
        Koneksi.Database.KoneksiDB();
        tampil_tblBuku();
        tampil_tblMhs();
        tampil_tblPeminjam();

    }

    public JTable getTblBuku() {
        return tblBuku;
    }

    public JTable getTblMhs() {
        return tblMhs;
    }

    public JTable getTblPeminjam() {
        return tblPeminjam;
    }

    public JTextField getTxtCari() {
        return txtCari;
    }

    public JTextField getTxtCari1() {
        return txtCari1;
    }

    public JTextField getTxtCari2() {
        return txtCari2;
    }

    public void tampil_tblBuku() {
        Object[] baris = {"Kode Buku", "Judul Buku", "Tanggal Terbit", "Pengarang"};
        DefaultTableModel tblModel = new DefaultTableModel(null, baris);
        tblBuku.setModel(tblModel);
        Connection con = new Koneksi.Database().KoneksiDB();
        try {
            String sql = "select * from tbl_buku order by kd_buku asc";
            java.sql.Statement stat = con.createStatement();
            java.sql.ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                String kode_buku = hasil.getString("kd_buku");
                String judul_buku = hasil.getString("jdl_buku");
                String tanggal_terbit = hasil.getString("tgl_terbit");
                String pengarang = hasil.getString("pengarang");
                String[] data = {kode_buku, judul_buku, tanggal_terbit, pengarang};
                tblModel.addRow(data);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Menampilkan data GAGAL", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void tampil_tblMhs() {
        Object[] baris = {"NIM", "Nama Mahasiswa", "Tempat Lahir", "Tanggal Lahir", "Jurusan", "Tanggal Masuk"};
        DefaultTableModel tblModel = new DefaultTableModel(null, baris);
        tblMhs.setModel(tblModel);
        Connection con = new Koneksi.Database().KoneksiDB();
        try {
            String sql = "select * from tbl_mahasiswa order by nim asc";
            java.sql.Statement stat = con.createStatement();
            java.sql.ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                String nim = hasil.getString("nim");
                String nama = hasil.getString("nama");
                String tempat_lahir = hasil.getString("tmpt_lahir");
                String tanggal_lahir = hasil.getString("tgl_lahir");
                String jurusan = hasil.getString("jurusan");
                String tanggal_masuk = hasil.getString("tgl_masuk");
                String[] data = {nim, nama, tempat_lahir, tanggal_lahir, jurusan, tanggal_masuk};
                tblModel.addRow(data);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Menampilkan data GAGAL", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void tampil_tblPeminjam() {
        Object[] baris = {"NIM", "Nama Mahasiswa", "Kode Buku", "Judul Buku", "Tanggal Terbit", "Tanggal Pinjam"};
        DefaultTableModel tblModel = new DefaultTableModel(null, baris);
        tblPeminjam.setModel(tblModel);
        Connection con = new Koneksi.Database().KoneksiDB();
        try {
            String sql = "select * from tbl_peminjam order by nim asc";
            java.sql.Statement stat = con.createStatement();
            java.sql.ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                String nim = hasil.getString("nim");
                String nama = hasil.getString("nama");
                String kode_buku = hasil.getString("kd_buku");
                String judul_buku = hasil.getString("jdl_buku");
                String tanggal_terbit = hasil.getString("tgl_terbit");
                String tanggal_pinjam = hasil.getString("tgl_pinjam");
                String[] data = {nim, nama, kode_buku, judul_buku, tanggal_terbit, tanggal_pinjam};
                tblModel.addRow(data);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Menampilkan data GAGAL", "Informasi", JOptionPane.INFORMATION_MESSAGE);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTab = new javax.swing.JTabbedPane();
        data_buku = new javax.swing.JPanel();
        txtCari2 = new javax.swing.JTextField();
        btnCari2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBuku = new javax.swing.JTable();
        btn_ibuku = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        data_mhs = new javax.swing.JPanel();
        txtCari1 = new javax.swing.JTextField();
        btnCari1 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblMhs = new javax.swing.JTable();
        btn_imhs = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        data_peminjaman = new javax.swing.JPanel();
        txtCari = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPeminjam = new javax.swing.JTable();
        btn_ipeminjam = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btn_cetak = new javax.swing.JButton();
        btn_cetak1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        File = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        Edit = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 0, 102));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Logo-Budi-Luhur-Universitas-Budi-Luhur-PNG.png"))); // NOI18N

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/kisspng-state-library-of-victoria-meridian-district-librar-vector-books-and-pens-5aa98120e573b2.8270384715210580809398 (1).png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("PERPUSTAKAAN");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("UNIVERSITAS BUDI LUHUR");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Jalan Raya Ciledug, Petukangan Utara, Jakarta Selatan");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Phone (021) 5853753 ext: 278, 279 Email: pustaka@budiluhur.ac.id");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(189, 189, 189)
                                .addComponent(jLabel4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(178, 178, 178)
                                .addComponent(jLabel5))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(148, 148, 148)
                                .addComponent(jLabel6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(210, 210, 210)))
                .addComponent(jLabel2)
                .addGap(239, 239, 239))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTab.setBackground(new java.awt.Color(0, 165, 229));

        data_buku.setBackground(new java.awt.Color(51, 0, 102));
        data_buku.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " Data Buku ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        txtCari2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCari2KeyReleased(evt);
            }
        });

        btnCari2.setText("Cari");
        btnCari2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCari2ActionPerformed(evt);
            }
        });

        tblBuku.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Kode Buku", "Judul Buku", "Tanggal Terbit", "Pengarang"
            }
        ));
        jScrollPane1.setViewportView(tblBuku);

        btn_ibuku.setText("Input Data Buku");
        btn_ibuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ibukuActionPerformed(evt);
            }
        });

        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout data_bukuLayout = new javax.swing.GroupLayout(data_buku);
        data_buku.setLayout(data_bukuLayout);
        data_bukuLayout.setHorizontalGroup(
            data_bukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(data_bukuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(data_bukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1251, Short.MAX_VALUE)
                    .addGroup(data_bukuLayout.createSequentialGroup()
                        .addComponent(txtCari2, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCari2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(btn_ibuku)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        data_bukuLayout.setVerticalGroup(
            data_bukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(data_bukuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(data_bukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(data_bukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCari2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_ibuku)
                        .addComponent(jButton1))
                    .addComponent(txtCari2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jTab.addTab("Data Buku", null, data_buku, "");
        data_buku.getAccessibleContext().setAccessibleName("Data Buku");

        data_mhs.setBackground(new java.awt.Color(51, 0, 102));
        data_mhs.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " Data Mahasiswa ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        btnCari1.setText("Cari");
        btnCari1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCari1ActionPerformed(evt);
            }
        });

        tblMhs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "NIM", "Nama Mahasiswa", "Tempat Lahir", "Tanggal Lahir", "Jurusan", "Tanggal Masuk"
            }
        ));
        jScrollPane4.setViewportView(tblMhs);

        btn_imhs.setText("Input Data Mahasiswa");
        btn_imhs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_imhsActionPerformed(evt);
            }
        });

        jButton2.setText("Refresh");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout data_mhsLayout = new javax.swing.GroupLayout(data_mhs);
        data_mhs.setLayout(data_mhsLayout);
        data_mhsLayout.setHorizontalGroup(
            data_mhsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(data_mhsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(data_mhsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1251, Short.MAX_VALUE)
                    .addGroup(data_mhsLayout.createSequentialGroup()
                        .addComponent(txtCari1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCari1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(btn_imhs)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        data_mhsLayout.setVerticalGroup(
            data_mhsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(data_mhsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(data_mhsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(data_mhsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCari1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_imhs)
                        .addComponent(jButton2))
                    .addComponent(txtCari1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jTab.addTab("Data Mahasiswa", data_mhs);
        data_mhs.getAccessibleContext().setAccessibleName("Data Mahasiswa");

        data_peminjaman.setBackground(new java.awt.Color(51, 0, 102));
        data_peminjaman.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " Data Peminjaman ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        tblPeminjam.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "NIM", "Nama Mahasiswa", "Jurusan", "Kode Buku", "Judul Buku", "Tanggal Terbit", "Tanggal Pinjam"
            }
        ));
        jScrollPane2.setViewportView(tblPeminjam);

        btn_ipeminjam.setText("Input Data Peminjam");
        btn_ipeminjam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ipeminjamActionPerformed(evt);
            }
        });

        jButton3.setText("Refresh");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btn_cetak.setText("Cetak Laporan");
        btn_cetak.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cetakMouseClicked(evt);
            }
        });
        btn_cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cetakActionPerformed(evt);
            }
        });

        btn_cetak1.setText("Preview");
        btn_cetak1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cetak1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout data_peminjamanLayout = new javax.swing.GroupLayout(data_peminjaman);
        data_peminjaman.setLayout(data_peminjamanLayout);
        data_peminjamanLayout.setHorizontalGroup(
            data_peminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(data_peminjamanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(data_peminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1251, Short.MAX_VALUE)
                    .addGroup(data_peminjamanLayout.createSequentialGroup()
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCari)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(btn_ipeminjam)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, data_peminjamanLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_cetak1)
                        .addGap(18, 18, 18)
                        .addComponent(btn_cetak)))
                .addContainerGap())
        );
        data_peminjamanLayout.setVerticalGroup(
            data_peminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(data_peminjamanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(data_peminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(data_peminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCari, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_ipeminjam)
                        .addComponent(jButton3))
                    .addComponent(txtCari))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(data_peminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cetak)
                    .addComponent(btn_cetak1))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jTab.addTab("Data Peminjaman", data_peminjaman);
        data_peminjaman.getAccessibleContext().setAccessibleName("Data Peminjaman");

        File.setText("File");

        jMenuItem1.setText("Data Perpustakaan");
        File.add(jMenuItem1);

        jMenuItem2.setText("Exit");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        File.add(jMenuItem2);

        jMenuBar1.add(File);

        Edit.setText("Edit");
        jMenuBar1.add(Edit);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTab)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTab))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void btn_ibukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ibukuActionPerformed
        View.FrmEntryBuku objMhs = new View.FrmEntryBuku();
        objMhs.setLocationRelativeTo(this);
        objMhs.setVisible(true);
    }//GEN-LAST:event_btn_ibukuActionPerformed

    private void btnCari2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCari2ActionPerformed
        Connection c = (Connection) Koneksi.Database.KoneksiDB();
        DefaultTableModel initabel = new DefaultTableModel();
        initabel.addColumn("Kode Buku");
        initabel.addColumn("Judul Buku");
        initabel.addColumn("Tanggal Terbit");
        initabel.addColumn("Pengarang");
        tblBuku.setModel(initabel);

        try {
            Statement s = c.createStatement();
            String sql = "SELECT * FROM tbl_buku WHERE kd_buku='" + txtCari2.getText() + "' ";
            ResultSet r = s.executeQuery(sql);

            while (r.next()) {
                initabel.addRow(new Object[]{
                    r.getString("kd_buku"),
                    r.getString("jdl_buku"),
                    r.getString("tgl_terbit"),
                    r.getString("pengarang"),});
                tblBuku.setModel(initabel);
            }
        } catch (SQLException sql_err) {
            JOptionPane.showMessageDialog(null, "Error : " + sql_err.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCari2ActionPerformed

    private void txtCari2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCari2KeyReleased

    }//GEN-LAST:event_txtCari2KeyReleased

    private void btn_imhsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_imhsActionPerformed
        View.FrmEntryMahasiswa objMhs = new View.FrmEntryMahasiswa();
        objMhs.setLocationRelativeTo(this);
        objMhs.setVisible(true);
    }//GEN-LAST:event_btn_imhsActionPerformed

    private void btn_ipeminjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ipeminjamActionPerformed
        View.FrmEntryPeminjaman objMhs = new View.FrmEntryPeminjaman();
        objMhs.setLocationRelativeTo(this);
        objMhs.setVisible(true);
    }//GEN-LAST:event_btn_ipeminjamActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        tampil_tblBuku();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        tampil_tblMhs();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        tampil_tblPeminjam();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnCari1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCari1ActionPerformed
        Connection c = (Connection) Koneksi.Database.KoneksiDB();
        Object[] baris = {"NIM", "Nama Mahasiswa", "Tempat Lahir", "Tanggal Lahir", "Jurusan", "Tanggal Masuk"};
        DefaultTableModel tblModel = new DefaultTableModel(null, baris);
        tblMhs.setModel(tblModel);

        try {
            Statement s = c.createStatement();
            String sql = "SELECT * FROM tbl_mahasiswa WHERE nim='" + txtCari1.getText() + "' ";
            ResultSet r = s.executeQuery(sql);

            while (r.next()) {
                tblModel.addRow(new Object[]{
                    r.getString("nim"),
                    r.getString("nama"),
                    r.getString("tmpt_lahir"),
                    r.getDate("tgl_lahir"),
                    r.getString("jurusan"),
                    r.getDate("tgl_masuk"),});
                tblMhs.setModel(tblModel);
            }
        } catch (SQLException sql_err) {
            JOptionPane.showMessageDialog(null, "Error : " + sql_err.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCari1ActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        Connection c = (Connection) Koneksi.Database.KoneksiDB();
        Object[] baris = {"NIM", "Nama Mahasiswa", "Jurusan", "Kode Buku", "Judul Buku", "Tanggal Terbit", "Tanggal Pinjam"};
        DefaultTableModel tblModel = new DefaultTableModel(null, baris);
        tblPeminjam.setModel(tblModel);

        try {
            Statement s = c.createStatement();
            String sql = "SELECT * FROM tbl_peminjam WHERE nim='" + txtCari.getText() + "' ";
            ResultSet r = s.executeQuery(sql);

            while (r.next()) {
                tblModel.addRow(new Object[]{
                    r.getString("nim"),
                    r.getString("nama"),
                    r.getString("jurusan"),
                    r.getString("kd_buku"),
                    r.getString("jdl_buku"),
                    r.getDate("tgl_terbit"),
                    r.getDate("tgl_pinjam"),});
                tblPeminjam.setModel(tblModel);
            }
        } catch (SQLException sql_err) {
            JOptionPane.showMessageDialog(null, "Error : " + sql_err.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCariActionPerformed

    private void btn_cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cetakActionPerformed
//        Menyimpan file ke excel
//        try {
//            Connection conn = Koneksi.Database.KoneksiDB();
//            String path = "src/Report/report_peminjaman.jasper";
//            File xlsx = new File("D:/report_peminjaman.xlsx");
//            JasperPrint print = JasperFillManager.fillReport(path, null, conn);
//
//            JRXlsxExporter xlsxExporter = new JRXlsxExporter();
//            xlsxExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
//            xlsxExporter.setParameter(JRExporterParameter.OUTPUT_FILE, xlsx);
//            xlsxExporter.exportReport();
//
//            JOptionPane.showMessageDialog(null, "Cek file pada drive D:/Report-Peminjaman.xlsx");
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(null, "Data Tidak Dapat Dicetak!!" + ex.getMessage(),
//                    "Cetak Data", JOptionPane.ERROR_MESSAGE);
//        }
//        menyimpan file ke pdf
        try {
            Connection cn = Koneksi.Database.KoneksiDB();
            String path = "src/Report/report_peminjaman.jasper";
            File pdf = new File("D:/Report-Peminjaman.pdf");
            JasperPrint print = JasperFillManager.fillReport(path, null, cn);
            JRPdfExporter pdfExporter = new JRPdfExporter();
            pdfExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
            pdfExporter.setParameter(JRExporterParameter.OUTPUT_FILE, pdf);
            pdfExporter.exportReport();

            JOptionPane.showMessageDialog(null, "Cek file pada drive D:/Report-Peminjaman.pdf");
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null,
                    "Data Tidak Dapat di Cetak !!!" + "\n" + e.getMessage(), "Cetak Data",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_cetakActionPerformed

    private void btn_cetak1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cetak1ActionPerformed
        try {
            HashMap parameter = new HashMap();
            java.sql.Connection cn = Koneksi.Database.KoneksiDB();
            File file = new File("src/Report/report_peminjaman.jasper");
            JasperReport jr = (JasperReport) JRLoader.loadObject(file);
            JasperPrint jp = JasperFillManager.fillReport(jr, parameter, cn);
            JasperViewer.viewReport(jp, false);
            JasperViewer.setDefaultLookAndFeelDecorated(true);
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null,
                    "Data Tidak Dapat di Cetak !!!" + "\n" + e.getMessage(), "Cetak Data",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_cetak1ActionPerformed

    private void btn_cetakMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cetakMouseClicked

    }//GEN-LAST:event_btn_cetakMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
    data_buku */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPerpustakaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPerpustakaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPerpustakaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPerpustakaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPerpustakaan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Edit;
    private javax.swing.JMenu File;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnCari1;
    private javax.swing.JButton btnCari2;
    private javax.swing.JButton btn_cetak;
    private javax.swing.JButton btn_cetak1;
    private javax.swing.JButton btn_ibuku;
    private javax.swing.JButton btn_imhs;
    private javax.swing.JButton btn_ipeminjam;
    private javax.swing.JPanel data_buku;
    private javax.swing.JPanel data_mhs;
    private javax.swing.JPanel data_peminjaman;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTab;
    private javax.swing.JTable tblBuku;
    private javax.swing.JTable tblMhs;
    private javax.swing.JTable tblPeminjam;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtCari1;
    private javax.swing.JTextField txtCari2;
    // End of variables declaration//GEN-END:variables
}
