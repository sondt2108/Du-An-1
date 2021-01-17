/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Du_An_BLL;


import static Du_An_BLL.BLLCTHDXuat.TaoMaCTHDX;
import Du_An_DAL.DALCTHDXuat;
import Du_An_DAL.DALCTHDXuat;
import Du_An_DAL.DALCTHDXuat;
import Du_An_DTO.CTHDXuat;
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
public class BLLCTHDXuat {
    public static String TaoMaCTHDX(){
        String MaCTHDX = "";
        try {

            MaCTHDX = "CTX";
            ResultSet rs = DALCTHDXuat.CountMaCTHDXuat(MaCTHDX);
            int rowCount = 0;
            if (rs.next()) {
                rowCount = rs.getInt(1);
            }
            boolean dup = false;
            do {
                if (rowCount > 98) {
                    MaCTHDX = MaCTHDX + (rowCount + 1);
                } else if (rowCount > 8) {
                    MaCTHDX = MaCTHDX + "0" + (rowCount + 1);
                } else {
                    MaCTHDX = MaCTHDX + "00" + (rowCount + 1);
                }               
                ResultSet rs2 = DALCTHDXuat.GetByMaCTHDX(MaCTHDX);
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

        return MaCTHDX;
    }
    
    public static void ThemCTHDXuat(JTable tbl, String maHD){
        for (int i = 0; i < tbl.getRowCount(); i++){
            CTHDXuat cthdXuat = new CTHDXuat();
        
            cthdXuat.setMa_CTHD_Xuat(TaoMaCTHDX());
            cthdXuat.setMa_HD_Xuat(maHD);
            
            String maSP = tbl.getValueAt(i, 1).toString();
            cthdXuat.setMaSP(maSP);
            
            String soLuong = tbl.getValueAt(i, 3).toString() ;           
            cthdXuat.setSoLuong(soLuong);
            
            double tongTien = ChuyenDoi.LaySoDouble(tbl.getValueAt(i, 5).toString()) ;
            cthdXuat.setThanhTien(tongTien);
            
            String ghiChu = tbl.getValueAt(i, 6).toString();
            cthdXuat.setGhiChu(ghiChu);
            
            DALCTHDXuat.ThemCTHDXuat(cthdXuat);
        }       
    }
    
    public static void LoadTBLChiTietHDXuat(String maHD, JTable tbl) {
        ResultSet rs = DALCTHDXuat.LayCTHDTheoMaHD(maHD);

        DefaultTableModel tbModel = (DefaultTableModel) tbl.getModel();
        tbModel.setRowCount(0);
        Object obj[] = new Object[6];

        try {
            while (rs.next()) {
                obj[0] = rs.getString("Ma_CTHD_Xuat");
                obj[1] = rs.getString("Ma_HD_Xuat");
                obj[2] = rs.getString("MaSP");
                obj[3] = rs.getInt("SoLuong");
                obj[4] = ChuyenDoi.DinhDangTien(rs.getDouble("ThanhTien"));
                obj[5] = rs.getString("GhiChu");

                tbModel.addRow(obj);
            }
        } catch (SQLException ex) {
            ThongBao.ThongBaoDangNhap("Thông Báo Lỗi", "Lỗi Lấy Danh Sách Chi Tiết Hóa Đơn");
        }
    }
}
