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
public class CTHDXuat {
    String Ma_CTHD_Xuat;
    String Ma_HD_Xuat;
    String MaSP;
    String SoLuong;
    Double ThanhTien;
    String GhiChu;

    public CTHDXuat() {
    }

    public CTHDXuat(String Ma_CTHD_Xuat, String Ma_HD_Xuat, String MaSP, String SoLuong, Double ThanhTien, String GhiChu) {
        this.Ma_CTHD_Xuat = Ma_CTHD_Xuat;
        this.Ma_HD_Xuat = Ma_HD_Xuat;
        this.MaSP = MaSP;
        this.SoLuong = SoLuong;
        this.ThanhTien = ThanhTien;
        this.GhiChu = GhiChu;
    }

    public String getMa_CTHD_Xuat() {
        return Ma_CTHD_Xuat;
    }

    public void setMa_CTHD_Xuat(String Ma_CTHD_Xuat) {
        this.Ma_CTHD_Xuat = Ma_CTHD_Xuat;
    }

    public String getMa_HD_Xuat() {
        return Ma_HD_Xuat;
    }

    public void setMa_HD_Xuat(String Ma_HD_Xuat) {
        this.Ma_HD_Xuat = Ma_HD_Xuat;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(String SoLuong) {
        this.SoLuong = SoLuong;
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
       
}
