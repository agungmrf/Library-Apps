/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAO_Interface;
import DAO.DAO_Peminjaman;
import Model.varPeminjaman;
import View.FrmEntryPeminjaman;
import View.MenuPerpustakaan;
import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Agung Ma'ruf
 */
public class Controller_Peminjam {
    FrmEntryPeminjaman form;
    DAO_Interface<varPeminjaman> model;
    List<varPeminjaman> list;
    String[] header;
    
    public Controller_Peminjam(FrmEntryPeminjaman form) {
        this.form = form;
        model = new DAO_Peminjaman();
        list = model.getAll();
        header = new String[]{"NIM", "Nama Mahasiswa", "Kode Buku", "Judul Buku", "Tanggal Terbit,", "Tanggal Pinjam"};
        form.getTblPeminjam().setShowGrid(true);
        form.getTblPeminjam().setShowVerticalLines(true);
        form.getTblPeminjam().setGridColor(Color.blue);
    }
    
    public void reset(){
        form.getTxtNim().setText("");
        form.getTxtNama().setText("");
        form.getTxtKdBuku().setText("");
        form.getTxtJdlBuku().setText("");
        form.getTxtTglTerbit().setDate(null);
        form.getTxtTglPinjam().setDate(null);
        form.getTxtNim().requestFocus();
        isiTable();
    }
    
    public void isiTable() {
        list = model.getAll();
        DefaultTableModel tblModel = new DefaultTableModel(new Object[][]{}, header) {
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
        
        Object[] data = new Object[header.length];
        for (varPeminjaman c : list) {
            data[0] = c.getvNim();
            data[1] = c.getvNama();
            data[2] = c.getvKdBuku();
            data[3] = c.getvJdlBuku();
            data[4] = c.getvTglTerbit();
            data[5] = c.getvTglPinjam();
            tblModel.addRow(data);
        }
        form.getTblPeminjam().setModel(tblModel);
    }
    
    public void isiField(int row){
        form.getTxtNim().setText(list.get(row).getvNim());
        form.getTxtNama().setText(list.get(row).getvNama());
        form.getTxtKdBuku().setText(list.get(row).getvKdBuku());
        form.getTxtJdlBuku().setText(list.get(row).getvJdlBuku());
        form.getTxtTglTerbit().setDate(list.get(row).getvTglTerbit());
        form.getTxtTglPinjam().setDate(list.get(row).getvTglPinjam());
    }
    
    public void insert(){
        varPeminjaman objPm = new varPeminjaman();
   
        objPm.setvNim(form.getTxtNim().getText());
        objPm.setvNama(form.getTxtNama().getText());
        objPm.setvKdBuku(form.getTxtKdBuku().getText());
        objPm.setvJdlBuku(form.getTxtJdlBuku().getText());
        objPm.setvTglTerbit(form.getTxtTglTerbit().getDate());
        objPm.setvTglPinjam(form.getTxtTglPinjam().getDate());
        model.insert(objPm);
    }
    
    public void update(){
        varPeminjaman objPm = new varPeminjaman();
   
        objPm.setvNim(form.getTxtNim().getText());
        objPm.setvNama(form.getTxtNama().getText());
        objPm.setvKdBuku(form.getTxtKdBuku().getText());
        objPm.setvJdlBuku(form.getTxtJdlBuku().getText());
        objPm.setvTglTerbit(form.getTxtTglTerbit().getDate());
        objPm.setvTglPinjam(form.getTxtTglPinjam().getDate());
        model.update(objPm);
    }
    
    public void delete(){
        if(!form.getTxtNim().getText().trim().isEmpty()){
            String kode = form.getTxtNim().getText();
            
            model.delete(kode);
        }
        else{
            JOptionPane.showMessageDialog(form, "Pilih data yang akan di hapus");
        }
    }
    
    public void isiTabelCari(){
        list = model.getCari(form.getTxtNim().getText().trim());
        DefaultTableModel tblModel = new DefaultTableModel(new Object[][]{}, header);
        Object[] data = new Object[header.length];
        for(varPeminjaman c : list){
            data[0] = c.getvNim();
            data[1] = c.getvNama();
            data[2] = c.getvKdBuku();
            data[3] = c.getvJdlBuku();
            data[4] = c.getvTglTerbit();
            data[5] = c.getvTglPinjam();
            tblModel.addRow(data);
        }
        form.getTblPeminjam().setModel(tblModel);
    }
    
}
