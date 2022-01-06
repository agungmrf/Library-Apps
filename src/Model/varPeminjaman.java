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
public class varPeminjaman {
    private String vNim;
    private String vNama;
    private String vJurusan;
    private String vKdBuku;
    private String vJdlBuku;
    private Date vTglTerbit;
    private Date vTglPinjam;

    public Date getvTglPinjam() {
        return vTglPinjam;
    }

    public void setvTglPinjam(Date vTglPinjam) {
        this.vTglPinjam = vTglPinjam;
    }

    public Date getvTglTerbit() {
        return vTglTerbit;
    }

    public void setvTglTerbit(Date vTglTerbit) {
        this.vTglTerbit = vTglTerbit;
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

    public String getvJurusan() {
        return vJurusan;
    }

    public void setvJurusan(String vJurusan) {
        this.vJurusan = vJurusan;
    }

    public String getvKdBuku() {
        return vKdBuku;
    }

    public void setvKdBuku(String vKdBuku) {
        this.vKdBuku = vKdBuku;
    }

    public String getvJdlBuku() {
        return vJdlBuku;
    }

    public void setvJdlBuku(String vJdlBuku) {
        this.vJdlBuku = vJdlBuku;
    }
    

}
