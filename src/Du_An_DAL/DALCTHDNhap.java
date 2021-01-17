/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Du_An_DAL;

import Du_An_DTO.CTHDNhap;
import Du_An_HELPER.ChuyenDoi;
import Du_An_HELPER.SQLHelper;
import java.sql.ResultSet;

/**
 *
 * @author Admin
 */
public class DALCTHDNhap {

    public static ResultSet CountMaCTHDNhap(String MaCTHDN) {
        String sql = "select Count(*) from CTHD_Nhap where Ma_CTHD_Nhap like ?";
        return SQLHelper.executeQuery(sql, "%" + MaCTHDN + "%");
    }

    public static ResultSet GetByMaCTHDN(String MaCTHDN) {
        String sql = "select * from CTHD_Nhap where Ma_CTHD_Nhap = ?";
        return SQLHelper.executeQuery(sql, MaCTHDN);
    }

    public static void ThemCTHDNhap(CTHDNhap cthdNhap) {
        String sql = "SET DATEFORMAT DMY "
                + "INSERT INTO [dbo].[CTHD_Nhap] "
                + "           ([Ma_CTHD_Nhap] "
                + "           ,[Ma_HD_Nhap] "
                + "           ,[MaSP] "
                + "           ,[SoLuong] "
                + "           ,[ThanhTien] "
                + "           ,[GhiChu]) "
                + "     VALUES(?,?,?,?,?,?)";
        SQLHelper.executeUpdate(sql, 
                cthdNhap.getMa_CTHD_Nhap(),
                cthdNhap.getMa_HD_Nhap(),
                cthdNhap.getMaSP(),
                ChuyenDoi.LaySoDouble(cthdNhap.getSoLuong()),
                ChuyenDoi.LaySoString(cthdNhap.getThanhTien()),
                cthdNhap.getGhiChu()
        );
    }
    
    public static ResultSet LayCTHDTheoMaHD(String maHD){
        String sql = "Select * From CTHD_Nhap where Ma_HD_Nhap = ?";
        return SQLHelper.executeQuery(sql, maHD);         
    }
}
