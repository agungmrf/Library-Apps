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
public class varBuku {
    private String vKodeBuku;
    private String vJudulBuku;
    private Date vTglTerbit;
    private String vPengarang;

    public Date getvTglTerbit() {
        return vTglTerbit;
    }

    public void setvTglTerbit(Date vTglTerbit) {
        this.vTglTerbit = vTglTerbit;
    }

    public String getvKodeBuku() {
        return vKodeBuku;
    }

    public void setvKodeBuku(String vKodeBuku) {
        this.vKodeBuku = vKodeBuku;
    }

    public String getvJudulBuku() {
        return vJudulBuku;
    }

    public void setvJudulBuku(String vJudulBuku) {
        this.vJudulBuku = vJudulBuku;
    }

    public String getvPengarang() {
        return vPengarang;
    }

    public void setvPengarang(String vPengarang) {
        this.vPengarang = vPengarang;
    }
}
