/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Du_An_DAL;

import Du_An_DTO.KhachHang;
import Du_An_HELPER.SQLHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class DALKhachHang {
    public static ResultSet getALLKhachHang() {
        String sql = "SELECT * FROM KhachHang";
        return SQLHelper.executeQuery(sql);
    }

    public static ResultSet getKhachHang(String MaKH) {
        String sql = "SELECT * FROM KhachHang WHERE MaKH = ?";
        return SQLHelper.executeQuery(sql, MaKH);
    }

    public static void ThemKhachHang(KhachHang kh) {
        String sql = " INSERT INTO [dbo].[KhachHang] "
                + "           ([MaKH] "
                + "           ,[TenKH] "
                + "           ,[DiaChi] "
                + "           ,[SDT] "
                + "           ,[Email] "
                + "           ,[GhiChu]) "
                + "     VALUES "
                + "           (?, ?, ?, ?, ?, ?)";

        SQLHelper.executeUpdate(sql,
                kh.getMaKhachHang(),
                kh.getTenKhachHang(),
                kh.getDiaChi(),
                kh.getSDT(),
                kh.getEmail(),
                kh.getGhiChu());

    }

    public static void UpdateKhachHang(KhachHang kh) {
        String sql = " UPDATE [dbo].[KhachHang] "
                + "   SET [TenKH] = ? "
                + "      ,[DiaChi] = ? "
                + "      ,[SDT] = ? "
                + "      ,[Email] = ? "
                + "      ,[GhiChu] = ? "
                + " WHERE MaKH = ? ";
        SQLHelper.executeUpdate(sql,
                kh.getTenKhachHang(),
                kh.getDiaChi(),
                kh.getSDT(),
                kh.getEmail(),
                kh.getGhiChu(),
                kh.getMaKhachHang());
    }
    // Hàm xoá Khách Hàng SQL
    // Hàm xoá nhân viên SQL

    

    public static void DeleteKhachHang(KhachHang KH) {
        String sql = " DELETE FROM dbo.KhachHang WHERE MaKH = ? ";
        SQLHelper.executeUpdate(sql, KH);
    }

    public static ResultSet TimKiem(String Ten, String SDT) {
        String sql = "{call sp_TimKH (? ,?)}";
        return SQLHelper.executeQuery(sql, Ten, SDT);
    }

    public static ResultSet LayKhachHangTheoTen(String tenKH) {
        String sql = "Select * From KhachHang where TenKH like ?";
        return SQLHelper.executeQuery(sql, tenKH);
    }
    
    
    public static ResultSet CountMaKH(String MaSP) {
        String sql = "select Count(*) from KhachHang where MaKH like ?";
        return SQLHelper.executeQuery(sql, "%" + MaSP + "%");
    }

    public static ResultSet GetByMaKH(String MaSP) {
        String sql = "select *  from KhachHang where MaKH = ?";
        return SQLHelper.executeQuery(sql, MaSP);
    }
    
    public static boolean kiemtraCoTheXoa(String MaKH) {
        String sql = "SELECT TOP 1* FROM  HD_Xuat WHERE MaKH = ?";
        ResultSet rs = SQLHelper.executeQuery(sql, MaKH);

        try {
            return !rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(DALSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }

    public static void DeleteKhachHang(String MaKH) {
        String sql = " DELETE FROM dbo.KhachHang WHERE MaKH = ? ";
        SQLHelper.executeUpdate(sql, MaKH);
    }
}
