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
public class XeMay extends PTGT implements Serializable{
    private double congSuat;

    public XeMay() {
    }

    public XeMay(double congSuat,String ma, String hangSX, String namSX, double giaBan, String mau) {
        super(ma, hangSX, namSX, giaBan, mau);
        this.congSuat = congSuat;
    }

    public double getCongSuat() {
        return congSuat;
    }

    public void setCongSuat(double congSuat) {
        this.congSuat = congSuat;
    }

    @Override
    public String toString() {
        return super.toString() + "\t"+ congSuat;
    }
    
    
    
}
