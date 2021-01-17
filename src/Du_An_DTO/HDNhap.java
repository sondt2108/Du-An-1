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
public class HDNhap {
    String Ma_HD_Nhap;
    Date NgayTao;
    String MaNV;
    String MaNCC;
    Double TongTien;
    String GhiChu;

    public HDNhap() {
    }

    public HDNhap(String Ma_HD_Nhap, Date NgayTao, String MaNV, String MaNCC, Double TongTien, String GhiChu) {
        this.Ma_HD_Nhap = Ma_HD_Nhap;
        this.NgayTao = NgayTao;
        this.MaNV = MaNV;
        this.MaNCC = MaNCC;
        this.TongTien = TongTien;
        this.GhiChu = GhiChu;
    }

    public String getMa_HD_Nhap() {
        return Ma_HD_Nhap;
    }

    public void setMa_HD_Nhap(String Ma_HD_Nhap) {
        this.Ma_HD_Nhap = Ma_HD_Nhap;
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

    public String getMaNCC() {
        return MaNCC;
    }

    public void setMaNCC(String MaNCC) {
        this.MaNCC = MaNCC;
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
