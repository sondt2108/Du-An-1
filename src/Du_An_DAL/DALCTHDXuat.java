/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Du_An_DAL;


import Du_An_DTO.CTHDXuat;
import Du_An_HELPER.ChuyenDoi;
import Du_An_HELPER.SQLHelper;
import java.sql.ResultSet;

/**
 *
 * @author Admin
 */
public class DALCTHDXuat {
    public static ResultSet CountMaCTHDXuat(String MaCTHDX) {
        String sql = "select Count(*) from CTHD_Xuat where Ma_CTHD_Xuat like ?";
        return SQLHelper.executeQuery(sql, "%" + MaCTHDX + "%");
    }

    public static ResultSet GetByMaCTHDX(String MaCTHDX) {
        String sql = "select * from CTHD_Xuat where Ma_CTHD_Xuat = ?";
        return SQLHelper.executeQuery(sql, MaCTHDX);
    }
    
    public static void ThemCTHDXuat(CTHDXuat cthdXuat) {
        String sql = "SET DATEFORMAT DMY "
                + "INSERT INTO [dbo].[CTHD_Xuat] "
                + "           ([Ma_CTHD_Xuat] "
                + "           ,[Ma_HD_Xuat] "
                + "           ,[MaSP] "
                + "           ,[SoLuong] "
                + "           ,[ThanhTien] "
                + "           ,[GhiChu]) "
                + "     VALUES(?,?,?,?,?,?)";
        SQLHelper.executeUpdate(sql, 
                cthdXuat.getMa_CTHD_Xuat(),
                cthdXuat.getMa_HD_Xuat(),
                cthdXuat.getMaSP(),
                ChuyenDoi.LaySoDouble(cthdXuat.getSoLuong()),
                ChuyenDoi.LaySoString(cthdXuat.getThanhTien()),
                cthdXuat.getGhiChu()
        );
    }
    
    public static ResultSet LayCTHDTheoMaHD(String maHD){
        String sql = "Select * From CTHD_Xuat where Ma_HD_Xuat = ?";
        return SQLHelper.executeQuery(sql, maHD);         
    }
}
