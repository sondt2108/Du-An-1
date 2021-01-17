/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Du_An_BLL;

import Du_An_DAL.DALHDNhap;
import Du_An_DAL.DALHoaDonNhap;
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
public class BLLHoaDonNhap {
    public static String TaoMaHDN(){
        String MaHDN = "";
        try {

            MaHDN = "HDN";
            ResultSet rs = DALHoaDonNhap.CountMaHDN(MaHDN);
            int rowCount = 0;
            if (rs.next()) {
                rowCount = rs.getInt(1);
            }
            boolean dup = false;
            do {
                if (rowCount > 98) {
                    MaHDN = MaHDN + (rowCount + 1);
                } else if (rowCount > 8) {
                    MaHDN = MaHDN + "0" + (rowCount + 1);
                } else {
                    MaHDN = MaHDN + "00" + (rowCount + 1);
                }
                System.out.println("MaNCC: " + MaHDN);
                ResultSet rs2 = DALHoaDonNhap.GetByMaHDN(MaHDN);
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

        return MaHDN;
    }
    
    public static void LoadDSHDNhapVaoTable(JTable tbl){
        ResultSet rs = DALHDNhap.GetAllHDNhap();
        System.out.println(rs);
        
        DefaultTableModel tbModel = (DefaultTableModel) tbl.getModel();
        tbModel.setRowCount(0);
        Object obj[] = new Object[6];
        
        try {
            while (rs.next()) {
                obj[0] = rs.getString("Ma_HD_Nhap");
                obj[1] = rs.getDate("NgayTao");
                obj[2] = rs.getString("MaNV");
                obj[3] = rs.getString("MaNCC");
                obj[4] = ChuyenDoi.DinhDangTien(rs.getDouble("TongTien")) ;                
                obj[5] = rs.getString("GhiChu");
                
                tbModel.addRow(obj);
            }
        } catch (SQLException ex) {
            ThongBao.ThongBaoDangNhap("Thông Báo Lỗi", "Lỗi Lấy Danh Sách Hóa Đơn");
        }
    }
    
    
    public static String GetTenHDBySoHoaDon(String Ma_HD_Nhap){
        ResultSet rs = DALHDNhap.GetByMaHDN(Ma_HD_Nhap);
        try {
            if(rs.next()){
                return rs.getString("Ma_HD_Nhap");
            }
        } catch (SQLException ex) {
            ThongBao.ThongBaoSQL("Lỗi lấy mã hóa đơn từ số hóa đơn", "Thông báo lỗi");
        }
        return Ma_HD_Nhap;
    }
}
