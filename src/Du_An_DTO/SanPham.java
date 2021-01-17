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
public class SanPham {
    String MaSanPham;
    String TenSanPham;
    int SoLuong;
    String DonViTinh;
    double GiaNhap;
    double GiaBan;
    Date NgayNhap;
    String MaLoaiSP;
    String MaHangSX;
    String ThoiGianBH;
    String HinhAnh;
    String GhiChu;

    public SanPham() {
    }

    public SanPham(String MaSanPham, String TenSanPham, int SoLuong, String DonViTinh, double GiaNhap, double GiaBan, Date NgayNhap, String MaLoaiSP, String MaHangSX, String ThoiGianBH, String HinhAnh, String GhiChu) {
        this.MaSanPham = MaSanPham;
        this.TenSanPham = TenSanPham;
        this.SoLuong = SoLuong;
        this.DonViTinh = DonViTinh;
        this.GiaNhap = GiaNhap;
        this.GiaBan = GiaBan;
        this.NgayNhap = NgayNhap;
        this.MaLoaiSP = MaLoaiSP;
        this.MaHangSX = MaHangSX;
        this.ThoiGianBH = ThoiGianBH;
        this.HinhAnh = HinhAnh;
        this.GhiChu = GhiChu;
    }

    public SanPham(String TenSanPham, int SoLuong, String DonViTinh, double GiaNhap, double GiaBan, Date NgayNhap, String MaLoaiSP, String MaHangSX, String ThoiGianBH, String HinhAnh, String GhiChu) {
        this.TenSanPham = TenSanPham;
        this.SoLuong = SoLuong;
        this.DonViTinh = DonViTinh;
        this.GiaNhap = GiaNhap;
        this.GiaBan = GiaBan;
        this.NgayNhap = NgayNhap;
        this.MaLoaiSP = MaLoaiSP;
        this.MaHangSX = MaHangSX;
        this.ThoiGianBH = ThoiGianBH;
        this.HinhAnh = HinhAnh;
        this.GhiChu = GhiChu;
    }
    
    

    public String getMaSanPham() {
        return MaSanPham;
    }

    public void setMaSanPham(String MaSanPham) {
        this.MaSanPham = MaSanPham;
    }

    public String getTenSanPham() {
        return TenSanPham;
    }

    public void setTenSanPham(String TenSanPham) {
        this.TenSanPham = TenSanPham;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public String getDonViTinh() {
        return DonViTinh;
    }

    public void setDonViTinh(String DonViTinh) {
        this.DonViTinh = DonViTinh;
    }

    public double getGiaNhap() {
        return GiaNhap;
    }

    public void setGiaNhap(double GiaNhap) {
        this.GiaNhap = GiaNhap;
    }

    public double getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(double GiaBan) {
        this.GiaBan = GiaBan;
    }

    public Date getNgayNhap() {
        return NgayNhap;
    }

    public void setNgayNhap(Date NgayNhap) {
        this.NgayNhap = NgayNhap;
    }

    public String getMaLoaiSP() {
        return MaLoaiSP;
    }

    public void setMaLoaiSP(String MaLoaiSP) {
        this.MaLoaiSP = MaLoaiSP;
    }

    public String getMaHangSX() {
        return MaHangSX;
    }

    public void setMaHangSX(String MaHangSX) {
        this.MaHangSX = MaHangSX;
    }

    public String getThoiGianBH() {
        return ThoiGianBH;
    }

    public void setThoiGianBH(String ThoiGianBH) {
        this.ThoiGianBH = ThoiGianBH;
    }

    public String getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(String HinhAnh) {
        this.HinhAnh = HinhAnh;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }
    
    
    
}
