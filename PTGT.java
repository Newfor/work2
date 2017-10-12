/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task1;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author NGOCTAM
 */
public class PTGT implements Serializable{
    private String ma;
    private String hangSX;
    private String namSX;
    private double giaBan;
    private String mau;

    public PTGT() {
    }

    public PTGT(String ma) {
        this.ma = ma;
    }
    

    public PTGT(String ma, String hangSX, String namSX, double giaBan, String mau) {
        this.ma = ma;
        this.hangSX = hangSX;
        this.namSX = namSX;
        this.giaBan = giaBan;
        this.mau = mau;
    }

    public String getMa() {
        return ma;
    }
    
    public String getHangSX() {
        return hangSX;
    }

    public String getNamSX() {
        return namSX;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public String getMau() {
        return mau;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }
    
    public void setHangSX(String hangSX) {
        this.hangSX = hangSX;
    }

    public void setNamSX(String namSX) {
        this.namSX = namSX;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public void setMau(String mau) {
        this.mau = mau;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
        final PTGT other = (PTGT) obj;
        if (!Objects.equals(this.ma, other.ma)) {
            return false;
        }
        return true;
    }

    
    
    @Override
    public String toString() {
        return  ma +"\t" + hangSX + "\t" + namSX + "\t" + giaBan + "\t" + mau ;
    }
    
    
    
}
