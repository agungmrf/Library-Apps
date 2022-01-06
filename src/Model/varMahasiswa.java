/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author Agung Ma'ruf;
 */
public class varMahasiswa {
    private String vNim;
    private String vNama;
    private String vTmpLahir;
    private Date vTglLahir;
    private String vJurusan;
    private Date vTglMasuk;

    public Date getvTglMasuk() {
        return vTglMasuk;
    }

    public void setvTglMasuk(Date vTglMasuk) {
        this.vTglMasuk = vTglMasuk;
    }

    public String getvNim() {
        return vNim;
    }

    public void setvNim(String vNim) {
        this.vNim = vNim;
    }

    public String getvNama() {
        return vNama;
    }

    public void setvNama(String vNama) {
        this.vNama = vNama;
    }

    public String getvTmpLahir() {
        return vTmpLahir;
    }

    public void setvTmpLahir(String vTmpLahir) {
        this.vTmpLahir = vTmpLahir;
    }

    public Date getvTglLahir() {
        return vTglLahir;
    }

    public void setvTglLahir(Date vTglLahir) {
        this.vTglLahir = vTglLahir;
    }

    public String getvJurusan() {
        return vJurusan;
    }

    public void setvJurusan(String vJurusan) {
        this.vJurusan = vJurusan;
    }

}
