/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task1;

import java.util.Scanner;

/**
 *
 * @author NGOCTAM
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        QuanLyPTGT ql = new QuanLyPTGT();
        int chon;
        do {
            System.out.println("-------------MENU----------");
            System.out.println("1. Nhap thong tin");
            System.out.println("2. Hien thi");
            System.out.println("3. Update thong tin");
            System.out.println("4. Tim kiem theo hang");
            System.out.println("5. Sap xep theo gia ban");
            System.out.println("6. Lap bang thong ke");
            System.out.println("0. Thoat");
            System.out.print("Nhap su lua chon: ");
            chon = Integer.parseInt(in.nextLine());
            switch (chon) {
                case 1:
                    int chon1;
                    do {
                        System.out.println("-------Nhap thong tin--------");
                        System.out.println("1. Nhap oto");
                        System.out.println("2. Nhap xa may");
                        System.out.println("3. Nhap xe tai");
                        System.out.println("0. Tro ve menu chinh");
                        System.out.println("Nhap su lua chon: ");
                        chon1 = Integer.parseInt(in.nextLine());
                        switch(chon1) {
                            case 1: 
                                while(true){
                                    if(!ql.themOto()){
                                        System.out.println("Ma da bi trung. Nhap lai");
                                    } else break;
                                }
                                break;
                            case 2: while(true){
                                    if(!ql.themXeMay()){
                                        System.out.println("Ma da bi trung. Nhap lai");
                                    } else break;
                                }
                                break;
                            case 3: while(true){
                                    if(!ql.themXeTai()){
                                        System.out.println("Ma da bi trung. Nhap lai");
                                    } else break;
                                }
                                break;
                            case 0: break;
                            
                        }
                    } while(chon1 != 0);
                    break;
                case 2:
                    int chon2;
                    do {
                        System.out.println("-------Hien thi thong tin--------");
                        System.out.println("1. Hien thi 1 bang");
                        System.out.println("2. Hien thi nhieu bang");
                        System.out.println("0. Tro ve menu chinh");
                        System.out.println("Nhap su lua chon: ");
                        chon2 = Integer.parseInt(in.nextLine());
                        switch(chon2) {
                            case 1: ql.hienThi1Bang();
                                break;
                            case 2: ql.hienThi3Bang();
                                break;
                            case 0: break;
                            
                        }
                    } while(chon2 != 0);
                    break;
                case 3:
                    while(true) {
                        if(!ql.update()) {
                            System.out.println("Ma xe nay khong ton tai");
                        } else break;
                    }
                    break;
                case 4:
                    ql.search();
                    break;
                case 5:
                    ql.sortByGia();
                    break;
                case 6:
                    ql.thongKe();
                    break;
               
                case 0: break;
                   
            }
        } while (chon != 0);

    }
}
