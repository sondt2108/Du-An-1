/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Du_An_DTO;

/**
 *
 * @author Admin
 */
public class CTHDNhap {
    String Ma_CTHD_Nhap;
    String Ma_HD_Nhap;
    String MaSP;
    String SoLuong;
    Double ThanhTien;
    String GhiChu;

    public CTHDNhap() {
    }

    public CTHDNhap(String Ma_CTHD_Nhap, String Ma_HD_Nhap, String MaSP, String SoLuong, Double ThanhTien, String GhiChu) {
        this.Ma_CTHD_Nhap = Ma_CTHD_Nhap;
        this.Ma_HD_Nhap = Ma_HD_Nhap;
        this.MaSP = MaSP;
        this.SoLuong = SoLuong;
        this.ThanhTien = ThanhTien;
        this.GhiChu = GhiChu;
    }

    public String getMa_CTHD_Nhap() {
        return Ma_CTHD_Nhap;
    }

    public void setMa_CTHD_Nhap(String Ma_CTHD_Nhap) {
        this.Ma_CTHD_Nhap = Ma_CTHD_Nhap;
    }

    public String getMa_HD_Nhap() {
        return Ma_HD_Nhap;
    }

    public void setMa_HD_Nhap(String Ma_HD_Nhap) {
        this.Ma_HD_Nhap = Ma_HD_Nhap;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public Double getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(Double ThanhTien) {
        this.ThanhTien = ThanhTien;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public String getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(String SoLuong) {
        this.SoLuong = SoLuong;
    }
    
    
}
