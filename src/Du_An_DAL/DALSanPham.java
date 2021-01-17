/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Du_An_DAL;

import Du_An_DTO.SanPham;
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
public class DALSanPham {

    public static ResultSet getALLSanPham() {
        String sql = "SELECT * FROM SanPham";
        return SQLHelper.executeQuery(sql);
    }

    public static ResultSet getSanPham(String MaSP) {
        String sql = "SELECT * FROM SanPham WHERE MaSP = ?";
        return SQLHelper.executeQuery(sql, MaSP);
    }

    public static void ThemSanPham(SanPham sp) {
        String sql = "SET DATEFORMAT DMY INSERT INTO [dbo].[SanPham] "
                + "           ([MaSP] "
                + "           ,[TenSP] "
                + "           ,[SoLuong] "
                + "           ,[DonViTinh] "
                + "           ,[GiaNhap] "
                + "           ,[GiaBan] "
                + "           ,[NgayNhap] "
                + "           ,[MaLoaiSP] "
                + "           ,[MaHangSX] "
                + "           ,[ThoiGianBH] "
                + "           ,[HinhAnh] "
                + "           ,[GhiChu]) "
                + "     VALUES "
                + "           (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        SQLHelper.executeUpdate(sql,
                sp.getMaSanPham(),
                sp.getTenSanPham(),
                sp.getSoLuong(),
                sp.getDonViTinh(),
                sp.getGiaNhap(),
                sp.getGiaBan(),
                ChuyenDoi.LayNgayString(sp.getNgayNhap()),
                sp.getMaLoaiSP(),
                sp.getMaHangSX(),
                sp.getThoiGianBH(),
                sp.getHinhAnh(),
                sp.getGhiChu()
        );

    }

    public static ResultSet CountMaSP(String MaSP) {
        String sql = "select Count(*) from SanPham where MaSP like ?";
        return SQLHelper.executeQuery(sql, "%" + MaSP + "%");
    }

    public static ResultSet GetByMaSP(String MaSP) {
        String sql = "select *  from SanPham where MaSP = ?";
        return SQLHelper.executeQuery(sql, MaSP);
    }

    public static void UpdateSanPham(SanPham sp) {
        String sql = "SET DATEFORMAT DMY UPDATE [dbo].[SanPham] "
                + "   SET [TenSP] = ? "
                + "      ,[SoLuong] = ? "
                + "      ,[DonViTinh] = ? "
                + "      ,[GiaNhap] = ? "
                + "      ,[GiaBan] = ? "
                + "      ,[NgayNhap] = ? "
                + "      ,[MaLoaiSP] = ? "
                + "      ,[MaHangSX] = ? "
                + "      ,[ThoiGianBH] = ? "
                + "      ,[HinhAnh] = ? "
                + "      ,[GhiChu] = ? "
                + " WHERE [MaSP] = ?";
        SQLHelper.executeUpdate(sql,
                sp.getTenSanPham(),
                sp.getSoLuong(),
                sp.getDonViTinh(),
                sp.getGiaNhap(),
                sp.getGiaBan(),
                ChuyenDoi.LayNgayString(sp.getNgayNhap()),
                sp.getMaLoaiSP(),
                sp.getMaHangSX(),
                sp.getThoiGianBH(),
                sp.getHinhAnh(),
                sp.getGhiChu(),
                sp.getMaSanPham());

    }

    public static boolean kiemtraCoTheXoa(String maSp) {
        String sql = "select top 1* from CTHD_Xuat where MaSP = ?";
        ResultSet rs = SQLHelper.executeQuery(sql, maSp);

        try {
            return !rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(DALSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }

    public static void DeleteSanPham(String MaSP) {

        String sql = " DELETE FROM SANPHAM WHERE MASP = ?";
        SQLHelper.executeUpdate(sql, MaSP);
    }

    public static ResultSet TimKiem(String TuKhoa) {
        String sql = "{call spTimKiemSp (?)}";

        return SQLHelper.executeQuery(sql, TuKhoa);
    }

    public static ResultSet LocDSSPTheoMaLoaiSP(String maLoaiSP){
        String sql = "Select * From SanPham where MaLoaiSP = ?";
        return SQLHelper.executeQuery(sql, maLoaiSP);
    }
    
    public static ResultSet LocDSSP(String keyWord, String maLoaiSP) {
        String sql = "Select * From SanPham where MaLoaiSP = ? and TenSP like ?";
        return SQLHelper.executeQuery(sql, maLoaiSP, "%" + keyWord + "%");
    }
    
    public static ResultSet LocDSSPTheoKeyWord(String keyWord){
        String sql = "Select * From SanPham where TenSP like ?";
        return SQLHelper.executeQuery(sql, "%" + keyWord + "%");
    }
}
