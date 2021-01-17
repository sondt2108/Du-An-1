/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Du_An_DAL;

import Du_An_DTO.HangSX;
import Du_An_HELPER.SQLHelper;
import java.sql.ResultSet;

/**
 *
 * @author Administrator
 */
public class DALHangSX {
    
    public static ResultSet GetAll() {
        String sql = "Select * from HangSX";
        return SQLHelper.executeQuery(sql);
    }
    
    
    public static ResultSet GetTenHangSX(String MaHangSX) {
        String sql = "SELECT * FROM HangSX WHERE MaHangSX = ?";
        return SQLHelper.executeQuery(sql, MaHangSX);
    }
    
     public static ResultSet GetDuLieuCBB(String KeyWord) {
        String sql = "Select * from HangSX where TenHangSX like N'%" + KeyWord + "%' or MaHangSX like '%" + KeyWord + "%' ";
        return SQLHelper.executeQuery(sql);
    }
     
     public static void ThemHangSX(HangSX hsx) {
        String sql = " INSERT INTO [dbo].[HangSX] " +
"           ([MaHangSX] " +
"           ,[TenHangSX] " +
"           ,[MoTa]) " +
"     VALUES " +
"           (?, ?, ?) ";

        SQLHelper.executeUpdate(sql,
                hsx.getMaHangSX(),
                hsx.getTenHangSX(),
                hsx.getGhiChu());
        //push
    }
     
      public static ResultSet CountMaHSX(String SoHoaDon) {
        String sql = "select Count(*) from HangSX where MaHangSX like ?";
        return SQLHelper.executeQuery(sql, "%" + SoHoaDon + "%");
    }
      
      public static ResultSet GetByMaHSX(String MaHSX) {
        String sql = "select * from HangSX where MaHangSX = ?";
        return SQLHelper.executeQuery(sql, MaHSX);
    }
     
      
}
