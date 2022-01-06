/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAO_Interface;
import DAO.DAO_Mahasiswa;
import Model.varMahasiswa;
import View.FrmEntryMahasiswa;
import View.MenuPerpustakaan;
import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Agung Ma'ruf
 */
public class Controller_Mahasiswa {
    FrmEntryMahasiswa form;
    DAO_Interface<varMahasiswa> model;
    List<varMahasiswa> list;
    String[] header;
    
    public Controller_Mahasiswa(FrmEntryMahasiswa form) {
        this.form = form;
        model = new DAO_Mahasiswa();
        list = model.getAll();
        header = new String[]{"NIM", "Nama Mahasiswa", "Tempat Lahir", "Tanggal Lahir", "Jurusan", "Tanggal Masuk"};
        form.getTblMahasiswa().setShowGrid(true);
        form.getTblMahasiswa().setShowVerticalLines(true);
        form.getTblMahasiswa().setGridColor(Color.blue);
    }
    
    public void reset(){
        form.getTxtNim().setText("");
        form.getTxtNama().setText("");
        form.getTxtTmpLahir().setText("");
        form.getTxtTglLahir().setDate(null);
        form.getTxtJurusan().setText("");
        form.getTxtTglMasuk().setDate(null);
        form.getTxtNama().requestFocus();
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
        for (varMahasiswa c : list) {
            data[0] = c.getvNim();
            data[1] = c.getvNama();
            data[2] = c.getvTmpLahir();
            data[3] = c.getvTglLahir();
            data[4] = c.getvJurusan();
            data[5] = c.getvTglMasuk();
            tblModel.addRow(data);
        }
        form.getTblMahasiswa().setModel(tblModel);
    }
    
    public void isiField(int row){
        form.getTxtNim().setText(list.get(row).getvNim());
        form.getTxtNama().setText(list.get(row).getvNama());
        form.getTxtTmpLahir().setText(list.get(row).getvTmpLahir());
        form.getTxtTglLahir().setDate(list.get(row).getvTglLahir());
        form.getTxtJurusan().setText(list.get(row).getvJurusan());
        form.getTxtTglMasuk().setDate(list.get(row).getvTglMasuk());
    }
    
    public void insert(){
        varMahasiswa objBk = new varMahasiswa();
   
        objBk.setvNim(form.getTxtNim().getText());
        objBk.setvNama(form.getTxtNama().getText());
        objBk.setvTmpLahir(form.getTxtTmpLahir().getText());
        objBk.setvTglLahir(form.getTxtTglLahir().getDate());
        objBk.setvJurusan(form.getTxtJurusan().getText());
        objBk.setvTglMasuk(form.getTxtTglMasuk().getDate());
        model.insert(objBk);
    }
    
    public void update(){
        varMahasiswa objBk = new varMahasiswa();
   
        objBk.setvNim(form.getTxtNim().getText());
        objBk.setvNama(form.getTxtNama().getText());
        objBk.setvTmpLahir(form.getTxtTmpLahir().getText());
        objBk.setvTglLahir(form.getTxtTglLahir().getDate());
        objBk.setvJurusan(form.getTxtJurusan().getText());
        objBk.setvTglMasuk(form.getTxtTglMasuk().getDate());
        model.update(objBk);
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
        for(varMahasiswa c : list){
            data[0] = c.getvNim();
            data[1] = c.getvNama();
            data[2] = c.getvTmpLahir();
            data[3] = c.getvTglLahir();
            data[4] = c.getvJurusan();
            data[5] = c.getvTglMasuk();
            tblModel.addRow(data);
        }
        form.getTblMahasiswa().setModel(tblModel);
    }
    
}
