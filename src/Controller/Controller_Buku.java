/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAO_Interface;
import DAO.DAO_Buku;
import Model.varBuku;
import View.FrmEntryBuku;
import View.MenuPerpustakaan;
import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Agung Ma'ruf
 */
public class Controller_Buku {
    FrmEntryBuku form;
    DAO_Interface<varBuku> model;
    List<varBuku> list;
    String[] header;
    
    public Controller_Buku(FrmEntryBuku form) {
        this.form = form;
        model = new DAO_Buku();
        list = model.getAll();
        header = new String[]{"Kode Buku", "Judul Buku", "Tanggal Terbit", "Pengarang"};
        form.getTblBuku().setShowGrid(true);
        form.getTblBuku().setShowVerticalLines(true);
        form.getTblBuku().setGridColor(Color.blue);
    }
    
    public void reset(){
        form.getTxtkd_buku().setText("");
        form.getTxtjdl_buku().setText("");
        form.getTxttgl_terbit().setDate(null);
        form.getTxtpengarang().setText("");
        form.getTxtkd_buku().requestFocus();
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
        for (varBuku c : list) {
            data[0] = c.getvKodeBuku();
            data[1] = c.getvJudulBuku();
            data[2] = c.getvTglTerbit();
            data[3] = c.getvPengarang();
            tblModel.addRow(data);
        }
        form.getTblBuku().setModel(tblModel);
    }
    
    public void isiField(int row){
        form.getTxtkd_buku().setText(list.get(row).getvKodeBuku());
        form.getTxtjdl_buku().setText(list.get(row).getvJudulBuku());
        form.getTxttgl_terbit().setDate(list.get(row).getvTglTerbit());
        form.getTxtpengarang().setText(list.get(row).getvPengarang());
    }
    
    public void insert(){
        varBuku objBk = new varBuku();
   
        objBk.setvKodeBuku(form.getTxtkd_buku().getText());
        objBk.setvJudulBuku(form.getTxtjdl_buku().getText());
        objBk.setvTglTerbit(form.getTxttgl_terbit().getDate());
        objBk.setvPengarang(form.getTxtpengarang().getText());
        model.insert(objBk);
    }
    
    public void update(){
        varBuku objBk = new varBuku();
   
        objBk.setvKodeBuku(form.getTxtkd_buku().getText());
        objBk.setvJudulBuku(form.getTxtjdl_buku().getText());
        objBk.setvTglTerbit(form.getTxttgl_terbit().getDate());
        objBk.setvPengarang(form.getTxtpengarang().getText());
        model.update(objBk);
    }
    
    public void delete(){
        if(!form.getTxtkd_buku().getText().trim().isEmpty()){
            String kode = form.getTxtkd_buku().getText();
            
            model.delete(kode);
        }
        else{
            JOptionPane.showMessageDialog(form, "Pilih data yang akan di hapus");
        }
    }
    
    public void isiTabelCari(){
        list = model.getCari(form.getTxtkd_buku().getText().trim());
        DefaultTableModel tblModel = new DefaultTableModel(new Object[][]{}, header);
        Object[] data = new Object[header.length];
        for(varBuku objBk : list){
            data[0] = objBk.getvKodeBuku();
            data[1] = objBk.getvJudulBuku();
            data[2] = objBk.getvTglTerbit();
            data[3] = objBk.getvPengarang();
            tblModel.addRow(data);
        }
        form.getTblBuku().setModel(tblModel);
    }
    
}
