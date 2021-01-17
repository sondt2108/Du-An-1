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
public class NhanVien {
    
    String MaNV;
    String TenNV;
    boolean GioiTinh;
    Date NgaySinh;
    String ChucVu;
    String DiaChi;
    String SDT;
    String CMND;
    Date NgayVaoLam;
    String TenDangNhap;
    String MatKhau;
    String Email;
    String HinhAnh;

    public NhanVien() {
    }

    public NhanVien(String MaNV, String TenNV, boolean GioiTinh, Date NgaySinh, String ChucVu, String DiaChi, String SDT, String CMND, Date NgayVaoLam, String TenDangNhap, String MatKhau, String Email, String HinhAnh) {
        this.MaNV = MaNV;
        this.TenNV = TenNV;
        this.GioiTinh = GioiTinh;
        this.NgaySinh = NgaySinh;
        this.ChucVu = ChucVu;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
        this.CMND = CMND;
        this.NgayVaoLam = NgayVaoLam;
        this.TenDangNhap = TenDangNhap;
        this.MatKhau = MatKhau;
        this.Email = Email;
        this.HinhAnh = HinhAnh;
    }

    public NhanVien(String TenNV, boolean GioiTinh, Date NgaySinh, String ChucVu, String DiaChi, String SDT, String CMND, Date NgayVaoLam, String TenDangNhap, String MatKhau, String Email, String HinhAnh) {
        this.TenNV = TenNV;
        this.GioiTinh = GioiTinh;
        this.NgaySinh = NgaySinh;
        this.ChucVu = ChucVu;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
        this.CMND = CMND;
        this.NgayVaoLam = NgayVaoLam;
        this.TenDangNhap = TenDangNhap;
        this.MatKhau = MatKhau;
        this.Email = Email;
        this.HinhAnh = HinhAnh;
    }
    
    

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public boolean isGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(boolean GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getChucVu() {
        return ChucVu;
    }

    public void setChucVu(String ChucVu) {
        this.ChucVu = ChucVu;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public Date getNgayVaoLam() {
        return NgayVaoLam;
    }

    public void setNgayVaoLam(Date NgayVaoLam) {
        this.NgayVaoLam = NgayVaoLam;
    }

    public String getTenDangNhap() {
        return TenDangNhap;
    }

    public void setTenDangNhap(String TenDangNhap) {
        this.TenDangNhap = TenDangNhap;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(String HinhAnh) {
        this.HinhAnh = HinhAnh;
    }
    
    
}
