/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task1;

import java.io.Serializable;

/**
 *
 * @author NGOCTAM
 */
public class Oto extends PTGT implements Serializable{
    private String kieuDongCo;
    private int soChoNgoi;

    public Oto() {
    }

    public Oto(String kieuDongCo, int soChoNgoi, String ma, String hangSX, String namSX, double giaBan, String mau) {
        super(ma,hangSX, namSX, giaBan, mau);
        this.kieuDongCo = kieuDongCo;
        this.soChoNgoi = soChoNgoi;
    }

    public String getKieuDongCo() {
        return kieuDongCo;
    }

    public int getSoChoNgoi() {
        return soChoNgoi;
    }

    public void setKieuDongCo(String kieuDongCo) {
        this.kieuDongCo = kieuDongCo;
    }

    public void setSoChoNgoi(int soChoNgoi) {
        this.soChoNgoi = soChoNgoi;
    }

    @Override
    public String toString() {
        return super.toString() + "\t" +  kieuDongCo + "\t" + soChoNgoi;
    }
    
    
    
}
