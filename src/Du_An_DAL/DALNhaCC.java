/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Du_An_DAL;

import Du_An_DTO.NhaCC;
import Du_An_HELPER.SQLHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class DALNhaCC {

    public static ResultSet getALLNCC() {
        String sql = "SELECT * FROM NhaCungCap";
        return SQLHelper.executeQuery(sql);
    }

    // lấy NCC theo mã
    public static ResultSet getMaNCC(String MaNCC) {
        String sql = "SELECT * FROM NhaCungCap WHERE MaNCC = ?";
        return SQLHelper.executeQuery(sql, MaNCC);
    }

    public static ResultSet LayMaNCC(String MaNCC) {
        String sql = "SELECT * FROM NhaCungCap WHERE MaNCC = ?";
        return SQLHelper.executeQuery(sql, MaNCC);
    }

    public static void ThemNhaCC(NhaCC ncc) {
        String sql = " SET DATEFORMAT DMY INSERT INTO [dbo].[NhaCungCap] "
                + "           ([MaNCC] "
                + "           ,[TenNCC] "
                + "           ,[SDT] "
                + "           ,[DiaChi] "
                + "           ,[Email] "
                + "           ,[GhiChu]) "
                + "     VALUES "
                + "           (?, ?, ?, ?, ?, ?) ";

        SQLHelper.executeUpdate(sql,
                ncc.getMaNCC(),
                ncc.getTenNCC(),
                ncc.getSDT(),
                ncc.getDiaChi(),
                ncc.getEmail(),
                ncc.getGhiChu());
        //push
    }

    public static void SuaNhaCC(NhaCC ncc) {
        String sql = " SET DATEFORMAT DMY UPDATE [dbo].[NhaCungCap] "
                + "   SET [TenNCC] = ? "
                + "      ,[SDT] = ? "
                + "      ,[DiaChi] = ? "
                + "      ,[Email] = ? "
                + "      ,[GhiChu] = ? "
                + " WHERE [MaNCC] = ?";

        SQLHelper.executeUpdate(sql,
                ncc.getTenNCC(),
                ncc.getSDT(),
                ncc.getDiaChi(),
                ncc.getEmail(),
                ncc.getGhiChu(),
                ncc.getMaNCC());

        //push
    }

    public static boolean kiemtraCoTheXoa(String MaNCC) {
        String sql = "SELECT TOP 1* FROM  HD_Nhap WHERE MaNCC = ?";
        ResultSet rs = SQLHelper.executeQuery(sql, MaNCC);

        try {
            return !rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(DALSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }

    public static void DeleteNCC(String MaNV) {
        String sql = " DELETE FROM NhaCungCap WHERE MaNCC = ?";
        SQLHelper.executeUpdate(sql, MaNV);
        //push
    }

    public static ResultSet TimNCCTheoTen(String TenNCC) {
        String sql = "select * From NhaCungCap where TenNCC = ?";
        return SQLHelper.executeQuery(sql, TenNCC);
    }

    public static ResultSet CountMaNCC(String MaNCC) {
        String sql = "select Count(*) from NhaCungCap where MaNCC like ?";
        return SQLHelper.executeQuery(sql, "%" + MaNCC + "%");
    }

    public static ResultSet GetByMaNCC(String MaNCC) {
        String sql = "select * from NhaCungCap where MaNCC = ?";
        return SQLHelper.executeQuery(sql, MaNCC);
    }
    
    public static ResultSet TimKiem(String TenNhaCC){
      String sql = "{call spTimKiemNCC (?)}";
      return SQLHelper.executeQuery(sql, TenNhaCC);
    }
}
