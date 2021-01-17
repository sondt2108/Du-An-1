/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Du_An_DAL;

import Du_An_DTO.NhanVien;
import Du_An_HELPER.ChuyenDoi;
import Du_An_HELPER.SQLHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class DALNhanVien {

    public static ResultSet getALLNhanVien() {
        String sql = "SELECT * FROM NhanVien";
        return SQLHelper.executeQuery(sql);
    }
    

    public static ResultSet getALLChucVu() {
        String sql = "SELECT * FROM dbo.ChucVu";
        return SQLHelper.executeQuery(sql);
    }

    public static ResultSet getChucVu(String MaCV) {
        String sql = "SELECT * FROM dbo.ChucVu WHERE MaChucVu = ?";
        return SQLHelper.executeQuery(sql, MaCV);
    }

    public static ResultSet getNhanVien(String MaNV) {
        String sql = "SELECT * FROM NhanVien WHERE MaNV = ?";
        return SQLHelper.executeQuery(sql, MaNV);
    }
    public static ResultSet DangNhap(String TenDangNhap, String MatKhau) {
        String sql = "select * from NhanVien where "
                + "TenDangNhap = ? and MatKhau = ?";
        return SQLHelper.executeQuery(sql, TenDangNhap, MatKhau);
    }

    public static ResultSet LayNV(int MaNV) {
        String sql = "SELECT * FROM NhanVien WHERE MaNV = ?";
        return SQLHelper.executeQuery(sql, MaNV);
    }

    public static ResultSet CountMaNV(String SoHoaDon) {
        String sql = "select Count(*) from NhanVien where MaNV like ?";
        return SQLHelper.executeQuery(sql, "%" + SoHoaDon + "%");
    }

    public static ResultSet GetByMaNV(String SoHoaDon) {
        String sql = "select * from NhanVien where MaNV = ?";
        return SQLHelper.executeQuery(sql, SoHoaDon);
    }

    public static void ThemNhanVien(NhanVien nv) {
        String sql = " SET DATEFORMAT DMY "
                + "INSERT INTO [dbo].[NhanVien] "
                + "           ([MaNV] "
                + "           ,[TenNV] "
                + "           ,[GioiTinh] "
                + "           ,[NgaySinh] "
                + "           ,[MaChucVu] "
                + "           ,[NgayVaoLam] "
                + "           ,[SDT] "
                + "           ,[DiaChi] "
                + "           ,[CMND] "
                + "           ,[Email] "
                + "           ,[TenDangNhap] "
                + "           ,[MatKhau] "
                + "           ,[HinhAnh]) "
                + "     VALUES "
                + "           (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";

        SQLHelper.executeUpdate(sql,
                nv.getMaNV(),
                nv.getTenNV(),
                nv.isGioiTinh(),
                ChuyenDoi.LayNgayString(nv.getNgaySinh()),
                nv.getChucVu(),
                ChuyenDoi.LayNgayString(nv.getNgayVaoLam()),
                nv.getSDT(),
                nv.getDiaChi(),
                nv.getCMND(),
                nv.getEmail(),
                nv.getTenDangNhap(),
                nv.getMatKhau(),
                nv.getHinhAnh());
        //push
    }

    public static void SuaNhanVien(NhanVien nv) {
        String sql = " SET DATEFORMAT DMY "
                + "UPDATE [dbo].[NhanVien] "
                + "   SET [TenNV] = ? "
                + "      ,[GioiTinh] = ? "
                + "      ,[NgaySinh] = ? "
                + "      ,[MaChucVu] = ? "
                + "      ,[NgayVaoLam] = ? "
                + "      ,[SDT] = ? "
                + "      ,[DiaChi] = ? "
                + "      ,[CMND] = ? "
                + "      ,[Email] = ? "
                + "      ,[TenDangNhap] = ? "
                + "      ,[MatKhau] = ? "
                + "      ,[HinhAnh] = ? "
                + " WHERE MaNV = ? ";

        SQLHelper.executeUpdate(sql,
                nv.getTenNV(),
                nv.isGioiTinh(),
                ChuyenDoi.LayNgayString(nv.getNgaySinh()),
                nv.getChucVu(),
                ChuyenDoi.LayNgayString(nv.getNgayVaoLam()),
                nv.getSDT(),
                nv.getDiaChi(),
                nv.getCMND(),
                nv.getEmail(),
                nv.getTenDangNhap(),
                nv.getMatKhau(),
                nv.getHinhAnh(),
                nv.getMaNV());
        //push
    }
    
    public static boolean kiemtraCoTheXoa(String MaNV) {
        String sql = "SELECT TOP 1* FROM  HD_Xuat WHERE MaNV = ?";
        ResultSet rs = SQLHelper.executeQuery(sql, MaNV);

        try {
            return !rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(DALSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }

    public static void DeleteNhanVien(String MaNV) {
        String sql = " DELETE FROM NHANVIEN WHERE MaNV = ?";
        SQLHelper.executeUpdate(sql, MaNV);
        //push
    }
    
    public static ResultSet TimKiem(String TenNhanVien){
      String sql = "{call spTimKiemNV (?)}";
      return SQLHelper.executeQuery(sql, TenNhanVien);
    }
    
    public static ResultSet LayNVTheoTen(String tenNV){
        String sql = "Select * From NhanVien Where TenNV like ?";
        return SQLHelper.executeQuery(sql, tenNV);
    }
}
