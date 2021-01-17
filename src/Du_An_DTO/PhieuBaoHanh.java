/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Du_An_DTO;

import java.util.Date;

/**
 *
 * @author Administrator
 */
public class PhieuBaoHanh {
    String MaPBH;
    String TenKhoHang;
    String DiaChiKhoHang;
    String SDTKhoHang;
    String MaNV;
    String MaKH;
    String MaHDXuat;
    Date NgayMuaSP;

    public PhieuBaoHanh() {
    }

    public PhieuBaoHanh(String MaPBH, String TenKhoHang, String DiaChiKhoHang, String SDTKhoHang, String MaNV, String MaKH, String MaHDXuat, Date NgayMuaSP) {
        this.MaPBH = MaPBH;
        this.TenKhoHang = TenKhoHang;
        this.DiaChiKhoHang = DiaChiKhoHang;
        this.SDTKhoHang = SDTKhoHang;
        this.MaNV = MaNV;
        this.MaKH = MaKH;
        this.MaHDXuat = MaHDXuat;
        this.NgayMuaSP = NgayMuaSP;
    }
    
    
    

    public String getMaPBH() {
        return MaPBH;
    }

    public void setMaPBH(String MaPBH) {
        this.MaPBH = MaPBH;
    }

    public String getTenKhoHang() {
        return TenKhoHang;
    }

    public void setTenKhoHang(String TenKhoHang) {
        this.TenKhoHang = TenKhoHang;
    }

    public String getDiaChiKhoHang() {
        return DiaChiKhoHang;
    }

    public void setDiaChiKhoHang(String DiaChiKhoHang) {
        this.DiaChiKhoHang = DiaChiKhoHang;
    }

    public String getSDTKhoHang() {
        return SDTKhoHang;
    }

    public void setSDTKhoHang(String SDTKhoHang) {
        this.SDTKhoHang = SDTKhoHang;
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

    public String getMaHDXuat() {
        return MaHDXuat;
    }

    public void setMaHDXuat(String MaHDXuat) {
        this.MaHDXuat = MaHDXuat;
    }

    public Date getNgayMuaSP() {
        return NgayMuaSP;
    }

    public void setNgayMuaSP(Date NgayMuaSP) {
        this.NgayMuaSP = NgayMuaSP;
    }
    
}
