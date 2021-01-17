/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Du_An_DAL;

import Du_An_DTO.LoaiSP;
import Du_An_HELPER.SQLHelper;
import java.sql.ResultSet;

/**
 *
 * @author Administrator
 */
public class DALLoaiSP {

    public static ResultSet GetTenLoaiSP(String MaLoaiSP) {
        String sql = "SELECT * FROM LoaiSP WHERE MaLoaiSP = ?";
        return SQLHelper.executeQuery(sql, MaLoaiSP);
    }

    public static ResultSet GetAll() {
        String sql = "Select * from LoaiSP";
        return SQLHelper.executeQuery(sql);
    }

    public static ResultSet GetDuLieuCBB(String KeyWord) {
        String sql = "Select * from LoaiSP where TenLoaiSP like N'%" + KeyWord + "%' or MaLoaiSP like '%" + KeyWord + "%' ";
        return SQLHelper.executeQuery(sql);
    }

    public static void ThemLoaiSP(LoaiSP lsp) {
        String sql = " SET DATEFORMAT DMY INSERT INTO [dbo].[LoaiSP] "
                + "           ([MaLoaiSP] "
                + "           ,[TenLoaiSP] "
                + "           ,[MoTa]) "
                + "     VALUES "
                + "           (?, ?, ?) ";

        SQLHelper.executeUpdate(sql,
                lsp.getMaLoaiSP(),
                lsp.getTenLoaiSP(),
                lsp.getMoTa());
        //push
    }
    
    public static ResultSet CountMaLSP(String MaLSP) {
        String sql = "select Count(*) from LoaiSP where MaLoaiSP like ?";
        return SQLHelper.executeQuery(sql, "%" + MaLSP + "%");
    }
      
      public static ResultSet GetByMaLSP(String MaLSP) {
        String sql = "select * from LoaiSP where MaLoaiSP = ?";
        return SQLHelper.executeQuery(sql, MaLSP);
    }
      
    public static ResultSet GetByTenLSP(String tenLoaiSP){
        String sql = "Select * From LoaiSP Where TenLoaiSP = ?";
        return SQLHelper.executeQuery(sql, tenLoaiSP);
    }

}
