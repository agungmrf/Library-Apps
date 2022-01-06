/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Koneksi.Database;
import Model.varMahasiswa;
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
public class DAO_Mahasiswa implements DAO_Interface<varMahasiswa>{
    public DAO_Mahasiswa(){
        connection = Database.KoneksiDB();
    }
    
    Connection connection;
    String INSERT = "INSERT INTO tbl_mahasiswa (nim, nama, tmpt_lahir, tgl_lahir, jurusan, tgl_masuk) VALUES(?,?,?,?,?,?)";
    String UPDATE = "UPDATE tbl_mahasiswa SET nama=?, tmpt_lahir=?, tgl_lahir=?, jurusan=?, tgl_masuk=? WHERE nim=?";
    String DELETE = "DELETE FROM tbl_mahasiswa WHERE nim=?";
    String SELECT = "SELECT * FROM tbl_mahasiswa";
    String CARI   = "SELECT * FROM tbl_mahasiswa WHERE nim LIKE ?";

    @Override
    public void insert(varMahasiswa Object) {
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
                st.setString(3, Object.getvTmpLahir());
                st.setDate(4, new java.sql.Date(Object.getvTglLahir().getTime()));
                st.setString(5, Object.getvJurusan());
                st.setDate(6, new java.sql.Date(Object.getvTglMasuk().getTime()));
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
    public void update(varMahasiswa Object) {
        PreparedStatement st = null;
        try{
            st = null;
            st = connection.prepareStatement(UPDATE);
            st.setString(1, Object.getvNama());
            st.setString(2, Object.getvTmpLahir());
            st.setDate(3, new java.sql.Date(Object.getvTglLahir().getTime()));
            st.setString(4, Object.getvJurusan());
            st.setDate(5, new java.sql.Date(Object.getvTglMasuk().getTime()));
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
    public List<varMahasiswa> getAll() {
        List<varMahasiswa> list = null;
        PreparedStatement st = null;
        try{
            st = null;
            list = new ArrayList<varMahasiswa>();
            st = connection.prepareStatement(SELECT);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                varMahasiswa objMhs = new varMahasiswa();
                objMhs.setvNim(rs.getString("nim"));
                objMhs.setvNama(rs.getString("nama"));
                objMhs.setvTmpLahir(rs.getString("tmpt_lahir"));
                objMhs.setvTglLahir(rs.getDate("tgl_lahir"));
                objMhs.setvJurusan(rs.getString("jurusan"));
                objMhs.setvTglMasuk(rs.getDate("tgl_masuk"));
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
    public List<varMahasiswa> getCari(String key) {
        List<varMahasiswa> list = null;
        PreparedStatement st = null;
        try{
            list = new ArrayList<varMahasiswa>();
            st = connection.prepareStatement(CARI);
            st.setString(1,  "%"+key+"%");
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
                varMahasiswa objMhs = new varMahasiswa();
                objMhs.setvNim(rs.getString("nim"));
                objMhs.setvNama(rs.getString("nama"));
                objMhs.setvTmpLahir(rs.getString("tmpt_lahir"));
                objMhs.setvTglLahir(rs.getDate("tgl_lahir"));
                objMhs.setvJurusan(rs.getString("jurusan"));
                objMhs.setvTglMasuk(rs.getDate("tgl_masuk"));
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
