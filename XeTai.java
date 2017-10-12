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
public class XeTai extends PTGT implements Serializable {
    private double trongTai;

    public XeTai() {
    }

    public XeTai(double trongTai,String ma, String hangSX, String namSX, double giaBan, String mau) {
        super(ma, hangSX, namSX, giaBan, mau);
        this.trongTai = trongTai;
    }

    public double getTrongTai() {
        return trongTai;
    }

    public void setTrongTai(double trongTai) {
        this.trongTai = trongTai;
    }

    @Override
    public String toString() {
        return super.toString() + "\t"+ trongTai;
    }
    
    
    
}
