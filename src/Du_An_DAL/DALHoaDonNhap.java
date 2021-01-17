/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Du_An_DAL;

import Du_An_HELPER.SQLHelper;
import java.sql.ResultSet;

/**
 *
 * @author Admin
 */
public class DALHoaDonNhap {
    public static ResultSet CountMaHDN(String MaHDN) {
        String sql = "select Count(*) from HD_Nhap where Ma_HD_Nhap like ?";
        return SQLHelper.executeQuery(sql, "%" + MaHDN + "%");
    }
    
    public static ResultSet GetByMaHDN(String MaHDN) {
        String sql = "select * from HD_Nhap where Ma_HD_Nhap = ?";
        return SQLHelper.executeQuery(sql, MaHDN);
    }
}
