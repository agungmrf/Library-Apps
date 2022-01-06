/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Koneksi.Database;
import Model.varBuku;
import com.mysql.jdbc.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Agung Ma'ruf
 */
public class DAO_Buku implements DAO_Interface<varBuku>{
    public DAO_Buku(){
        connection = Database.KoneksiDB();
    }
    
    Connection connection;
    String INSERT = "INSERT INTO tbl_buku (kd_buku, jdl_buku, tgl_terbit, pengarang) VALUES(?,?,?,?)";
    String UPDATE = "UPDATE tbl_buku SET jdl_buku=?, tgl_terbit=?, pengarang=? WHERE kd_buku=?";
    String DELETE = "DELETE FROM tbl_buku WHERE kd_buku=?";
    String SELECT = "SELECT * FROM tbl_buku";
    String CARI   = "SELECT * FROM tbl_buku WHERE kd_buku LIKE ?";

    @Override
    public void insert(varBuku Object) {
        PreparedStatement st = null;
        try{
            st = connection.prepareStatement(CARI);
            st.setString(1, Object.getvKodeBuku());
            ResultSet rs = st.executeQuery();
            if (rs.next()){
                JOptionPane.showMessageDialog(null, "Data sudah pernah di simpan");
            }
            else {
                st = null;
                st = connection.prepareStatement(INSERT);
                st.setString(1, Object.getvKodeBuku());
                st.setString(2, Object.getvJudulBuku());
                st.setDate(3, new java.sql.Date(Object.getvTglTerbit().getTime()));
                st.setString(4, Object.getvPengarang());
                st.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil di simpan");
            }
            st.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(varBuku Object) {
        PreparedStatement st = null;
        try{
            st = null;
            st = connection.prepareStatement(UPDATE);
            st.setString(1, Object.getvJudulBuku());
            st.setDate(2, new java.sql.Date(Object.getvTglTerbit().getTime()));
            st.setString(3, Object.getvPengarang());
            st.setString(4, Object.getvKodeBuku());
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil di ubah");
            st.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String kode) {
        PreparedStatement st = null;
       try{
           st = null;
           st = connection.prepareStatement(DELETE);
           st.setString(1, kode);
           st.executeUpdate();
           JOptionPane.showMessageDialog(null, "Data Berhasil di Hapus");
           st.close();
       }
       catch(Exception e){
           e.printStackTrace();
       }
    }

    @Override
    public List<varBuku> getAll() {
        List<varBuku> list = null;
        PreparedStatement st = null;
        try{
            st = null;
            list = new ArrayList<varBuku>();
            st = connection.prepareStatement(SELECT);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                varBuku objBk = new varBuku();
                objBk.setvKodeBuku(rs.getString("kd_buku"));
                objBk.setvJudulBuku(rs.getString("jdl_buku"));
                objBk.setvTglTerbit(rs.getDate("tgl_terbit"));
                objBk.setvPengarang(rs.getString("pengarang"));
                list.add(objBk);
            }
            st.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<varBuku> getCari(String key) {
        List<varBuku> list = null;
        PreparedStatement st = null;
        try{
            list = new ArrayList<varBuku>();
            st = connection.prepareStatement(CARI);
            st.setString(1,  "%"+key+"%");
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
                varBuku objBk = new varBuku();
                objBk.setvKodeBuku(rs.getString("kd_buku"));
                objBk.setvJudulBuku(rs.getString("jdl_buku"));
                objBk.setvTglTerbit(rs.getDate("tgl_terbit"));
                objBk.setvPengarang(rs.getString("pengarang"));
                list.add(objBk);
            }
            st.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    
}
