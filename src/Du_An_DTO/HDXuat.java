/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Du_An_DTO;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class HDXuat {
    String Ma_HD_Xuat;
    Date NgayTao;
    String MaNV;
    String MaKH;
    Double TongTien;
    String GhiChu;

    public HDXuat() {
    }

    public HDXuat(String Ma_HD_Xuat, Date NgayTao, String MaNV, String MaKH, Double TongTien, String GhiChu) {
        this.Ma_HD_Xuat = Ma_HD_Xuat;
        this.NgayTao = NgayTao;
        this.MaNV = MaNV;
        this.MaKH = MaKH;
        this.TongTien = TongTien;
        this.GhiChu = GhiChu;
    }

    public String getMa_HD_Xuat() {
        return Ma_HD_Xuat;
    }

    public void setMa_HD_Xuat(String Ma_HD_Xuat) {
        this.Ma_HD_Xuat = Ma_HD_Xuat;
    }

    public Date getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(Date NgayTao) {
        this.NgayTao = NgayTao;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public Double getTongTien() {
        return TongTien;
    }

    public void setTongTien(Double TongTien) {
        this.TongTien = TongTien;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }
    
    
}
