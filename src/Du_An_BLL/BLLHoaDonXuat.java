/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Du_An_BLL;

import Du_An_DAL.DALHDXuat;
import Du_An_DAL.DALHDXuat;
import Du_An_HELPER.ChuyenDoi;
import Du_An_HELPER.ThongBao;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class BLLHoaDonXuat {
    public static String TaoMaHDX(){
        String MaHDX = "";
        try {

            MaHDX = "HDX";
            ResultSet rs = DALHDXuat.CountMaHDN(MaHDX);
            int rowCount = 0;
            if (rs.next()) {
                rowCount = rs.getInt(1);
            }
            boolean dup = false;
            do {
                if (rowCount > 98) {
                    MaHDX = MaHDX + (rowCount + 1);
                } else if (rowCount > 8) {
                    MaHDX = MaHDX + "0" + (rowCount + 1);
                } else {
                    MaHDX = MaHDX + "00" + (rowCount + 1);
                }               
                ResultSet rs2 = DALHDXuat.GetByMaHDX(MaHDX);
                if (rs2.next()) {
                    dup = true;
                    rowCount++;
                    
                } else {
                    dup = false;
                }
            } while (dup);

        } catch (SQLException ex) {
            System.out.println("Lỗi số hóa đơn");
        }

        return MaHDX;
    }
    
    public static void LoadDSHDXuatVaoTable(JTable tbl){
        ResultSet rs = DALHDXuat.GetAllHDXuat();
        System.out.println(rs);
        
        DefaultTableModel tbModel = (DefaultTableModel) tbl.getModel();
        tbModel.setRowCount(0);
        Object obj[] = new Object[6];
        
        try {
            while (rs.next()) {
                obj[0] = rs.getString("Ma_HD_Xuat");
                obj[1] = rs.getDate("NgayTao");
                obj[2] = rs.getString("MaNV");
                obj[3] = rs.getString("MaKH");
                obj[4] = ChuyenDoi.DinhDangTien(rs.getDouble("TongTien")) ;                
                obj[5] = rs.getString("GhiChu");
                
                tbModel.addRow(obj);
            }
        } catch (SQLException ex) {
            ThongBao.ThongBaoDangNhap("Thông Báo Lỗi", "Lỗi Lấy Danh Sách Hóa Đơn");
        }
    }
    
    public static String GetTenHDBySoHoaDon(String Ma_HD_Xuat){
        ResultSet rs = DALHDXuat.GetByMaHDX(Ma_HD_Xuat);
        try {
            if(rs.next()){
                return rs.getString("Ma_HD_Xuat");
            }
        } catch (SQLException ex) {
            ThongBao.ThongBaoSQL("Lỗi lấy mã hóa đơn từ số hóa đơn", "Thông báo lỗi");
        }
        return Ma_HD_Xuat;
    }
}
