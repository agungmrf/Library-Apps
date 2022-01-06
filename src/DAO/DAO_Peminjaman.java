/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Koneksi.Database;
import Model.varPeminjaman;
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
public class DAO_Peminjaman implements DAO_Interface<varPeminjaman>{
    public DAO_Peminjaman(){
        connection = Database.KoneksiDB();
    }
    
    Connection connection;
    String INSERT = "INSERT INTO tbl_peminjam (nim, nama, kd_buku, jdl_buku, tgl_terbit, tgl_pinjam) VALUES(?,?,?,?,?,?)";
    String UPDATE = "UPDATE tbl_peminjam SET nama=?, kd_buku=?, jdl_buku=?, tgl_terbit=?, tgl_pinjam=? WHERE nim=?";
    String DELETE = "DELETE FROM tbl_peminjam WHERE nim=?";
    String SELECT = "SELECT * FROM tbl_peminjam";
    String CARI   = "SELECT * FROM tbl_peminjam WHERE nim LIKE ?";

    @Override
    public void insert(varPeminjaman Object) {
        PreparedStatement st = null;
        try{
            st = connection.prepareStatement(CARI);
            st.setString(1, Object.getvNim());
            ResultSet rs = st.executeQuery();
            if (rs.next()){
                JOptionPane.showMessageDialog(null, "Data sudah pernah di simpan");
            }
            else {
                st = null;
                st = connection.prepareStatement(INSERT);
                st.setString(1, Object.getvNim());
                st.setString(2, Object.getvNama());
                st.setString(3, Object.getvKdBuku());
                st.setString(4, Object.getvJdlBuku());
                st.setDate(5, new java.sql.Date(Object.getvTglTerbit().getTime()));
                st.setDate(6, new java.sql.Date(Object.getvTglPinjam().getTime()));
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
    public void update(varPeminjaman Object) {
        PreparedStatement st = null;
        try{
            st = null;
            st = connection.prepareStatement(UPDATE);
            st.setString(1, Object.getvNama());
            st.setString(2, Object.getvKdBuku());
            st.setString(3, Object.getvJdlBuku());
            st.setDate(4, new java.sql.Date(Object.getvTglTerbit().getTime()));
            st.setDate(5, new java.sql.Date(Object.getvTglPinjam().getTime()));
            st.setString(6, Object.getvNim());
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
    public List<varPeminjaman> getAll() {
        List<varPeminjaman> list = null;
        PreparedStatement st = null;
        try{
            st = null;
            list = new ArrayList<varPeminjaman>();
            st = connection.prepareStatement(SELECT);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                varPeminjaman objMhs = new varPeminjaman();
                objMhs.setvNim(rs.getString("nim"));
                objMhs.setvNama(rs.getString("nama"));
                objMhs.setvKdBuku(rs.getString("kd_buku"));
                objMhs.setvJdlBuku(rs.getString("jdl_buku"));
                objMhs.setvTglTerbit(rs.getDate("tgl_terbit"));
                objMhs.setvTglPinjam(rs.getDate("tgl_pinjam"));
                list.add(objMhs);
            }
            st.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<varPeminjaman> getCari(String key) {
        List<varPeminjaman> list = null;
        PreparedStatement st = null;
        try{
            list = new ArrayList<varPeminjaman>();
            st = connection.prepareStatement(CARI);
            st.setString(1,  "%"+key+"%");
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
                varPeminjaman objMhs = new varPeminjaman();
                objMhs.setvNim(rs.getString("nim"));
                objMhs.setvNama(rs.getString("nama"));
                objMhs.setvKdBuku(rs.getString("kd_buku"));
                objMhs.setvJdlBuku(rs.getString("jdl_buku"));
                objMhs.setvTglTerbit(rs.getDate("tgl_terbit"));
                objMhs.setvTglPinjam(rs.getDate("tgl_pinjam"));
                list.add(objMhs);
            }
            st.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    
}
