/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Du_An_DAL;

import Du_An_DTO.HDXuat;
import Du_An_HELPER.ChuyenDoi;
import Du_An_HELPER.SQLHelper;
import java.sql.ResultSet;

/**
 *
 * @author Admin
 */
public class DALHDXuat {

    public static ResultSet CountMaHDN(String MaHDX) {
        String sql = "select Count(*) from HD_Xuat where Ma_HD_Xuat like ?";
        return SQLHelper.executeQuery(sql, "%" + MaHDX + "%");
    }

    public static ResultSet GetByMaHDX(String MaHDX) {
        String sql = "select * from HD_Xuat where Ma_HD_Xuat = ?";
        return SQLHelper.executeQuery(sql, MaHDX);
    }

    public static void ThemHDXuat(HDXuat hdXuat) {
        String sql = "SET DATEFORMAT DMY "
                + "INSERT INTO [dbo].[HD_Xuat] "
                + "           ([Ma_HD_Xuat] "
                + "           ,[NgayTao] "
                + "           ,[MaNV] "
                + "           ,[MaKH] "
                + "           ,[TongTien] "
                + "           ,[GhiChu]) "
                + "     VALUES(?,?,?,?,?,?)";
        SQLHelper.executeUpdate(sql, 
                hdXuat.getMa_HD_Xuat(),
                ChuyenDoi.LayNgayString(hdXuat.getNgayTao()),
                hdXuat.getMaNV(),
                hdXuat.getMaKH(),
                ChuyenDoi.LaySoString(hdXuat.getTongTien()),
                hdXuat.getGhiChu()
                );        
    }
    
    public static ResultSet GetAllHDXuat (){
        String sql = "Select * From HD_Xuat";
        return SQLHelper.executeQuery(sql);
    }
}
