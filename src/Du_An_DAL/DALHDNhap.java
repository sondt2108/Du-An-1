/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Du_An_DAL;

import Du_An_DTO.HDNhap;
import Du_An_HELPER.ChuyenDoi;
import Du_An_HELPER.SQLHelper;
import java.sql.ResultSet;

/**
 *
 * @author Admin
 */
public class DALHDNhap {

    public static void ThemHDNhap(HDNhap hdNhap) {
        String sql = "SET DATEFORMAT DMY "
                + "INSERT INTO [dbo].[HD_Nhap] "
                + "           ([Ma_HD_Nhap] "
                + "           ,[NgayTao] "
                + "           ,[MaNV] "
                + "           ,[MaNCC] "
                + "           ,[TongTien] "
                + "           ,[GhiChu]) "
                + "     VALUES (?,?,?,?,?,?)";
        SQLHelper.executeUpdate(sql, 
                hdNhap.getMa_HD_Nhap(),
                ChuyenDoi.LayNgayString(hdNhap.getNgayTao()),
                hdNhap.getMaNV(),
                hdNhap.getMaNCC(),
                ChuyenDoi.LaySoString(hdNhap.getTongTien()),
                hdNhap.getGhiChu()
        );
    }
    
    public static ResultSet GetAllHDNhap (){
        String sql = "Select * From HD_Nhap";
        return SQLHelper.executeQuery(sql);
    }
    
    public static ResultSet GetByMaHDN(String MaHDN) {
        String sql = "select * from HD_Nhap where Ma_HD_Nhap = ?";
        return SQLHelper.executeQuery(sql, MaHDN);
    }
}
