/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author NGOCTAM
 */
public class QuanLyPTGT {

    private ArrayList<PTGT> list;
    private ArrayList<PTGT> sortList;
    private IOFile file = new IOFile();

    public QuanLyPTGT() {
        list = new ArrayList<>();
        sortList = new ArrayList<>();
        setList();
    }

    public ArrayList<PTGT> getList() {
        return list;
    }

    public void setList() {
        try {
            file.InFile(list, "src/task1/PTGT.dat");
        } catch (ClassNotFoundException e) {
            System.out.println("Loi ClassNotFoundException");
        } catch (IOException ex) {
            System.out.println("");
        }
    }

    public PTGT themPTGT() {
        //PTGT obj = new PTGT();
        Scanner in = new Scanner(System.in);
        System.out.print("Nhap ma: ");
        String ma = in.nextLine();
        PTGT obj1 = new PTGT(ma);
        if(list.contains(obj1)) return null;
        
        System.out.print("Nhap hang san xuat: ");
        String hangSX = in.nextLine();
        
        // kiem tra nam san xuat theo dinh dang dd/MM/yyyy
        String namSX = "";
        while(true) {
            System.out.print("Nhap nam san xuat<dd/MM/yyyy>: ");
            namSX = in.nextLine();
            if(namSX.matches("^\\d{2}/\\d{2}/\\d{4}$")) break;
        }
        
        System.out.print("Nhap gia ban: ");
        double giaBan = Double.parseDouble(in.nextLine());
        
        System.out.print("Nhap mau: ");
        String mau = in.nextLine();
        PTGT obj = new PTGT(ma, hangSX, namSX, giaBan, mau);
        return obj;
    }
    
    public boolean themOto() {
        Scanner in = new Scanner(System.in);
        PTGT ptgt = themPTGT();
        if(ptgt == null) return false;
        
        System.out.print("Nhap kieu dong co: ");
        String kieuDongCo = in.nextLine();
        
        System.out.print("Nhap so cho ngoi: ");
        int soChoNgoi = Integer.parseInt(in.nextLine());
        Oto oto = new Oto(kieuDongCo, soChoNgoi, ptgt.getMa(),  ptgt.getHangSX(), ptgt.getNamSX(), ptgt.getGiaBan(), ptgt.getMau());
        list.add(oto);
        try{
            file.outFile(list, "src/task1/PTGT.dat");
        } catch(IOException e) {
            System.out.println("Loi");
        }
        return true;
        
    }
    
    public boolean themXeMay() {
        Scanner in = new Scanner(System.in);
        PTGT ptgt = themPTGT();
        if(ptgt == null) return false;
        System.out.print("Nhap cong suat: ");
        double congSuat = Double.parseDouble(in.nextLine());
        XeMay xemay = new XeMay(congSuat, ptgt.getMa(), ptgt.getHangSX(), ptgt.getNamSX(), ptgt.getGiaBan(), ptgt.getMau());
        list.add(xemay);
        try{
            file.outFile(list, "src/task1/PTGT.dat");
        } catch(IOException e) {
            System.out.println("Loi");
        }
        
        return true;
    }
    
    public boolean themXeTai() {
        Scanner in = new Scanner(System.in);
        PTGT ptgt = themPTGT();
        if(ptgt == null) return false;
        System.out.print("Nhap trong tai: ");
        double trongTai = Double.parseDouble(in.nextLine());
        
        XeTai xetai = new XeTai(trongTai,ptgt.getMa(), ptgt.getHangSX(), ptgt.getNamSX(), ptgt.getGiaBan(), ptgt.getMau());
        list.add(xetai);
        try{
            file.outFile(list, "src/task1/PTGT.dat");
        } catch(IOException e) {
            System.out.println("Loi");
        }
        return true;
    }
    
    public void hienThi1Bang() {
        setList();
        int tong = list.size();
        System.out.println("\n\n-------------DANH SACH PT-------------");
        System.out.println("Ma \t HangSX \t namSX \t gia \t mau \t kieuDC/CS/TT \t soCNgoi");
        for(PTGT li:list) {
            System.out.println(li.toString());
        }
        System.out.println("---------------------Tong: " + tong);
    }
    
    public void hienThi3Bang() {
        setList();
        System.out.println("\n\n----------------OTO--------------------");
        System.out.println("Ma \t HangSX \t namSX \t gia t mau t kieuDC \t soCNgoi");
        int tongOto = 0;
        for(PTGT li:list) {
            if(li instanceof Oto) {
                System.out.println(li.toString());
                tongOto++;
            }
        }
        System.out.println("\n\n-----------------------------------Tong: " + tongOto);
        
        System.out.println("----------------XEMAY--------------------");
        System.out.println("Ma \t HangSX \t namSX \t gia \t mau \t CongSuat");
        int tongXeMay = 0;
        for(PTGT li:list) {
            if(li instanceof XeMay) {
                System.out.println(li.toString());
                tongXeMay++;
            }
        }
        System.out.println("-----------------------------------Tong: " + tongXeMay);
        
        System.out.println("\n\n----------------XETAI--------------------");
        System.out.println("Ma \t HangSX \t namSX \t gia \t mau \t TrongTai");
        int tongXeTai = 0;
        for(PTGT li:list) {
            if(li instanceof XeTai) {
                System.out.println(li.toString());
                tongXeTai++;
            }
        }
        System.out.println("-----------------------------------Tong: " + tongXeTai);
    }
    
    public boolean update() {
        Scanner in = new Scanner(System.in);
        System.out.print("Nhap ma can update: ");
         String ma = in.nextLine();
        PTGT obj = new PTGT(ma);
        if(!list.contains(obj)) {
            return false;
        }
        obj = list.get(list.indexOf(obj));
        
        System.out.print("Nhap hang san xuat can sua: ");
        String hangSX = in.nextLine();
        obj.setHangSX(hangSX);
        
        // kiem tra nam san xuat theo dinh dang dd/MM/yyyy
        String namSX = "";
        while(true) {
            System.out.print("Nhap nam san xuat can sua<dd/MM/yyyy>: ");
            namSX = in.nextLine();
            if(namSX.matches("^\\d{2}/\\d{2}/\\d{4}$")) break;
        }
        obj.setNamSX(namSX);
        System.out.print("Nhap gia ban can sua: ");
        double giaBan = Double.parseDouble(in.nextLine());
        obj.setGiaBan(giaBan);
        System.out.print("Nhap mau can sua: ");
        String mau = in.nextLine();
        obj.setMau(mau);
        
        if(obj instanceof Oto) {
            System.out.print("Nhap kieu dong co: ");
            String kieuDongCo = in.nextLine();
            ((Oto) obj).setKieuDongCo(kieuDongCo);

            System.out.print("Nhap so cho ngoi: ");
            int soChoNgoi = Integer.parseInt(in.nextLine());
            ((Oto) obj).setSoChoNgoi(soChoNgoi);
        }
        else if(obj instanceof XeMay) {
            System.out.print("Nhap cong suat: ");
            double congSuat = Double.parseDouble(in.nextLine());
            ((XeMay) obj).setCongSuat(congSuat);
        }
        if(obj instanceof XeTai) {
            System.out.print("Nhap trong tai: ");
            double trongTai = Double.parseDouble(in.nextLine());
            ((XeTai) obj).setTrongTai(trongTai);
        }
        try{
            file.outFile(list, "src/task1/PTGT.dat");
        } catch(IOException e) {
            System.out.println("Loi");
        }
        return true;
    }
    
    public void search() {
        setList();
        Scanner in = new Scanner(System.in);
        System.out.print("Nhap hang san xuat can tim: ");
        String hangSX = in.nextLine();
        int i = 0;
        System.out.println("STT \t Ma \t HangSX \t namSX \t gia \t mau \t kieuDC/CS/TT \t soCNgoi");
        for(PTGT o: list) {
            if(o.getHangSX().indexOf(hangSX) >= 0) {
                i++;
                System.out.println(i+"\t" + o.toString());
            }
        }
        
       
    }
    
    public void sortByGia() {
        setList();
        sortList.addAll(list);
        Collections.sort(sortList,new  Comparator<PTGT>() {
            @Override
            public int compare(PTGT o1, PTGT o2) {
                return (int) (o1.getGiaBan() - o2.getGiaBan());
            }
        
        });
        
        System.out.println("\n\n----------Danh sach sau khi sort----------");
        System.out.println("Ma \t HangSX \t namSX \t gia \t mau \t kieuDC/CS/TT \t soCNgoi");
        for(PTGT li:sortList) {
            System.out.println(li.toString());
        }
        
    }
    
    
    public void thongKe() {
        setList();
        ArrayList<PTGT> listSort = new ArrayList<>();
        listSort.addAll(list);
        // sap xep theo nam de ty tim cho de
        Collections.sort(listSort, new Comparator<PTGT>() {
            @Override
            public int compare(PTGT o1, PTGT o2) {
                String tmp1, tmp2;
                tmp1 = o1.getNamSX().substring(6); // chi can lay nam so sanh, k can thang vs ngay
                tmp2 = o2.getNamSX().substring(6);
                return tmp1.compareTo(tmp2);
            }
            
        });
        
        int length = listSort.size();
        String s = listSort.get(0).getNamSX().substring(6);
        int i = 1;
        double avg = 0.0;
        int soLuong = 1;
        double tongGia = listSort.get(0).getGiaBan();
        System.out.println("\n\n--------Thong ke----------");
        System.out.println("nam\tso luong\tgia tb");
        while(i < length) {
            if(s.compareTo(listSort.get(i).getNamSX().substring(6)) == 0) {
                soLuong++;
                tongGia += listSort.get(i).getGiaBan();
                
            } else {
                avg = tongGia/soLuong;
                System.out.println(s + "\t" + soLuong + "\t" + avg);
                s = listSort.get(i).getNamSX().substring(6);
                soLuong = 1;
                tongGia = listSort.get(i).getGiaBan();
                avg = 0;
            }
            i++;
        }
       
        avg = tongGia/soLuong;
         System.out.println(s + "\t" + soLuong + "\t" + avg);
        
    }
    
}
