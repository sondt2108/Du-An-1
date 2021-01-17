/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Du_An_BLL;

import Du_An_DAL.DALBaoHanh;
import Du_An_DAL.DALKhachHang;
import Du_An_DTO.CTPTNBH;
import Du_An_DTO.PhieuBaoHanh;
import Du_An_DTO.PhieuTNBH;
import Du_An_HELPER.ThongBao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class BLLBaoHanh {
    
    public static void LoadCKBH(JTable tblDanhSach ) {
        DefaultTableModel tbModel = (DefaultTableModel) tblDanhSach.getModel();
        tbModel.setRowCount(0); // sét số dòng trong bảng về 0
        // Lấy dự liệu danh sách nhân viên từ DAL
        ResultSet rs = DALBaoHanh.LoadBH();
        Object obj[] = new Object[13];
        try {
            while (rs.next()) {
                obj[0] = tbModel.getRowCount() + 1;
                obj[1] = rs.getString("MaPTNBH");
                obj[2] = rs.getString("TenPTNBH");
                obj[3] = rs.getString("ThoiGianBH");
                obj[4] = rs.getString("NgayTao");
                obj[5] = rs.getString("MaKH");
                obj[6] = rs.getString("Ma_HD_Xuat");
                obj[7] = rs.getString("TenKH");
                obj[8] = rs.getString("Ma_PBH");
                obj[9] = rs.getString("TenKhoHang");
                obj[10] = rs.getString("DiaChiKhoHang");
                obj[11] = rs.getString("SDT_KhoHang");
                obj[12] = rs.getString("TenNV");
                // Thêm obj vào table 
                tbModel.addRow(obj);

            }
        } catch (SQLException e) {
            ThongBao.ThongBaoDangNhap("Thông Báo Lỗi", "Lỗi Lấy Danh Sách Khách Hàng");
        }
    }
    public static void TimBH(JTable tblDanhSach,String SDT, String Ten) {
        DefaultTableModel tbModel = (DefaultTableModel) tblDanhSach.getModel();
        tbModel.setRowCount(0); // sét số dòng trong bảng về 0
        // Lấy dự liệu danh sách nhân viên từ DAL
       ResultSet rs = DALBaoHanh.TimKiem(SDT, Ten);
        Object obj[] = new Object[13];
        try {
            while (rs.next()) {
                obj[0] = tbModel.getRowCount() + 1;
                obj[1] = rs.getString("MaSP");
                obj[2] = rs.getString("TenSP");
                obj[3] = rs.getString("ThoiGianBH");
                obj[4] = rs.getString("NgayTao");
                obj[5] = rs.getString("MaKH");
                obj[6] = rs.getString("Ma_HD_Xuat");
                obj[7] = rs.getString("TenKH");
                obj[8] = rs.getString("Ma_PBH");
                obj[9] = rs.getString("TenKhoHang");
                obj[10] = rs.getString("DiaChiKhoHang");
                obj[11] = rs.getString("SDT_KhoHang");
                obj[12] = rs.getString("TenNV");
                // Thêm obj vào table 
                tbModel.addRow(obj);

            }
        } catch (SQLException e) {
            ThongBao.ThongBaoDangNhap("Thông Báo Lỗi", "Lỗi Lấy Danh Sách Khách Hàng");
        }
    }
    
    
    public static String TaoMaPTNBH(){
        String PTNBH = "";
        try {

            PTNBH = "PTNBH";
            ResultSet rs = DALBaoHanh.CountMaPTNBH(PTNBH);
            int rowCount = 0;
            if (rs.next()) {
                rowCount = rs.getInt(1);
            }
            boolean dup = false;
            do {
                if (rowCount > 98) {
                    PTNBH = PTNBH + (rowCount + 1);
                } else if (rowCount > 8) {
                    PTNBH = PTNBH + "0" + (rowCount + 1);
                } else {
                    PTNBH = PTNBH + "00" + (rowCount + 1);
                }
                System.out.println("PTNBH: " + PTNBH);
                ResultSet rs2 = DALBaoHanh.GetByMaPTNBH(PTNBH);
                if (rs2.next()) {
                    dup = true;
                    rowCount++;
                    
                } else {
                    dup = false;
                }
            } while (dup);

        } catch (SQLException ex) {
            System.out.println("Lỗi số");
        }

        return PTNBH;
    }
    
    public static String TaoMaPCTTNBH(){
        String PCTTNBH = "";
        try {

            PCTTNBH = "PCTTNBH";
            ResultSet rs = DALBaoHanh.CountMaPCTTNBH(PCTTNBH);
            int rowCount = 0;
            if (rs.next()) {
                rowCount = rs.getInt(1);
            }
            boolean dup = false;
            do {
                if (rowCount > 98) {
                    PCTTNBH = PCTTNBH + (rowCount + 1);
                } else if (rowCount > 8) {
                    PCTTNBH = PCTTNBH + "0" + (rowCount + 1);
                } else {
                    PCTTNBH = PCTTNBH + "00" + (rowCount + 1);
                }
                System.out.println("PCTTNBH: " + PCTTNBH);
                ResultSet rs2 = DALBaoHanh.GetByMaPCTTNBH(PCTTNBH);
                if (rs2.next()) {
                    dup = true;
                    rowCount++;
                    
                } else {
                    dup = false;
                }
            } while (dup);

        } catch (SQLException ex) {
            System.out.println("Lỗi số");
        }

        return PCTTNBH;
    }
    
    public static void ThemCTTNBH(JTable tbl, String MaPCTTNBH, String LyDoLoi, Date NgayHenTra, int SoLuong, String MaPTNBH, String GhiChu) {
        for (int i = 0; i < tbl.getRowCount(); i++) {
            CTPTNBH cttn = new CTPTNBH();
             cttn.setMaPCTTNBH(TaoMaPCTTNBH());
             cttn.setLyDoLoi(LyDoLoi);
             cttn.setNgayHenTra(NgayHenTra);
             cttn.setSoLuong(SoLuong);
             cttn.setMaPTNBH(MaPTNBH);
             cttn.setGhiChu(GhiChu);
            String Ma_HDXuat = tbl.getValueAt(i, 3).toString();
            cttn.setMa_HDXuat(Ma_HDXuat);

            DALBaoHanh.ThemPCTTNBH(cttn);
        }
    
        
    }
    
       public static void ThemPTNBH(PhieuTNBH bh) {

        // Kiểm tra tên đang nhập đa tồn tại
        // kiểm tra ok -> gọi hàm thêm từ DALNhanVien
        DALBaoHanh.ThemPTNBH(bh);
    }
       
       public static String GetTenHDBySoHoaDon(String Ma_PTNBH){
        ResultSet rs = DALBaoHanh.GetByMaBH(Ma_PTNBH);
        try {
            if(rs.next()){
                return rs.getString("Ma_PTNBH");
            }
        } catch (SQLException ex) {
            ThongBao.ThongBaoSQL("Lỗi lấy mã hóa đơn từ số hóa đơn", "Thông báo lỗi");
        }
        return Ma_PTNBH;
    }
       
       public static void ThemPBH(PhieuBaoHanh bh) {

        // Kiểm tra tên đang nhập đa tồn tại
        // kiểm tra ok -> gọi hàm thêm từ DALNhanVien
        DALBaoHanh.ThemBH(bh);
    }
       
       public static String TaoMaPBH(){
        String PBH = "";
        try {

            PBH = "PBH";
            ResultSet rs = DALBaoHanh.CountMaPBH(PBH);
            int rowCount = 0;
            if (rs.next()) {
                rowCount = rs.getInt(1);
            }
            boolean dup = false;
            do {
                if (rowCount > 98) {
                    PBH = PBH + (rowCount + 1);
                } else if (rowCount > 8) {
                    PBH = PBH + "0" + (rowCount + 1);
                } else {
                    PBH = PBH + "00" + (rowCount + 1);
                }
                System.out.println("PCTTNBH: " + PBH);
                ResultSet rs2 = DALBaoHanh.GetByMaPCTTNBH(PBH);
                if (rs2.next()) {
                    dup = true;
                    rowCount++;
                    
                } else {
                    dup = false;
                }
            } while (dup);

        } catch (SQLException ex) {
            System.out.println("Lỗi số");
        }

        return PBH;
    }
}
